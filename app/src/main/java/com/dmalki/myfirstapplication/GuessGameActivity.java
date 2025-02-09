package com.dmalki.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class GuessGameActivity extends AppCompatActivity {

//    EditText num1;
//    EditText num2;
    EditText numguess;
    TextView numguesstitle;
//    Button startbtn;
    Button guessbtn;
//    int n1;
//    int n2;
    int n = -100;
    int rangeMax = 1;
    int ng;
    int count;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_game);
        //Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        initViews();
    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
    }*/

    @SuppressLint("WrongViewCast")
    private void initViews() {

/*        startbtn = findViewById(R.id.startbtn);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1 = Integer.parseInt(String.valueOf(num1.getText()));
                n2 = Integer.parseInt(String.valueOf(num2.getText()));
                n = (int)(Math.random() * (Math.max(n1, n2) - Math.min(n1, n2) + 1) + Math.min(n1, n2));
                count = 0;
                startbtn.setText("Restart");
            }
        });

        guessbtn = findViewById(R.id.guessbtn);
        numguess = findViewById(R.id.numguess);
        numguesstitle = findViewById(R.id.numguesstitle);
        guessbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(n != -100) {
                    ng = Integer.parseInt(String.valueOf(numguess.getText()));
                    count++;
                    if (n == ng) {
                        numguesstitle.setText("YOU WON! it only took you " + count + "trys");
                    } else if (ng > n) {
                        numguesstitle.setText("your number is bigger, plz try again");
                    } else if (ng < n) {
                        numguesstitle.setText("your number is smaller, plz try again");
                    }
                }
            }
        }); */

        radioButton1 = findViewById(R.id.radioButton1);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = (int)(Math.random() * 10 + 1);
                rangeMax = 10;
                radioButton1.setText("1-10😋");
                radioButton2.setText("1-100");
                radioButton3.setText("1-1000");
            }
        });
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = (int)(Math.random() * 100 + 1);
                rangeMax = 100;
                radioButton1.setText("1-10");
                radioButton2.setText("1-100🤗");
                radioButton3.setText("1-1000");
            }
        });
        radioButton3 = findViewById(R.id.radioButton3);
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n = (int)(Math.random() * 1000 + 1);
                rangeMax = 1000;
                radioButton1.setText("1-10");
                radioButton2.setText("1-100");
                radioButton3.setText("1-1000😎");
            }
        });

        guessbtn = findViewById(R.id.guessbtn);
        numguess = findViewById(R.id.numguess);
        numguesstitle = findViewById(R.id.numguesstitle);
        guessbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numguesstitle.setTextColor(Color.parseColor("#20837B"));
                ng = Integer.parseInt(String.valueOf(numguess.getText()));
                if((ng <= rangeMax) && (ng >= 1)){
                    count++;
                    if (n == ng) {
                        numguesstitle.setText("YOU WON! it only took you " + count + "trys✨💖, to play again choos a range🤗");
                        Intent intent = getIntent();
                        if(intent.getStringExtra("resalt").equals("tofes")){
                            setResult(RESULT_OK);
                        }
                    } else if (ng > n) {
                        numguesstitle.setText("your number is too big, please think of a smaller number try again");
                    } else if (ng < n) {
                        numguesstitle.setText("your number is too small, please think of a bigger number try again");
                    }
                }
                else{
                    numguesstitle.setText("your number is not in range, plz try again");
                    numguesstitle.setTextColor(Color.parseColor("#FB0000"));
                }
            }
        });


    }

}