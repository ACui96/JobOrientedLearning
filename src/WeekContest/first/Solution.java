package WeekContest.first;

public class Solution {

    public static void main(String[] args) {
        String s = "0010";
        int res = minOperations(s);
        System.out.println(res);
    }

    /**
     * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
     *
     * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
     *
     * 返回使 s 变成 交替字符串 所需的 最少 操作数。
     * @param s
     * @return
     */
    public static int minOperations(String s) {
        char[] c = s.toCharArray();
        int res = 0;
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = 1; j < c.length; j++) {
                if (c[i] == c[j]) {
                    if (c[j] == '0') {
                        c[j] = 1;
                        res += 1;
                    } else if (c[j] == '1') {
                        c[j] = 0;
                        res += 1;
                    } else {
                        continue;
                    }
                }
            }
        }
        return res;
    }
    /**
     * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 1e9 + 7 取余 后的结果。
     *
     * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
     *
     * 子字符串 是字符串中的一个连续字符序列。
     */
    public static int countHomogenous(String s) {

        return 0;
    }

}
