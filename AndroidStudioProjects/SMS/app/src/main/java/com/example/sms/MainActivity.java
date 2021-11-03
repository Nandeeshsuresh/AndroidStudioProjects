package com.example.sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //initialize variable
    EditText phone_number,text_message;
    Button b_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable

        text_message = findViewById(R.id.tmessage);
        phone_number = findViewById(R.id.pnumber);
        b_button = findViewById(R.id.sbutton);


        b_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check condition
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {

                    //when permission is granted
                    //create method
                    sendMessage();
                } else {
                    //when permisssion is not granted request permissoin
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, 100);

                }
            }

        });
        }


    private void sendMessage(){
        //Get values from edit text
        String sphone=phone_number.getText().toString().trim();
        String smessage=text_message.getText().toString().trim();

        //check condition
        if(!sphone.equals("")&& !smessage.equals("")) {
            //when both edit text value not equal to blank
            //initialize sms manager
            SmsManager smsManager = SmsManager.getDefault();
            //send text message
            smsManager.sendTextMessage(sphone, null, smessage, null, null);

            //Display toast
            Toast.makeText(getApplicationContext(),
                    "SMS sent successfully!", Toast.LENGTH_LONG).show();
        }else{
            //when  edit text value is blank
            //Display
            Toast.makeText(getApplicationContext(),"Enter value first",Toast.LENGTH_SHORT).show();





        }
        }

  @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions ,@NonNull  int[] grantResults){
    super.onRequestPermissionsResult( requestCode,permissions,grantResults);
    //check condition
    if(requestCode==100&&grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
        //when permission is granted
        //call method
        sendMessage();
    }else{
        //when perrmission is deleted
        //Display toast
        Toast.makeText(getApplicationContext(),"permission denined",Toast.LENGTH_SHORT).show();

    }


}


}