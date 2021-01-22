package ADataStructure.A2LinkedList;

/**
 * @ClassName Main
 * @Description TODO
 * @Author acui
 * @Date 2021/1/21 17:14
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        // 实例化节点
        ListNode n1 = new ListNode(0);// 节点 head
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);

        // 构建引用指向
        n1.next = n2;
        n2.next = n3;
    }

}
