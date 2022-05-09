package ADataStructure.Code;

/**
 * @ClassName A2CQueueMain
 * @Description TODO
 * @Author acui
 * @Date 2021/1/21 18:58
 * @Version 1.0
 **/
public class A2CQueueMain {
    public static void main(String[] args) {
        A2CQueue obj = new A2CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }
}
