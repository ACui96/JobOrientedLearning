package Java.Java基础.Object通用方法;

import java.util.HashSet;

/**
 * @author Acui
 * @date 2021年06月18日 10:27
 */
public class EqualsExample {
    private int x;
    private int y;
    private int z;

    public EqualsExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualsExample that =  (EqualsExample) o;

        if (x != that.x) return false;
        if (y != this.y) return false;
        return z == that.z;
    }

    /*
     * 理想的哈希函数应当具有均匀性，即不相等的对象应当均匀分布到所有可能的哈希值上。
     * 这就要求了哈希函数要把所有域的值都考虑进来。
     * 可以将每个域都当成 R 进制的某一位，然后组成一个 R 进制的整数。
     *
     * R 一般取 31，因为它是一个奇素数，如果是偶数的话，当出现乘法溢出，信息就会丢失，因为与 2 相乘相当于向左移一位，最左边的位丢失。
     * 并且一个数与 31 相乘可以转换成移位和减法：31*x == (x<<5)-x，编译器会自动进行这个优化。
     * @author Acui
     * @date 2021/6/18 10:35
     * @return int
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public static void main(String[] args) {
        //下面的代码中，新建了两个等价的对象，并将它们添加到 HashSet 中。
        // 我们希望将这两个对象当成一样的，只在集合中添加一个对象。
        // 但是 EqualExample 没有实现 hashCode() 方法，
        // 因此这两个对象的哈希值是不同的，最终导致集合添加了两个等价的对象。
        EqualsExample e1 = new EqualsExample(1, 1, 1);
        EqualsExample e2 = new EqualsExample(1, 1, 1);
        System.out.println(e1.equals(e2));
        HashSet<EqualsExample> set = new HashSet<>();
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());
        System.out.println(((17*31+1)*31+1)*31+1);
        set.add(e1);
        set.add(e2);
        System.out.println(set.size());
    }
}
