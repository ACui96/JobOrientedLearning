package atguigu.排序算法;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Acui
 * @date 2021年05月13日 15:49
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort(arr);
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = simpleDateFormat.format(date);
        System.out.println("date1 = " + date1);
//        shellSort(arr);    //交换 5s
        shellSort2(arr);    //移位式 1s内

        String date2 = simpleDateFormat.format(new Date());
        System.out.println("date2 = " + date2);

//        System.out.println("arr = " + Arrays.toString(arr));
    }

    /**
     * 希尔排序 改良的插入排序 缩小增量排序
     * @author Acui
     * @date 2021/5/13 15:51
     */
    public static void shellSort(int[] arr) {
        int temp;
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
//            System.out.println("希尔排序第 " + (++count) + " 轮后 arr = " + Arrays.toString(arr));
        }
    }

    public static void shellSort2(int[] arr){
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //退出即找到插入位置
                    arr[j] = temp;
                }
            }
        }
    }
}
