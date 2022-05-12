package com.ailyan.anagram;

import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView four, five, six;

    private int level;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        four = (ImageView) findViewById(R.id.four);
        five = (ImageView) findViewById(R.id.five);
        six = (ImageView) findViewById(R.id.six);

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = 1;
                Intent myIntent = new Intent(MainActivity.this, GameActivity.class);
                myIntent.putExtra("levelchoice", level);
                startActivity(myIntent);

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = 2;
                Intent myIntent = new Intent(MainActivity.this, GameActivity.class);
                myIntent.putExtra("levelchoice", level);
                startActivity(myIntent);

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level = 3;
                Intent myIntent = new Intent(MainActivity.this, GameActivity.class);
                myIntent.putExtra("levelchoice", level);
                startActivity(myIntent);

            }
        });


    }
}







