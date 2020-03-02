package com.example.tdiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ArrayList<BEThrow> _history;
    ListView listHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listHistory = findViewById(R.id.lv_history_content2);
        Button backButton = findViewById(R.id.btn_back);
        Button clearButton = findViewById(R.id.btn_clear1);


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
        setListview();
    }

    private void setListview() {
        _history = (ArrayList<BEThrow>)getIntent().getSerializableExtra("history");
        HistoryAdapter historyAdapter = new HistoryAdapter(this, android.R.layout.simple_list_item_1, _history);
        listHistory.setAdapter(historyAdapter);

    }


    private void clearHistory() {
    }

    private void back() {
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
