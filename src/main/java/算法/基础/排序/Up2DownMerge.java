package 算法.基础.排序;

import java.util.Arrays;

/**
 * @author Acui
 * @date 2021年06月29日 19:26
 * 自顶向下归并排序
 * 将一个大数组分成两个小数组去求解。
 *
 * 因为每次都将问题对半分成两个子问题，这种对半分的算法复杂度一般为 O(NlogN)。
 */
public class Up2DownMerge<T extends Comparable<T>> extends MergeSort<T>{
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int l, int h) {
        System.out.println("Arrays.asList(nums) = " + Arrays.asList(nums));
        System.out.println("l = " + l);
        System.out.println("h = " + h);
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;

        sort(nums, l, mid);
        sort(nums, mid + 1, h);
        merge(nums, l, mid, h);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 4, 6, 2, 7, 9, 3, 5};
        new Up2DownMerge<Integer>().sort(nums);
//        System.out.println("Arrays.asList(nums) = " + Arrays.asList(nums));

    }
}
