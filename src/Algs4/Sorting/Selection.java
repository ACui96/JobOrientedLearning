package Algs4.Sorting;


public class Selection<T extends Comparable> extends Sort<T>{
    /**
     * 选择排序，从数组中挑选最小的元素与当前元素互换
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(nums[j], nums[i])) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}
