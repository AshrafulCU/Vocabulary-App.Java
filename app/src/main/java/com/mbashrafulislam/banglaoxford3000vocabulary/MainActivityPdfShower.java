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
    import com.rajat.pdfviewer.HeaderData;
    import com.rajat.pdfviewer.PdfRendererView;
    import com.rajat.pdfviewer.util.CacheStrategy;

    import java.io.File;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.io.InputStream;
    import java.util.HashMap;
    import java.util.Map;

    import okhttp3.OkHttpClient;
    import okhttp3.Request;
    import okhttp3.Response;

    public class MainActivityPdfShower extends AppCompatActivity {

        PdfRendererView pdfView;
        public static String myString = ""; // এখানে Asset নাম অথবা URL থাকবে
        AdView adView;
        // ১. ইন্টারস্টিশিয়াল অ্যাডের জন্য ভেরিয়েবল
        private InterstitialAd mInterstitialAd;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            EdgeToEdge.enable(this);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_pdf_shower);

            pdfView = findViewById(R.id.pdfView);
            adView = findViewById(R.id.adView);

            // Admob Setup
            MobileAds.initialize(this, initializationStatus -> {
                loadInterstitialAd();

            });
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);

            // প্রধান লজিক: URL নাকি Asset চেক করা
            if (myString != null && myString.startsWith("http")) {
                // ১. যদি URL হয় (Google Drive)
                loadPdfFromUrl(myString);
            } else if (myString != null && !myString.isEmpty()) {
                // ২. যদি Assets ফাইল হয়
                loadPdfFromAssets(myString);
            }

            // Status Listener
            setupPdfStatusListener();

            // Screenshot block (নিরাপত্তার জন্য)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);

            applyDisplayCutouts();
        }

        // URL থেকে PDF লোড করার মেথড (গুগল ড্রাইভ ফিক্স সহ)
//        private void loadPdfFromUrl(String url) {
//            // ১. একটি Map তৈরি করে তাতে User-Agent যোগ করুন
//            Map<String, String> headersMap = new HashMap<>();
//            headersMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
//
//            // ২. HeaderData অবজেক্টে Map-টি পাস করুন
//            HeaderData headers = new HeaderData(headersMap);
//
//            // ৩. লোড করা শুরু করুন
//            pdfView.initWithUrl(
//                    url,
//                    headers,
//                    getCoroutineScope(getLifecycle()),
//                    getLifecycle(),
//                    CacheStrategy.MAXIMIZE_PERFORMANCE
//            );
//        }
        private void loadInterstitialAd(){
            AdRequest adRequest = new AdRequest.Builder().build();

            // এখানে টেস্ট আইডি দেওয়া হয়েছে
            InterstitialAd.load(this, "ca-app-pub-2173890419930461/4961551788", adRequest,

                    // Test Ad: ca-app-pub-3940256099942544/1033173712

                    // Real Ad: ca-app-pub-2173890419930461/4961551788

                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            mInterstitialAd = interstitialAd;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            mInterstitialAd = null;
                            Toast.makeText(MainActivityPdfShower.this, "Ad Failed: " + loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        // ৪. ব্যাক বাটন চাপলে অ্যাড দেখানো
        @android.annotation.SuppressLint("MissingSuperCall")
        @Override
        public void onBackPressed() {
            new AlertDialog.Builder(this)
                    .setTitle("Alert!")
                    .setMessage("Do you want to exit?")
                    .setIcon(R.drawable.alerticon)
                    .setNegativeButton("No", (dialog, i) -> dialog.dismiss())
                    .setPositiveButton("Yes", (dialog, i) -> {
                        dialog.dismiss();

                        // যদি অ্যাড লোড হয়ে থাকে তবে দেখাবে, নাহলে সরাসরি বের হয়ে যাবে
                        if (mInterstitialAd != null) {
                            mInterstitialAd.show(MainActivityPdfShower.this);

                            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                                @Override
                                public void onAdDismissedFullScreenContent() {
                                    // অ্যাড বন্ধ করলে অ্যাক্টিভিটি ফিনিশ হবে
                                    finish();
                                }
                            });
                        } else {
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

                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    Response response = client.newCall(request).execute();

                    if (!response.isSuccessful()) {

                        runOnUiThread(() ->
                                Toast.makeText(
                                        MainActivityPdfShower.this,
                                        "PDF download failed!",
                                        Toast.LENGTH_LONG
                                ).show());

                        return;
                    }

                    //File pdfFile = new File(getCacheDir(), "temp_pdf.pdf"); (ata dial akai pdf open hova onno button a click korlao tai nichar first 2 line ar code lika hoiacha)
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

                        pdfView.initWithFile(
                                pdfFile,
                                CacheStrategy.MAXIMIZE_PERFORMANCE
                        );

                        Toast.makeText(
                                MainActivityPdfShower.this,
                                "PDF Loaded Successfully",
                                Toast.LENGTH_LONG
                        ).show();

                    });

                } catch (Exception e) {

                    runOnUiThread(() ->
                            Toast.makeText(
                                    MainActivityPdfShower.this,
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG
                            ).show());

                }

            }).start();
        }

        // Assets থেকে PDF লোড করার মেথড
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

                // Assets থেকে ফাইল নিয়ে লোড করা
                pdfView.initWithFile(file, CacheStrategy.MAXIMIZE_PERFORMANCE);

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Asset loading failed!", Toast.LENGTH_SHORT).show();
            }
        }

        private void setupPdfStatusListener() {
            pdfView.setStatusListener(new PdfRendererView.StatusCallBack() {
                @Override
                public void onPdfRenderSuccess() {}

                @Override
                public void onPdfRenderStart() {}

                @Override
                public void onPageChanged(int i, int i1) {}

                @Override
                public void onPdfLoadProgress(int i, long l, @Nullable Long aLong) {}

                @Override
                public void onPdfLoadStart() {
                    Toast.makeText(MainActivityPdfShower.this, "Loading PDF...", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onPdfLoadSuccess(String absolutePath) {
                    // সফলভাবে লোড হলে
                }

                @Override
                public void onError(Throwable error) {
                    // কোনো এরর হলে ইউজারকে জানানো
                    Toast.makeText(MainActivityPdfShower.this, "Error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        }

//        @Override
//        public void onBackPressed() {
//            new AlertDialog.Builder(this)
//                    .setTitle("Alert!")
//                    .setMessage("Do you want to exit?")
//                    .setIcon(R.drawable.alerticon)
//                    .setNegativeButton("No", (dialog, i) -> dialog.dismiss())
//                    .setPositiveButton("Yes", (dialog, i) -> {
//                        dialog.dismiss();
//                        finish();
//                    })
//                    .show();
//        }

        private void applyDisplayCutouts() {
            // নিশ্চিত করুন আপনার Layout-এর ID 'pdfShowActivityLayout'
            if (findViewById(R.id.pdfShowActivityLayout) != null) {
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pdfShowActivityLayout), (v, insets) -> {
                    Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
                    v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
                    return WindowInsetsCompat.CONSUMED;
                });
            }
        }
    }