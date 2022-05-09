package Interview.leihuo20220423;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int M = sc.nextInt();
//        int Hp = sc.nextInt();
//        int LowerHp = sc.nextInt();
//        int UpperHp = sc.nextInt();
//        int N = sc.nextInt();
//        int[][] D = new int[M][N];
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                D[i][j] = sc.nextInt();
//            }
//        }
//        for (int i = 0; i < D.length; i++) {
//            System.out.println(minHit(Hp, LowerHp, UpperHp, D[i]));
//        }
        String s = "abcabc";
        int c = s.indexOf('c', 2);
        System.out.println(c);


    }

    private static int minHit(int hp, int lowerHp, int upperHp, int[] D) {
        if (hp < lowerHp || hp - lowerHp < D[0]) return 0;
        //贪心  先用大技能打
        int min = 0;
        int maxDIdx = D.length - 1;
        while (!isXuruo(hp,lowerHp,upperHp)){
            if(maxDIdx < 0) {
                return 0;
            }
            int d = D[maxDIdx];
            if (hp - d >= lowerHp) {
                hp = hp - d;
                min++;
            }else {

                maxDIdx--;
            }
        }
        return min;
    }

    private static boolean isXuruo(int hp, int lowerHp, int upperHp) {
        return hp >= lowerHp && hp <= upperHp;
    }


}
