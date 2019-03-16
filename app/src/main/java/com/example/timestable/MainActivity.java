package com.example.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent=new ArrayList<String>();
        for(int j=1;j<=10;j++){
            timesTableContent.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final SeekBar timesTableSeekbar=findViewById(R.id.timesTablesSeekBar);
        timesTableListView=findViewById(R.id.timesTablesListView);
        int max=20;
        int startPosition=10;
        timesTableSeekbar.setMax(max);
        timesTableSeekbar.setProgress(startPosition);
        generateTimesTable(startPosition);
        timesTableSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if (progress < min) {
                    timesTableNumber = min;
                    timesTableSeekbar.setProgress(min);


                } else {
                    timesTableNumber = progress;
                }
                Log.i("Seekbar value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
