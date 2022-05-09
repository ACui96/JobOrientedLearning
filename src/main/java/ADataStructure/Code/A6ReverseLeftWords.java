package ADataStructure.Code;

/**
 * @ClassName A0ReplaceSpace
 * @Description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 *
 * 作者：Krahets
 * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/589fz2/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Author acui
 * @Date 2021/1/21 17:43
 * @Version 1.0
 **/
public class A6ReverseLeftWords {

    public static void main(String[] args) {
        //测试
        String s = "abcdef";

//        String sr = solution1(s, 2);
//        String sr = solution2(s, 2);
        String sr = solution3(s, 2);


        System.out.println(sr);
    }

    /**
     * 方法一：字符串切片
     * @param s
     * @param n
     * @return
     */
    public static String solution1(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     * 方法二：列表遍历拼接
     * 若面试规定不允许使用 切片函数 ，则使用此方法。
     * @param s
     * @param n
     * @return
     */
    public static String solution2(String s, int n) {
        StringBuilder res = new StringBuilder();

//        for (int i = n; i < s.length(); i++) {
//            res.append(s.charAt(i));
//        }
//        for (int i = 0; i < n; i++) {
//            res.append(s.charAt(i));
//        }

        //利用求余运算简化代码
        for (int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }

    /**
     * 方法三：字符串遍历拼接
     * 若规定 Python 不能使用 join() 函数，或规定 Java 只能用 String ，则使用此方法。
     *
     * 此方法与 方法二 思路一致，区别是使用字符串代替列表。
     *
     * 作者：Krahets
     * 链接：https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58eckc/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param s
     * @param n
     * @return
     */
    public static String solution3(String s, int n) {
        String res = "";
        for (int i = n; i < n + s.length(); i++) {
            res += s.charAt(i % s.length());
        }
        return res;
    }


}
