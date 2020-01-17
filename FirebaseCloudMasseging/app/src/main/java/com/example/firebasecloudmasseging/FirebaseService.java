package com.example.firebasecloudmasseging;

import android.content.Intent;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class FirebaseService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        if (remoteMessage.getData().size() > 0) {
            String isiPesan = remoteMessage.getData().get("pesan");
            Intent intent = new Intent("com.example.firebasecloudmasseging_PESAN-FCM");
            intent.putExtra("pesan", isiPesan);
            LocalBroadcastManager lbm = LocalBroadcastManager.getInstance(this);
            lbm.sendBroadcast(intent);
        }
    }
}
