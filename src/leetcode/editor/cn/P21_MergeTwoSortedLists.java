//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1674 👎 0


package leetcode.editor.cn;

import ADataStructure.A2LinkedList.ListNode;

//Java：合并两个有序链表
public class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new P21_MergeTwoSortedLists ().new Solution();
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
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //标签：链表、递归
            //这道题可以使用递归实现，新链表也不需要构造新节点，我们下面列举递归三个要素
            //终止条件：两条链表分别名为 l1 和 l2，当 l1 为空或 l2 为空时结束
            //返回值：每一层调用都返回排序好的链表头
            //本级递归内容：如果 l1 的 val 值更小，则将 l1.next 与排序好的链表头相接，l2 同理
            //O(m+n)，m 为 l1的长度，n 为 l2 的长度
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

