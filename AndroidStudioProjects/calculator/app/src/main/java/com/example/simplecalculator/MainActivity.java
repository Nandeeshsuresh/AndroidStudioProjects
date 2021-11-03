package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button clear, div, add, sub, mul, b9, b8, b7, b6, b5, b4, b3, b2, b1, b0, bdot, bans;
    EditText result, display;
    String disp, oldnum="", res, operator, newnum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=findViewById(R.id.displayy);
        result=findViewById(R.id.resultt);
        clear = findViewById(R.id.clearb);
        div = findViewById(R.id.divisionb);
        add = findViewById(R.id.addb);
        sub = findViewById(R.id.subb);
        mul = findViewById(R.id.mulb);
        b9 = findViewById(R.id.nineb);
        b8 = findViewById(R.id.eightb);
        b7 = findViewById(R.id.sevenb);
        b6 = findViewById(R.id.sixb);
        b5 = findViewById(R.id.fiveb);
        b4 = findViewById(R.id.fourb);
        b3 = findViewById(R.id.threeb);
        b2 = findViewById(R.id.twob);
        b1 = findViewById(R.id.oneb);
        b0 = findViewById(R.id.zerob);
        bdot = findViewById(R.id.dotb);
        bans = findViewById(R.id.equalb);

        clear.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        add.setOnClickListener(this);
        sub.setOnClickListener(this);
        b9.setOnClickListener(this);
        b8.setOnClickListener(this);
        b7.setOnClickListener(this);
        b6.setOnClickListener(this);
        b5.setOnClickListener(this);
        b4.setOnClickListener(this);
        b3.setOnClickListener(this);
        b2.setOnClickListener(this);
        b1.setOnClickListener(this);
        b0.setOnClickListener(this);
        bdot.setOnClickListener(this);
        bans.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        disp = display.getText().toString();
        res = result.getText().toString();

       if (v.equals(b9)) {
            disp = disp + 9;
            res = res + 9;
        }
       else if (v.equals(b8)) {
            disp = disp + 8;
            res = res + 8;
        }

       else if (v.equals(b7)) {
            disp = disp + 7;
            res = res + 7;
        }
       else if (v.equals(b6)) {
            disp = disp + 6;
            res = res + 6;
        }

       else if (v.equals(b5)) {
            disp = disp + 5;
            res = res + 5;
        }
       else if(v.equals(b4)){
           disp=disp+4;
           res=res+4;
       }
       else if (v.equals(b3)) {
            disp = disp + 3;
            res = res + 3;
        }
       else if (v.equals(b2)) {
            disp = disp + 2;
            res = res + 2;
        }
       else if (v.equals(b1)) {
            disp = disp + 1;
            res = res + 1;
        }
       else if (v.equals(b0)) {
            disp = disp + 0;
            res = res + 0;
        }

       else if (v.equals(clear)) {
            disp = "";
            res = "";
        }

       else if (v.equals(div)) {
            disp = disp + "/";
            oldnum = res;
            operator = "/";
            res = "";

        }

       else if (v.equals(add)) {
           disp = disp + "+";
           oldnum = res;
           operator = "+";
           res = "";

       }

       else if (v.equals(mul)) {
            disp = disp + "*";
            oldnum = res;
            operator = "*";
            res = "";

        }
       else if (v.equals(sub)) {
            disp = disp + "-";
            oldnum = res;
            operator = "-";
            res = "";

        }

        else if (v.equals(bans)) {
            newnum=res;
            double finalresult = 0.0;

            switch (operator) {
                case "/":
                    finalresult = Double.parseDouble(oldnum) / Double.parseDouble(newnum);
                    break;
                case "+":
                    finalresult = Double.parseDouble(oldnum) + Double.parseDouble(newnum);
                    break;
                case "-":
                    finalresult = Double.parseDouble(oldnum) - Double.parseDouble(newnum);
                    break;
                case "*":
                    finalresult = Double.parseDouble(oldnum) * Double.parseDouble(newnum);
                    break;
            }
            res = finalresult + "";
        }
        display.setText(disp);
        result.setText(res);
    }
}