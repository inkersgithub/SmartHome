package tech.jiss.smarthome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class WebAppInterface {
    Context mContext;
    SharedPreferences sharedPreferences;
    String logname,logpwd,Fname,Eid,Mno;

    // Instantiate the interface and set the context
    WebAppInterface(Context c) {
        mContext = c;
        sharedPreferences = mContext.getSharedPreferences("SmartH",MODE_PRIVATE);

    }

    // Show a toast from the web page
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();

    }


    @JavascriptInterface
    public void sendLogout (String Logout) {

        Toast.makeText(mContext, Logout, Toast.LENGTH_SHORT).show();




    }


    @JavascriptInterface
    public String IpAdrss() {
        return sharedPreferences.getString("IpData","");
    }






}