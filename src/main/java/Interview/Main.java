package Interview;

import java.util.Scanner;


class Solution {
    public boolean func(int[] arr) {

        return false;
    }
}
/**
 * @author Acui
 * @date 2022年04月08日 16:55
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(char2Index('a'));
//        System.out.println(char2Index('b'));
//        System.out.println(char2Index('c'));
//        System.out.println(char2Index('x'));
//        System.out.println(char2Index('y'));
//        System.out.println(char2Index('z'));
//
//        System.out.println(index2Char(1));
//        System.out.println(index2Char(2));
//        System.out.println(index2Char(3));
//        System.out.println(index2Char(24));
//        System.out.println(index2Char(25));
//        System.out.println(index2Char(26));
        char a = '6';
        int b = a - '0';
        System.out.println(b);
//        char c = (char)(b+'0');
        char c = (char)(b+'0');
        System.out.println(c);
    }

    private static char index2Char(int num) {
        return (char) (num + '0');
    }

    private static int char2Index(char c) {
        return c - 'a';
    }
}
