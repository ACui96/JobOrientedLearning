//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 100 👎 0


package leetcode.editor.cn;

//从尾到头打印链表

import ADataStructure.A2LinkedList.ListNode;

import java.util.LinkedList;

public class CongWeiDaoTouDaYinLianBiaoLcof{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();

    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while(head != null){
            stack.addLast(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for(int i = 0; i < stack.size(); i++){
            ans[i] = stack.removeLast();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}