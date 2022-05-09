package testApi;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Acui
 * @date 2022年04月03日 20:13
 */

public class StreamTest {

    @Test
    public void test() {
        List<String> strings = Arrays.asList("abc", "def", "gkh", "abc");
        Stream<String> stringStream = strings.stream().filter(s -> "abc".equals(s));
        long count = stringStream.count();

        strings.stream().forEach(System.out::println);

        Stream<String> limit = strings.stream().limit(1);
        String[] strings1 = limit.toArray(String[]::new);
        Stream<String> map = strings.stream().map(s -> s + "22");
        strings.stream().sorted().forEach(System.out::println);

        List<String> collect = strings.stream().filter(s -> "abc".equals(s)).collect(Collectors.toList());
        String collect1 = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(","));

        List<Integer> number = Arrays.asList(1, 2, 5, 4);

        IntSummaryStatistics statistics = number.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 ： " + statistics.getMax());
        System.out.println("列表中最小的数 ： " + statistics.getMin());
        System.out.println("列表的平均数 ： " + statistics.getAverage());
        System.out.println("列表中元素数 ： " + statistics.getCount());
        System.out.println("列表中所有数之和 ： " + statistics.getSum());

        System.out.println("+++++++++++++++合并流+++++++++++++");
        List<String> strings2 = Arrays.asList("xyz", "jqx");
        long count1 = Stream.concat(strings2.stream(), strings.stream()).count();
        System.out.println(count1);
        Stream stream = strings.stream();
        stream.limit(2);
        try {
            stream.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            stream.limit(2).forEach(System.out::println);
        }

    }

    @Test
    // Stream 的延迟执行
    public void laziness() {
        List<String> strings = Arrays.asList("abc", "def", "gkh", "abc");
        Stream<String> stringStream = strings.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.out.println("Predicate.test 执行");
                return true;
            }
        });
        System.out.println("count 执行");
        System.out.println(stringStream.count());
    }

    @Test
    // parallelStreamTest  并行流测试
    public void parallelStreamTest() {
        List<Integer> list = Arrays.asList(1, 2, 5, 4);
        list.parallelStream().forEach(num -> System.out.println(Thread.currentThread().getName() + ">>" + num));
    }


}
