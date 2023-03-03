package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static String playerName1, playerName2, filmName, hint1, hint2;

    public static final String MSG1 = "com.example.hangman.player1";

    public static final String MSG2 = "com.example.hangman.player2";

    public static final String MSG3 = "com.example.hangman.filmName";

    public static final String MSG4 = "com.example.hangman.hint1";

    public static final String MSG5 = "com.example.hangman.hint2";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        playerName1 = intent.getStringExtra(MainActivity.PLAYER1);
        playerName2 = intent.getStringExtra(MainActivity.PLAYER2);

        TextView textView = findViewById(R.id.textPlayerName);
        textView.setText("Hello, "
                +playerName1+"\nPlease enter word for\n"+playerName2
                +" to guess."
        );

    }

    public void confirmAction(View view)
    {
        EditText filmNameEdit = findViewById(R.id.filmNameText);
        EditText hint1Edit = findViewById(R.id.hint1NameText);
        EditText hint2Edit = findViewById(R.id.hint2NameText);
        filmName = filmNameEdit.getText().toString();
        hint1 = hint1Edit.getText().toString();
        hint2 = hint2Edit.getText().toString();
        if (filmName.equals("")||filmName.equals(" "))
        {
            filmNameEdit.setHint("Enter valid film Name");
        }
        else if(hint1.equals("")||hint1.equals(" "))
        {
            hint1Edit.setHint("Enter valid film category");
        }
        else if(hint2.equals("")||hint2.equals(" "))
        {
            hint2Edit.setHint("Enter actor/actress");
        }
        else {
        openActivity3();
        }
    }

    public void openActivity3()
    {
        Intent intent = new Intent(this, MainActivity3.class);
        //String message1 = playerName1+" "+playerName2+" "+filmName+" "+hint1+" "+hint2;
        String msg1 = playerName1;
        String msg2 = playerName2;
        String msg3 = filmName;
        String msg4 = hint1;
        String msg5 = hint2;
        intent.putExtra(MSG1,msg1);
        intent.putExtra(MSG2,msg2);
        intent.putExtra(MSG3,msg3);
        intent.putExtra(MSG4,msg4);
        intent.putExtra(MSG5, msg5);
        startActivity(intent);
    }


}