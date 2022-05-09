package Interview.alibaba20220415;

import java.util.*;
/**
 * @author Acui
 * @date 2022年04月15日 18:58
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] c = sc.next().toCharArray();
        Map<Character, String> map = new HashMap<>();
        map.put('2', "ABC");
        map.put('3', "DEF");
        map.put('4', "GHI");
        map.put('5', "JKL");
        map.put('6', "MNO");
        map.put('7', "PQRS");
        map.put('8', "TUV");
        map.put('9', "WXYZ");

        int begin = 0;
        while (begin < c.length && c[begin] == '1') {
            begin++;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char temp = map.get(c[begin]).charAt(0);


    }
}
