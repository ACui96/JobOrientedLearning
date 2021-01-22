package ADataStructure.Code;

/**
 * @ClassName A0ReplaceSpace
 * @Description 剑指 Offer 05. 替换空格 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Author acui
 * @Date 2021/1/21 17:43
 * @Version 1.0
 **/
public class A0ReplaceSpace {
    public static void main(String[] args) {
        String s = "Wo ai ni !";
        s = replaceSpace(s);
        System.out.println(s);
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c :s.toCharArray() ) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
