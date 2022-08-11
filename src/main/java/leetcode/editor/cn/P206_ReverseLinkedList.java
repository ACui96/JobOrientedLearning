//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1696 👎 0


package leetcode.editor.cn;

import ADataStructure.A2LinkedList.ListNode;

//Java：反转链表
public class P206_ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new P206_ReverseLinkedList ().new Solution();
        // TO TEST
        ListNode someNode = new ListNode();


        ListNode head = someNode.build(new int[]{1, 2, 3, 4, 5});
        while (head != null) {
            System.out.println(head.val);
        }


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
        //递归
        public ListNode reverseList1(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode next = head.next;
            ListNode newHead = reverseList(next);
            next.next = head;
            head.next = null;
            return newHead;
        }
        //头插法
        public ListNode reverseList(ListNode head) {
            ListNode newHead = new ListNode(-1);
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead.next;
                newHead.next = head;
                head = next;
            }
            return newHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

