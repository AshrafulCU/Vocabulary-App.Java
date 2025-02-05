package com.mbashrafulislam.banglaoxford3000vocabulary;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;


public class TextToSpeechActivity extends AppCompatActivity {


    String lcode = "bn-BD";

    SharedPreferences LastSelectLast;
    SharedPreferences.Editor editor2;

    private static final int PERMISSION_REQUEST_CODE = 1;
    Spinner spinner2;
    ImageView microPhone,remover,copyIcon;
    EditText keyboardEditText;
    ImageView keyBoardIcon,removeIcon,shareIcon;
    TextView  commaTextView,dariTextView,dotTextView,questionTextView;
    AdView adView2;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        //getSupportActionBar().hide(); To hide action bar either use it or below
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);




        spinner2 = findViewById(R.id.spinner2);
        microPhone= findViewById(R.id.microPhone);
        keyboardEditText= findViewById(R.id.keyboardEditText);
        keyBoardIcon = findViewById(R.id.keyBoardIcon);
        removeIcon = findViewById(R.id.removeIcon);
        commaTextView= findViewById(R.id.commaTextView);
        dariTextView = findViewById(R.id.dariTextView);
        dotTextView = findViewById(R.id.dotTextView);
        questionTextView = findViewById(R.id.questionTextView);
        remover = findViewById(R.id.remover);
        copyIcon = findViewById(R.id.copyIcon);
        shareIcon = findViewById(R.id.shareIcon);
        adView2 = findViewById(R.id.adView2);

        MobileAds.initialize(TextToSpeechActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        //requestConsentFrom();
        AdRequest adRequest = new AdRequest.Builder().build();
        adView2.loadAd(adRequest);
        //End admob ad




        String[] languages = {"Bengali","English", "Arabic","Hindi","Tamil","Spanish","French",
                "Chinese","Japanese","German","Portuguese","Russian","Indonesian","Marathi","Swahili",

                "Telugu","Punjabi","Turkish","Urdu","Danish","Maldivian","Greek","Gujarati","Italian"};

        LastSelectLast = TextToSpeechActivity.this.getSharedPreferences("LastSelectLast", Context.MODE_PRIVATE);
        editor2 = LastSelectLast.edit();
        final int LastClickLast = LastSelectLast.getInt("LastClickLast", 0);


        // Language codes
        String[] lCodes = {"bn-BD","en-US","ar-SA","hi-IN","ta-IN","es-CL","fr-FR",
                "zh-TW","jp-JP","de-DE","pt-PT","ru-RU","id-ID","mr-MR","sw-SZ","te-IN","pa-IN","tr-TR","ur-UR",
                "da-DK","dv-MV", "el-GR", "gu-IN", "it-IT" };



        ArrayAdapter adapterForKeyboard = new ArrayAdapter(TextToSpeechActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,languages);
        adapterForKeyboard.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapterForKeyboard);
        spinner2.setSelection(LastClickLast);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                // setting lcode corresponding
                // to the language selected
                lcode = lCodes[i];

                editor2.putInt("LastClickLast",i).commit();



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        microPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                microPhone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE,lcode);
                        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak now!");
                        // starting intent for result
                        activityResultLauncher.launch(intent);
                    }
                });
            }
        });

                //***********************
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

                //***********************

        //********************** To Open Keyboard if Necessary ***************************************************
       keyBoardIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openKeyboard();

            }
        });
        //**************************************************************************

        //*****************************************************************

        commaTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //binding.editText.append(",");

                int cursorPosition = keyboardEditText.getSelectionStart();
                String newText = keyboardEditText.getText().toString().substring(0,cursorPosition)
                        +","+keyboardEditText.getText().toString().substring(cursorPosition);

               keyboardEditText.setText(newText);

                //editText.setSelection(cursorPosition+d.get(0).length());
                keyboardEditText.setSelection(keyboardEditText.getText().length());
            }
        });

        //****************************************************************

        //*****************************************************************

       dariTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //binding.editText.append(",");

                int cursorPosition = keyboardEditText.getSelectionStart();
                String newText = keyboardEditText.getText().toString().substring(0,cursorPosition)
                        +"।"+keyboardEditText.getText().toString().substring(cursorPosition);

                keyboardEditText.setText(newText);

                //editText.setSelection(cursorPosition+d.get(0).length());
                keyboardEditText.setSelection(keyboardEditText.getText().length());
            }
        });

        //****************************************************************

        //*****************************************************************

        dotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //binding.editText.append(",");

                int cursorPosition = keyboardEditText.getSelectionStart();
                String newText = keyboardEditText.getText().toString().substring(0,cursorPosition)
                        +"."+keyboardEditText.getText().toString().substring(cursorPosition);

                keyboardEditText.setText(newText);

                //editText.setSelection(cursorPosition+d.get(0).length());
                keyboardEditText.setSelection(keyboardEditText.getText().length());
            }
        });

        //****************************************************************

        //*****************************************************************

       questionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //binding.editText.append(",");

                int cursorPosition = keyboardEditText.getSelectionStart();
                String newText = keyboardEditText.getText().toString().substring(0,cursorPosition)
                        +"?"+keyboardEditText.getText().toString().substring(cursorPosition);

                keyboardEditText.setText(newText);

                //editText.setSelection(cursorPosition+d.get(0).length());
                keyboardEditText.setSelection(keyboardEditText.getText().length());
            }
        });

        //****************************************************************

        //****************** Erase Character ***************

        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int cursorPosition = keyboardEditText.getSelectionStart();
                if (cursorPosition > 0) {
                    keyboardEditText.setText(keyboardEditText.getText().delete(cursorPosition - 1, cursorPosition));
                    keyboardEditText.setSelection(cursorPosition-1);
                }

            }
        });

        //*****************************************************************
        //********************* To Delete Whole Text *********************************

        removeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keyboardEditText.getText().clear();
            }
        });

        //*************************************************************

        //****************** To Copy the Text ****************
        copyIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(keyboardEditText.getText())){

                    Toast.makeText(TextToSpeechActivity.this,"No Text Found.",Toast.LENGTH_LONG).show();

                }else {
                    ClipboardManager clipboardManager = (ClipboardManager) TextToSpeechActivity.this.getSystemService(Context.CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("tag", keyboardEditText.getText().toString());
                    clipboardManager.setPrimaryClip(clipData);
                    Toast.makeText(TextToSpeechActivity.this, "Copied", Toast.LENGTH_SHORT).show();

                }


            }
        });


        //***************************************************

        //*********** To share text ********************
        shareIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(keyboardEditText.getText())){

                    Toast.makeText(TextToSpeechActivity.this,"No Text Found To Share.",Toast.LENGTH_LONG).show();

                }else {

                    sharedTextOnly(keyboardEditText.getText().toString());

                }


            }
        });












    }// Last Second Bracket before


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(


            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {


                    // if result is not empty
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {


                        // get data and append it to editText
                        ArrayList<String> d = result.getData().getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                        // editText.setText(editText.getText()+" "+d.get(0));

                        int cursorPosition = keyboardEditText.getSelectionStart();
                        String newText = keyboardEditText.getText().toString().substring(0, cursorPosition)
                                + " " + d.get(0) + " " + keyboardEditText.getText().toString().substring(cursorPosition);

                        keyboardEditText.setText(newText);

                        //editText.setSelection(cursorPosition+d.get(0).length());
                       keyboardEditText.setSelection(keyboardEditText.getText().length());


                    } else {
                        Toast.makeText(TextToSpeechActivity.this, "Error recognizing speech. Try again.", Toast.LENGTH_LONG).show();

                    }

                }


            });

    // Method to open keyBord
    private void openKeyboard(){
        InputMethodManager inputMethodManager = (InputMethodManager) TextToSpeechActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(inputMethodManager != null){
            inputMethodManager.showSoftInput(keyboardEditText, 0);
        }
    }

    // TO share text only
    private void sharedTextOnly(String title){
        String shareBody = title;

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"Subject Here");
        intent.putExtra(Intent.EXTRA_TEXT,shareBody);
        startActivity(Intent.createChooser(intent,"Share Via"));
    }


}