package leetcode.editor.test;

public class Main {
    /**
     * 125 100 多少种
     * @param args
     */
    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 50; j++) {
                for (int k = 0; k < 20; k++) {
                    if (i + j * 2 + k * 5 == 100) {
                        cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }



}
