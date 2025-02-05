package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivityPdfShower extends AppCompatActivity {


    PDFView pdfView;
    public static String myString = " ";
    AdView adView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pdf_shower);


        pdfView = findViewById(R.id.pdfView);
        adView = findViewById(R.id.adView);

        // FOR Admob Ad
        //Start admob ad


        MobileAds.initialize(MainActivityPdfShower.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        //requestConsentFrom();
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        //End admob ad




        pdfView.fromAsset(myString)
                .defaultPage(0)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))

                .load();


    }

    @Override
    public void onBackPressed() {
        // Show an alert dialog to confirm exit
        new AlertDialog.Builder(MainActivityPdfShower.this)
                .setTitle("Make Sure !!!")
                .setMessage("Do You Want To Really Exit?")
                .setIcon(R.drawable.alerticon)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finishAndRemoveTask();
                    }
                })
                .show();
    }

}