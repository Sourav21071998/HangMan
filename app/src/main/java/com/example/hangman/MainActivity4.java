package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        Intent intent = getIntent();
        String results = intent.getStringExtra(MainActivity3.RESULT);
        TextView resultText = findViewById(R.id.resultText);
        resultText.setText(results);
    }

    public void playAgainAction(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}