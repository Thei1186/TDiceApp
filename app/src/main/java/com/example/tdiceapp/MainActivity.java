package com.example.tdiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rollButton, clearButton;
    LinearLayout diceContainer;

    Random rng;
    Spinner spnDiceQuantity;
    ListView historyContent;
    ArrayAdapter<String> string_adapter, diceAdapter;
    int selection;

    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rng = new Random();

        diceContainer = findViewById(R.id.LL_dice_container);

        spnDiceQuantity = findViewById(R.id.spn_dice);
        diceAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, getResources().getStringArray(R.array.dice_options));
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
        string_adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        historyContent.setAdapter(string_adapter);


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
                clearHistory();
            }
        });
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
            image.setLayoutParams(new android.view.ViewGroup.LayoutParams(150,150));
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
        StringBuilder history = new StringBuilder();
        for (int i = 0; i < diceContainer.getChildCount(); i++)
        {
            int dieResult = rng.nextInt(6) + 1;
            ImageView currentDie =(ImageView) diceContainer.getChildAt(i);
            if (currentDie != null)
            {
                setDieImage(dieResult, currentDie);
            }
            history.append(dieResult);
            if(i != diceContainer.getChildCount() - 1)
            {
                history.append(" | ");
            }
        }
            createHistory(history.toString());
    }

    private void createHistory(String results) {
        if (string_adapter.getCount() >= 5)
        {
            clearHistory();
        }
        count++;
        string_adapter.add(count + ": " + results);

    }

    private void clearHistory() {
        if (count % 5 > 0)
        {
            count = 0;
        }
         string_adapter.clear();
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
