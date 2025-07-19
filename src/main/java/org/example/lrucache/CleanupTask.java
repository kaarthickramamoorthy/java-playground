package org.example.lrucache;

import java.util.concurrent.TimeUnit;

public class CleanupTask<K, V> implements Runnable {

    private final TTLCache<K, V> instance;

    public CleanupTask(TTLCache<K, V> instance) {
        this.instance = instance;
    }

    @Override
    public void run() {
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
                instance.cleanUp();
            }

            catch(InterruptedException ie){
                System.out.println(ie);
            }
        }

    }
}
