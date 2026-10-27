package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class Free_IELTS_Mock_Test extends AppCompatActivity {

    private RewardedAd rewardedAd;
    private Button freeMockTestButton;
    private TextView tvPointsDisplay;
    private SharedPreferences sharedPreferences;

    // Constants
    private static final int AD_REWARD = 100; // 100 points per ad
    private static final long COOLDOWN_MILLIS = 5 * 60 * 1000; // 5 minutes break

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_ielts_mock_test);

        freeMockTestButton = findViewById(R.id.ielts_free_mock_test_button);
        tvPointsDisplay = findViewById(R.id.tv_points_display);
        sharedPreferences = getSharedPreferences("MockTestPrefs", MODE_PRIVATE);
        Button btn499 = findViewById(R.id.ielts_free_mock_test499_button);
        Button btn999 = findViewById(R.id.ielts_mock_test999_button);

        // Update UI at start
        updatePointsUI();

        MobileAds.initialize(this, initializationStatus -> {
            loadRewardedAd();
        });

        freeMockTestButton.setOnClickListener(v -> {
            showBookingInfoDialog();
        });



// ৪৯৯ টাকার প্যাকেজের জন্য ক্লিক লজিক
        btn499.setOnClickListener(v -> {
            String message = "Hello Sir,\nI want to purchase the *STANDARD PACKAGE* (499 Tk/ $5).\n" +
                    "Details: 2 Speaking Mock Tests.\n" +
                    "Please provide payment instructions (BKash/Nagad/Rocket/GPay).";
            sendToWhatsApp(message);
        });

// ৯৯৯ টাকার প্যাকেজের জন্য ক্লিক লজিক
        btn999.setOnClickListener(v -> {
            String message = "Hello Sir,\nI want to purchase the *PREMIUM PACKAGE* (999 Tk/ $10).\n" +
                    "Details: 5 Speaking Mock Tests.\n" +
                    "Please provide payment instructions (BKash/Nagad/Rocket/GPay).";
            sendToWhatsApp(message);
        });

        applyDisplayCutouts();



    }   // last second baracket

    private void updatePointsUI() {
        int points = sharedPreferences.getInt("user_points", 0);
        if (points < 200) {
            tvPointsDisplay.setText("First Mock Test Progress: " + points + "/200");
            freeMockTestButton.setText("Get Points for 1st Test");
        } else if (points < 400) {
            tvPointsDisplay.setText("Second Mock Test Progress: " + points + "/400");
            freeMockTestButton.setText("Get Points for 2nd Test");
        } else {
            tvPointsDisplay.setText("Status: 400/400 (All Free Tests Unlocked)");
            freeMockTestButton.setText("Limit Reached");
        }
    }

    private void showBookingInfoDialog() {
        int points = sharedPreferences.getInt("user_points", 0);
        long lastAdTime = sharedPreferences.getLong("last_ad_timestamp", 0);
        long currentTime = System.currentTimeMillis();

        // 1. Check Total Limit
        if (points >= 400) {
            showLimitReachedDialog();
            return;
        }

        // 2. Check 5-Minute Break (Cooldown)
        if (currentTime - lastAdTime < COOLDOWN_MILLIS) {
            long remainingMinutes = (COOLDOWN_MILLIS - (currentTime - lastAdTime)) / 60000;
            Toast.makeText(this, "Please wait " + (remainingMinutes + 1) + " more minutes for the next ad.", Toast.LENGTH_LONG).show();
            return;
        }

        // 3. Information Dialog in English
        String message = "To unlock one FREE Mock Test, you need 200 points.\n\n" +
                "Rules:\n" +
                "1. You will earn 100 points per video ad.\n" +
                "2. You must watch the video until the end to earn points.\n" +
                "3. There is a 5-minute break between each ad.";

        new AlertDialog.Builder(this)
                .setTitle("IELTS Speaking Mock Test")
                .setMessage(message)
                .setPositiveButton("Watch Reward Ad", (dialog, which) -> {
                    startAdProcess();
                })
                .setNegativeButton("Close", null)
                .show();
    }

    private void startAdProcess() {
        if (rewardedAd != null) {
            rewardedAd.show(this, rewardItem -> {
                // User earned reward
                int currentPoints = sharedPreferences.getInt("user_points", 0);
                int newPoints = currentPoints + AD_REWARD;

                // Save points and timestamp
                sharedPreferences.edit()
                        .putInt("user_points", newPoints)
                        .putLong("last_ad_timestamp", System.currentTimeMillis())
                        .apply();

                updatePointsUI();
                checkIfUnlockReached(newPoints);
                loadRewardedAd();
            });
        } else {
            Toast.makeText(this, "Ad is loading, please try again in 5 seconds.", Toast.LENGTH_LONG).show();
            loadRewardedAd();
        }
    }

    private void checkIfUnlockReached(int points) {
        if (points == 200) {
            showSuccessDialog("Congratulations! Your 1st Mock Test is unlocked. Please send a message to book your slot.", 1);
        } else if (points == 400) {
            showSuccessDialog("Congratulations! Your 2nd Mock Test is unlocked. Please send a message to book your slot.", 2);
        }
    }

//    private void showSuccessDialog(String msg, int testNum) {
//        new AlertDialog.Builder(this)
//                .setTitle("Test Unlocked!")
//                .setMessage(msg)
//                .setPositiveButton("Book via WhatsApp", (dialog, which) -> openWhatsAppForBooking(testNum))
//                .setNegativeButton("Later", null)
//                .show();
//
//    }
private void showSuccessDialog(String msg, int testNum) {
    new AlertDialog.Builder(this)
            .setTitle("Test Unlocked!")
            .setMessage(msg)
            .setCancelable(false) // এটি যোগ করলে ডায়ালগের বাইরে ক্লিক করলে বন্ধ হবে না
            .setPositiveButton("Book via WhatsApp", (dialog, which) -> {
                openWhatsAppForBooking(testNum);
                dialog.dismiss(); // হোয়াটসঅ্যাপ ওপেন হওয়ার পর ডায়ালগ বন্ধ হবে
            })
            .setNegativeButton("Later", (dialog, which) -> {
                dialog.dismiss(); // 'Later' বাটনে ক্লিক করলে তবেই বন্ধ হবে
            })
            .show();
}

    private void openWhatsAppForBooking(int testNumber) {
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        String deviceCode = androidId.substring(Math.max(0, androidId.length() - 5)).toUpperCase();

        String message = "Hello Sir,\nI have achieved enough points for Mock Test #" + testNumber + "." +
                "\nDevice Verification ID: " + deviceCode +
                "\n\nFull Name (As per Passport): " +
                "\nPassport Number: " +
                "\nI want to book my " + (testNumber == 1 ? "1st" : "2nd") + " FREE Mock Test.";

        sendToWhatsApp(message);
    }

    private void openWhatsAppForPremium() {
        String message = "Hello Sir, I want to purchase your Premium Mock Test packages.";
        sendToWhatsApp(message);
    }

    private void sendToWhatsApp(String message) {
        try {
            String url = "https://api.whatsapp.com/send?phone=4915251803436&text=" + Uri.encode(message);
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "WhatsApp is not installed!", Toast.LENGTH_LONG).show();
        }
    }

    private void showLimitReachedDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Free Limit Reached!")
                .setMessage("You have used all your free mock test opportunities. Please purchase a premium package for more tests.")
                .setPositiveButton("Buy Premium", (dialog, which) -> openWhatsAppForPremium())
                .setNegativeButton("Close", null)
                .show();
    }

    private void loadRewardedAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",

                // Test ID:  ca-app-pub-3940256099942544/5224354917

                // Real ID: ca-app-pub-2173890419930461/4413185001

                adRequest, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        rewardedAd = null;
                    }
                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;
                    }
                });
    }


    private void applyDisplayCutouts() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.free_ielts_mockTest_layout), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                            | WindowInsetsCompat.Type.displayCutout()
            );
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }


}