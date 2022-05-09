package ADataStructure.Code;

import ADataStructure.A2LinkedList.NodeRandom;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/9p0yy1/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class A5CopyListRandom {
    public static void main(String[] args) {
        NodeRandom node1 = new NodeRandom(1);
        NodeRandom node2 = new NodeRandom(2);
        NodeRandom node3 = new NodeRandom(3);
        NodeRandom node4 = new NodeRandom(4);
        NodeRandom node5 = new NodeRandom(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        node1.random = null;
        node2.random = node3;
        node3.random = node5;
        node4.random = node2;
        node5.random = node1;

        NodeRandom head = solution(node1);

        NodeRandom head2 = solution2(node1);

//        NodeRandom cur = head;
        NodeRandom cur = head2;

        Map<Integer, NodeRandom> map = new HashMap<>();
        while (cur != null) {
            map.put(cur.val, cur.random);
            cur = cur.next;
        }

        for (Integer val : map.keySet()) {
            System.out.println(val);
        }
        for (NodeRandom nodeRandom : map.values()) {
            try {
                System.out.println(nodeRandom.val);
            } catch (NullPointerException e) {
                continue;
            }finally {
                System.out.println("null");
            }


        }

    }
    //法1：哈希表
    public static NodeRandom solution(NodeRandom head) {
        if (head == null) {
            return null;
        }
        NodeRandom cur = head;
        Map<NodeRandom, NodeRandom> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new NodeRandom(cur.getVal()));
            cur = cur.getNext();
        }
        cur = head;
        while (cur != null) {
            map.get(cur).setNext(map.get(cur.getNext()));
            map.get(cur).setRandom(map.get(cur.getRandom()));
            cur = cur.getNext();
        }
        return map.get(head);
    }

    //法2：拼接+拆分
    public static NodeRandom solution2(NodeRandom head) {
        if(head == null){
            return null;
        }
        //1.拼接链表
        NodeRandom cur = head;
        while(cur != null){
            NodeRandom tmp = new NodeRandom(cur.val);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = cur.next.next;
        }

        //2.给Random赋值
        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //3.拆分链表
        NodeRandom pre = head, res = head.next;
        cur = head.next;

        while(cur.next != null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;
    }

}
