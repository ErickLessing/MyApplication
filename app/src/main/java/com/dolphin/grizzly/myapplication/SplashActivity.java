package com.dolphin.grizzly.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread splashThread = new Thread()
        {
            public void run()
            {
                try{
                    TextView name = findViewById(R.id.txtSplashName);
                    name.animate().alpha(1f).setDuration(3000);
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent= new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                }

            }
        };
        splashThread.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }

}
