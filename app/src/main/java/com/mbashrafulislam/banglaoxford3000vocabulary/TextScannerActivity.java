package com.mbashrafulislam.banglaoxford3000vocabulary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.devanagari.DevanagariTextRecognizerOptions;

import java.io.IOException;

public class TextScannerActivity extends AppCompatActivity {

    TextView textView;
    Button capture_button;
    Button copy_button;
    private static final int REQUEST_CAMERA_CODE = 100;
    Uri imageUri;
    TextRecognizer textRecognizer;
    final String commonText = "Click Capture to Extract Text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scanner);

        textView = findViewById(R.id.text_view);
        capture_button = findViewById(R.id.caputer_button);
        copy_button = findViewById(R.id.copy_button);

        // Initialize the recognizer
        textRecognizer = TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());

        // Check and request permissions
        checkAndRequestPermissions();

        capture_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ImagePicker.with(TextScannerActivity.this)
                        .crop()

                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start();
            }
        });

        copy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToCopy = textView.getText().toString().trim();

                if (textToCopy.isEmpty() || textToCopy.equals(commonText)) {
                    Toast.makeText(TextScannerActivity.this, "No text to copy", Toast.LENGTH_SHORT).show();
                } else {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("Copied Text", textToCopy);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(TextScannerActivity.this, "Text copied to clipboard", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                imageUri = data.getData();
                textView.setText("Converting...");
                recognizeText();
            }
        } else {
            Toast.makeText(this, "Image is not selected", Toast.LENGTH_LONG).show();
        }
    }

    private void recognizeText() {
        if (imageUri != null) {
            try {
                InputImage inputImage = InputImage.fromFilePath(TextScannerActivity.this, imageUri);

                Task<Text> result = textRecognizer.process(inputImage)
                        .addOnSuccessListener(new OnSuccessListener<Text>() {
                            @Override
                            public void onSuccess(Text text) {
                                String recognizedText = text.getText();
                                textView.setText(recognizedText);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(TextScannerActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{
                        android.Manifest.permission.READ_MEDIA_IMAGES,
                        android.Manifest.permission.CAMERA
                }, REQUEST_CAMERA_CODE);
            }
        } else {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.CAMERA
                }, REQUEST_CAMERA_CODE);
            }
        }
    }




}