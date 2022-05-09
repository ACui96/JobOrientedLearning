package leetcode.editor.test.bytedance20211010;

import java.util.*;

/**
 * @author Acui
 * @date 2021年10月10日 10:13
 */
public class Q4 {
    public static void main(String[] args) {
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('b');
        list.add('e');
        list.add('A');
        list.add('T');
        Collections.sort(list);

        /*for (Character character : list) {
            System.out.println(character.compareTo('c'));
            System.out.println(character);
        }*/
        Character A = 'A';
        System.out.println(A.compareTo('a'));

        System.out.println('a' - 32);
    }
}
