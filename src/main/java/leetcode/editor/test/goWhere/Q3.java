package leetcode.editor.test.goWhere;

import edu.princeton.cs.algs4.In;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Acui
 * @date 2021年10月13日 16:19
 */
public class Q3 {

    public static Deque<Character> st1 = new LinkedList<>();
    public static Deque<Integer> st2 = new LinkedList<>();
    public static Deque<Integer> snum = new LinkedList<>();

    public static void main(String[] args) {
//        String s = "(+(*123)(/62)(-14))";
        String s = "(+2(*34)(-35))";

        char[] ss = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int num = 0;
            if (Character.isDigit(ss[i])) {
                int numsize=0;
                while (Character.isDigit(ss[i + numsize]) && i + numsize < len) {
                    numsize++;
                }
                int count = 0;
                for (int j = numsize; j > 0; j--) {
                    num += (int) ((ss[i + count] - '0') * Math.pow(10, j - 1));
                    count++;
                }
                st2.push(num);
                i+=numsize-1;

            } else if (ss[i] == '(') {
                st2.push(Integer.MAX_VALUE);
            } else if ((ss[i]=='+'||ss[i]=='-'||ss[i]=='*'||ss[i]=='/') && !st1.isEmpty()){
                st1.push(ss[i]);
            }else if (ss[i]==')' && !st1.isEmpty()) {
                char app = st1.peek();
                st1.pop();
                while (st2.peek() != Integer.MAX_VALUE) {
                    snum.push(st2.pop());
                }
                st2.pop();
                int sum = snum.pop();
                while (!snum.isEmpty()) {
                    if (app == '+') {
                        sum += snum.pop();
                    } else if (app == '-') {
                        sum -= snum.pop();
                    } else if (app == '*') {
                        sum *= snum.pop();
                    } else if (app == '/') {
                        sum /= snum.pop();
                    }
                }
                st2.push(sum);

            }

        }
        if (st1.isEmpty()) {
            System.out.println(st2.pop());
        }
    }


}
