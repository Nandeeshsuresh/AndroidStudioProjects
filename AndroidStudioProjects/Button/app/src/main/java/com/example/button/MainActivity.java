package com.example.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ename;
    TextView textview;
    String username,output;


    public void onclick(View v)  {

       ename=findViewById(R.id.name);
       textview=findViewById(R.id.display);

       username=ename.getText().toString();
       output="hello   "+  username  +"   welcome";
       textview.setText(output);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}