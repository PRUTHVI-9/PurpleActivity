package com.example.purpleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//    TextView view;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp);
        layout = findViewById(R.id.linear);
        TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("&#9679"));
        textView.setTextColor(Color.WHITE);
        TextView tv1 = new TextView(this);
        tv1.setText(Html.fromHtml("&#9679"));
        tv1.setTextColor(Color.WHITE);
        LinearLayout ll = new LinearLayout(MainActivity.this);

        layout.addView(textView);
        layout.addView(tv1);

//        view = findViewById(R.id.temp);
//        view.setText(Html.fromHtml("&#9679"));
//        view.setTextColor(Color.RED);


//        LinearLayout mainlayout = new LinearLayout(MainActivity.this);
//        mainlayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        TextView textView = new TextView(MainActivity.this);
//        textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        textView.setText("Hello hsbshuosaevworld");
//        mainlayout.addView(textView);
//        setContentView(mainlayout);
    }
}