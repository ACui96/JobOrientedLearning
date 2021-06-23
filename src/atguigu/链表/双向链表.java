package atguigu.链表;

/**
 * @author Acui
 * @date 2021年05月12日 9:01
 * doubledLinkedList
 */
public class 双向链表 {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList{
    //初始化头节点，头节点不要动
    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }


}
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;// 指向下一个节点 默认为null
    public HeroNode2 pre; // 指向前一个节点 默认为null

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}