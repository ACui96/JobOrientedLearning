//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 370 👎 0


package leetcode.editor.cn;

import ADataStructure.A2LinkedList.ListNode;

import java.util.ArrayDeque;
import java.util.Stack;

//Java：两数相加 II
public class P445_AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new P445_AddTwoNumbersIi ().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = valstack(l1);
            Stack<Integer> stack2 = valstack(l2);
            ListNode head = new ListNode(-1);
            int carry = 0;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
                int x = stack1.isEmpty() ? 0 : stack1.pop();
                int y = stack2.isEmpty() ? 0 : stack2.pop();
                int sum = x + y + carry;
                ListNode node = new ListNode(sum % 10);
                carry = sum / 10;
                //头插法新建链表
                node.next = head.next;
                head.next = node;
            }
            return head.next;
        }

        private Stack<Integer> valstack(ListNode l) {
            Stack<Integer> stack = new Stack<>();
            while (l != null) {
                stack.add(l.val);
                l = l.next;
            }
            return stack;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

