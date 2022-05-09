package atguigu.链表;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Acui
 * @date 2021年05月11日 14:32
 */
public class Main {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero2);


        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);



        singleLinkedList.list();

        System.out.println("=============反转链表====================");
        reverse(singleLinkedList.getHead());
        singleLinkedList.list();
        System.out.println("=============从尾到头打印链表====================");
        reversePrint(singleLinkedList.getHead());
        System.out.println("=============从尾到头打印链表结束====================");
        int k = 1;
        System.out.printf("倒数第%d个节点是"+getKthNode(singleLinkedList.getHead(), k).toString()+"\n", k);
        System.out.println("=============修改后============");

        HeroNode luHeroNode = new HeroNode(2, "卢俊", "玉麒麟！！！");
        singleLinkedList.update(luHeroNode);

        singleLinkedList.list();

        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
        System.out.println("==============删除后=================");
        singleLinkedList.list();

        System.out.println(getLength(singleLinkedList.getHead()));//2
    }

    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 获取倒数第 k 个节点
     * @author Acui
     * @date 2021/5/11 15:45
     * @param head
     * @param k
     * @return atguigu.链表.HeroNode
     */
    public static HeroNode getKthNode(HeroNode head, int k) {
        HeroNode fast = head.next;
        HeroNode slow = head.next;

        for (int i = 0; i < k - 1; i++) {
            if (fast == null) {
                System.out.printf("倒数第 %d 个节点不存在\n",k);
                return null;
            }
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    /**
     * 反转单链表
     * @author Acui
     * @date 2021/5/11 16:06
     * @param head
     */
    public static void reverse(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return ;
        }
        HeroNode reverseHead = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;

        }
        head.next = reverseHead.next;
    }

    /**
     * 利用栈从尾到头打印单链表
     * @author Acui
     * @date 2021/5/11 16:07
     */
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().toString());
        }
    }

}



class SingleLinkedList {
    //初始化头节点，头节点不要动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 找到最后节点
     * 添加到最后
     * @author Acui
     * @date 2021/5/11 14:37
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                //找到链表的最后
                break;
            }
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false; //标志待添加的标号是否存在，默认为false
        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {

                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入\n",heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 根据 newHeroNode 的 no 来修改即可
     * @author Acui
     * @date 2021/5/11 14:58
     * @param newHeroNode
     */
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空~~~");
            return;
        }

        HeroNode temp = head.next;
//        boolean flag = false; //标志是否存在该节点
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                temp.nickname = newHeroNode.nickname;
                temp.name = newHeroNode.name;
                break;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("未找到该英雄~~~");
        }
    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空~~~");
        }
        HeroNode temp = head;
        while (temp.next != null) {
            if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("为找到该节点~~~");
        }
    }



    /**
     * 显示链表
     * @author Acui
     * @date 2021/5/11 14:39
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}
