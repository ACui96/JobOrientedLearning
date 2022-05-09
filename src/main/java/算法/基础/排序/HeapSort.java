package 算法.基础.排序;

import java.util.Arrays;

/**
 * 把最大元素和当前堆中数组的最后一个元素交换位置，并且不删除它，
 * 那么就可以得到一个从尾到头的递减序列，从正向来看就是一个递增序列，这就是堆排序。
 *
 * #5.1 构建堆
 * 无序数组建立堆最直接的方法是从左到右遍历数组进行上浮操作。
 * 一个更高效的方法是从右至左进行下沉操作，如果一个节点的两个节点都已经是堆有序，
 * 那么进行下沉操作可以使得这个节点为根节点的堆有序。
 * 叶子节点不需要进行下沉操作，可以忽略叶子节点的元素，因此只需要遍历一半的元素即可。
 * @author Acui
 * @date 2022年04月14日 16:30
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T>{
    /**
     * 数组第 0 个位置不能有元素
     * @author Acui
     * @date 2022/4/14 16:31
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }
        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }

    public static void main(String[] args) {
        Integer[] nums = new ArrayExample().nums;
        new HeapSort<Integer>().sort(nums);
        System.out.println("Arrays.asList(nums) = " + Arrays.asList(nums));
    }
}
