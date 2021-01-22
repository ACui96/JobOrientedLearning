package ADataStructure.A3Stack;

import java.util.Stack;

/**
 * @ClassName Main
 * @Description TODO
 * @Author acui
 * @Date 2021/1/21 17:19
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 元素 1 入栈
        stack.push(2); // 元素 2 入栈

        System.out.println("入栈之后");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println("先入后出");
        stack.pop();   // 出栈 -> 元素 2
        System.out.println("出栈 -> 元素 2 之后");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        stack.pop();   // 出栈 -> 元素 1
        System.out.println("出栈 -> 元素 1 之后");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }
}
