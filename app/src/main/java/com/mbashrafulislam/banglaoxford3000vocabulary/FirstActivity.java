package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class FirstActivity extends AppCompatActivity {


    CardView vocabulary, voicekeyboard, textScanner, qRcodeScanner,ielts,freeMockTest;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        vocabulary = findViewById(R.id.vocabulary_cardView);
        voicekeyboard = findViewById(R.id.voicekeyboard_cardView);
        textScanner = findViewById(R.id.textScannerCardView);
        qRcodeScanner = findViewById(R.id.qRcodeScanner);
        ielts = findViewById(R.id.ielts_cardView);
        freeMockTest = findViewById(R.id.free_mock_test_cardView);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // For the status bar color and text white
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            Window window = getWindow();
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//            window.setStatusBarColor(Color.parseColor("#851E3E")); // set your desire color
//
//        }
//
//        // To make the text white
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            getWindow().setDecorFitsSystemWindows(false);
//        } else {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//            );
//        }
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            // Ensure white icons by NOT using LIGHT_STATUS_BAR flag
//            getWindow().getDecorView().setSystemUiVisibility(0);
//        }

       freeMockTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent freeIeltsMockTestIntent = new Intent(FirstActivity.this, Free_IELTS_Mock_Test.class);
                startActivity(freeIeltsMockTestIntent);

                if (interstitialAd != null){
                    interstitialAd.show(FirstActivity.this);
                }

            }
        });

        vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vocabIntent = new Intent(FirstActivity.this, ButtonActivity.class);
                startActivity(vocabIntent);

                if (interstitialAd != null){
                    interstitialAd.show(FirstActivity.this);
                }


            }
        });


        voicekeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent voiceIntent = new Intent(FirstActivity.this, TextToSpeechActivity.class);
                startActivity(voiceIntent);



            }
        });

        textScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent textScannerIntent = new Intent(FirstActivity.this, TextScannerActivity.class);
                startActivity(textScannerIntent);

                if (interstitialAd != null){
                    interstitialAd.show(FirstActivity.this);
                }

            }
        });

        qRcodeScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent qRInternt = new Intent(FirstActivity.this, QRCodeScanner.class);
                startActivity(qRInternt);

                if (interstitialAd != null){
                    interstitialAd.show(FirstActivity.this);
                }
            }
        });

        ielts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ieltsIntent = new Intent(FirstActivity.this, IeltsActivity.class);
                startActivity(ieltsIntent);

                if (interstitialAd != null){
                    interstitialAd.show(FirstActivity.this);
                }

            }
        });


        //MobileAds.initialize(getApplicationContext());
        MobileAds.initialize(this, initializationStatus -> {
            loadMyInterstitialAd();

        });


        applyDisplayCutouts();



    }

    // ২. ইন্টারস্টিশিয়াল অ্যাড লোড করার জন্য আলাদা মেথড
    private void loadMyInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        // এখানে আমি সব স্পেস এবং ভুল অক্ষর সরিয়ে একদম ফ্রেশ টেস্ট আইডি দিয়েছি
        String adUnitId = "ca-app-pub-3940256099942544/1033173712";

        //Test Ad: ca-app-pub-3940256099942544/1033173712

        // Real Ad: ca-app-pub-2173890419930461/8993075146

        InterstitialAd.load(this, adUnitId, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd ad) {
                        interstitialAd = ad;

                        // অ্যাড লোড হলে বাটনগুলো এনাবল করে দিন
                        textScanner.setEnabled(true);
                        qRcodeScanner.setEnabled(true);
                        ielts.setEnabled(true);
                        vocabulary.setEnabled(true);
                        freeMockTest.setEnabled(true);

                        //Toast.makeText(FirstActivity.this, "Ad Loaded", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        interstitialAd = null;
                        // কেন অ্যাড লোড হলো না তা টোস্টে দেখা যাবে (যেমন Code 3 মানে No Fill)
                        //Toast.makeText(FirstActivity.this, "Ad Failed: " + loadAdError.getMessage(), Toast.LENGTH_LONG).show();

                        Toast.makeText(FirstActivity.this, "Ad Failed:", Toast.LENGTH_LONG).show();
                    }
                });
    }



    private void applyDisplayCutouts() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.firstActivityLayout), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                            | WindowInsetsCompat.Type.displayCutout()
            );
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }
}