import listener.Listener;
import listener.Printer;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().watchForGc();
        List<String> overflowList = null;
        long startTime = System.currentTimeMillis();
        Printer.setStartTime(startTime);
        for (int numbeOfArrayList = 0; ; numbeOfArrayList++) {
            overflowList = new ArrayList<>();
            for (int listSize = 0; listSize < numbeOfArrayList * numbeOfArrayList; listSize++)
                overflowList.add("str");
            Printer.setListSize(numbeOfArrayList);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Insomnia");
            }
        }
    }

    private void watchForGc() {
        List<GarbageCollectorMXBean> gcList = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean el : gcList) {
            NotificationEmitter emitter = (NotificationEmitter) el;
            NotificationListener listener = new Listener();
            emitter.addNotificationListener(listener, null, null);
        }
    }
}