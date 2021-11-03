package com.example.wallpaper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //define variables
    Button wallpaperset;
    Timer tmr;
    Drawable drawable;
    WallpaperManager wlprmgr;

    //initialize piccount
    int piccount=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize button,wallpaper,timer
        wallpaperset=findViewById(R.id.button);
        tmr = new Timer();
        wlprmgr=WallpaperManager.getInstance(this);


        //activate button
        wallpaperset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //run wallpaper method
                setWallpaper();
            }
        });

            }

            private void setWallpaper()
            {
                //start a timer method
                tmr.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        //for each piccount convert the picture into drawable
                        //change the piccount
                          if(piccount==1)
                          {
                                drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.pic1,null);
                                piccount=2;
                          }
                          else if(piccount==2)
                          {
                              drawable=ResourcesCompat.getDrawable(getResources(),R.drawable.pic2,null);
                              piccount=3;
                          }
                          else if(piccount==3)
                          {
                              drawable=ResourcesCompat.getDrawable(getResources(),R.drawable.pic3,null);
                              piccount=4;
                          }
                          else if(piccount==4)
                          {
                              drawable=ResourcesCompat.getDrawable(getResources(),R.drawable.pic5,null);
                              piccount=5;
                          }
                          else if(piccount==5)
                          {
                              drawable=ResourcesCompat.getDrawable(getResources(),R.drawable.pic6,null);
                              piccount=1;
                          }
                        //convert drawable into bit map
                        assert drawable!=null;
                        Bitmap wallpaper = ((BitmapDrawable)drawable).getBitmap();

                        try{
                            wlprmgr.setBitmap(wallpaper);
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                },0,3000);
            }
        }



