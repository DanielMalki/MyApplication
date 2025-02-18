package com.dmalki.myfirstapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /*implements CompoundButton.OnCheckedChangeListener*/ /* implements View.OnClickListener */ {

    Button sigma_button;
    Button alpha_button;
    TextView tv1;
    Switch switch1;
    ConstraintLayout constraintLayout;
    SeekBar seekBar1;
    ImageView imageView1;
    ImageView imageView2;
    Button nextPG;
    Button guessgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        sigma_button = findViewById(R.id.sigma_button);
//        sigma_button.setOnClickListener(this);
//        alpha_button = findViewById(R.id.alpha_button);
//        alpha_button.setOnClickListener(this);
//        tv1 = findViewById(R.id.tv1);
//        switch1 = findViewById(R.id.switch1);
//        switch1.setOnCheckedChangeListener(this);
//        constraintLayout = findViewById(R.id.constraintLayoutMain);

        initViews();

    }

    private void initViews() {

        tv1 = findViewById(R.id.tv1);
        sigma_button = findViewById(R.id.sigma_button);
        sigma_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("SIGMA button");
                Log.d("SIGMA button", "1");
                Toast.makeText(MainActivity.this, "SIGMA", Toast.LENGTH_SHORT).show();
            }
        });

        alpha_button = findViewById(R.id.alpha_button);
        alpha_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("ALPHA button");
                Log.d("ALPHA button", "2");
                Toast.makeText(MainActivity.this, "ALPHA", Toast.LENGTH_SHORT).show();
            }
        });
        switch1 = findViewById(R.id.switch1);
        constraintLayout = findViewById(R.id.constraintLayoutMain);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    constraintLayout.setBackgroundColor(Color.parseColor("#033A2D"));
                    switch1.setText("on");
                }
                else{
                    constraintLayout.setBackgroundColor(Color.parseColor("#65DABE"));
                    switch1.setText("off");
                }
            }
        });

        seekBar1 = findViewById(R.id.seekBar1);
        imageView1 = findViewById(R.id.alphaMaleWolff);
        imageView2 = findViewById(R.id.didiBabbyOil);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Float alpha = (float)progress/100;
                imageView1.setAlpha(alpha);
                imageView2.setAlpha(1 - alpha);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        nextPG = findViewById(R.id.nextPG);
        nextPG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LiniarActivity.class);
                finish();
                startActivity(intent);
            }
        });

        guessgame = findViewById(R.id.guessgame);
        guessgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GuessGameActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if(id == R.id.action_login){
            Toast.makeText(this, "you selected login", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.action_register){
            Toast.makeText(this, "you selected register", Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.action_start){
            Toast.makeText(this, "you selected start", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    //    @Override
//    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        if(isChecked){
//            constraintLayout.setBackgroundColor(color."#033A2D");
//            constraintLayout.setTag("on");
//        }
//        else{
//            constraintLayout.setBackgroundColor(color."#65DABE");
//            constraintLayout.setTag("on");
//        }
//    }




/*    @Override
    public void onClick(View view) {
        if (view == sigma_button) {
            tv1.setText("SIGMA button");
            Log.d("SIGMA button", "1");
        } else if (view == alpha_button) {
            tv1.setText("ALPHA button");
            Log.d("ALPHA button", "2");
        }
    } */


/*    public void AlfaSigma(View view) {
        if (view == sigma_button) {
            tv1.setText("SIGMA button");
            Log.d("SIGMA button", "1");
        } else if (view == alpha_button) {
            tv1.setText("ALPHA button");
            Log.d("ALPHA button", "2");
        }
    } */

}

