package com.example.sumi.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.TimePicker;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int mMinute = 0;
    int mHourOfDay = 0;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            showTimePickerDialog();
        } else if (v.getId() == R.id.button2) {
            if (mHourOfDay <= 2 && mHourOfDay <= 9) {
                mTextView.setText("おはよう" + mHourOfDay + ":" + mMinute);
            } else if (mHourOfDay >= 10 && mMinute <= 17) {
                mTextView.setText("こんにちは" + mHourOfDay + ":" + mMinute);
            } else {
                mTextView.setText("こんばんは" + mHourOfDay + ":" + mMinute);
            }
        }

    }

    private void showTimePickerDialog() {



        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ";" + String.valueOf(minute));

                        mHourOfDay = hourOfDay;
                        mMinute = minute;
                    }
                },
                13, //  初期値（時間）
                0,  //  初期値（分）
                true);

        timePickerDialog.show();


    }



}
