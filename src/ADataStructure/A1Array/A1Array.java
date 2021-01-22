package ADataStructure.A1Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName A1Array
 * @Description TODO
 * @Author acui
 * @Date 2021/1/21 16:48
 * @Version 1.0
 **/
public class A1Array {
    public static void main(String[] args) {
        // 初始化一个长度为 5 的数组 array
        int[] array = new int[5];
        // 元素赋值
        array[0] = 2;
        array[1] = 3;
        array[2] = 1;
        array[3] = 0;
        array[4] = 2;

        // 在初始化时直接赋值
        int[] array1 = {2, 3, 1, 0, 2};

        // 初始化可变数组
        List<Integer> array2 = new ArrayList<>();

        // 向尾部添加元素
        array2.add(2);
        array2.add(3);
        array2.add(1);
        array2.add(0);
        array2.add(2);

        // 访问元素
        System.out.println("*****array2的第三个元素：" + array2.get(2));

        // 删除元素
        System.out.println("*****删除第三个元素之前：" + array2.get(2));
        for (Integer integer : array2) {
            System.out.println(integer);

        }
        array2.remove(2);
        System.out.println("*****删除第三个元素之后：" + array2.get(2));
        for (Integer integer : array2) {
            System.out.println(integer);
        }

    }
}
