package JavaBasic.Java容器;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Acui
 * @date 2021年06月23日 15:06
 */
public class ArrayListCode {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> synList = Collections.synchronizedList(list);


        List<String> list1 = new CopyOnWriteArrayList<>();
    }
}
