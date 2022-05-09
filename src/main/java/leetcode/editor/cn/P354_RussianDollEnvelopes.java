//给定一些标记了宽度和高度的信封，宽度和高度以整数对形式 (w, h) 出现。当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如
//同俄罗斯套娃一样。 
//
// 请计算最多能有多少个信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 说明: 
//不允许旋转信封。 
//
// 示例: 
//
// 输入: envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出: 3 
//解释: 最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
// 
// Related Topics 二分查找 动态规划 
// 👍 401 👎 0


package leetcode.editor.cn;

//俄罗斯套娃信封问题

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P354_RussianDollEnvelopes{
    //测试代码
    public static void main(String[] args) {
        Solution solution = new P354_RussianDollEnvelopes().new Solution();
        int[][] envelopes = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int ans = solution.maxEnvelopes(envelopes);
        System.out.println(ans);
    }
        
    //力扣代码
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;
            if(n == 0) {
                return 0;
            }
            Arrays.sort(envelopes, (e1, e2) ->{
                if(e1[0] == e2[0]) return e2[1] - e1[1];
                return e1[0] - e2[0];
            });

            List<Integer> f = new ArrayList<>();
            f.add(envelopes[0][1]);
            for(int i = 1; i < n; i++) {
                int num = envelopes[i][1];
                if(num > f.get(f.size() - 1)) {
                    f.add(num);
                }else {
                    int index = binarySearch(f, num);
                    f.set(index, num);
                }
            }
            for (Integer i : f) {
                System.out.println(i);
            }
            return f.size();
        }

        public int binarySearch(List<Integer> f, int num) {
            int left = 0, right = f.size() - 1;
            while(left < right) {
                int mid = left + (right - left) / 2;
                if(f.get(mid) < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}