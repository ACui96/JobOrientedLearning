package testApi;

import java.util.*;

/**
 * @author Acui
 * @date 2021年07月27日 16:01
 */
public class GenerateSquares {
    public static void main(String[] args) {
////        System.out.println(Integer.highestOneBit(2));
//        String a = "abc";
//        String b = "abcd";
//        System.out.println(Integer.valueOf(a) ^ Integer.valueOf(b));
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        System.out.println(list.remove(0));


        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(1, 2);
//        map.put(null, 1);
//        map.put(null, 2);

        System.out.println(map.get(1));
        System.out.println(map.get(null));
    }
}
