package com.mbashrafulislam.banglaoxford3000vocabulary;

import static androidx.lifecycle.LifecycleKt.getCoroutineScope;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.rajat.pdfviewer.PdfRendererView;
import com.rajat.pdfviewer.util.CacheStrategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivityPdfShower extends AppCompatActivity {

    PdfRendererView pdfView;
    public static String myString = "";
    AdView adView;
    private InterstitialAd mInterstitialAd;

    // --- অ্যাড ফ্রিকোয়েন্সি কন্ট্রোল করার জন্য ভেরিয়েবল ---
    private static long lastAdShowTime = 0;
    private static final long AD_INTERVAL = 3 * 60 * 1000; // ৫ মিনিট বিরতি (মিনিট * সেকেন্ড * ১০০০)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pdf_shower);

        pdfView = findViewById(R.id.pdfView);
        adView = findViewById(R.id.adView);

        // ১. অ্যাডমোব ইনিশিয়ালাইজ এবং বিরতি চেক করে অ্যাড লোড
        MobileAds.initialize(this, initializationStatus -> {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastAdShowTime > AD_INTERVAL) {
                loadInterstitialAd();
            }
        });

        // ২. ব্যানার অ্যাড লোড করা
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // ৩. PDF লোড লজিক
        if (myString != null && myString.startsWith("http")) {
            loadPdfFromUrl(myString);
        } else if (myString != null && !myString.isEmpty()) {
            loadPdfFromAssets(myString);
        }

        setupPdfStatusListener();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        applyDisplayCutouts();
    }

    private void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest,

                // Test ID: ca-app-pub-3940256099942544/1033173712
                // Real ID: ca-app-pub-2173890419930461/4961551788
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Alert!")
                .setMessage("Do you want to exit?")
                .setIcon(R.drawable.alerticon)
                .setCancelable(false)
                .setNegativeButton("No", (dialog, i) -> dialog.dismiss())
                .setPositiveButton("Yes", (dialog, i) -> {
                    dialog.dismiss();

                    long currentTime = System.currentTimeMillis();
                    // যদি অ্যাড রেডি থাকে এবং ৫ মিনিট পার হয়ে যায়, তবেই অ্যাড দেখাবে
                    if (mInterstitialAd != null && (currentTime - lastAdShowTime > AD_INTERVAL)) {
                        lastAdShowTime = currentTime; // সময় আপডেট করা হলো
                        mInterstitialAd.show(MainActivityPdfShower.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                finish();
                            }
                        });
                    } else {
                        // অন্যথায় সরাসরি বের হয়ে যাবে
                        finish();
                    }
                })
                .show();
    }

    private void loadPdfFromUrl(String url) {
        File[] files = getCacheDir().listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().endsWith(".pdf")) {
                    file.delete();
                }
            }
        }

        Toast.makeText(this, "Downloading PDF...", Toast.LENGTH_LONG).show();

        new Thread(() -> {
            try {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                Response response = client.newCall(request).execute();

                if (!response.isSuccessful()) {
                    runOnUiThread(() -> Toast.makeText(MainActivityPdfShower.this, "PDF download failed!", Toast.LENGTH_LONG).show());
                    return;
                }

                String fileName = url.substring(url.lastIndexOf("/") + 1);
                File pdfFile = new File(getCacheDir(), fileName);

                InputStream inputStream = response.body().byteStream();
                FileOutputStream outputStream = new FileOutputStream(pdfFile);

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();

                runOnUiThread(() -> {
                    pdfView.initWithFile(pdfFile, CacheStrategy.MAXIMIZE_PERFORMANCE);
                    Toast.makeText(MainActivityPdfShower.this, "PDF Loaded Successfully", Toast.LENGTH_LONG).show();
                });

            } catch (Exception e) {
                runOnUiThread(() -> Toast.makeText(MainActivityPdfShower.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show());
            }
        }).start();
    }

    private void loadPdfFromAssets(String assetFileName) {
        AssetManager assetManager = this.getAssets();
        File file = new File(getCacheDir(), assetFileName);
        try {
            InputStream inputStream = assetManager.open(assetFileName);
            FileOutputStream outputStream = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
            pdfView.initWithFile(file, CacheStrategy.MAXIMIZE_PERFORMANCE);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Asset loading failed!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setupPdfStatusListener() {
        pdfView.setStatusListener(new PdfRendererView.StatusCallBack() {
            @Override public void onPdfRenderSuccess() {}
            @Override public void onPdfRenderStart() {}
            @Override public void onPageChanged(int i, int i1) {}
            @Override public void onPdfLoadProgress(int i, long l, @Nullable Long aLong) {}
            @Override
            public void onPdfLoadStart() {
                Toast.makeText(MainActivityPdfShower.this, "Loading PDF...", Toast.LENGTH_LONG).show();
            }
            @Override public void onPdfLoadSuccess(String absolutePath) {}
            @Override
            public void onError(Throwable error) {
                Toast.makeText(MainActivityPdfShower.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void applyDisplayCutouts() {
        if (findViewById(R.id.pdfShowActivityLayout) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pdfShowActivityLayout), (v, insets) -> {
                Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
                v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
                return WindowInsetsCompat.CONSUMED;
            });
        }
    }
}