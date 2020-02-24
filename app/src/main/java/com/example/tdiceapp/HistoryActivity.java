package com.example.tdiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class HistoryActivity extends AppCompatActivity {

    ListView listHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listHistory.findViewById(R.id.lv_history_content2);
        Button backButton = findViewById(R.id.btn_back);
        Button clearButton = findViewById(R.id.btn_clear1);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });



    }

    private void back() {
        finish();
    }
}
