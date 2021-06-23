package Algs4.Sorting;

import java.util.*;

/**
 * @author Acui
 * @date 2021年05月14日 9:03
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private int partition(T[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        T v = nums[lo];
        while (true) {
            while (less(nums[++i], v) && i != hi) ;
            while (less(v, nums[--j]) && j != lo) ;
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, i, j);
        return j;
    }

    private void shuffle(Comparable[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

}
