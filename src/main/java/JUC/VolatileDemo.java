package JUC;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Acui
 * @date 2021年09月19日 16:49
 */
class MyData {
//    volatile int num = 0;
    volatile int num = 0;
    public void addTo60() {
        this.num = 60;
    }

    public void incrementBy1() {
        this.num++;
    }


    AtomicInteger atomicInteger = new AtomicInteger();

    public void incrementAtomic() {
        atomicInteger.incrementAndGet();
    }


    Map<String, AtomicInteger> atomicMap = new HashMap<>();

    public void incrementMapBy1(String key){
        if (atomicMap.containsKey(key)) {
            atomicMap.get(key).incrementAndGet();
        } else {
            atomicMap.put(key, new AtomicInteger(1));
        }
    }

}

public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.incrementBy1();
                    myData.incrementAtomic();
                    myData.incrementMapBy1("cxf");
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 3) {
            Thread.yield();
        }
        System.out.println("1The final number is" + "\t" + myData.num);
        System.out.println("2The final number is" + "\t" + myData.atomicInteger);
        System.out.println("3The final number of cxf is" + "\t" + myData.atomicMap.get("cxf"));

//        new Thread(() ->{
//            System.out.println(Thread.currentThread().getName() + "\t" + "开始执行。。。");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            myData.addTo60();
//        },"A").start();
//
//
//        while (myData.num == 0) {
//
//        }
//        System.out.println("mission is over");
    }
}
