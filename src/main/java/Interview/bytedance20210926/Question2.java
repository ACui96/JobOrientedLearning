package Interview.bytedance20210926;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acui
 * @date 2021年09月26日 19:31
 * 链表 value 为 k 最小交换次数
 */
public class Question2 {


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,3,7,3,4,3,9,3};
        int i = find(array,3);
        System.out.println(i);
    }

    public static int find(int[] array , int k){
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0 ; i < array.length ; i++){
            if(array[i] == k){
                tmp.add(i);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i < tmp.size() ; i++){
            if(tmp.get(i) - tmp.get(i-1) < min){
                min = tmp.get(i) - tmp.get(i-1);
            }
        }
        min -= 1;
        int num = tmp.size();
        num -= 2;
        num -= min;
        return min + num;
    }
}
