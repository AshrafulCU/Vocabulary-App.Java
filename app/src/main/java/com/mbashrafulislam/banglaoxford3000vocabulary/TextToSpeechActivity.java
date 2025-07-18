package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class TextToSpeechActivity extends AppCompatActivity {

    String lcode = "bn-BD";
    SharedPreferences LastSelectLast;
    SharedPreferences.Editor editor2;
    private static final int PERMISSION_REQUEST_CODE = 1;

    private SpeechRecognizer speechRecognizer;
    private Intent speechRecognizerIntent;
    private boolean isListening = false;

    // UI elements
    private Spinner spinner2;
    private ImageView microPhone, remover, copyIcon, keyBoardIcon, removeIcon, shareIcon;
    private EditText keyboardEditText;
    private TextView commaTextView, dariTextView, dotTextView, questionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        //getSupportActionBar().hide(); To hide action bar either use it or below
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Initialize views
        spinner2 = findViewById(R.id.spinner2);
        microPhone = findViewById(R.id.microPhone);
        keyboardEditText = findViewById(R.id.keyboardEditText);
        keyBoardIcon = findViewById(R.id.keyBoardIcon);
        removeIcon = findViewById(R.id.removeIcon);
        commaTextView = findViewById(R.id.commaTextView);
        dariTextView = findViewById(R.id.dariTextView);
        dotTextView = findViewById(R.id.dotTextView);
        questionTextView = findViewById(R.id.questionTextView);
        remover = findViewById(R.id.remover);
        copyIcon = findViewById(R.id.copyIcon);
        shareIcon = findViewById(R.id.shareIcon);

        String[] languages = {"Bengali","English", "Arabic","Hindi","Tamil","Spanish","French",
                "Chinese","Japanese","German","Portuguese","Russian","Indonesian","Marathi","Swahili",
                "Telugu","Punjabi","Turkish","Urdu","Danish","Maldivian","Greek","Gujarati","Italian"};

        LastSelectLast = getSharedPreferences("LastSelectLast", Context.MODE_PRIVATE);
        editor2 = LastSelectLast.edit();
        final int LastClickLast = LastSelectLast.getInt("LastClickLast", 0);

        String[] lCodes = {"bn-BD","en-US","ar-SA","hi-IN","ta-IN","es-CL","fr-FR",
                "zh-TW","jp-JP","de-DE","pt-PT","ru-RU","id-ID","mr-MR","sw-SZ","te-IN","pa-IN","tr-TR","ur-UR",
                "da-DK","dv-MV", "el-GR", "gu-IN", "it-IT"};

        ArrayAdapter adapterForKeyboard = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,languages);
        adapterForKeyboard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapterForKeyboard);
        spinner2.setSelection(LastClickLast);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lcode = lCodes[i];
                editor2.putInt("LastClickLast", i).commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PERMISSION_REQUEST_CODE);
        }

        // Initialize speech recognizer
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);

//        microPhone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!isListening) {
//                    startListening();
//                } else {
//                    stopListening();
//                }
//            }
//        });

        microPhone.setOnClickListener(view -> {
            if (isInternetAvailable()) {
                if (!isListening) {
                    startListening();
                } else {
                    stopListening();
                }
            } else {
                Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_LONG).show();
            }
        });


        // ... (keep all your other existing click listeners)
        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cursorPosition = keyboardEditText.getSelectionStart();
                if (cursorPosition > 0) {
                    keyboardEditText.getText().delete(cursorPosition - 1, cursorPosition);
                    keyboardEditText.setSelection(cursorPosition - 1);
                }
            }
        });

        commaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertText(",");
            }
        });

        dariTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertText("।");
            }
        });

        dotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertText(".");
            }
        });

        questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertText("?");
            }
        });

        removeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyboardEditText.getText().clear();
            }
        });

        keyboardEditText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.onTouchEvent(event);
                InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
                return true;
            }
        });

        copyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(keyboardEditText.getText())) {
                    Toast.makeText(TextToSpeechActivity.this, "No Text Found.", Toast.LENGTH_LONG).show();
                } else {
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("tag", keyboardEditText.getText().toString());
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(TextToSpeechActivity.this, "Copied", Toast.LENGTH_SHORT).show();
                }
            }
        });

        keyBoardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openKeyboard();
            }
        });

        shareIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(keyboardEditText.getText())) {
                    Toast.makeText(TextToSpeechActivity.this, "No Text Found To Share.", Toast.LENGTH_LONG).show();
                } else {
                    sharedTextOnly(keyboardEditText.getText().toString());
                }
            }
        });
    }

    private boolean isInternetAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager !=null){
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }





    private void startListening() {
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
                isListening = true;
                microPhone.setImageResource(R.drawable.microphone ); // Change to active mic icon
            }

            @Override public void onBeginningOfSpeech() {}
            @Override public void onRmsChanged(float rmsdB) {}
            @Override public void onBufferReceived(byte[] buffer) {}
            @Override public void onEndOfSpeech() {}

            @Override
            public void onError(int error) {
                isListening = false;
                microPhone.setImageResource(R.drawable.microphone); // Change back to default mic icon

                if (error == SpeechRecognizer.ERROR_NO_MATCH || error == SpeechRecognizer.ERROR_SPEECH_TIMEOUT) {
                    // These are expected errors, don't show toast
                } else {
                    Toast.makeText(TextToSpeechActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onResults(Bundle results) {
                ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matches != null && !matches.isEmpty()) {
                    insertText(" " + matches.get(0) + " ");
                }

                // Only continue listening if we're still in listening mode
                if (isListening) {
                    speechRecognizer.startListening(speechRecognizerIntent);
                }
            }

            @Override public void onPartialResults(Bundle partialResults) {}
            @Override public void onEvent(int eventType, Bundle params) {}
        });

        speechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, lcode);
        speechRecognizer.startListening(speechRecognizerIntent);
    }

    private void stopListening() {
        isListening = false;
        microPhone.setImageResource(R.drawable.microphone); // Change back to default mic icon
        if (speechRecognizer != null) {
            speechRecognizer.stopListening();
        }
    }

    private void insertText(String text) {
        int cursorPosition = keyboardEditText.getSelectionStart();
        String newText = keyboardEditText.getText().toString().substring(0, cursorPosition)
                + text + keyboardEditText.getText().toString().substring(cursorPosition);
        keyboardEditText.setText(newText);
        keyboardEditText.setSelection(keyboardEditText.getText().length());
    }

    private void openKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(keyboardEditText, 0);
        }
    }

    private void sharedTextOnly(String title) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
        intent.putExtra(Intent.EXTRA_TEXT, title);
        startActivity(Intent.createChooser(intent, "Share Via"));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (speechRecognizer != null) {
            speechRecognizer.destroy();
        }
    }
}