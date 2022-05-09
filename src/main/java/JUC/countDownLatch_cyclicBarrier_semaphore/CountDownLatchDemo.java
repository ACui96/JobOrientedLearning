package JUC.countDownLatch_cyclicBarrier_semaphore;

import JUC.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author Acui
 * @date 2021年09月21日 15:57
 *
 * CountdownLatch 倒计时门闩
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws Exception{

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t 国被灭！");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦国一统！");


        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getRetCode());
        System.out.println(CountryEnum.ONE.getRetMessage());

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t bye bye~， 同学上完自习，离开教室");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();

        System.out.println(Thread.currentThread().getName() + "\t *******bye bye, 班长锁门");



    }


}
