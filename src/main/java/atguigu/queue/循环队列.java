package atguigu.queue;

import java.util.Scanner;

/**
 * @author Acui
 * @date 2021年05月09日 21:34
 */
public class 循环队列 {
    public static void main(String[] args) {
        System.out.println("测试循环队列");
        CircleQueue queue = new CircleQueue(4);
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

class CircleQueue {
    //front 就是队列第一个元素
    //rear  指向队列最后一个元素的后一个位置   空出一个空间作为约定
    //(rear + 1) % maxsize == front     [满]
    //rear == front                     [空]
    //(rear + maxsize - front) % maxsize  为有效数据的个数

    private int front, rear;
    private int maxSize;
    private int[] arr;

    public CircleQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0; //front 就是队列第一个元素
        rear = 0;  //rear  指向队列最后一个元素的后一个位置   空出一个空间作为约定
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
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
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int temp = front;
        front = (front + 1) % maxSize;
        return arr[temp];

    }

    public void disp() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
