package com.example.firebasecloudmasseging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private BroadcastReceiver mHandler = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            // mengambil nilai extra dari notifikasi
            Bundle bundle = intent.getExtras();
            if (bundle != null && bundle.containsKey("pesan")){
                String isiPesan = bundle.getString("pesan");
                textView.setText(isiPesan);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mHandler);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("isiPesan", "getInstanceId failed", task.getException());
                            return;
                        }

                        // Get new Instance ID token
                        String token = task.getResult().getToken();

                        // Log and toast
                        String msg = "isiToken: " + token;
                        Log.d("isiPesan", msg);
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

        LocalBroadcastManager.getInstance(this).registerReceiver(mHandler,
                new IntentFilter("com.example.firebasecloudmasseging_PESAN-FCM"));

        textView = findViewById(R.id.text_view);

        // mengambil nilai extra dari notifikasi
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.containsKey("pesan")){
            String isiPesan = bundle.getString("pesan");
            TextView textView = findViewById(R.id.text_view);
            textView.setText(isiPesan);
        }
    }
}
