package WeekContest.first228;

public class Solution {

    public static void main(String[] args) {
        String s = "0010";
        int res = minOperations(s);
        System.out.println(res);
        String s1 = "wwwwwwwwbbwwwwwwwwwwwww";
        int res1 = countHomogenous(s1);
        System.out.println(res1);
    }

    /**
     * 第一题
     * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
     *
     * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
     *
     * 返回使 s 变成 交替字符串 所需的 最少 操作数。
     * @param s
     * @return
     */

    public static int solve(String s, int f){
        char[] c =  s.toCharArray();
        int ans = 0, n = s.length();
        for(int i = 0; i < n; i++){
            int cur = c[i] - '0';
            if(cur != f){
                ++ans;
            }
            //异或，f是1则为0，f是0则为1
            f ^= 1;
        }
        return ans;
    }

    public static int minOperations(String s) {
        return Math.min(solve(s, 0), solve(s, 1));
    }

    /**
     * 第二题
     * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 1e9 + 7 取余 后的结果。
     *
     * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
     *
     * 子字符串 是字符串中的一个连续字符序列。
     */

    public static int countHomogenous(String s) {
        int len = s.length(), mod = (int) (1e9 + 7);
        int i = 0, j = 0;
        long count = 0;
        while (i < len) {
            char ch = s.charAt(i);
            while(j< len && s.charAt(j) == ch){
                j++;
            }
            long n = (long)(j - i);
            count += n * (n + 1) / 2;
            i = j;
        }
        int res = (int) (count % mod);
        return res;
    }

    /**
     * 第三题. 袋子里最少数目的球
     * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
     *
     * 你可以进行如下操作至多 maxOperations 次：
     *
     * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
     * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
     * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
     *
     * 请你返回进行上述操作后的最小开销。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [9], maxOperations = 2
     * 输出：3
     * 解释：
     * - 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
     * - 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
     * 装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
     * 示例 2：
     *
     * 输入：nums = [2,4,8,2], maxOperations = 4
     * 输出：2
     * 解释：
     * - 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
     * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
     * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
     * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
     * 装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
     * 示例 3：
     *
     * 输入：nums = [7,17], maxOperations = 2
     * 输出：7
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * 1 <= maxOperations, nums[i] <= 109
     */
    public static int minimumSize(int[] nums, int maxOperations) {
        return 0;
    }

}
