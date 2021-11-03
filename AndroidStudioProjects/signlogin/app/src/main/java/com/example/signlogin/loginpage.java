package com.example.signlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicReference;

public class loginpage extends AppCompatActivity {
    EditText lusername,lpassword;
    Button blogin;
    TextView warning;

    String iuname,ipass,textdispaly;

    int counter=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        //initialize view

        lusername=findViewById(R.id.etluname);
        lpassword=findViewById(R.id.etlpass);
        blogin=findViewById(R.id.blogin);
        warning=findViewById(R.id.warning);

        //retrive savedusername and password from intent


        String savedusername = getIntent().getStringExtra("saveduname");

        String savedpassword = getIntent().getStringExtra("savedpassword");

        //activate button

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the userinput
                iuname=lusername.getText().toString();
                ipass=lpassword.getText().toString();

                //check if the userinput matches with text data



                if(savedusername==iuname&&savedpassword==ipass)
                {
                   Toast.makeText(loginpage.this,"succesfully loggedin",Toast.LENGTH_LONG).show();  //if matched

                    Intent intent =new Intent(getApplicationContext(),homepage.class);
                    startActivity(intent);

                }

                else{
                    Toast.makeText(loginpage.this,"wrong username or password",Toast.LENGTH_LONG).show();

                    //decrement counter by 1
                    counter--;
                    textdispaly="number of attempts remaining is "+counter;
                    warning.setText(textdispaly);

                    //check the counter
                    if(counter==0)
                    {
                        //disable the login button
                        blogin.setEnabled(false);
                    }

                }

            }
        });


    }
}