package com.example.datepickerapp;

import android.app.DatePickerDialog;
import android.icu.util.IslamicCalendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    int bday,bmonth,byear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                DatePickerDialog dpd=new DatePickerDialog(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        bday=dayOfMonth;
                        bmonth=month+1;
                        byear=year;
                        textView.setText(bday+"/"+bmonth+"/"+byear);
                    }
                },c.get(Calendar.DATE),c.get(Calendar.MONTH),c.get(Calendar.YEAR));
                dpd.show();

            }
        });
    }

}