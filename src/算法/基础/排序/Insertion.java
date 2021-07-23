package 算法.基础.排序;

import java.util.Arrays;

/**
 * @author Acui
 * @date 2021年06月29日 18:53
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
            System.out.println(Arrays.asList(nums));
        }
    }
}
