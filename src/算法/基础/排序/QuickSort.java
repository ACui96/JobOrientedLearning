package 算法.基础.排序;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Acui
 * @date 2021年07月01日 10:00
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l)
            return ;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);

    }

    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;//h+1是因为
        T v = nums[l];
        while (true) {
            while(less(nums[++i], v) && i != h);
            while(less(v, nums[--j]) && j != l);
            if (i >= j)
                break;
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

    // 利用快速排序的 partition 来找数组中第 k 大的数
    public T select(T[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (h > l) {
            int j = partition(nums, l, h);
            if (j == k) {
                return nums[k];
            } else if (j > k) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }

    public static void main(String[] args) {
        Integer nums[] = new Integer[]{2,5,7,8,8};
        Comparable ret = new QuickSort().select(nums, 3);
        System.out.println(ret);
    }
}
