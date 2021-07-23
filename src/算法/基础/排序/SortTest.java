package 算法.基础.排序;

import java.util.Arrays;

/**
 * @author Acui
 * @date 2021年06月29日 18:37
 */
public class SortTest {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("============排序前=================");
        System.out.println(Arrays.asList(nums));
//
//        System.out.println("============选择排序 Selection===============");
//        new Selection().sort(nums);
//        System.out.println(Arrays.asList(nums));

//        System.out.println("============冒泡排序 BubbleSort===============");
//        new BubbleSort().sort1(nums);
//        System.out.println(Arrays.asList(nums));

//        System.out.println("============插入排序 InsertionSort===============");
//        new Insertion().sort(nums);
//        System.out.println(Arrays.asList(nums));

//        System.out.println("============希尔排序 Shell===============");
//        new Shell().sort(nums);
//        System.out.println(Arrays.asList(nums));

//        System.out.println("============自上而下归并排序 ===============");
//        new Up2DownMerge().sort(nums);
//        System.out.println(Arrays.asList(nums));

//        System.out.println("============快速排序 ===============");
//        new QuickSort().sort(nums);
//        System.out.println(Arrays.asList(nums));

        System.out.println("============快速排序 ===============");
        new ThreeWayQuickSort().sort(nums);
        System.out.println(Arrays.asList(nums));



    }
}
