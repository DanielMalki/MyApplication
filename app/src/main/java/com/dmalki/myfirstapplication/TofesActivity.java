package com.dmalki.myfirstapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TofesActivity extends AppCompatActivity {

    Button togame;
    Button toterms;
    TextView wintext;
    private static int gameRequestCode = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tofes);
        initViews();
    }

    private void initViews() {
        toterms = findViewById(R.id.toterms);
        toterms.setEnabled(false);
        togame = findViewById(R.id.togame);
        wintext = findViewById(R.id.wintext);
        togame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TofesActivity.this, GuessGameActivity.class);
                intent.putExtra("resalt", "tofes");
                startActivityForResult(intent, gameRequestCode);
                wintext.setText("yay you won!😍😎");
                toterms.setEnabled(true);
            }
        });

        toterms = findViewById(R.id.toterms);
        toterms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(TofesActivity.this, ???.class);
            }
        });


    }
}