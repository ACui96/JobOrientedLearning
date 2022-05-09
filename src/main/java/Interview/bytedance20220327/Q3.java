package Interview.bytedance20220327;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Acui
 * @date 2022年03月27日 19:38
 */
public class Q3 {



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();//存储所有魔法棒

        if (x % 2 == 0) {
            list.add(x / 2);
            list.add(x / 2);
        }else {
            list.add(x);
        }

        int longest = Collections.max(list);

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list.size(); j++) {
                list.set(j, list.get(j) + 1);
            }
            int evenLongest = Integer.MIN_VALUE;
            for (int v : list) {
                if (v % 2 == 0) {
                    evenLongest = Math.max(evenLongest, v);
                }
            }

            for (int j = 0; j < list.size(); j++) {
                int v = list.get(j);
                if (v == evenLongest) {
                    list.set(j, evenLongest / 2);
                    list.add(evenLongest / 2);
                    break;
                }
            }


        }
        int ret = Collections.max(list);
        System.out.println(ret);
    }

    class Solution {
        // x 初始长度  n 经过 n 秒
        public synchronized int solution(int x, int n) {

            List<Integer> list = new ArrayList<>();//存储所有魔法棒

            if (x % 2 == 0) {
                list.add(x / 2);
                list.add(x / 2);
            }else {
                list.add(x);
            }

            int longest = Collections.max(list);

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < list.size(); j++) {
                    list.set(j, list.get(j) + 1);
                }
                int evenLongest = Integer.MIN_VALUE;
                for (int v : list) {
                    if (v % 2 == 0) {
                        evenLongest = Math.max(evenLongest, v);
                    }
                }

                for (int j = 0; j < list.size(); j++) {
                    int v = list.get(j);
                    if (v == evenLongest) {
                        list.set(j, evenLongest / 2);
                        list.add(evenLongest / 2);
                        break;
                    }
                }


            }
            return Collections.max(list);
        }
    }
}
