package testApi;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        String str = "qywyery23tdd";
        String str = "have you ever go shopping and";
        Map<Character, Integer> cache = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (c == ' ') continue;
            cache.put(c, cache.getOrDefault(c, 0) + 1);
            if (cache.get(c) == 3) {
                System.out.println(c);
                break;
            }

        }
    }

    private static void func() {

    }
}
