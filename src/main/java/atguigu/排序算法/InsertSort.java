package atguigu.排序算法;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Acui
 * @date 2021年05月13日 15:10
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};


        System.out.println("排序前 = " + Arrays.toString(arr));
        insertSort(arr);
        System.out.println("排序后 = " + Arrays.toString(arr));

//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1 = simpleDateFormat.format(date);
//        System.out.println("date1 = " + date1);
//        insertSort(arr);    //1s
//        String date2 = simpleDateFormat.format(new Date());
//        System.out.println("date2 = " + date2);
    }

    /**
     * 插入排序 
     * @author Acui
     * @date 2021/5/13 15:11
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && arr[insertIndex] > insertValue) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }
}
