package testApi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Acui
 * @date 2022年04月03日 20:02
 */
public class lambdaExpression {

    public static void main(String[] args) {
        lambdaFor();
    }


    static void lambdaFor() {
        List<String> strings = Arrays.asList("1", "2", "3");
        for (String s : strings) {
            System.out.println(s);
        }

        System.out.println("lambda");
        strings.forEach((s) -> System.out.println(s));

        System.out.println("System.out::println");
        strings.forEach(System.out::println);

        HashMap<Integer, String> map = new HashMap<>();
        map.forEach((k, v) -> System.out.println(v));

    }
}
