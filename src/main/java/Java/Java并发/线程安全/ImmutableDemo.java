package Java.Java并发.线程安全;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Acui
 * @date 2022年04月26日 15:54
 */
public class ImmutableDemo {

    private AtomicInteger cnt = new AtomicInteger();

    public void add() {
        cnt.incrementAndGet();
    }

    public static void main(String[] args) {
        HashMap<Object, Object> map = new HashMap<>();
        Map<Object, Object> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("a", 1);
    }
}
