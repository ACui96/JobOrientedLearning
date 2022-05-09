package Java;

import java.util.concurrent.atomic.AtomicInteger;

class ShareData4 {
    AtomicInteger ai = new AtomicInteger(0);

    public synchronized void print1(){
        try {
            while (ai.get() != 0){
                this.wait();
            }
            System.out.println(Thread.currentThread().getName());
            ai.incrementAndGet();
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print2(){
        try {
            while (ai.get() != 1){
                this.wait();
            }
            System.out.println(Thread.currentThread().getName());
            ai.incrementAndGet();
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print3(){
        try {
            while (ai.get() != 2){
                this.wait();
            }
            System.out.println(Thread.currentThread().getName());
            ai.set(0);
            this.notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


public class lei {
    public static void main(String[] args) {
        ShareData4 data = new ShareData4();

        for (int j = 0; j < 5; j++) {
            new Thread(() -> {
                for (int i = 1; i <= 5; i++){
                    data.print1();
                }
            },"线程1").start();
            new Thread(() -> {
                for (int i = 1; i <= 5; i++){
                    data.print2();
                }
            },"线程2").start();
            new Thread(() -> {
                for (int i = 1; i <= 5; i++){
                    data.print3();
                }
            },"线程3").start();
        }

    }
}