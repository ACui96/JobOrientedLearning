package Algs4.Basic;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayDeque;
import java.util.Calendar;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        double ret = solution("(1+((2+3)*(4*5)))");
        System.out.println(ret);
    }

    public static double solution(String s) {
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Double> vals = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
//            System.out.println("jinlaile");
            System.out.println(c);
            switch (c) {
                case '(':;
                case '+': ops.push(c);
                    break;
                case '-':ops.push(c);
                    break;
                case '*':ops.push(c);
                    break;
                case '/':ops.push(c);
                    break;
                case ')':
                    double v = vals.pop();
                    System.out.println(v);
                    Character op = ops.pop();
                    if(op.equals('+')) v = vals.pop() + v;
                    else if(op.equals('-')) v = vals.pop() - v;
                    else if(op.equals('*')) v = vals.pop() * v;
                    else if(op.equals('/')) v = vals.pop() / v;
                    break;
                default:
                    vals.push(Double.parseDouble(String.valueOf(c)));
            }
            i++;
        }
        return vals.pop();
    }
}
