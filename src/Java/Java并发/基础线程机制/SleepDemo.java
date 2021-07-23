package Java.Java并发.基础线程机制;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Acui
 * @date 2021年06月29日 19:41
 */
class SleepDemo {

    public void run() {
        try {
            System.out.println("I'm falling sleep>>>>>>>>" + new Date());

            Thread.sleep(3000);



            System.out.println("Hello, I'm wake up>>>>>>>" + new Date());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("完成了最重要的事情，建议其它同优先级的线程执行任务！");
        Thread.yield();
    }

    public static void main(String[] args) {
        new SleepDemo().run();
    }

}

