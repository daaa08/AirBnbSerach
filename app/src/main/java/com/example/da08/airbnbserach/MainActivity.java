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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FloatingActionButton fab;
    Button btnStart, btnEnd;
    private CalendarView calendarView;
    private Search search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        init();
        setListener();
        setCalendarButtonText();

    }

    private void init(){
        search = new Search();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    private static final int CHECK_IN = 10;
    private static final int CHECK_OUT = 20;
    private int checkStatus = CHECK_IN;

    private void setListener(){

        calendarView.setOnDateChangeListener(dateChangeListener);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    private void setCalendarButtonText(){
        setButtonText(btnStart, getString(R.string.hint_start_date), getString(R.string.hint_select_date));
        setButtonText(btnEnd, getString(R.string.hint_end_date), "-");

    }

    private void setButtonText(Button btn, String upText, String downText){
        // button의 특정 글자 색만 바꾸기  (위젯의 android:textAllCaps="false" 적용해야함 -> 대문자는 인식못하기때문)
        String btnCheckInDate = "<font color='#888888'>" + upText
                + "</font> <br> <font color=\"#fd5a5f\">" + downText + "</font>";
        StringUtil.setHtmlText(btn,btnCheckInDate);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStart :
                checkStatus = CHECK_IN;
                setButtonText(btnStart, getString(R.string.hint_start_date), getString(R.string.hint_select_date));
                setButtonText(btnEnd, getString(R.string.hint_end_date), search.checkOutDate);
                break;
            case R.id.btnEnd:
                checkStatus = CHECK_OUT;
                setButtonText(btnEnd, getString(R.string.hint_end_date), getString(R.string.hint_select_date));
                setButtonText(btnStart, getString(R.string.hint_start_date), search.checkInDate);
                break;
        }
    }

    CalendarView.OnDateChangeListener dateChangeListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
            Log.i("calender", "year:"+i+", month:"+i1+", dayOfMonth:"+i2);
            String theDay = String.format("%d-%02d-%02d", i, i1, i2);
//            String theDay = String.format("%s = %d", "joe", 35);
            switch (checkStatus) {
                case CHECK_IN:
                    search.checkInDate = theDay;
                    setButtonText(btnStart, getString(R.string.hint_start_date), search.checkInDate);
                    break;
                case CHECK_OUT:
                    search.checkOutDate = theDay;
                    setButtonText(btnEnd, getString(R.string.hint_end_date), search.checkOutDate);
                    break;
            }
        }
    };
}
