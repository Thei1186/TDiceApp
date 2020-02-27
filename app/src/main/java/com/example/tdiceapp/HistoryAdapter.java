package com.example.tdiceapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class HistoryAdapter extends ArrayAdapter<BEThrow> {

    private ArrayList<BEThrow> historyList;

    private final int[] colours = {
            Color.parseColor("#1A1A1A"),
            Color.parseColor("#262626")
    };

    public HistoryAdapter(Context context, int resId, ArrayList<BEThrow> historyList) {
        super(context, resId, historyList);
        this.historyList = historyList;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            LayoutInflater li = (LayoutInflater)
                    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = li.inflate(R.layout.cell, null);
            Log.d("XYZ", "Position: " + position + " View created");
        } else {
            Log.d("XYZ", "Position: " + position + " View reused");
        }
        v.setBackgroundColor(colours[position % colours.length]);

        BEThrow t = historyList.get(position);
        TextView index = v.findViewById(R.id.tv_history_index);
        LinearLayout historyDice = v.findViewById(R.id.ll_history_dice);
        historyDice.removeAllViews();
        for (int i=0; i < t.eyes.length; i++)
            historyDice.addView( getDieImage(t.eyes[i]));
        index.setText("" + (1+position) );

        return v;
    }

    private ImageView getDieImage(int result)
    {
        ImageView res = new ImageView( getContext() );
        switch (result)
        {
            case 1:
                res.setImageResource(R.drawable.one);
                break;
            case 2:
                res.setImageResource(R.drawable.two);
                break;
            case 3:
                res.setImageResource(R.drawable.three);
                break;
            case 4:
                res.setImageResource(R.drawable.four);
                break;
            case 5:
                res.setImageResource(R.drawable.five);
                break;
            case 6:
                res.setImageResource(R.drawable.six);
                break;
        }
        return res;
    }

   /* private ImageView setDieImage(Context context, int result)
    {
        ImageView view = new ImageView(context);
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
        return view;
    } */
}
