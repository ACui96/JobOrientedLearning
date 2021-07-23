package 算法.基础.排序;

import java.util.Arrays;

/**
 * @author Acui
 * @date 2021年06月29日 19:07
 */
public class Shell<T extends Comparable<T>> extends Sort<T>{

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
                System.out.println(Arrays.asList(nums));
            }
            h = h / 3;
        }
    }
}
