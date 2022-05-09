package Interview.kuaishou360tencent20220424.tencent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;

/**
 * @author Acui
 * @date 2022年04月24日 20:10
 */
public class test {
    Map<String, AtomicInteger> map = new HashMap<>();
    Map<String, Integer> regularMap = new HashMap<>();

    public static void main(String[] args) {

        test t = new test();

        for (int i = 0; i < 20; i++) {
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    t.incr("cxf");
                }

            }, String.valueOf(i)).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.print(t.map.get("cxf")+"\t");

        System.out.println();
        for (int i = 0; i < 100; i++) {
            new Thread(() ->{
                t.incr1("key2");

            }, String.valueOf(i)).start();
        }
        System.out.print(t.regularMap.get("key2")+"\t");

    }

    private int incr(String key) {
        if (!map.containsKey(key)) {
            map.put(key, new AtomicInteger(1));
            return 1;
        } else {
            return map.get(key).incrementAndGet();
        }
    }

    private synchronized void incr1(String key) {

        if (!regularMap.containsKey(key)) {
            regularMap.put(key, 1);
        } else {
            regularMap.put(key, regularMap.get(key) + 1);
        }

    }
}
