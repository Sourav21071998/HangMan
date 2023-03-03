package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    String guessName="";
    String filmName="";
    String player1;
    String player2;
    String hint1;
    String hint2;
    String usedUpCharacters="";

    static char guessCharacterArray[];

    public static final String RESULT = "com.example.hangman.result";

    public static final String RESULT2 = "com.example.hangman.result2";

    static int chances=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent intent = getIntent();
        player1 = intent.getStringExtra(MainActivity2.MSG1);
        player2 = intent.getStringExtra(MainActivity2.MSG2);
        filmName = intent.getStringExtra(MainActivity2.MSG3);
        hint1 = intent.getStringExtra(MainActivity2.MSG4);
        hint2 = intent.getStringExtra(MainActivity2.MSG5);

        TextView textView = findViewById(R.id.namesEditText);

        filmName=filmName.toUpperCase();
        textView.setText("Hello, "+player2+" Try to\n"
                        +"guess the film name.");
        int len=filmName.length();
        TextView hintText =findViewById(R.id.hintTexts);
        hintText.setText("Hints :"+hint1+", "+hint2);

        int i;
        for(i=0;i < len;i++)
        {
            if(filmName.charAt(i)==' ')
            {
                guessName = guessName+" ";
            }
            else
            {
                guessName = guessName+"*";
            }
        }

        TextView guessText = findViewById(R.id.guessWordText);
        guessText.setText(guessName);
        //System.out.println(names);
        convertToArray();
    }

    public void convertToArray()
    {
        guessCharacterArray = new char[filmName.length()];
        int j;
        for(j=0;j<guessCharacterArray.length;j++)
        {
            if(filmName.charAt(j)==' ')
            {
                guessCharacterArray[j]=' ';
            }
            else
            {
                guessCharacterArray[j]='*';
            }
        }
        //System.out.println(guessCharacterArray);
    }

    public void guessAction(View view)
    {
        TextView textView = findViewById(R.id.namesEditText);
        textView.setText("Hello, "+player2+" Try to\n"
                +"guess the film name.");
        EditText characterText = findViewById(R.id.characterEditText);
        String text = characterText.getText().toString();
        characterText.setText("");
        int win=0;
        int flag=0;

        //SXconvertToArray();
        if(text.equals(""))
        {
            textView.setText("Enter a single character");
        }
        else if(text.length()>1)
        {
            textView.setText("Enter a single character");
        }
        else
        {
                char txt = text.toUpperCase().charAt(0);
                int i=0;
                String guessName1 ="";
                for(i=0 ; i< filmName.length(); i++)
                {
                    char p = filmName.charAt(i);
                    if (txt == p)
                    {
                        flag=1;
                        guessCharacterArray[i] = p;
                    }
                    else if (guessCharacterArray[i] ==' ' || guessCharacterArray[i]!='*')
                    {
                        continue;
                    }
                    else
                    {
                        guessCharacterArray[i] = '*';
                    }
                }

                System.out.println(guessCharacterArray);
                if (flag == 0)
                {
                    if(!usedUpCharacters.contains(text))
                    {
                        usedUpCharacters = usedUpCharacters + " " + text;
                        chances--;
                    }
                    if (chances == 0)
                    {
                        //System.out.println("Hello" + chances);
//                        TextView guessText = findViewById(R.id.guessWordText);
//                        guessText.setText("Given name was: " + filmName);
                        TextView chancesView = findViewById(R.id.chancesTextView);
//                        chancesView.setText(player2+" lose. "+player1+" won. Given name was "+filmName);
                        textView.setText(player2+" lose. "+player1+" won. Given name was "+filmName);
                        chancesView.setText("Chances left: "+chances);
                        Intent intent = new Intent(this,MainActivity4.class);
                        intent.putExtra(RESULT,player1+" won.\n Film name: "+filmName);
                        chances = 5;
                        startActivity(intent);
//                        Intent intent = new Intent(this,MainActivity.class);
//                        startActivity(intent);
                    }
                    else
                    {
                        TextView chancesView = findViewById(R.id.chancesTextView);
                        chancesView.setText("Chances left: " + chances);
                        TextView usedCharacters = findViewById((R.id.usedCharacters));

                        usedCharacters.setText("Used characters: " + usedUpCharacters);
//                        TextView guessText = findViewById(R.id.guessWordText);
//                        guessText.setText(guessName);
                    }
                }
                else
                {
                    int j;
                    for (j = 0; j < guessCharacterArray.length; j++)
                    {
                        if (guessCharacterArray[j] == '*') {
                            guessName1 = guessName1 + "*";
                        } else if (guessCharacterArray[j] == ' ') {
                            guessName1 = guessName1 + " ";
                        } else {
                            guessName1 = guessName1 + guessCharacterArray[j];
                        }
                    }
                    String s="";
                    s=characterToString(s);
                    if (guessName1.equals(filmName))
                    {
                        win=1;
                        TextView word = findViewById(R.id.guessWordText);
                        word.setText(player2 + " won ");
                        Intent intent = new Intent(this,MainActivity4.class);
                        intent.putExtra(RESULT,player2+" won.\n Film name: "+filmName);
                        chances=5;
                        startActivity(intent);
                    }
                    else
                    {
                        guessName = guessName1;
                        guessName1="";

                    }

                }


        }
        if(win==0)
        {
        TextView guessText = findViewById(R.id.guessWordText);
        guessText.setText(guessName);
        }

    }
    public String characterToString(String s)
    {
        int i;
        for(i=0;i<guessCharacterArray.length;i++)
        {
            s=s+guessCharacterArray[i];
        }
        return s;
    }
}