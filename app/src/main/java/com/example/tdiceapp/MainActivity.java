package com.example.tdiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rollButton, clearButton;
    LinearLayout diceContainer;

    Random rng;
    Spinner spnDiceQuantity;
    ListView historyContent;
    ArrayAdapter<String> diceAdapter;
    ArrayAdapter<BEThrow> _historyAdapter;
    ArrayList<BEThrow> _history;
    int selection;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _history = new ArrayList<>();
        rng = new Random();

        diceContainer = findViewById(R.id.LL_dice_container);
        spnDiceQuantity = findViewById(R.id.spn_dice);

        Button btnHistory = findViewById(R.id.btn_history);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHistory();
            }
        });

        diceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,
                getResources().getStringArray(R.array.dice_options));
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDiceQuantity.setAdapter(diceAdapter);
        spnDiceQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               getSelection(diceContainer);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        historyContent = findViewById(R.id.lv_history_content);
        _historyAdapter = new HistoryAdapter(this, android.R.layout.simple_list_item_1, _history);
        historyContent.setAdapter(_historyAdapter);


        rollButton = findViewById(R.id.btn_roll_dice);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
        clearButton = findViewById(R.id.btn_clear);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _history.clear();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    private void openHistory() {
        Intent intent = new Intent(this, HistoryActivity.class);

        intent.putExtra("history",_history);
        startActivity(intent);
    }

    private void getSelection(LinearLayout container) {
        diceContainer.removeAllViews();
        if (spnDiceQuantity.getSelectedItemPosition() != 0)
        {
            selection = Integer.parseInt((String) spnDiceQuantity.getSelectedItem());
            createDice(container, selection);
        }
    }


    private void createDice(LinearLayout container, int selection) {
        while (!(selection <= 0 ))
        {
            ImageView image = new ImageView(this);

            switch (selection)
            {
                case 1:
                    image.setImageResource(R.drawable.one);
                    break;
                case 2:
                    image.setImageResource(R.drawable.two);
                    break;
                case 3:
                    image.setImageResource(R.drawable.three);
                    break;
                case 4:
                    image.setImageResource(R.drawable.four);
                    break;
                case 5:
                    image.setImageResource(R.drawable.five);
                    break;
                case 6:
                    image.setImageResource(R.drawable.six);
                    break;
            }
            image.setId(selection);
            container.addView(image);
            selection--;
        };
    }

    private void rollDice()
    {
        if (spnDiceQuantity.getSelectedItemPosition() == 0)
        {
            Toast.makeText(this, R.string.spn_no_choice, Toast.LENGTH_SHORT).show();
            return;
        }
        BEThrow current = new BEThrow();
        current.time = Calendar.getInstance();
        current.eyes = new int[diceContainer.getChildCount()];

        //Grabs hold of the LinearLayout's children and throws for each
        for (int i = 0; i < diceContainer.getChildCount(); i++)
        {
            //The toss
            int dieResult = rng.nextInt(6) + 1;

            //The current die that was tossed
            ImageView currentDie =(ImageView) diceContainer.getChildAt(i);

            if (currentDie != null)
            {
                //Sets the matching image to the die
                setDieImage(dieResult, currentDie);
            }

            //Adds the result to the history string
            current.eyes[i] = dieResult;

        }

        _history.add(current);
    }


    private void setDieImage(int result, ImageView view)
    {
        switch (result)
        {
            case 1:
                view.setImageResource(R.drawable.one);
                break;
            case 2:
                view.setImageResource(R.drawable.two);
                break;
            case 3:
                view.setImageResource(R.drawable.three);
                break;
            case 4:
                view.setImageResource(R.drawable.four);
                break;
            case 5:
                view.setImageResource(R.drawable.five);
                break;
            case 6:
                view.setImageResource(R.drawable.six);
                break;
        }
    }

}
