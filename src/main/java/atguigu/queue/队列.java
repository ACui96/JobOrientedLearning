package atguigu.queue;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2021年05月09日 20:50
 */
public class 队列 {
    public static void main(String[] args) {
        //TO TEST
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("d(disp):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加元素到队列");
            System.out.println("g(pop):从队列取元素");
            System.out.println("p(peek):显示队列头的元素");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'd':
                    queue.disp();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int num = scanner.nextInt();
                    queue.push(num);
                    break;
                case 'g':
                    try {
                        int ret = queue.pop();
                        System.out.printf("取出的数据是%d\n", ret);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'p':
                    try {
                        int ret = queue.peek();
                        System.out.printf("队首的数据是%d\n", ret);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出。。。");
    }
}

class ArrayQueue {
    private int maxSize;
    private int front, rear;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头，指向队列头的前一个位置
        rear = -1;  //指向队列尾
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    public void push(int num) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[++rear] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[++front];
    }

    public void disp() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }
}
