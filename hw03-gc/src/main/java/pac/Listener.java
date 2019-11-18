package pac;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.Notification;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;

public class Listener implements NotificationListener {
    public void handleNotification(Notification n, Object h){
        if(n.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)){
            GarbageCollectionNotificationInfo i = GarbageCollectionNotificationInfo.from((CompositeData)n.getUserData());

            String action = i.getGcAction();
            long duration = i.getGcInfo().getDuration();

            new printer().print(action,duration);
        }
    }
}