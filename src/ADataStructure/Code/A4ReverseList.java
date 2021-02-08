package ADataStructure.Code;

import ADataStructure.A2LinkedList.ListNode;

import java.util.LinkedList;

/**
 * @ClassName A0ReplaceSpace
 * @Description 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author acui
 * @Date 2021/1/21 17:43
 * @Version 1.0
 **/
public class A4ReverseList {

    public static void main(String[] args) {
        // 实例化节点
        ListNode n1 = new ListNode(1);// 节点 head
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        // 构建引用指向
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        //测试方法1
        //ListNode n1Reverse = reverseList(n1);
        //测试方法2
        ListNode n1Reverse = reverseList2(n1);
        while (n1Reverse != null) {
            System.out.println(n1Reverse.val);
            n1Reverse=n1Reverse.next;
        }
    }
    //方法1：迭代(双指针)
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //方法2：递归
    public static ListNode reverseList2(ListNode head) {
        return recur(head, null);
    }

    private static ListNode recur(ListNode cur, ListNode pre) {
        if(cur==null) {
            return pre;
        }
        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }

}
