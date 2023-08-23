package com.nabilAnagramme.anagram;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    //Declaration of Variables
    private Button first_letter_Button;
    private Button second_letter_Button;
    private Button third_letter_Button;
    private Button fourth_letter_Button;
    private Button fifth_letter_Button;
    private Button sixth_letter_Button;
    private ImageView afficherSolution;
    private ImageView RetourButton;


    private TextView first_letter_answer_TextView;
    private TextView second_letter_answer_TextView;
    private TextView third_letter_answer_TextView;
    private TextView fourth_letter_answer_TextView;
    private TextView fifth_letter_answer_TextView;
    private TextView sixth_letter_answer_TextView;

    private Button answerButton;
    private Button resetButton;
    private Button skipButton;

    private String pressedletter;

    private int answeredcounter = 0;
    private int triescounter = 0;
    private int answered_position = 0;
    private int firstletterpressed = 0;
    private int secondletterpressed = 0;
    private int thirdletterpressed = 0;
    private int fourthletterpressed = 0;
    private int fifthletterpressed = 0;
    private int sixthletterpressed = 0;
    private int wordorder;
    private int level;
    private int fouthtextview = 0;
    private int fifithtextview = 0;
    private int sixthtextview = 0;
    public AlertDialog dialog = null;
    private int ilevel1=0;
    private int ilevel2=0;
    private int ilevel3=0;

    private int[] letters_pointer_array;
    int[] words_order_pointer_array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29};


    //Declaration of tables with game words per level
    String[][] mywordseasy = new String[][]{
            {"v", "i", "d", "e"},
            {"b", "l", "e", "u"},
            {"s", "a", "l", "e"},
            {"d", "o", "u", "x"},
            {"f", "a", "u", "x"},
            {"f", "o", "r", "t"},
            {"h", "a", "u", "t"},
            {"l", "o", "n", "g"},
            {"v", "e", "r", "t"},
            {"s", "e", "u", "l"},
            {"c", "h", "o", "u"},
            {"k", "i", "w", "i"},
            {"l", "a", "m","a"},
            {"l", "i", "o", "n"},
            {"c", "h", "a", "t"},
            {"c", "u", "b", "a"},
            {"i", "n", "d", "e"},
            {"m", "a", "l", "i"},
            {"t", "o", "g", "o"},
            {"f", "i", "l", "s"},
            {"m", "è", "r", "e"},
            {"p", "è", "r", "e"},
            {"m", "o", "d", "e"},
            {"o", "r", "a", "l"},
            {"n", "i", "c", "e"},
            {"l", "y", "o", "n"},
            {"m", "a", "n", "s"},
            {"s", "t", "o", "p"},
            {"m", "a", "ï", "s"},
            {"m", "o", "r", "t"},
    };

    String[][] mywordsmedium = new String[][]{
            {"p", "a", "r", "i", "s"},
            {"m", "o", "n", "d", "e"},
            {"g", "r", "a", "n", "d"},
            {"p", "r", "e", "n", "d"},
            {"c", "a", "d", "r", "e"},
            {"u", "n", "i", "o", "n"},
            {"é", "c", "o", "l", "e"},
            {"p", "o", "i", "n", "t"},
            {"j", "e", "u", "n", "e"},
            {"f", "e", "m", "m", "e"},
            {"p", "o", "i", "r", "e"},
            {"p", "o", "m", "m", "e"},
            {"n", "a", "v", "e", "t"},
            {"o", "l", "i", "v", "e"},
            {"p", "e", "t", "i", "t"},
            {"g", "r", "a", "n", "d"},
            {"t", "e", "r", "r", "e"},
            {"l", "a", "p", "i", "n"},
            {"p", "o", "u", "l", "e"},
            {"d", "i", "n", "d", "e"},
            {"v", "a", "c", "h", "e"},
            {"m", "a", "r", "o", "c"},
            {"f", "r", "è", "r", "e"},
            {"t", "a", "n", "t", "e"},
            {"b", "e", "l", "l", "e"},
            {"c", "h", "i", "n", "e"},
            {"b", "è", "n", "i", "n"},
            {"c", "h", "i", "l", "i"},
            {"f", "i", "n", "i", "r"},
            {"t", "e", "n", "i", "r"},
    };

    String[][] mywordshard = new String[][]{
            {"p", "a", "r", "l", "e", "r"},
            {"d", "a", "n", "s", "e", "r"},
            {"m", "a", "n", "g", "e", "r"},
            {"d", "o", "r", "m", "i", "r"},
            {"g", "i", "r", "a", "f", "e"},
            {"c", "o", "c", "h", "a", "n"},
            {"c", "a", "n", "a", "r", "d"},
            {"c", "h", "e", "v", "a", "l"},
            {"f", "r", "a", "n", "c", "e"},
            {"n", "a", "n", "t", "e", "s"},
            {"o", "i", "g", "n", "o", "n"},
            {"s", "a", "l", "a", "d", "e"},
            {"t", "o", "m", "a", "t", "e"},
            {"a", "v", "o", "c", "a", "t"},
            {"p", "l", "a", "n", "t", "e"},
            {"c", "o", "u", "r", "g", "e"},
            {"f", "r", "a", "i", "s", "e"},
            {"p", "a", "t", "a", "t", "e"},
            {"o", "r", "a", "n", "g", "e"},
            {"s", "o", "u", "r", "i", "s"},
            {"c", "h", "è", "v", "r", "e"},
            {"c", "a", "n", "a", "r", "d"},
            {"c", "o", "u", "s", "i", "n"},
            {"p", "a", "r", "o", "l", "e"},
            {"l", "a", "n", "g", "u", "e"},
            {"a", "m", "i", "e", "n", "s"},
            {"p", "a", "r", "t", "i", "r"},
            {"s", "e", "n", "t", "i", "r"},
            {"m", "o", "n", "t", "e", "r"},
            {"h", "o", "c", "k", "e", "y"},
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        first_letter_Button = (Button) findViewById(R.id.first_letter_btn);
        second_letter_Button = (Button) findViewById(R.id.second_letter_btn);
        third_letter_Button = (Button) findViewById(R.id.third_letter_btn);
        fourth_letter_Button = (Button) findViewById(R.id.fourth_letter_btn);
        fifth_letter_Button = (Button) findViewById(R.id.fifth_letter_btn);
        sixth_letter_Button = (Button) findViewById(R.id.sixth_letter_btn);
        afficherSolution=(ImageView) findViewById(R.id.affichersolution);

        first_letter_answer_TextView = (TextView) findViewById(R.id.first_letter_answer_tv);
        second_letter_answer_TextView = (TextView) findViewById(R.id.second_letter_answer_tv);
        third_letter_answer_TextView = (TextView) findViewById(R.id.third_letter_answer_tv);
        fourth_letter_answer_TextView = (TextView) findViewById(R.id.fourth_letter_answer_tv);
        fifth_letter_answer_TextView = (TextView) findViewById(R.id.fifth_letter_answer_tv);
        sixth_letter_answer_TextView = (TextView) findViewById(R.id.sixth_letter_answer_tv);

        RetourButton = (ImageView) findViewById(R.id.retour);
        resetButton = (Button) findViewById(R.id.resetButton);
        skipButton = (Button) findViewById(R.id.skipButton);


        //Download a user-selected level from MainActivity
        Intent intent = getIntent();
        level = intent.getIntExtra("levelchoice", 0);


        //Loading first word
        nextWord();

        resetButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ilevel1=0;
                ilevel2=0;
                ilevel3=0;
                resetAnswer();

            }
        });

        skipButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                ilevel1=0;
                ilevel2=0;
                ilevel3=0;
                skipAnswer();
            }
        });
        afficherSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ShowSolution();
            }
        });
        RetourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameActivity.this, MainActivity.class));
            }
        });


        first_letter_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (firstletterpressed == 0) {
                    //If the first letter of the confused word is pressed it converts it to a string and loads it via the loadLetter () function in the appropriate textview of the answer
                    //Similarly for the other letters, in which position of the answer will be entered is determined by loadLetter (), where it takes as a parameter the letter that was pressed
                    //The firstletterpressed variable indicates that the button has already been pressed and can not be pressed again
                    pressedletter = first_letter_Button.getText().toString();
                    loadLetter(pressedletter);
                    firstletterpressed = 1;
                    first_letter_Button.setVisibility(View.INVISIBLE);
                }
            }
        });


        second_letter_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (secondletterpressed == 0) {
                    pressedletter = second_letter_Button.getText().toString();
                    loadLetter(pressedletter);
                    secondletterpressed = 1;
                    second_letter_Button.setVisibility(View.INVISIBLE);
                }
            }
        });


        third_letter_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (thirdletterpressed == 0) {
                    pressedletter = third_letter_Button.getText().toString();
                    loadLetter(pressedletter);
                    thirdletterpressed = 1;
                    third_letter_Button.setVisibility(View.INVISIBLE);
                }
            }
        });


        fourth_letter_Button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (fourthletterpressed == 0) {
                    pressedletter = fourth_letter_Button.getText().toString();
                    loadLetter(pressedletter);
                    fourthletterpressed = 1;
                    fourth_letter_Button.setVisibility(View.INVISIBLE);


                }
            }
        });

        //The 5 letter will be "activated" (otherwise it has Visibility: Gone) when the user selects the intermediate level or the difficult
        if (level == 2 || level == 3) {
            fifth_letter_Button.setVisibility(View.VISIBLE);
            fifth_letter_answer_TextView.setVisibility(View.INVISIBLE);

            fifth_letter_Button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (fifthletterpressed == 0) {
                        pressedletter = fifth_letter_Button.getText().toString();
                        loadLetter(pressedletter);
                        fifthletterpressed = 1;
                        fifth_letter_Button.setVisibility(View.INVISIBLE);

                    }
                }
            });
        }

        //The 6 letter will be "activated" when the user selects a difficult level
        if (level == 3) {

            sixth_letter_Button.setVisibility(View.VISIBLE);
            sixth_letter_answer_TextView.setVisibility(View.INVISIBLE);

            sixth_letter_Button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    if (sixthletterpressed == 0) {
                        pressedletter = sixth_letter_Button.getText().toString();
                        loadLetter(pressedletter);
                        sixthletterpressed = 1;
                        sixth_letter_Button.setVisibility(View.INVISIBLE);

                    }
                }
            });
        }
    }

    //submit answer


    public void loadLetter(String letter) {

        // The variable answered_position is set where it shows how many letters the user has answered to be loaded in the appropriate Textview,
        // ie if answered_position shows 2, it means that the user has given 3 letters as an answer to complete the word and the next letter will be loaded in the 4th textview
        // So when pressed, the given letter is hidden and loaded in the answer

        if (answered_position == 0) {
            first_letter_answer_TextView.setText(letter);
            first_letter_answer_TextView.setVisibility(View.VISIBLE);
        }

        if (answered_position == 1) {
            second_letter_answer_TextView.setText(letter);
            second_letter_answer_TextView.setVisibility(View.VISIBLE);
        }

        if (answered_position == 2) {
            third_letter_answer_TextView.setText(letter);
            third_letter_answer_TextView.setVisibility(View.VISIBLE);
        }

        if (answered_position == 3) {
            fourth_letter_answer_TextView.setText(letter);
            fourth_letter_answer_TextView.setVisibility(View.VISIBLE);
            if(level==1) {
                checkAnswer();
            }

            fouthtextview = 4;

        }

        if (level == 2 || level == 3) {
            if (answered_position == 4) {
                fifth_letter_answer_TextView.setText(letter);
                fifth_letter_answer_TextView.setVisibility(View.VISIBLE);
                if(level==2) {
                    checkAnswer();
                }
                fifithtextview = 5;

            }
        }

        if (level == 3) {
            if (answered_position == 5) {
                sixth_letter_answer_TextView.setText(letter);
                sixth_letter_answer_TextView.setVisibility(View.VISIBLE);

                    checkAnswer();


            }
        }

        answered_position++;

    }


    public void checkAnswer() {

        // This function is called with the answerButton button and takes the letters given as answers and checks them with the corresponding table level
        // Counts attempts on one variable and passes to another variable whether the user answered correctly or not,
        // where at the end it calls the AnswerMessage () function with the variable parameter to show the appropriate right / wrong message

        String firstletteranswer = first_letter_answer_TextView.getText().toString();
        String secondletteranswer = second_letter_answer_TextView.getText().toString();
        String thirdletteranswer = third_letter_answer_TextView.getText().toString();
        String fourthletteranswer = fourth_letter_answer_TextView.getText().toString();
        String fifthletteranswer = fifth_letter_answer_TextView.getText().toString();
        String sixthletteranswer = sixth_letter_answer_TextView.getText().toString();
        int correctanswer = 0;
        triescounter++;

        if (level == 1) {
            if (firstletteranswer.equals(mywordseasy[wordorder][0]) && secondletteranswer.equals(mywordseasy[wordorder][1]) && thirdletteranswer.equals(mywordseasy[wordorder][2]) && fourthletteranswer.equals(mywordseasy[wordorder][3]))
                correctanswer = 1;
            else
                correctanswer = 0;
        }

        if (level == 2) {
            if (firstletteranswer.equals(mywordsmedium[wordorder][0]) && secondletteranswer.equals(mywordsmedium[wordorder][1]) && thirdletteranswer.equals(mywordsmedium[wordorder][2]) && fourthletteranswer.equals(mywordsmedium[wordorder][3]) && fifthletteranswer.equals(mywordsmedium[wordorder][4]))
                correctanswer = 1;
            else
                correctanswer = 0;
        }

        if (level == 3) {
            if (firstletteranswer.equals(mywordshard[wordorder][0]) && secondletteranswer.equals(mywordshard[wordorder][1]) && thirdletteranswer.equals(mywordshard[wordorder][2]) && fourthletteranswer.equals(mywordshard[wordorder][3]) && fifthletteranswer.equals(mywordshard[wordorder][4]) && sixthletteranswer.equals(mywordshard[wordorder][5]))
                correctanswer = 1;
            else
                correctanswer = 0;
        }

        AnswerMessage(correctanswer);
    }

    //show the solution of word
    public void ShowSolution() {
        if(level==1) {
                     first_letter_Button.setVisibility(View.VISIBLE);
                     second_letter_Button.setVisibility(View.VISIBLE);
                     third_letter_Button.setVisibility(View.VISIBLE);
                     fourth_letter_Button.setVisibility(View.VISIBLE);

                if (ilevel1==0) {
                    first_letter_answer_TextView.setText(mywordseasy[wordorder][0]);
                    first_letter_answer_TextView.setVisibility(View.VISIBLE);
                }
                if (ilevel1 == 1) {
                    second_letter_answer_TextView.setText(mywordseasy[wordorder][1]);
                    second_letter_answer_TextView.setVisibility(View.VISIBLE);
                }
                if (ilevel1 == 2){
                    third_letter_answer_TextView.setText(mywordseasy[wordorder][2]);
                third_letter_answer_TextView.setVisibility(View.VISIBLE);
            }
            if(ilevel1==3) {
                fourth_letter_answer_TextView.setText(mywordseasy[wordorder][3]);
                fourth_letter_answer_TextView.setVisibility(View.VISIBLE);
            }
            ilevel1++;

        }
       if(level==2){
           first_letter_Button.setVisibility(View.VISIBLE);
           second_letter_Button.setVisibility(View.VISIBLE);
           third_letter_Button.setVisibility(View.VISIBLE);
           fourth_letter_Button.setVisibility(View.VISIBLE);
           fifth_letter_Button.setVisibility(View.VISIBLE);
           if (ilevel2==0) {
               first_letter_answer_TextView.setText(mywordsmedium[wordorder][0]);
               first_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel2==1) {
               second_letter_answer_TextView.setText(mywordsmedium[wordorder][1]);
               second_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel2==2) {
               third_letter_answer_TextView.setText(mywordsmedium[wordorder][2]);
               third_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel2==3) {
               fourth_letter_answer_TextView.setText(mywordsmedium[wordorder][3]);
               fourth_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel2==4) {
               fifth_letter_answer_TextView.setText(mywordsmedium[wordorder][4]);
               fifth_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           ilevel2++;

       }
       if(level==3){
           first_letter_Button.setVisibility(View.VISIBLE);
           second_letter_Button.setVisibility(View.VISIBLE);
           third_letter_Button.setVisibility(View.VISIBLE);
           fourth_letter_Button.setVisibility(View.VISIBLE);
           fifth_letter_Button.setVisibility(View.VISIBLE);
           sixth_letter_Button.setVisibility(View.VISIBLE);
           if (ilevel3==0) {
               first_letter_answer_TextView.setText(mywordshard[wordorder][0]);
               first_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel3==1) {
               second_letter_answer_TextView.setText(mywordshard[wordorder][1]);
               second_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel3==2) {
               third_letter_answer_TextView.setText(mywordshard[wordorder][2]);
               third_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel3==3) {
               fourth_letter_answer_TextView.setText(mywordshard[wordorder][3]);
               fourth_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel3==4) {
               fifth_letter_answer_TextView.setText(mywordshard[wordorder][4]);
               fifth_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           if (ilevel3==5) {
               sixth_letter_answer_TextView.setText(mywordshard[wordorder][5]);
               sixth_letter_answer_TextView.setVisibility(View.VISIBLE);
           }
           ilevel3++;
       }
    }





    public void AnswerMessage(int correctanswer) {

        // This function shows the right / wrong messages depending on the answer, if it is wrong it deletes the answer and displays the same confused word again,
        // if correct, deletes the answer and loads the next word

        final MediaPlayer correctsound = MediaPlayer.create(this, R.raw.correct);

        if (correctanswer == 1)   {
            //Toast.makeText(GameActivity.this, "Well done", Toast.LENGTH_SHORT).show();
            answeredcounter++;
            if (answeredcounter < 30)
            {
                // in this condition it is checked if all the words have been answered, if not, it continues in the game


                showPopUpCorrecteAnswer();

            }
            else
            {
                // if all the words have been answered then the Results Activity will start where the variable that measured the efforts will be sent

                correctsound.start();
                Intent myIntent = new Intent(GameActivity.this, ResultsActivity.class);
                myIntent.putExtra("scoretries", triescounter);
                startActivity(myIntent);
            }
        }
        else
        {
            setButonInvisible();
            showPopUpInCorrecteAnswer();
            //Toast.makeText(GameActivity.this, "Please try again.", Toast.LENGTH_SHORT).show();
        }
    }


    public void resetAnswer() {
        // This function erases the given answer, resets the answer position, reappears the upper word and undoes the pressing of the buttons so that they can be pressed again

        first_letter_answer_TextView.setText(null);
        second_letter_answer_TextView.setText(null);
        third_letter_answer_TextView.setText(null);
        fourth_letter_answer_TextView.setText(null);
        fifth_letter_answer_TextView.setText(null);
        sixth_letter_answer_TextView.setText(null);

        answered_position = 0;
        firstletterpressed = 0;
        secondletterpressed = 0;
        thirdletterpressed = 0;
        fourthletterpressed = 0;

        first_letter_Button.setVisibility(View.VISIBLE);
        second_letter_Button.setVisibility(View.VISIBLE);
        third_letter_Button.setVisibility(View.VISIBLE);
        fourth_letter_Button.setVisibility(View.VISIBLE);
        first_letter_answer_TextView.setVisibility(View.INVISIBLE);
        second_letter_answer_TextView.setVisibility(View.INVISIBLE);
        third_letter_answer_TextView.setVisibility(View.INVISIBLE);
        fourth_letter_answer_TextView.setVisibility(View.INVISIBLE);

        if (level == 2 || level == 3)
        {
            fifthletterpressed = 0;
            fifth_letter_Button.setVisibility(View.VISIBLE);
            fifth_letter_answer_TextView.setVisibility(View.INVISIBLE);
        }

        if (level == 3)
        {
            sixthletterpressed = 0;
            sixth_letter_Button.setVisibility(View.VISIBLE);
            sixth_letter_answer_TextView.setVisibility(View.INVISIBLE);
        }
    }


    public void skipAnswer() {
        answeredcounter++;
        if (answeredcounter < 30)
        {
            resetAnswer();
            nextWord();
        }
        else
        {
            Intent myIntent = new Intent(GameActivity.this, ResultsActivity.class);
            myIntent.putExtra("scoretries", triescounter);
            startActivity(myIntent);
        }
    }


    public void nextWord() {

        // Its function is to load the word and display it
        // Initially the randomwordsorder () function is called where it will give a random order of the array (its function will be explained within this function)
        // Depending on the level, the corresponding level table will be selected and the word chosen by the randomwordsorder () function will be taken.
        // and a random letter of this word will be loaded on each button, for the random letter the scrabbleletters () function is called
        // Each new word initializes a table of placeholders where needed in scrabbleletters ()

        wordorder = randomwordsorder();
        if (level == 1) {
            letters_pointer_array = new int[] {0,1,2,3};
            first_letter_Button.setText(mywordseasy[wordorder][scrabbleletters()]);
            second_letter_Button.setText(mywordseasy[wordorder][scrabbleletters()]);
            third_letter_Button.setText(mywordseasy[wordorder][scrabbleletters()]);
            fourth_letter_Button.setText(mywordseasy[wordorder][scrabbleletters()]);
        }
        if (level == 2){
            letters_pointer_array = new int[] {0,1,2,3,4};
            first_letter_Button.setText(mywordsmedium[wordorder][scrabbleletters()]);
            second_letter_Button.setText(mywordsmedium[wordorder][scrabbleletters()]);
            third_letter_Button.setText(mywordsmedium[wordorder][scrabbleletters()]);
            fourth_letter_Button.setText(mywordsmedium[wordorder][scrabbleletters()]);
            fifth_letter_Button.setText(mywordsmedium[wordorder][scrabbleletters()]);
        }
        if (level == 3){
            letters_pointer_array = new int[] {0,1,2,3,4,5};
            first_letter_Button.setText(mywordshard[wordorder][scrabbleletters()]);
            second_letter_Button.setText(mywordshard[wordorder][scrabbleletters()]);
            third_letter_Button.setText(mywordshard[wordorder][scrabbleletters()]);
            fourth_letter_Button.setText(mywordshard[wordorder][scrabbleletters()]);
            fifth_letter_Button.setText(mywordshard[wordorder][scrabbleletters()]);
            sixth_letter_Button.setText(mywordshard[wordorder][scrabbleletters()]);
        }
    }


    public int scrabbleletters(){
        int randomletter=0;
        int showletterpos=0;

        // Scrabbleletters works as follows, a new table has been created with the letters of the difficulty level, this table shows the position of the letters of the word
        // random selects a random position in this table and makes it -1 so that if random selects it it will run again because this letter has been selected
        // so every time scrabbleletters is called it will randomly give a letter that has not been selected more than once

        do
        {
            Random rand = new Random();

            if (level == 1) {
                randomletter = rand.nextInt(4 );
            }
            if (level == 2){
                randomletter = rand.nextInt(5 );
            }
            if (level == 3){
                randomletter = rand.nextInt(6 );
            }


            if (letters_pointer_array[randomletter] != -1)
            {
                showletterpos=letters_pointer_array[randomletter];
            }
        } while (letters_pointer_array[randomletter] == -1);

        letters_pointer_array[randomletter] = -1;

        return showletterpos;
    }


    public int randomwordsorder(){
        int randomword;
        int wordpos=0;

        // Works the same way as scrabbleletters (), random specifies a word / (line of word array) and -1 is entered in the position index table so that this word does not reappear

        do
        {
            Random rand2 = new Random();
            randomword = rand2.nextInt(30 );
            if (words_order_pointer_array[randomword] != -1)
            {
                wordpos=words_order_pointer_array[randomword];
            }
        } while (words_order_pointer_array[randomword] == -1);

        words_order_pointer_array[randomword] = -1;

        return wordpos;
    }
    public void  showPopUpInCorrecteAnswer(){

        final AlertDialog.Builder alertdialogue = new AlertDialog.Builder(GameActivity.this);
        final View incorrecteModal = getLayoutInflater().inflate(R.layout.incorrecte_popup, null);
        alertdialogue.setView(incorrecteModal);
        dialog = alertdialogue.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        ImageView ok=incorrecteModal.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.cancel();
                resetAnswer();
            }
        });
}
    public void  showPopUpCorrecteAnswer(){

        final AlertDialog.Builder alertdialogue = new AlertDialog.Builder(GameActivity.this);
        final View incorrecteModal = getLayoutInflater().inflate(R.layout.correcte_popup, null);
        alertdialogue.setView(incorrecteModal);
        dialog = alertdialogue.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        ImageView ok=incorrecteModal.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.cancel();
                resetAnswer();
                nextWord();
            }
        });
    }
    public void setButonInvisible(){
        first_letter_Button.setVisibility(View.INVISIBLE);
        second_letter_Button.setVisibility(View.INVISIBLE);
        third_letter_Button.setVisibility(View.INVISIBLE);
        fourth_letter_Button.setVisibility(View.INVISIBLE);
        fifth_letter_Button.setVisibility(View.INVISIBLE);
        sixth_letter_Button.setVisibility(View.INVISIBLE);
    }
}
