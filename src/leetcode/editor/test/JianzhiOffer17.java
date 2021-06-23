package leetcode.editor.test;

/**
 * @author Acui
 * @date 2021年06月09日 20:34
 * 大数问题
 */
public class JianzhiOffer17 {
    public static void main(String[] args) {
        int n = 3;
//        solution solution = new JianzhiOffer17().new solution();
//        System.out.println(solution.printNumbers(n));
//        System.out.println(Integer.parseInt("001"));


        Solution1 solution1 = new JianzhiOffer17().new Solution1();
        int[] numbers = solution1.printNumbers(n);



    }

    class solution{
        StringBuilder res;
        int count = 0, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public String printNumbers(int n) {
            //全排列  先固定高位，在递归固定地位
            this.n = n;
            res = new StringBuilder(); //数字字符串集
            num = new char[n];
            dfs(0);
            res.deleteCharAt(res.length() - 1);
            return res.toString();
        }

        private void dfs(int x) {
            if (x == n) {
                res.append(String.valueOf(num) + ',');
                return;
            }
            for (char i : loop) {
                num[x] = i;
                dfs(x + 1);
            }

        }
    }

    class Solution1 {
        char[] num;
        int[] ans;
        int count = 0, n;
        public int[] printNumbers(int n) {
            this.n = n;
            num = new char[n];
            ans = new int[(int) (Math.pow(10, n) - 1)];
            dfs(0);
            return ans;
        }
        private void dfs(int n) {
            if (n == this.n) {
                String tmp = String.valueOf(num);
                int curNum = Integer.parseInt(tmp);
                if (curNum != 0) {
                    ans[count++] = curNum;
                }
                return;
            }
            for (char i = '0'; i <= '9'; i++) {
                num[n] = i;
                dfs(n + 1);
            }
        }
    }
}

