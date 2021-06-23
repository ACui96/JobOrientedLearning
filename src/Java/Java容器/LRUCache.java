package Java.Java容器;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Acui
 * @date 2021年06月23日 16:54
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache() {
        super(MAX_ENTRIES, 0.75f, true);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        cache.put(5, "e");
        System.out.println(cache.keySet());
        System.out.println(cache.values());
    }
}
