package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class ButtonActivity extends AppCompatActivity {

    Button aButton,bButton,cButton,dButton,eButton,fButton,gButton,hButton,
            iButton,jklButton,mButton,motivationButton,noButton,pButton,qrButton,
            sButton,tButton,uButton,vButton,wyzButton;


    LottieAnimationView lottieMic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        aButton = findViewById(R.id.aButton);
        bButton = findViewById(R.id.bButton);
        cButton = findViewById(R.id.cButton);
        dButton = findViewById(R.id.dButton);
        eButton = findViewById(R.id.eButton);
        fButton = findViewById(R.id.fButton);
        gButton = findViewById(R.id.gButton);
        hButton = findViewById(R.id.hButton);
        iButton = findViewById(R.id.iButton);
        jklButton = findViewById(R.id.jklButton);
        mButton = findViewById(R.id.mButton);
        motivationButton = findViewById(R.id.motivationButton);
        noButton = findViewById(R.id.noButton);
        pButton = findViewById(R.id.pButton);
        qrButton = findViewById(R.id.qrButton);
        sButton = findViewById(R.id.sButton);
        tButton = findViewById(R.id.tButton);
        uButton = findViewById(R.id.uButton);
        vButton = findViewById(R.id.vButton);
        wyzButton = findViewById(R.id.wyzButton);

        lottieMic = findViewById(R.id.lottieMic);



        lottieMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(ButtonActivity.this,TextToSpeechActivity.class);
                startActivity( myIntent );
            }
        });



        aButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "a.pdf";

                Intent aIntent = new Intent(ButtonActivity.this, MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "b.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "c.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "d.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "e.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "f.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        gButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "g.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        hButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "h.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        iButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "i.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        jklButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "jkl.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "m.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        motivationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "motivation.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "no.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "p.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        qrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "qr.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        sButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "s.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "t.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "u.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        vButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "v.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        wyzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "wyz.pdf";

                Intent aIntent = new Intent(ButtonActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        // To edge to edge
        applyDisplayCutouts();

        // to make the status bar color and text to color due to edge to edge

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#851E3E")); // Set your desired color
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            getWindow().setDecorFitsSystemWindows(false);
        } else {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Ensure white icons by NOT using LIGHT_STATUS_BAR flag
            getWindow().getDecorView().setSystemUiVisibility(0);
        }



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




}