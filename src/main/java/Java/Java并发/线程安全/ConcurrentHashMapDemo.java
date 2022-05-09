package Java.Java并发.线程安全;

import com.google.common.util.concurrent.AtomicLongMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Acui
 * @date 2022年04月26日 16:21
 */
public class ConcurrentHashMapDemo {
    private Map<String, AtomicInteger> map = new ConcurrentHashMap<>();
    private AtomicLongMap<String> atomicLongMap = AtomicLongMap.create();


    public void addAtomicLongMap(String key) {
        atomicLongMap.incrementAndGet(key);
    }


    public void add(String key) {
        AtomicInteger oldValue;
        oldValue = map.get(key);
        if (null == oldValue) {
            AtomicInteger zeroValue = new AtomicInteger(0);
            oldValue = map.putIfAbsent(key, zeroValue);
            if (null == oldValue) {
                oldValue = zeroValue;
            }
        }
        oldValue.incrementAndGet();
    }

    public static void main(String[] args) {
        AtomicLongMap<String> atomicLongMap = AtomicLongMap.create();


        ConcurrentHashMapDemo demo = new ConcurrentHashMapDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 1000; j++) {
                executorService.execute(()->{
                    demo.add("abc");
                    demo.add("xyz");
                    demo.add("cxf");
                    demo.addAtomicLongMap("abc");
                });
            }
        }
        executorService.shutdown();
        System.out.println(demo.map.get("abc"));
        System.out.println(demo.map.get("xyz"));
        System.out.println(demo.map.get("cxf"));
        System.out.println(demo.atomicLongMap.get("abc"));

    }



}
