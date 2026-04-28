package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwnerKt;

// নতুন লাইব্রেরি ইমপোর্ট
import com.rajat.pdfviewer.PdfRendererView;
import com.rajat.pdfviewer.util.CacheStrategy;
import com.rajat.pdfviewer.util.PdfSource;
import com.rajat.pdfviewer.util.saveTo;
import com.rajat.pdfviewer.HeaderData;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivityPdfShower extends AppCompatActivity {

    PdfRendererView pdfView; // টাইপ পরিবর্তন করা হয়েছে
    //public static String myString = "a.pdf"; // ডিফল্ট নাম
    public static String myString = "a.pdf"; // ডিফল্ট নাম
    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pdf_shower);

        pdfView = findViewById(R.id.pdfView);
        adView = findViewById(R.id.adView);

        // Admob সেটআপ
        MobileAds.initialize(this, initializationStatus -> {});
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //String assetFileName = "a.pdf";
        AssetManager assetManager = this.getAssets();
        File file = new File(getCacheDir(),myString);
        // Inside onCreate method
      try {
          InputStream inputStream = assetManager.open(myString);
          FileOutputStream outputStream = new FileOutputStream(file);

          byte[] buffer = new byte[1024];
          int length;
          while ((length=inputStream.read(buffer))>0){
              outputStream.write(buffer,0,length);
          }
          inputStream.close();
          outputStream.close();
          pdfView.initWithFile(file,CacheStrategy.MAXIMIZE_PERFORMANCE);

      }catch (IOException e){
          e.printStackTrace();
      }


        // 3. Status Listener with English Toast Messages
        pdfView.setStatusListener(new PdfRendererView.StatusCallBack() {
            @Override
            public void onPdfLoadStart() {
                android.widget.Toast.makeText(MainActivityPdfShower.this, "Opening PDF...", android.widget.Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPdfLoadProgress(int progress, long downloadedBytes, Long totalBytes) {
                // Not showing Toast here because it triggers too frequently
            }

            @Override
            public void onPdfLoadSuccess(String absolutePath) {
                android.widget.Toast.makeText(MainActivityPdfShower.this, "PDF Loaded Successfully", android.widget.Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable error) {
                android.widget.Toast.makeText(MainActivityPdfShower.this, "Error: Unable to open PDF", android.widget.Toast.LENGTH_LONG).show();
            }

            @Override
            public void onPageChanged(int currentPage, int totalPage) {
                // Shows a toast every time the user flips a page
              //  android.widget.Toast.makeText(MainActivityPdfShower.this, "Page " + (currentPage + 1) + " of " + totalPage, android.widget.Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPdfRenderStart() {
            }

            @Override
            public void onPdfRenderSuccess() {
                android.widget.Toast.makeText(MainActivityPdfShower.this, "PDF Rendering Complete", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        pdfView.setZoomListener(new PdfRendererView.ZoomListener() {
            @Override
            public void onZoomChanged(boolean isZoomedIn, float scale) {
                if (isZoomedIn) {
                    android.widget.Toast.makeText(MainActivityPdfShower.this, "Zoomed In (Scale: " + scale + ")", android.widget.Toast.LENGTH_SHORT).show();
                } else {
                    android.widget.Toast.makeText(MainActivityPdfShower.this, "Original View", android.widget.Toast.LENGTH_SHORT).show();
                }
            }
        });



        //1. This officially blocks the screenshot (resulting in a black image)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);

// 2. This detects the screenshot attempt ONLY when it happens
        getWindow().getDecorView().getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() {
            @Override
            public void onWindowFocusChanged(boolean hasFocus) {
                // hasFocus is false when the system screenshot UI or Power menu pops up
                if (!hasFocus) {
                   // android.widget.Toast.makeText(MainActivityPdfShower.this," ",android.widget.Toast.LENGTH_SHORT).show();
                }
            }
        });



        applyDisplayCutouts();

        // স্ট্যাটাস বার কালার সেটআপ
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#851E3E"));
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Alert!")
                .setMessage("Do you want to exit?")
                .setIcon(R.drawable.alerticon)
                .setNegativeButton("No", (dialog, i) -> dialog.dismiss())
                .setPositiveButton("Yes", (dialog, i) -> {
                    dialog.dismiss();
                    finish();
                })
                .show();
    }

    private void applyDisplayCutouts() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pdfShowActivityLayout), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }
}