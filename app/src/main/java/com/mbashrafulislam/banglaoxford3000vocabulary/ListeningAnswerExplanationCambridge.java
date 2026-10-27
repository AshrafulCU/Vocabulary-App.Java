package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListeningAnswerExplanationCambridge extends AppCompatActivity {

    CardView cambridge11_listening,cambridge12_listening,cambridge13_listening,cambridge14_listening,cambridge15_listening,
    cambridge16_listening, cambridge17_listening, cambridge18_listening, cambridge19_listening, cambridge20_listening;
    LinearLayout cambridge11_linearlayout_subsections,  cambridge12_linearlayout_subsections, cambaridge13_linearlayout_subsections,
            cambridge14_linearlayout_subsections, cambridge15_linearlayout_subsections, cambridge16_linearlayout_subsections, cambridge17_linearlayout_subsections,
    cambridge18_linearlayout_subsections, cambridge19_linearlayout_subsections, cambridge20_linearlayout_subsections;

    //Button to add pdf
    CardView cambridge11_test1_listening,cambridge11_test2_listening,cambridge11_test3_listening,cambridge11_test4_listening;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_listening_answer_explanation_cambridge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cambridge11_listening = findViewById(R.id.cambridge11_listening);
        cambridge12_listening = findViewById(R.id.cambridge12_listening);
        cambridge13_listening = findViewById(R.id.cambridge13_listening);
        cambridge14_listening = findViewById(R.id.cambridge14_listening);
        cambridge15_listening = findViewById(R.id.cambridge15_listening);
        cambridge16_listening = findViewById(R.id.cambridge16_listening);
        cambridge17_listening = findViewById(R.id.cambridge17_listening);
        cambridge18_listening = findViewById(R.id.cambridge18_listening);
        cambridge19_listening = findViewById(R.id.cambridge19_listening);
        cambridge20_listening = findViewById(R.id.cambridge20_listening);





        cambridge11_linearlayout_subsections = findViewById(R.id.cambridge11_linearlayout_subsections);
        cambridge12_linearlayout_subsections = findViewById(R.id.cambridge12_linearlayout_subsections);
        cambaridge13_linearlayout_subsections = findViewById(R.id.cambridge13_linearlayout_subsections);
        cambridge14_linearlayout_subsections = findViewById(R.id.cambridge14_linearlayout_subsections);
        cambridge15_linearlayout_subsections = findViewById(R.id.cambridge15_linearlayout_subsections);
        cambridge16_linearlayout_subsections = findViewById(R.id.cambridge16_linearlayout_subsections);
        cambridge17_linearlayout_subsections = findViewById(R.id.cambridge17_linearlayout_subsections);
        cambridge18_linearlayout_subsections = findViewById(R.id.cambridge18_linearlayout_subsections);
        cambridge19_linearlayout_subsections = findViewById(R.id.cambridge19_linearlayout_subsections);
        cambridge20_linearlayout_subsections = findViewById(R.id.cambridge20_linearlayout_subsections);





        // Button to add pdf

        cambridge11_test1_listening = findViewById(R.id.cambridge11_test1_listening);
        cambridge11_test2_listening = findViewById(R.id.cambridge11_test2_listening);
        cambridge11_test3_listening = findViewById(R.id.cambridge11_test3_listening);
        cambridge11_test4_listening = findViewById(R.id.cambridge11_test4_listening);







        cambridge11_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

        cambridge11_test1_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/listening_cambridge11_test1.pdf";
                Intent aIntent = new Intent(ListeningAnswerExplanationCambridge.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge11_test2_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/listening_cambridge11_test2.pdf";
                Intent aIntent = new Intent(ListeningAnswerExplanationCambridge.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge11_test3_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/listening_cambridge11_test3.pdf";
                Intent aIntent = new Intent(ListeningAnswerExplanationCambridge.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge11_test4_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/listening_cambridge11_test4.pdf";
                Intent aIntent = new Intent(ListeningAnswerExplanationCambridge.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });


        cambridge12_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge13_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge14_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge15_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge16_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge17_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });

        cambridge18_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });


        cambridge19_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });


        cambridge20_listening.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isInternetAvailable()) {
//                    showNoInternetDialog();
//                    return;
//                }
//                if (cambridge12_linearlayout_subsections.getVisibility() == View.GONE) {
//                    cambridge12_linearlayout_subsections.setVisibility(View.VISIBLE);
//                } else {
//                    cambridge12_linearlayout_subsections.setVisibility(View.GONE);
//                }

                Toast.makeText(ListeningAnswerExplanationCambridge.this, "We are updating this feature soon. Thank you for your patience.", Toast.LENGTH_LONG).show();
            }
        });





    }  // last second bracket

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