package com.example.signlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button  signup;
    String uname="",pass="";
    private static final Pattern password_pattern=Pattern.compile("^" +
            "(?=.*[0-9])"+      // atlest onedigit
            "(?=.*[a-z])" +           // atlest one lowercase letter
            "(?=.*[A-Z])"+     // atlest one   uppercaseletter
            "(?=.*[a-zA-Z])"+  //anyletter
            "(?=.*[@#$%^&+_=\\*])"+           //atlest one special charatcer
            "(?=\\S+$)"+         //no whitespacw
            "(?=.{8,})"+            //atlest 8 character
            ".*$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.etuname);
        password=findViewById(R.id.etpass);
        signup=findViewById(R.id.bsignup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uname=username.getText().toString();
                pass=password.getText().toString();

                if(uname.isEmpty()||pass.isEmpty())   //checking that username and password field not empty
                {
                    Toast.makeText(MainActivity.this,"enter the username and password",Toast.LENGTH_LONG).show();
                }
                else if(password.length()<8)     //checking that password length should be less than 8
                {
                    Toast.makeText(MainActivity.this,"password should contain 8 characters",Toast.LENGTH_LONG).show();
                }
                else if(!password_pattern.matcher(pass).matches())
                {
                    Toast.makeText(MainActivity.this,"password should coantain " +
                            "one lowercase letter and uppercase letter" +
                            "one digit and one special character ",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"succesfully signed up",Toast.LENGTH_LONG).show();

                    Intent intent =new Intent(MainActivity.this,loginpage.class);

                    intent.putExtra("saveduname",uname);
                    intent.putExtra("savedpassword",pass);

                    startActivity(intent);
                }}
        });


    }
}