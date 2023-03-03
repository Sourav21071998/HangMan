package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText player1, player2;

    public static final String PLAYER1 = "com.example.hangman.player1";
    public static final String PLAYER2 = "com.example.hangman.player2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNextActivity(View view)
    {
        player1 = findViewById(R.id.namePlayer1);
        player2 = findViewById(R.id.namePlayer2);
        openActivity2();
    }

    public void openActivity2()
    {
        Intent intent = new Intent(this,MainActivity2.class);
        String message1 = player1.getText().toString();
        String message2 = player2.getText().toString();
        if(message1.equals("")||message1.equals(" "))
        {
            player1.setHint("Enter name of Player1");
        }
        else if(message2.equals("")||message2.equals(" "))
        {
            player2.setHint("Enter name of player2");
        }
        else {
            intent.putExtra(PLAYER1, message1);
            intent.putExtra(PLAYER2, message2);
            startActivity(intent);
        }
    }
}