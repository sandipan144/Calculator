package com.chakraborty.sandipan.calculator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {
    TextInputEditText number1EditText;
    TextInputEditText number2EditText;
    Button addbutton;
    FloatingActionButton resetbutton;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        addbutton = findViewById(R.id.addbutton);
        resetbutton = findViewById(R.id.resetbutton);
        t1 = findViewById(R.id.textView);

        resetbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1EditText.setText("");
                number2EditText.setText("");
                number1EditText.requestFocus();
            }
        });

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                String num1 = number1EditText.getText().toString();
                String num2 = number2EditText.getText().toString();
                if (num1.length()==0 || num2.length()==0) {
                    Toast.makeText(CalculatorActivity.this, "Input the fucking number", Toast.LENGTH_SHORT).show();
                } else {
                    int num11 = Integer.parseInt(num1);
                    int num22 = Integer.parseInt(num2);
                    int ans = num11 + num22;
                    //t1.setText("Result is:  "+ans);
                    //displayAlertMessage(ans);
                    Intent intent = new Intent(CalculatorActivity.this, ResultActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_answer", ans);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
            }
        });
    }

    private void displayAlertMessage(int ans){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Answer");
        builder.setMessage("Answer is: "+ans);
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", null);
        builder.setNegativeButton("No",null);
        builder.setNeutralButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}
