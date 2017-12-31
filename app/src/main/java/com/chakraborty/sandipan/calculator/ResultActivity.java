package com.chakraborty.sandipan.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");
        t1 = findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        int ans = bundle.getInt("key_answer");
        t1.setText("Result is :"+ans);
    }
}
