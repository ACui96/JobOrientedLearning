//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组 
// 👍 490 👎 0


package leetcode.editor.cn;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P118_PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118_PascalsTriangle ().new Solution();
        // TO TEST
        List<List<Integer>> ret = solution.generate(5);
        System.out.println("ret = " + ret);
    }
    //Java：杨辉三角
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<>();
            helper(ret, new ArrayList<Integer>(), numRows, 0);
            return ret;
        }

        private void helper(List<List<Integer>> ret, List<Integer> row, int numRows, int curRow) {
            if (curRow >= numRows) {
                return ;
            }
            List<Integer> nextRow = new ArrayList<>();
            for (int i = 0; i <= curRow; i++) {
                if (i == 0 || i == curRow) {
                    nextRow.add(1);
                } else {
                    nextRow.add(row.get(i - 1) + row.get(i));
                }
            }
            ret.add(new ArrayList<>(nextRow));
            helper(ret, nextRow, numRows, curRow + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

