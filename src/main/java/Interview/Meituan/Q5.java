package Interview.Meituan;




/**
 * @author Acui
 * @date 2022年04月09日 17:40
 */
public class Q5 {
    public static void main(String[] args) {
        String s1 = "15346";
        String s2 = "21534";
        String maxSubString = new Solution11().getMaxSubString(s1, s2);
        System.out.println(maxSubString);
    }
}

class Solution11 {
    public int longestCommonSubsequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 1; i <= M; ++i) {
            for (int j = 1; j <= N; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[M][N];
    }

    public String getMaxSubString(String s1, String s2) {
        String max, min;
        max = s1.length() > s2.length() ? s1 : s2;
        min = max == s1 ? s2 : s1;
        for (int x = 0; x < min.length(); x++) {
            for (int y = 0, z = min.length() - x; z != min.length() + 1; y++, z++) {
                String temp = min.substring(y, z);
                if (max.contains(temp)) {
                    return temp;
                }
            }
        }
        return "";
    }
}
