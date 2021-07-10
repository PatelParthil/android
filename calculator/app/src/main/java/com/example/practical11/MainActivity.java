package com.example.practical11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnadd,btnminus,btnmul,btndiv,btnequal,btnclear,btndot,btnbracket,btnper;
    TextView txtinput,txtoutput;
    String ans;
    Boolean checkBracket = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = findViewById(R.id.btn_zero);
        btn1 = findViewById(R.id.btn_one);
        btn2 = findViewById(R.id.btn_two);
        btn3 = findViewById(R.id.btn_three);
        btn4 = findViewById(R.id.btn_four);
        btn5 = findViewById(R.id.btn_five);
        btn6 = findViewById(R.id.btn_six);
        btn7 = findViewById(R.id.btn_seven);
        btn8 = findViewById(R.id.btn_eight);
        btn9 = findViewById(R.id.btn_nine);

        btnadd = findViewById(R.id.btn_plus);
        btnminus = findViewById(R.id.btn_minus);
        btnmul = findViewById(R.id.btn_mul);
        btndiv = findViewById(R.id.btn_divide);

        btnequal = findViewById(R.id.btn_equal);

        btnclear = findViewById(R.id.btn_clear);
        btndot = findViewById(R.id.btn_dot);
        btnbracket = findViewById(R.id.btn_bracket);
        btnper = findViewById(R.id.btn_percentage);

        txtinput = findViewById(R.id.txt1);
        txtoutput = findViewById(R.id.txt2);

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtinput.setText("");
                txtoutput.setText("");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "9");
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "+");
            }
        });
        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "-");
            }
        });
        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "*");
            }
        });
        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "/");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + ".");
            }
        });
        btnper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                txtinput.setText(ans + "%");
            }
        });
        btnbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBracket)
                {
                    ans = txtinput.getText().toString();
                    txtinput.setText(ans + ")");
                    checkBracket = false;
                }
                else
                {
                    ans = txtinput.getText().toString();
                    txtinput.setText(ans + "(");
                    checkBracket = true;
                }
            }
        });
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans = txtinput.getText().toString();
                ans = ans.replaceAll("%","/10");
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);
                String finalResult = "";
                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,ans,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";
                }
                txtoutput.setText(finalResult);
            }
        });
    }
}