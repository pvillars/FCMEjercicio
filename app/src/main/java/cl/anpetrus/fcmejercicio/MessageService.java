package cl.anpetrus.fcmejercicio;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Petrus on 04-11-2017.
 */

public class MessageService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();
        Log.d("title", String.valueOf(title) );
        Log.d("body",String.valueOf(body));

        String data = remoteMessage.getData().get("data");
        Log.d("data",String.valueOf(data));

        String key = remoteMessage.getData().get("key");
        Log.d("key", String.valueOf(key));

        if (remoteMessage.getData().size() > 0) {
            NewMessageNotification.notify(this,data,key);
        } else {
            NewMessageNotification.notify(this, title, body);
        }

    }
}
