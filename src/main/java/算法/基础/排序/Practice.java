package 算法.基础.排序;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Acui
 * @date 2022年04月14日 14:35
 */
public class Practice<T extends Comparable<T>> extends Sort<T>{


    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (l >= h) return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h);
            while (less(v, nums[--j]) && j != l);
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();
        System.out.println("Arrays.asList(example.nums) = " + Arrays.asList(example.nums));
        new Practice<Integer>().sort(example.nums);
        System.out.println("Arrays.asList(example.nums) = " + Arrays.asList(example.nums));
    }
}
