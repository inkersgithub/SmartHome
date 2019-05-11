package tech.jiss.smarthome;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class NetActivity extends AppCompatActivity {

    WebView respo;
    ImageView Bbtn,Fbtn,Pbtn,ser2;

    Boolean Bdata=false,Fdata=false,Pdata=false;
    Button msgBar;
    Animation slide_down,slide_up;
    ImageButton ser1;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
       slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);

        Bbtn = findViewById(R.id.bulb);
        Fbtn = findViewById(R.id.fan);
        Pbtn = findViewById(R.id.plug);
        progressBar = findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.GONE);
        ser1 = findViewById(R.id.ser1);
        ser2 = findViewById(R.id.ser2);
        ser1.setVisibility(View.GONE);
        ser2.setVisibility(View.GONE);
        msgBar = findViewById(R.id.Mbar);
        msgBar.setVisibility(View.GONE);
        respo = (WebView)findViewById(R.id.wv);
        respo.setVisibility(View.GONE);
        WebSettings set = respo.getSettings();
        respo.setWebViewClient(new WebClient());
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(false);
      //  respo.loadUrl("file:///android_asset/main.html");
        respo.setBackgroundResource(R.color.gray);
        respo.setBackgroundColor(0x00000000);
        respo.setVerticalScrollBarEnabled(false);


        Bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (Bdata)
            {
                Bbtn.setImageResource(R.drawable.off);
                respo.loadUrl("https://maker.ifttt.com/trigger/boff/with/key/dGrwAT4yxX8rmtFy-PF2WD");
                msgbar(false,"Bulb is turned OFF");
                Bdata=false;
            }
            else
            {
                Bbtn.setImageResource(R.drawable.on);

                respo.loadUrl("https://maker.ifttt.com/trigger/bon/with/key/dGrwAT4yxX8rmtFy-PF2WD");
                msgbar(true,"Bulb is turned ON");
                Bdata=true;
            }


            }
        });

        Fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Fdata)
                {
                    Fbtn.setImageResource(R.drawable.foff);
                    respo.loadUrl("https://maker.ifttt.com/trigger/foff/with/key/dGrwAT4yxX8rmtFy-PF2WD");
                    msgbar(false,"Fan is turned OFF");
                    Fdata=false;
                }
                else
                {
                    Fbtn.setImageResource(R.drawable.fon);
                    respo.loadUrl("https://maker.ifttt.com/trigger/fon/with/key/dGrwAT4yxX8rmtFy-PF2WD");
                    msgbar(true,"Fan is turned ON");
                    Fdata=true;
                }


            }
        });

        Pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pdata)
                {

                    respo.loadUrl("https://maker.ifttt.com/trigger/poff/with/key/dGrwAT4yxX8rmtFy-PF2WD");
                    msgbar(false,"Plug is turned OFF");
                    Pdata=false;
                    Pbtn.setImageResource(R.drawable.poff);
                }
                else
                {

                    respo.loadUrl("https://maker.ifttt.com/trigger/pon/with/key/dGrwAT4yxX8rmtFy-PF2WD");
                    msgbar(true,"Plug is turned ON");
                    Pdata=true;
                    Pbtn.setImageResource(R.drawable.pon);
                }


            }
        });





    }

    public void msgbar(final Boolean clr,final String msg)
    {

        ser1.setVisibility(View.VISIBLE);
        ser2.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);


        if(clr){
            msgBar.setBackgroundColor(getResources().getColor(R.color.On));}
        else{
            msgBar.setBackgroundColor(getResources().getColor(R.color.Off)); }

        msgBar.setText(msg);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                ser1.setVisibility(View.GONE);
                ser2.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);
                msgBar.setVisibility(View.VISIBLE);
                msgBar.startAnimation(slide_up);

            }
        }, 2500);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                msgBar.startAnimation(slide_down);

        msgBar.setVisibility(View.GONE);

            }
        }, 4800);



    }





    class WebClient extends WebViewClient {


    }






}
