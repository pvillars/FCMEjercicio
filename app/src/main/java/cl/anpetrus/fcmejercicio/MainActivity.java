package cl.anpetrus.fcmejercicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        firebaseMessaging.subscribeToTopic("weather");

        String data = getIntent().getStringExtra("data");
        if (data != null) {
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "no hay data", Toast.LENGTH_SHORT).show();
        }

    }
}
