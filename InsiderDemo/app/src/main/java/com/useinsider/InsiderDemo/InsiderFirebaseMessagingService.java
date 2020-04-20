package com.useinsider.InsiderDemo;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.useinsider.insider.Insider;

public class InsiderFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage != null && remoteMessage.getData().containsKey("source") && remoteMessage.getData().get("source").equals("Insider")) {
            Insider.Instance.handleNotification(getApplicationContext(), remoteMessage);
            return;
        }
    }
}
