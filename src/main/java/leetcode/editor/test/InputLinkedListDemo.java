package leetcode.editor.test;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Acui
 * @date 2022年03月10日 14:58
 */
public class InputLinkedListDemo {
    // 先定义节点类
    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //输入是一串数字，请将其转换成单链表格式之后，再进行操作
        //输入描述:
        //一串数字，用逗号分隔
        //输入
        //1,2,3,4,5
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toString();
        //
        String[] arr = str.split(",");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        Stack<LinkedNode> stack = new Stack<>();
        LinkedNode head = new LinkedNode(0);
        LinkedNode p = head;
        for (int i = 0; i < arr.length; i++) {
            p.next = new LinkedNode(nums[i]);
            p = p.next;
            stack.add(p);
        }
        head = head.next;
        //
        p = head;
        LinkedNode q = stack.peek();
        while ((!p.equals(q)) && (!p.equals(q))) {
            q = stack.pop();
            q.next = p.next;
        }
    }
}
