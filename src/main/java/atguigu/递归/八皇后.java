package atguigu.递归;

/**
 * @author Acui
 * @date 2021年05月13日 8:25
 */
public class 八皇后 {
    final int max = 8;
    int[] array = new int[max];

    static int count = 0, jud = 0;
    public static void main(String[] args) {
        //测试

        八皇后 八皇后 = new 八皇后();
        八皇后.check(0);
        System.out.println("解法count = " + count);
        System.out.println("判断冲突函数执行次数 jud = " + jud);
    }

    /**
     * 放置第 n 个皇后
     * note：check 是每一次递归都有一个 for 循环
     * @author Acui
     * @date 2021/5/13 8:56
     * @param n
     */
    private void check(int n) {
        if (n == max) { // n == 8, 8 个皇后已经放好了
            print();
            return;
        }
        //依次放入
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n 放到第一列
            array[n] = i;
            //判断冲突
            if (judge(n)) {//不冲突
                check(n + 1);
            }
            //若冲突，继续执行 （放到下一列）
        }
    }

    /**
     * 当放置第 n 个皇后时，检测该皇后是否与其他皇后冲突
     * @author Acui
     * @date 2021/5/13 8:54
     * @param n 第 n 个皇后
     * @return boolean
     */
    private boolean judge(int n) {
        jud++;
        for (int i = 0; i < n; i++) {
            //同一列 、 同一斜线
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
