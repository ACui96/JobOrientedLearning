package 算法;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Acui
 * @date 2022年04月27日 11:02
 * // hash 表 + 双向链表 实现 LRU 缓存 最近最久未使用
 * put（k, v）： 没存过，1.新建节点 2.更新 map 3.插入头 4. 判断当前 size 是否超过 capacity ，超过则移除 尾节点
 *          存过， 1. 更新值  2.移到头节点
 * get（k）：不存在， 返回 -1
 *          存在，1.返回 v 2. 移到头节点
 */
public class LRUCache {
    class DLinkedNode{
        DLinkedNode prev, next;
        int key, val;

        public DLinkedNode() {

        }

        public DLinkedNode(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
    Map<Integer, DLinkedNode> map = new HashMap<>();
    DLinkedNode head, tail;
    int capacity, size;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public void put(int k, int v) {
        DLinkedNode node = map.get(k);
        if (node == null) {
            node = new DLinkedNode(k, v);
            map.put(k, node);
            addToHead(node);
            if (++size > capacity) {
                DLinkedNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.val = v;
            moveToHead(node);
        }
    }

    public int get(int k) {
        DLinkedNode node = map.get(k);
        if (node != null) {
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DLinkedNode removeTail() {
        DLinkedNode ret = tail.prev;
        removeNode(ret);
        return ret;
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(3));
        System.out.println(lRUCache.get(4));


    }
}


