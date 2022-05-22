package 算法.基础.lambda表达式比较器;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Acui
 * @date 2022年05月25日 9:42
 */
@Slf4j
public class LambadaTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 10; i > 0; i --) {
            list.add(new Student("Student" + i, i + 20));
        }
        log.info("list.size() = {}", list.size());


        log.info("stuList before sort: {}", list.toString());

        // sort by age
        list.sort(((o1, o2) -> o1.age - o2.age));

        // sort by name
        list.sort(((o1, o2) -> o1.name.compareTo(o2.name)));


        log.info("stuList after sort: {}", list.toString());
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
