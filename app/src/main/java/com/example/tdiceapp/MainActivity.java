package com.example.tdiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btn_roll;
    LinearLayout dice_container;
    ImageView dice1, dice2;
    Random rng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rng = new Random();

        dice1 = findViewById(R.id.iv_dice1);
        dice2 = findViewById(R.id.iv_dice2);
        dice1.setImageResource(R.drawable.one);
        dice2.setImageResource(R.drawable.two);
        dice_container = findViewById(R.id.LL_dice_container);
        btn_roll = findViewById(R.id.btn_roll_dice);
        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollFirstDie();
            }
        });
    }
    private void rollDice(){
        rollFirstDie();
        rollSecondDie();
    }
    private int rollFirstDie() {
        int firstDieResult = rng.nextInt(6) + 1;
        switch (firstDieResult)
        {
            case 1:
                dice1.setImageResource(R.drawable.one);
                break;
            case 2:
                dice1.setImageResource(R.drawable.two);
                break;
            case 3:
                dice1.setImageResource(R.drawable.three);
                break;
            case 4:
                dice1.setImageResource(R.drawable.four);
                break;
            case 5:
                dice1.setImageResource(R.drawable.five);
                break;
            case 6:
                dice1.setImageResource(R.drawable.six);
                break;
        }
        return firstDieResult;
    }

    private int rollSecondDie() {
        int secondDieResult = rng.nextInt(6) + 1;
        switch (secondDieResult)
        {
            case 1:
                dice2.setImageResource(R.drawable.one);
                break;
            case 2:
                dice2.setImageResource(R.drawable.two);
                break;
            case 3:
                dice2.setImageResource(R.drawable.three);
                break;
            case 4:
                dice2.setImageResource(R.drawable.four);
                break;
            case 5:
                dice2.setImageResource(R.drawable.five);
                break;
            case 6:
                dice2.setImageResource(R.drawable.six);
                break;
        }
        return secondDieResult;
    }
}
