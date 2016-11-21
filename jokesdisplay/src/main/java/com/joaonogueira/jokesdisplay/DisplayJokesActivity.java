package com.joaonogueira.jokesdisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);
        TextView textView = (TextView) findViewById(R.id.text_display_joke);
        assert textView != null;
        textView.setText(getIntent().getStringExtra("joke"));
    }
}
