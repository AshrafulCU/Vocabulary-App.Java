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
        cambridge12_test1_reading,cambridge12_test2_reading,cambridge12_test3_reading, cambridge12_test4_reading,
        cambridge13_test1_reading,cambridge13_test2_reading,cambridge13_test3_reading, cambridge13_test4_reading,
        cambridge14_test1_reading,cambridge14_test2_reading,cambridge14_test3_reading, cambridge14_test4_reading,
        cambridge15_test1_reading,cambridge15_test2_reading,cambridge15_test3_reading, cambridge15_test4_reading,
        cambridge16_test1_reading,cambridge16_test2_reading,cambridge16_test3_reading, cambridge16_test4_reading,
        cambridge17_test1_reading,cambridge17_test2_reading,cambridge17_test3_reading, cambridge17_test4_reading,
        cambridge18_test1_reading,cambridge18_test2_reading,cambridge18_test3_reading, cambridge18_test4_reading,
        cambridge19_test1_reading,cambridge19_test2_reading,cambridge19_test3_reading, cambridge19_test4_reading,
        cambridge20_test1_reading,cambridge20_test2_reading,cambridge20_test3_reading, cambridge20_test4_reading;




LinearLayout cambridge11_linearlayout_subsections,  cambridge12_linearlayout_subsections, cambaridge13_linearlayout_subsections,
        cambridge14_linearlayout_subsections, cambridge15_linearlayout_subsections,cambridge16_linearlayout_subsections,
        cambridge17_linearlayout_subsections, cambridge18_linearlayout_subsections, cambridge19_linearlayout_subsections,
        cambridge20_linearlayout_subsections;

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
        cambaridge13_linearlayout_subsections=findViewById(R.id.cambridge13_linearlayout_subsections);
        cambridge14_linearlayout_subsections=findViewById(R.id.cambridge14_linearlayout_subsections);
        cambridge15_linearlayout_subsections=findViewById(R.id.cambridge15_linearlayout_subsections);
        cambridge16_linearlayout_subsections=findViewById(R.id.cambridge16_linearlayout_subsections);
        cambridge17_linearlayout_subsections=findViewById(R.id.cambridge17_linearlayout_subsections);
        cambridge18_linearlayout_subsections=findViewById(R.id.cambridge18_linearlayout_subsections);
        cambridge19_linearlayout_subsections=findViewById(R.id.cambridge19_linearlayout_subsections);
        cambridge20_linearlayout_subsections=findViewById(R.id.cambridge20_linearlayout_subsections);


        cambridge11_test1_reading=findViewById(R.id.cambridge11_test1_reading);
        cambridge11_test2_reading = findViewById(R.id.cambridge11_test2_reading);
        cambridge11_test3_reading = findViewById(R.id.cambridge11_test3_reading);
        cambridge11_test4_reading = findViewById(R.id.cambridge11_test4_reading);

        cambridge12_test1_reading = findViewById(R.id.cambridge12_test1_reading);
        cambridge12_test2_reading = findViewById(R.id.cambridge12_test2_reading);
        cambridge12_test3_reading = findViewById(R.id.cambridge12_test3_reading);
        cambridge12_test4_reading = findViewById(R.id.cambridge12_test4_reading);

        cambridge13_test1_reading = findViewById(R.id.cambridge13_test1_reading);
        cambridge13_test2_reading = findViewById(R.id.cambridge13_test2_reading);
        cambridge13_test3_reading = findViewById(R.id.cambridge13_test3_reading);
        cambridge13_test4_reading = findViewById(R.id.cambridge13_test4_reading);

        cambridge14_test1_reading = findViewById(R.id.cambridge14_test1_reading);
        cambridge14_test2_reading = findViewById(R.id.cambridge14_test2_reading);
        cambridge14_test3_reading = findViewById(R.id.cambridge14_test3_reading);
        cambridge14_test4_reading = findViewById(R.id.cambridge14_test4_reading);

        cambridge15_test1_reading = findViewById(R.id.cambridge15_test1_reading);
        cambridge15_test2_reading = findViewById(R.id.cambridge15_test2_reading);
        cambridge15_test3_reading = findViewById(R.id.cambridge15_test3_reading);
        cambridge15_test4_reading = findViewById(R.id.cambridge15_test4_reading);

        cambridge16_test1_reading = findViewById(R.id.cambridge16_test1_reading);
        cambridge16_test2_reading = findViewById(R.id.cambridge16_test2_reading);
        cambridge16_test3_reading = findViewById(R.id.cambridge16_test3_reading);
        cambridge16_test4_reading = findViewById(R.id.cambridge16_test4_reading);

        cambridge17_test1_reading = findViewById(R.id.cambridge17_test1_reading);
        cambridge17_test2_reading = findViewById(R.id.cambridge17_test2_reading);
        cambridge17_test3_reading = findViewById(R.id.cambridge17_test3_reading);
        cambridge17_test4_reading = findViewById(R.id.cambridge17_test4_reading);

        cambridge18_test1_reading = findViewById(R.id.cambridge18_test1_reading);
        cambridge18_test2_reading = findViewById(R.id.cambridge18_test2_reading);
        cambridge18_test3_reading = findViewById(R.id.cambridge18_test3_reading);
        cambridge18_test4_reading = findViewById(R.id.cambridge18_test4_reading);

        cambridge19_test1_reading = findViewById(R.id.cambridge19_test1_reading);
        cambridge19_test2_reading = findViewById(R.id.cambridge19_test2_reading);
        cambridge19_test3_reading = findViewById(R.id.cambridge19_test3_reading);
        cambridge19_test4_reading = findViewById(R.id.cambridge19_test4_reading);

        cambridge20_test1_reading = findViewById(R.id.cambridge20_test1_reading);
        cambridge20_test2_reading = findViewById(R.id.cambridge20_test2_reading);
        cambridge20_test3_reading = findViewById(R.id.cambridge20_test3_reading);
        cambridge20_test4_reading = findViewById(R.id.cambridge20_test4_reading);









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
              if (cambaridge13_linearlayout_subsections.getVisibility() == View.GONE) {
                  cambaridge13_linearlayout_subsections.setVisibility(View.VISIBLE);
              } else {
                cambaridge13_linearlayout_subsections.setVisibility(View.GONE);
              }



          }
      });
        cambridge13_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge13_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge13_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge13_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge13_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge13_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge13_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge13_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });



        cambridge14_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge14_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge14_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge14_linearlayout_subsections.setVisibility(View.GONE);
                }
            }
        });

        cambridge14_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge14_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cambridge14_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge14_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge14_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge14_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge14_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge14_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });





        cambridge15_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge15_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge15_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge15_linearlayout_subsections.setVisibility(View.GONE);
                }

            }
        });

        cambridge15_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge15_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge15_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge15_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge15_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge15_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge15_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge15_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });




        cambridge16_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge16_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge16_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge16_linearlayout_subsections.setVisibility(View.GONE);
                }


            }
        });
        cambridge16_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge16_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge16_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge16_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge16_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge16_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge16_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge16_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });



        cambridge17_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge17_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge17_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge17_linearlayout_subsections.setVisibility(View.GONE);
                }
            }
        });
        cambridge17_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge17_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge17_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge17_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge17_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge17_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge17_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge17_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });




        cambridge18_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge18_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge18_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge18_linearlayout_subsections.setVisibility(View.GONE);
                }

            }
        });
        cambridge18_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge18_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge18_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge18_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge18_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge18_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge18_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge18_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });



        cambridge19_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge19_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge19_linearlayout_subsections.setVisibility(View.VISIBLE);
                } else {
                    cambridge19_linearlayout_subsections.setVisibility(View.GONE);
                }

            }
        });
        cambridge19_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge19_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge19_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge19_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge19_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge19_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge19_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge19_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });




        cambridge20_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isInternetAvailable()) {
                    showNoInternetDialog();
                    return;
                }
                if (cambridge20_linearlayout_subsections.getVisibility() == View.GONE) {
                    cambridge20_linearlayout_subsections.setVisibility(View.VISIBLE);
                    Toast.makeText(ButtonActivity.this, "Please scroll up to show the answers for Cambridge Reading Test 20.", Toast.LENGTH_LONG ).show();

                } else {
                    cambridge20_linearlayout_subsections.setVisibility(View.GONE);
                }

            }
        });
        cambridge20_test1_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge20_test1.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge20_test2_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge20_test2.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge20_test3_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge20_test3.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        cambridge20_test4_reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString
                        = "https://github.com/AshrafulCU/IELTS-PDFs/releases/download/v1.0/reading_cambridge20_test4.pdf";
                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

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