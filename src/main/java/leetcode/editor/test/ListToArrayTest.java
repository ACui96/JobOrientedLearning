package leetcode.editor.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Acui
 * @date 2021年06月11日 15:36
 */
public class ListToArrayTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");

        String[] strings = list.toArray(new String[0]);
        String[] strings1 = list.toArray(new String[10]);

        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings1));

    }
}
