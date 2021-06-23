package atguigu.排序算法;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Acui
 * @date 2021年05月13日 10:02
 */
public class BubbleSorting {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println("排序前 = " + Arrays.toString(arr));
        //测试速度 O(n^2)  80000 个数据
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = simpleDateFormat.format(date);
        System.out.println("date1 = " + date1);
        bubbleSort(arr);//9s
        String date2 = simpleDateFormat.format(new Date());
        System.out.println("date2 = " + date2);

    }

    private static void bubbleSort(int[] arr) {
        int tmp = 0;
        boolean flag = false; //标志是否进行交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
//            System.out.printf("第 %d 趟之后的排序结果 = " + Arrays.toString(arr) + "\n", i + 1);
            if (!flag) {
                break; //没有发生交换
            } else {
                flag = false; //重置flag
            }
        }
    }
}
