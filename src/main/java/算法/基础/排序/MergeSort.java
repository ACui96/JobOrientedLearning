package 算法.基础.排序;

/**
 * @author Acui
 * @date 2021年06月29日 19:17
 * 归并方法将数组中两个已经排序的部分归并成一个。
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux; // 辅助数组

    protected void merge(T[] nums, int l, int m, int h) {
        int i = l, j = m + 1;
        for (int k = l; k <= h; k++) {
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[j++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (aux[i].compareTo(aux[j]) <= 0) {
                nums[k] = aux[i++]; // 先进行这一步，保证稳定性
            } else {
                nums[k] = aux[j++];
            }

        }
    }
}
