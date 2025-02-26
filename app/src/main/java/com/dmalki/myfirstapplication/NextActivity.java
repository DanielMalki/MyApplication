package com.dmalki.myfirstapplication;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NextActivity extends AppCompatActivity {

    Button sendBTN;
    EditText ETString;
    EditText ETInt;
    Button readBTN;
    TextView raedString;
    TextClock raedInt;
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_next);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            initViews();

            return insets;
        });
    }

    @SuppressLint("WrongViewCast")
    private void initViews() {
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();
        editor.putString("STR", ""); // Storing string
        editor.putInt("INT", -1); // Storing integer
        editor.commit(); // commit changes

        editor.commit();

        sendBTN = findViewById(R.id.sendBTN);
        ETString = findViewById(R.id.ETString);
        ETInt = findViewById(R.id.ETInt);
        sendBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("STR", String.valueOf(ETString.getText()));
                editor.putInt("INT", Integer.parseInt(String.valueOf(ETInt.getText())));
                editor.commit();
                Toast.makeText(NextActivity.this, "information sent successfully", Toast.LENGTH_SHORT).show();
            }
        });

        readBTN = findViewById(R.id.readBTN);
        raedString = findViewById(R.id.raedString);
        raedInt = findViewById(R.id.readInt);
        readBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                raedString.setText(pref.getString("key_name", null));
                raedInt.setText(pref.getInt("key_name", -1));
            }
        });
    }
}