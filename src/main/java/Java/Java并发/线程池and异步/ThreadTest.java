package Java.Java并发.线程池and异步;



import java.util.concurrent.*;

/**
 * @author Acui
 * @date 2022年04月12日 9:14
 */
public class ThreadTest {
    public static ExecutorService executor= Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("main.....start...");
        //1
//        CompletableFuture.runAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 2;
//            System.out.println("运行结果：" + i);
//        }, executor);
        //2
//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 0;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).whenComplete((t, u) -> {           //处理结果
//            System.out.println("异步任务成功完成了...结果是：" + t + ";异常是：" + u);
//        }).exceptionally(throwable ->{                  //感知异常
//            return 10;
//        });

//        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
//            System.out.println("当前线程：" + Thread.currentThread().getId());
//            int i = 10 / 0;
//            System.out.println("运行结果：" + i);
//            return i;
//        }, executor).handle((res, thr) ->{
//            if (null != res) return res * 2;
//            if (thr != null) return 0;
//            return 0;
//        });
        /**
         * 线程串行化
         * 1).thenRunAsync(() ->{
         *             System.out.println("任务2qidongle ");
         *         },executor) 无返回值
         * 2
         * thenAcceptAsync 能接受返回值
         * 3 thenApplyAsync
         * .thenApplyAsync(res -> {
         *             System.out.println(" thenApplyAsync启动了。拿到结果：" + res);
         *             return "Hello,thenApplyAsync()" + res;
         *         }, executor);
         * 接受上一步返回值  并有自己的返回值
         *
         */

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("当前线程：" + Thread.currentThread().getId());
            int i = 10 / 2;
            System.out.println("运行结果：" + i);
            return i;
        }, executor).thenApplyAsync(res -> {
            System.out.println(" thenApplyAsync启动了。拿到结果：" + res);
            return "Hello,thenApplyAsync()" + res;
        }, executor);
//        Integer integer = future.get();
        String ret = future.get();

        System.out.println("main.....end..." + ret);
    }
}
