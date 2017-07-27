package com.example.da08.airbnbserach;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Button btnStart, btnEnd;
    private CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setListener();
        setCalendarButtonText();

    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    private void setListener(){

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Log.i("calender", "year:"+i+", month:"+i1+", dayOfMonth:"+i2);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void setCalendarButtonText(){

        // button의 특정 글자 색만 바꾸기  (위젯의 android:textAllCaps="false" 적용해야함 -> 대문자는 인식못하기때문)

        String btnCheckInDate = getString(R.string.hint_start_date)
                + "<br> <font color = '#E14269'>" + getString(R.string.hint_select_date) + "</font>";
        StringUtil.setHtmlText(btnStart, btnCheckInDate);
//        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
//            btnStart.setText(Html.fromHtml(btnCheckInDate));
//        }else{
//            btnStart.setText(Html.fromHtml(btnCheckInDate,Html.FROM_HTML_MODE_LEGACY));
//        }

        String btnCheckOutDate = getString(R.string.hint_end_date)
                + "<br> <font color = '#E14269'>" + getString(R.string.hint_selectEnd_date) + "</font>";
        StringUtil.setHtmlText(btnEnd, btnCheckOutDate);
//        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
//            btnEnd.setText(Html.fromHtml(btnCheckOutDate));
//        }else{
//            btnEnd.setText(Html.fromHtml(btnCheckOutDate,Html.FROM_HTML_MODE_LEGACY));
//        }

    }
}
