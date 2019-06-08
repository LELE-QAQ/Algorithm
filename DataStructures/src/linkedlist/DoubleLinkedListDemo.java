package linkedlist;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Created By KL
 * Date: 2019/6/5
 * Time: 9:05
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        // 先创建节点
        List hero1 = new List(1, "宋江");
        List hero2 = new List(2, "卢俊义");
        List hero3 = new List(3, "吴用");
        List hero4 = new List(4, "林冲");
        // 创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();
        System.out.println();
        doubleLinkedList.del(2);
        doubleLinkedList.list();
    }
}


class DoubleLinkedList {

    private List head = new List(0, "");

    //添加
    public void add(List node) {
        List temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
    }

    //删除
    public void del(int no) {
        if (head.next == null) {
            System.out.println("链表为空。。。。。");
            return;
        }
        List temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;

            //最后一个节点不用执行，否则抛空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        }
    }

    //遍历
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        List temp = head.next;
        while (true) {
            // 判断是否到链表最后
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将temp后移， 一定小心
            temp = temp.next;
        }
    }
}

class List {
    public int no;
    public String name;
    public List pre;
    public List next;

    public List(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "List{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}