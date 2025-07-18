package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class FirstActivity extends AppCompatActivity {


    CardView vocabulary, voicekeyboard, textScanner, qRcodeScanner;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        vocabulary = findViewById(R.id.vocabulary_cardView);
        voicekeyboard = findViewById(R.id.voicekeyboard_cardView);
        textScanner = findViewById(R.id.textScannerCardView);
        qRcodeScanner = findViewById(R.id.qRcodeScanner);



        vocabulary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent vocabIntent = new Intent(FirstActivity.this, ButtonActivity.class);
                startActivity(vocabIntent);


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
                }else {
                    Toast.makeText(FirstActivity.this, "Ad is loading...", Toast.LENGTH_SHORT).show();
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
                }else {
                    Toast.makeText(FirstActivity.this, "Ad is loading...", Toast.LENGTH_SHORT).show();
                }
            }
        });

        MobileAds.initialize(getApplicationContext());
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(getApplicationContext(), "ca-app-pub-3940256099942544/1033173712",
                adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        interstitialAd =null;
                        Toast.makeText(getApplicationContext(), "Ad failed to load", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        FirstActivity.this.interstitialAd = interstitialAd;
                        textScanner.setEnabled(true);
                        qRcodeScanner.setEnabled(true);

                    }
                }

        );






    }
}