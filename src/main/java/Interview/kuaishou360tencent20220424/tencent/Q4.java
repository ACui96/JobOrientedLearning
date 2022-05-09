package Interview.kuaishou360tencent20220424.tencent;


import ADataStructure.A2LinkedList.ListNode;

import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        cur.next = new ListNode(2);
        cur = cur.next;
        cur.next = new ListNode(3);
        cur = cur.next;
        cur.next = new ListNode(4);
        cur = cur.next;
        cur.next = head;

        String[] str = new String[4];
        for (int i = 0; i < 4; i++) {
            str[i] = String.valueOf(i + 1);
        }
        StringBuilder sb = new StringBuilder();
        String min = "";
        int start = 0;
//        for () {
////            sb.append()
//        }

    }

    private static void func() {

    }

}
