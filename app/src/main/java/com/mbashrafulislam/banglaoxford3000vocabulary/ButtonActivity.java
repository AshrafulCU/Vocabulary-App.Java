package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class ButtonActivity extends AppCompatActivity {


CardView cambridge11_reading,cambridge12_reading,cambridge13_reading,cambridge14_reading,
        cambridge15_reading,cambridge16_reading,cambridge17_reading,cambridge18_reading,
        cambridge19_reading,cambridge20_reading;

CardView cambridge11_test1_reading,cambridge11_test2_reading,cambridge11_test3_reading, cambridge11_test4_reading,
        cambridge12_test1_reading,cambridge12_test2_reading,cambridge12_test3_reading, cambridge12_test4_reading;

LinearLayout cambridge11_linearlayout_subsections,  cambridge12_linearlayout_subsections;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        cambridge11_reading=findViewById(R.id.cambridge11_reading);
        cambridge12_reading=findViewById(R.id.cambridge12_reading);
        cambridge13_reading=findViewById(R.id.cambridge13_reading);
        cambridge14_reading=findViewById(R.id.cambridge14_reading);
        cambridge15_reading=findViewById(R.id.cambridge15_reading);
        cambridge16_reading=findViewById(R.id.cambridge16_reading);
        cambridge17_reading=findViewById(R.id.cambridge17_reading);
        cambridge18_reading=findViewById(R.id.cambridge18_reading);
        cambridge19_reading=findViewById(R.id.cambridge19_reading);
        cambridge20_reading=findViewById(R.id.cambridge20_reading);

        cambridge11_linearlayout_subsections=findViewById(R.id.cambridge11_linearlayout_subsections);
        cambridge12_linearlayout_subsections=findViewById(R.id.cambridge12_linearlayout_subsections);


        cambridge11_test1_reading=findViewById(R.id.cambridge11_test1_reading);
        cambridge11_test2_reading = findViewById(R.id.cambridge11_test2_reading);
        cambridge11_test3_reading = findViewById(R.id.cambridge11_test3_reading);
        cambridge11_test4_reading = findViewById(R.id.cambridge11_test4_reading);
        cambridge12_test1_reading = findViewById(R.id.cambridge12_test1_reading);
        cambridge12_test2_reading = findViewById(R.id.cambridge12_test2_reading);
        cambridge12_test3_reading = findViewById(R.id.cambridge12_test3_reading);
        cambridge12_test4_reading = findViewById(R.id.cambridge12_test4_reading);








        cambridge11_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge11_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge11_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge11_linearlayout_subsections.setVisibility(View.GONE);
                }
            }
        });

        cambridge11_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                MainActivityPdfShower.myString = "reading_cambridge11.pdf";
//                Intent aIntent = new Intent(ButtonActivity.this,
//                        MainActivityPdfShower.class);
//                startActivity(aIntent);
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge11_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge11_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge11_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge11_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge11_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge11_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge11_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });



        cambridge12_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
                }

            }
        });
        cambridge12_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge12_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge12_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge12_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge12_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge12_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge12_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge12_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });



      cambridge13_reading.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              if (!isInternetAvailable()) {
                  showNoInternetDialog();
                  return;
              }
              Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();


          }
      });

        cambridge14_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge15_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge16_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge17_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge18_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge19_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge20_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                Toast.makeText(ButtonActivity.this, "We are updating this feature. Thank you for your Patience.", Toast.LENGTH_LONG).show();
            }
        });



        // To edge to edge
        applyDisplayCutouts();




    }
    private void applyDisplayCutouts() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonActivityLayout), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars()
                            | WindowInsetsCompat.Type.displayCutout()
            );
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });
    }

    private boolean isInternetAvailable() {

        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {

            Network network = connectivityManager.getActiveNetwork();

            if (network == null) {
                return false;
            }

            NetworkCapabilities capabilities =
                    connectivityManager.getNetworkCapabilities(network);

            return capabilities != null &&
                    (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                            || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET));
        }

        return false;
    }

    private void showNoInternetDialog() {

        new AlertDialog.Builder(this)
                .setTitle("No Internet Connection")
                .setMessage("Please check your internet connection and try again.")
                .setIcon(R.drawable.alerticon) // optional
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .show();
    }




}