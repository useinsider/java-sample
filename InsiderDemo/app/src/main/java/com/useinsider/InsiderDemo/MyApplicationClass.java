package com.useinsider.InsiderDemo;

import android.app.Application;
import android.util.Log;

import com.useinsider.insider.Insider;
import com.useinsider.insider.InsiderCallback;
import com.useinsider.insider.InsiderCallbackType;

import org.json.JSONObject;

public class MyApplicationClass extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        // TODO: Please change with your partner name.
        // Make sure that all the letters are lowercase.
        Insider.Instance.init(this, "your_partner_name");
        Insider.Instance.registerInsiderCallback(new InsiderCallback() {
            @Override
            public void doAction(JSONObject data, InsiderCallbackType callbackType) {
                switch (callbackType) {
                    case NOTIFICATION_OPEN:
                        Log.d("[INSIDER]", "[NOTIFICATION_OPEN]: " + data);
                        break;
                    case TEMP_STORE_CUSTOM_ACTION:
                        Log.d("[INSIDER]", "[TEMP_STORE_CUSTOM_ACTION]: " + data);
                        break;
                }
            }
        });
        // TODO: Add your splash activity.
        //Insider.Instance.setSplashActivity(Splash.activity);
        Insider.Instance.getCurrentUser().setLocationOptin(true);
        Insider.Instance.startTrackingGeofence();
        Insider.Instance.enableIDFACollection(false);
        Insider.Instance.getCurrentUser().setLocale("tr_TR");
    }
}
