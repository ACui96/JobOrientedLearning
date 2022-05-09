package leetcode.editor.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acui
 * @date 2021年10月08日 20:16
 */
public class Zhishu {
    public static void main(String[] args) {
        System.out.println(new Solution1().countPrimes(1, 3));
        System.out.println(new Solution1().countPrimes(2, 3));
        System.out.println(new Solution1().countPrimes(1, 10));
        System.out.println(new Solution1().countPrimes(20, 30));
        System.out.println(new Solution1().countPrimes(1, 100));

        System.out.println(new Solution1().countPrimes(5, 8));
        System.out.println(new Solution1().countPrimes(10, 20));
        System.out.println(new Solution1().countPrimes(7, 10));

//        int i = 0;
//        int count = 0;
//        for (i = 20; i <= 30; i++) {
//            int j = 0;
//            int flag = 1;
//            //sqrt 是开平方函数 要引用math.h
//            for (j = 2; j <= Math.sqrt(i); j++) {
//                if (i % j == 0) {
//                    flag = 0;
//                    break;
//                }
//            }
//            if (flag) {
//                count++;
//                System.out.println(i);
//            }
//        }
//        printf("\n%d ", count);


    }

    static class Solution {
        public int countPrimes(int start, int n) {
            List<Integer> primes = new ArrayList<Integer>();
            int[] isPrime = new int[start];
            Arrays.fill(isPrime, 1);
            for (int i = start; i < n; ++i) {
                if (isPrime[i] == 1) {
                    primes.add(i);
                }
                for (int j = i; j < primes.size() && i * primes.get(j) < n; ++j) {
                    isPrime[i * primes.get(j)] = 0;
                    if (i % primes.get(j) == 0) {
                        break;
                    }
                }
            }
            return primes.size();
        }
    }
    static class Solution1 {
        public int countPrimes(int start, int n) {
            int ans = 0;
            for (int i = start; i <= n; ++i) {
                ans += isPrime(i) ? 1 : 0;
            }
            return ans;
        }

        public boolean isPrime(int x) {
            if (x == 1) return false;
            for (int i = 2; i * i <= x; ++i) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


}
