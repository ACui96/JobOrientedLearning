//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 排序 链表 
// 👍 1129 👎 0


package leetcode.editor.cn;

import ADataStructure.A2LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P148_SortList {
    public static void main(String[] args) {
        Solution solution = new P148_SortList ().new Solution();
        // TO TEST
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
    //Java：排序链表
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
        public ListNode sortList(ListNode head) {
            ListNode cur = head;
            List<Integer> list = new ArrayList<>();
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            Arrays.sort(arr);
            cur = head;
            for (int val : arr) {
                cur.val = val;
                cur = cur.next;
            }
            return head;
        }

        public ListNode sortList1(ListNode head) {

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

