package JUC;

import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Acui
 * @date 2022年04月11日 18:44
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();

        IntStream.range(0, 10).forEach(i -> new Thread(() -> {
            local.set(Thread.currentThread().getName() + ":" + i);
            System.out.println("线程：" + Thread.currentThread().getName() + ",local" + local.get());
        }).start());
    }
}

/**
 * @author Acui
 * @date 2022/4/11 19:10
 * ThreadLocal 使用场景 - 全局 Session 管理
 */
class AuthHolder {
    private static final ThreadLocal<Map<String, String>> loginThreadLocal = new ThreadLocal<>();

    public static void map(Map<String, String> map) {
        loginThreadLocal.set(map);
    }

    public static String userId() {
        return get("userId");
    }

    public static String get(String key) {
        Map<String, String> map = getMap();
        return map.get(key);
    }

    public static void clear() {
        loginThreadLocal.remove();
    }

    private static Map<String, String> getMap() {
        return loginThreadLocal.get();
    }
}

