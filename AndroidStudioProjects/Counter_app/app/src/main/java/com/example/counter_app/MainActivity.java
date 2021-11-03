package com.example.counter_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "thread";

    Handler mainhandler = new Handler();

    int count = 0;

    boolean running = false;

    Button startbb, stopbb;
    TextView counter;

    void startthread(){
        newthread nobj = new newthread();
        nobj.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.textView);
        startbb = findViewById(R.id.startb);
        stopbb = findViewById(R.id.stopb);


        startbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                running = true;
                startthread();

            }
        });


        stopbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
            }
        });

    }
        class newthread extends Thread{
            public void run()
            {
                while (running) {
                    count++;

                    mainhandler.post(new Runnable() {
                        @Override
                        public void run() {
                            counter.setText(String.valueOf(count));
                        }
                    });

                    try{

                        Thread.sleep(1000);
                         }catch(InterruptedException e)
                    {

                        e.printStackTrace();

                }
            }
    }}


    }