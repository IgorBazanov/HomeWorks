package pac;

import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class heapOverflow {
    public void overflow(){
        watchForGc();
        List<String>list;
        long t = System.currentTimeMillis();
        for(int i=0; i<10000;i++){
            list = new ArrayList<>();

            for(int q=0;q<i*i;q++)
                list.add("str");
            printer.setT(System.currentTimeMillis()-t);
            printer.setI(i*i);


            try{Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println("Insomnia");
            }
        }
    }

    public void watchForGc(){
        List<GarbageCollectorMXBean> gcList = ManagementFactory.getGarbageCollectorMXBeans();
        for(GarbageCollectorMXBean el:gcList){
            NotificationEmitter emitter = (NotificationEmitter) el;
            NotificationListener listener = new Listener();
            emitter.addNotificationListener(listener,null,null);
        }
    }
}