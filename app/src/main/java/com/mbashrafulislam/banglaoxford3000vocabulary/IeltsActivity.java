package com.mbashrafulislam.banglaoxford3000vocabulary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IeltsActivity extends AppCompatActivity {

    CardView ielts_listening_cardView,  ielts_reading_cardView,  ielts_writing_cardView,  ielts_speaking_cardView ;
    LinearLayout linearLayout_listening_to_hide, spelling_button,get_band_8_listening_button,
            paraphrasing_word_part1, paraphrasing_word_part2, miscellaneous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ielts);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ielts_listening_cardView = findViewById(R.id.ielts_listening_cardView);
        linearLayout_listening_to_hide = findViewById(R.id.linearlayout_listening_to_hide);
        ielts_reading_cardView = findViewById(R.id.ielts_Reading_cardView);
        ielts_speaking_cardView = findViewById(R.id.ielts_Speaking_cardView);
        ielts_writing_cardView = findViewById(R.id.ielts_Writing_cardView);

        spelling_button = findViewById(R.id.spelling_button);
        get_band_8_listening_button = findViewById(R.id.get_band_8_listening_button);
        paraphrasing_word_part1 = findViewById(R.id.paraphrasing_word_part1);
        paraphrasing_word_part2 = findViewById(R.id.paraphrasing_word_part2);
        miscellaneous = findViewById(R.id.miscellaneous);








        ielts_listening_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout_listening_to_hide.setVisibility(View.VISIBLE);
            }
        });

       ielts_reading_cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(IeltsActivity.this,"We’re updating this feature soon. Thanks for your patience.",
                       Toast.LENGTH_LONG).show();

           }
       });

        ielts_speaking_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IeltsActivity.this,"We’re updating this feature soon. Thanks for your patience.",
                        Toast.LENGTH_LONG).show();

            }
        });

        ielts_writing_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(IeltsActivity.this,"We’re updating this feature soon. Thanks for your patience.",
                        Toast.LENGTH_LONG).show();

            }
        });



        spelling_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "ieltsspelling.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        get_band_8_listening_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "get_band_8_in_listening.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        paraphrasing_word_part1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "listening_paraphrasing_word1.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        paraphrasing_word_part2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "listening_paraphrasing_word2.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        miscellaneous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "miscellaneous.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });













    }
}