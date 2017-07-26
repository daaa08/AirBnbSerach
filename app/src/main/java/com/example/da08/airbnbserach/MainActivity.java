package com.example.da08.airbnbserach;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    Button btnStart, btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // button의 특정 글자 색만 바꾸기
        btnStart = (Button)findViewById(R.id.btnStart);
        String btnCheckInDate = getString(R.string.hint_start_date)
                +"<br> <font color = '#E14269'>"+getString(R.string.hint_select_date)+"</font>";
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            btnStart.setText(Html.fromHtml(btnCheckInDate));
        }else{
            btnStart.setText(Html.fromHtml(btnCheckInDate,Html.FROM_HTML_MODE_LEGACY));
        }

        btnEnd = (Button)findViewById(R.id.btnEnd);
        String btnCheckOutDate = getString(R.string.hint_end_date)
                +"<br> <font color = '#E14269'>"+getString(R.string.hint_selectEnd_date)+"</font>";
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N){
            btnEnd.setText(Html.fromHtml(btnCheckOutDate));
        }else{
            btnEnd.setText(Html.fromHtml(btnCheckOutDate,Html.FROM_HTML_MODE_LEGACY));
        }

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
