package tech.jiss.smarthome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.NoBar);
        setContentView(R.layout.activity_splash);




        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this,NetActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2000);



    }
}
