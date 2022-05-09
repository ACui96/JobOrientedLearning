package atguigu.排序算法;

import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Acui
 * @date 2021年05月13日 10:49
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1};
//        System.out.println("排序前 = " + Arrays.toString(arr));
//
//        selectSort(arr);
//        System.out.println("排序后 = " + Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = simpleDateFormat.format(date);
        System.out.println("date1 = " + date1);
        selectSort(arr);    //两秒
        String date2 = simpleDateFormat.format(new Date());
        System.out.println("date2 = " + date2);
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]){
                    minIndex = j;
                    min = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
//            System.out.printf("第 %d 轮之后 arr = " + Arrays.toString(arr) + "\n", i + 1);
        }


    }

}
