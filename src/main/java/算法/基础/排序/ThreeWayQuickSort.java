package 算法.基础.排序;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Acui
 * @date 2021年07月01日 10:25
 *
 * 快排优化
 * 对于有大量重复元素的数组，可以将数组切分为三部分，分别对应小于、等于和大于切分元素。
 *
 * 三向切分快速排序对于有大量重复元素的随机数组可以在线性时间内完成排序。
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T>{

//    @Override
    protected void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    protected void sort1(T[] nums, int l, int h) {
        if (l >= h) return;
        int lt = l, i = l + 1, ht = h;
        T v = nums[l];
        while (i <= ht) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, ht--);
            } else {
                i++;
            }
        }
        sort1(nums, l, lt - 1);
        sort1(nums, ht + 1, h);
    }


    public static void main(String[] args) {
        ArrayExample example = new ArrayExample();
        Integer[] nums = example.nums;
//        new ThreeWayQuickSort<Integer>().sort1(nums, 0, nums.length);
        Arrays.sort(nums);
        System.out.println(Arrays.asList(nums));
    }



}
