package testApi;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import static javafx.scene.input.KeyCode.L;


class Solution {
    @Test
    public void test() {

    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Integer a = 1;
//        Integer b = 1;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 1);
//        map.put(2, 1);

        String a = "tom";
        String b = "bom";

        Map<String, Integer> map = new HashMap<>();
        map.put(a, 1);
        map.put(b, 1);


//        System.out.println(a == b);
//        System.out.println(map.get(1)==map.get(2));
        System.out.println(map.get(a) == map.get(b));
    }

    public int[] maxSubArray(int @NotNull [] nums) {
        int sum = 0;
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum >= 0) {
                sum += nums[i];
                right = i;
            } else {
                sum = nums[i];
                left = i;
            }
        }
        int[] ret = new int[right - left + 1];
        for (int i = 0; i < right - left + 1; i++) {
            ret[i] = nums[i + left];
        }
        return ret;
    }

    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        if (c[0] == '0') return 0;
        int pre = 1, cur = 1;
        for (int i = 1; i < c.length; i++) {
            int tmp = cur;
            if (c[i] == '0') {
                if (c[i - 1] == '1' || c[i - 1] == '2') cur = pre;
                else return 0;
            } else if (c[i - 1] == '1' || (c[i - 1] == '2' && c[i] >= '1' && c[i] <= '6')){
                cur = cur + pre;
            }
            pre = tmp;
        }
        return cur;
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int ret = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] >= 0) {
                    if (tickets[k] == 0) break;
                    if (tickets[i] == 0) continue;
                    tickets[i]--;
                    ret++;
                }
            }
        }
        return ret;
    }
}