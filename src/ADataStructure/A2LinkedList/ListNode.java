package ADataStructure.A2LinkedList;

/**
 * @ClassName ListNode
 * @Description TODO
 * @Author acui
 * @Date 2021/1/21 17:12
 * @Version 1.0
 **/
public class ListNode {
    public int val;        //节点值
    public ListNode next;  //后续节点引用

    public ListNode() {

    }

    public ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
