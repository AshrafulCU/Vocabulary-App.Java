package com.mbashrafulislam.banglaoxford3000vocabulary;

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

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_scanner);

        textView = findViewById(R.id.text_view);
        capture_button = findViewById(R.id.caputer_button);
        copy_button = findViewById(R.id.copy_button);

        // Initialize the recognizer
        textRecognizer = TextRecognition.getClient(new DevanagariTextRecognizerOptions.Builder().build());


        capture_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Check and request permissions

                if ( checkAndRequestPermissions()){
                    ImagePicker.with(TextScannerActivity.this)
                            .crop()

                            .compress(1024)
                            .maxResultSize(1080, 1080)
                            .start();
                }else {
                    Toast.makeText(TextScannerActivity.this,
                            "To Scan, You have to Allow the access to take photo or picture.",
                            Toast.LENGTH_LONG).show();
                }




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

        applyDisplayCutouts();

    }

    private void applyDisplayCutouts() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textScanneActivityLayout), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                            | WindowInsetsCompat.Type.displayCutout()
            );
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return WindowInsetsCompat.CONSUMED;
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

    private boolean checkAndRequestPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{
                        android.Manifest.permission.READ_MEDIA_IMAGES,
                        android.Manifest.permission.CAMERA
                }, REQUEST_CAMERA_CODE);
                return false; // Permission not granted yet
            }
        } else {
            if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{
                        android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.CAMERA
                }, REQUEST_CAMERA_CODE);
                return false; // Permission not granted yet
            }
        }
        return true; // All permissions granted
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CAMERA_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissions granted - you can start ImagePicker here if you want
            } else {
                Toast.makeText(this, "Permission denied.", Toast.LENGTH_SHORT).show();
            }
        }
    }






}