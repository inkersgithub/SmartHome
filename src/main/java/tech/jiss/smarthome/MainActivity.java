package tech.jiss.smarthome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        webview = (WebView)findViewById(R.id.webview);
        WebSettings set = webview.getSettings();
        webview.setWebViewClient(new WebClient());
        set.setJavaScriptEnabled(true);
        set.setBuiltInZoomControls(false);
        webview.loadUrl("file:///android_asset/main.html");
        webview.setBackgroundResource(R.color.colorPrimaryDark);
        webview.setBackgroundColor(0x00000000);
        webview.setVerticalScrollBarEnabled(false);
        webview.getSettings().setAppCachePath("/data/data/"+ getPackageName() +"/cache");
        webview.getSettings().setAppCacheEnabled(true);
        webview.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setAppCacheMaxSize(1024*1024*8);
        webview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webview.addJavascriptInterface(new WebAppInterface(this), "AndroidInterface");
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()) {


                webview.goBack();


        } else {
            super.onBackPressed();
        }
    }class WebClient extends WebViewClient {


    }


}


