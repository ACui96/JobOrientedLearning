package JUC.a20220218;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Acui
 * @date 2022年02月18日 15:09
 */

class MyData {
    Map<String, AtomicInteger> atomicMap;
    Map<String , LongAdder> concurrentHashMap = new ConcurrentHashMap();

    Map<String, Integer> regularMap = new HashMap<>();
    AtomicInteger atomicInteger = new AtomicInteger();

    public MyData() {
        this.atomicMap = new HashMap<>();

    }

    private Lock lock = new ReentrantLock();
    public void increRegularMapByLock(String key) {
        lock.lock();
        try{
            if (!regularMap.containsKey(key)) {
                regularMap.put(key, 1);
            } else {
                regularMap.put(key, regularMap.get(key) + 1);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void incrRegularMap(String key) {
        synchronized (this) {
            if (!regularMap.containsKey(key)) {
                regularMap.put(key, 1);
            } else {
                regularMap.put(key, regularMap.get(key) + 1);
            }
        }

    }

    public void setConcurrentHashMap(String key) {
        if (!concurrentHashMap.containsKey(key)){
            concurrentHashMap.put(key, new LongAdder());
        }else{
            synchronized (MyData.class) {
                concurrentHashMap.get(key).increment();
            }
        }
    }

    public void incrMap(String key) {
        synchronized (MyData.class){
            if (!atomicMap.containsKey(key)) {
                atomicMap.put(key, new AtomicInteger(1));
            } else {
                atomicMap.get(key).incrementAndGet();
            }
        }

    }


    public void incrAtomicInteger() {
        atomicInteger.incrementAndGet();
    }

}
public class Test {
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 2000; j++) {
//                    myData.incrMap("abc");
//                    myData.incrMap("abc1");
//                    myData.incrMap("abc2");
                    myData.setConcurrentHashMap("setConcurrentHashMap");
//                    System.out.println("线程"+Thread.currentThread().getName()+"的值="+myData.concurrentHashMap.get("setConcurrentHashMap"));
                    myData.incrRegularMap("RegularMap");
                    myData.incrAtomicInteger();
                    myData.increRegularMapByLock("increRegularMapByLock");
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 5) {
            Thread.yield();
        }
        System.out.println("abc 的最终结果为" + "\t" + myData.atomicMap.get("abc"));
        System.out.println("abc1 的最终结果为" + "\t" + myData.atomicMap.get("abc1"));
        System.out.println("abc2 的最终结果为" + "\t" + myData.atomicMap.get("abc2"));
        System.out.println("setConcurrentHashMap 的最终结果为" + "\t" + myData.concurrentHashMap.get("setConcurrentHashMap"));
        System.out.println("RegularMap 的最终结果为" + "\t" + myData.regularMap.get("RegularMap"));
        System.out.println("regularMap.get(\"increRegularMapByLock\")  的最终结果为" + "\t" + myData.regularMap.get("increRegularMapByLock"));

        System.out.println("atomicInteger 的最终结果为" + "\t" + myData.atomicInteger);

    }
}
