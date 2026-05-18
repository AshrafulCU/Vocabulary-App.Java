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
    LinearLayout linearLayout_listening_to_hide, spelling_button,get_band_8_listening_button, additional_spelling_button,
            paraphrasing_word_part1, paraphrasing_word_part2, miscellaneous, linearlayout_reading_to_hide;

    LinearLayout reading_paraphrases1_button, reading_paraphrases2_button,
            reading_paraphrases3_button,reading_paraphrases4_button,
            vocab1_button, vocab2_button, vocab3_button, vocab4_button, vocab5_button, vocab6_button;

    LinearLayout  linearlayout_speaking_to_hide, speaking_guide_button, speaking_vocabulary_button,
            speaking_idioms_button, speaking_part1_button;

    LinearLayout linearlayout_writing_to_hide, writing_task1_vocab_button,writing_task1_commonMistake_button,
    writing_task2_vocab_button, writing_task2_ideas_button;


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
        ielts_writing_cardView = findViewById(R.id.ielts_writing_cardView);
        additional_spelling_button = findViewById(R.id.additional_spelling_button);

        spelling_button = findViewById(R.id.spelling_button);
        get_band_8_listening_button = findViewById(R.id.get_band_8_listening_button);
        paraphrasing_word_part1 = findViewById(R.id.paraphrasing_word_part1);
        paraphrasing_word_part2 = findViewById(R.id.paraphrasing_word_part2);
        miscellaneous = findViewById(R.id.miscellaneous);
        linearlayout_reading_to_hide = findViewById(R.id.linearlayout_reading_to_hide);

        reading_paraphrases1_button = findViewById(R.id.paraphrases1_button);
        reading_paraphrases2_button = findViewById(R.id.paraphrases2_button);
        reading_paraphrases3_button = findViewById(R.id.paraphrases3_button);
        reading_paraphrases4_button = findViewById(R.id.paraphrases4_button);
        vocab1_button = findViewById(R.id.vocab1_button);
        vocab2_button = findViewById(R.id.vocab2_button);
        vocab3_button = findViewById(R.id.vocab3_button);
        vocab4_button = findViewById(R.id.vocab4_button);
        vocab5_button = findViewById(R.id.vocab5_button);
        vocab6_button = findViewById(R.id.vocab6_button);

        speaking_guide_button = findViewById(R.id.speaking_guide_button);
        linearlayout_speaking_to_hide =findViewById(R.id.linearlayout_speaking_to_hide);
        speaking_vocabulary_button = findViewById(R.id.speaking_vocabulary_button);
        speaking_idioms_button = findViewById(R.id.speaking_idioms_button);
        speaking_part1_button = findViewById(R.id.speaking_part1_button);

        linearlayout_writing_to_hide = findViewById(R.id.linearlayout_writing_to_hide);
        writing_task1_vocab_button = findViewById(R.id.writing_task1_vocab_button);
        writing_task1_commonMistake_button = findViewById(R.id.writing_task1_commonMistake_button);
        writing_task2_vocab_button = findViewById(R.id.writing_task2_vocab_button);
        writing_task2_ideas_button = findViewById(R.id.writing_task2_ideas_button);






        ielts_listening_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Jodi layout ta age thekei VISIBLE (open) thake
                if (linearLayout_listening_to_hide.getVisibility() == View.VISIBLE) {
                    // Tahole click korle GONE (hide) kore dibe
                    linearLayout_listening_to_hide.setVisibility(View.GONE);
                } else {
                    // Ar jodi hide kora thake, tahole VISIBLE (open) kore dibe
                    linearLayout_listening_to_hide.setVisibility(View.VISIBLE);
                }
            }
        });


        ielts_reading_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearlayout_reading_to_hide.getVisibility() == View.VISIBLE){
                    linearlayout_reading_to_hide.setVisibility(View.GONE);
                }else {
                    linearlayout_reading_to_hide.setVisibility(View.VISIBLE);
                }

            }
        });


        ielts_speaking_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (linearlayout_speaking_to_hide.getVisibility() == View.VISIBLE){
                  linearlayout_speaking_to_hide.setVisibility(View.GONE);

                }else {
                  linearlayout_speaking_to_hide.setVisibility(View.VISIBLE);
                }

            }
        });

        ielts_writing_cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearlayout_writing_to_hide.getVisibility() == View.VISIBLE){
                    linearlayout_writing_to_hide.setVisibility(View.GONE);

                }else {
                    linearlayout_writing_to_hide.setVisibility(View.VISIBLE);

                }


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

        additional_spelling_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "subject_related_spelling.pdf";

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

        reading_paraphrases1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "reading_pharapharsing1.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        reading_paraphrases2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "reading_paraphrasing2.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        reading_paraphrases3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "reading_paraphrasing3.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        reading_paraphrases4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "reading_paraphrasing4.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        vocab1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "vocab1.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        vocab2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "vocab2.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        vocab3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "vocab3.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        vocab4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "vocab4.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });
        vocab5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "vocab5.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        vocab6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "vocab6.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        speaking_guide_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "speaking_guide.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        speaking_vocabulary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "speaking_vocabulary.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        speaking_idioms_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "speaking_idioms.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        speaking_part1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "speaking_part1_3.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        writing_task1_vocab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "writing_task1_vocabulary.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        writing_task1_commonMistake_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivityPdfShower.myString = "writing_task1_common_mistake.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        writing_task2_vocab_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityPdfShower.myString = "writing_task2_vocab.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });

        writing_task2_ideas_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivityPdfShower.myString = "writing_task2_ideas.pdf";

                Intent aIntent = new Intent(IeltsActivity.this,
                        MainActivityPdfShower.class);
                startActivity(aIntent);

            }
        });


















    }
}