package com.example.tdiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {

    ArrayAdapter<String> historyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ListView listHistory = findViewById(R.id.lv_history_content2);
        Button backButton = findViewById(R.id.btn_back);
        Button clearButton = findViewById(R.id.btn_clear1);

        historyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listHistory.setAdapter(historyAdapter);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHistory();
            }
        });

    }

    private void clearHistory() {
    }

    private void back() {
        finish();
    }
}
