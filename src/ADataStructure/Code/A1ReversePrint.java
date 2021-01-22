package ADataStructure.Code;

import ADataStructure.A2LinkedList.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @ClassName A0ReplaceSpace
 * @Description 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @Author acui
 * @Date 2021/1/21 17:43
 * @Version 1.0
 **/
public class A1ReversePrint {
    static ArrayList<Integer> tmp = new ArrayList<>();
    public static void main(String[] args) {
        // 实例化节点
        ListNode n1 = new ListNode(0);// 节点 head
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);

        // 构建引用指向
        n1.next = n2;
        n2.next = n3;

        //方法1： 递归  测试
        //int[] ints = reversePrint(n1);

        //方法2： 辅助栈 测试
        int[] ints = reversePrint1(n1);

        for (int i : ints) {
            System.out.println(i);
        }
    }

    //方法1： 递归
    public static int[] reversePrint(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = tmp.get(i);
        }
        return res;

    }

    public static void recur(ListNode h) {
        if(h == null) return;
        recur(h.next);
        tmp.add(h.val);
    }

    //方法2:辅助栈法
    public static int[] reversePrint1(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }
}
