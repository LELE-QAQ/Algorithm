package linkedlist;

/**
 * Created with IntelliJ IDEA
 * Description:链表
 * Created By KL
 * Date: 2019/6/4
 * Time: 10:47
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        listNode hero1 = new listNode(1, "宋江");
        listNode hero2 = new listNode(2, "卢俊义");
        listNode hero3 = new listNode(3, "吴用");
        listNode hero4 = new listNode(4, "林冲");


        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        /*singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);*/

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);


        singleLinkedList.show();

        listNode del = singleLinkedList.del(2);
        System.out.println("删除的节点是:" + del);

        singleLinkedList.show();

        listNode hero5 = new listNode(4, "qwert");
        System.out.println();

        singleLinkedList.update(hero5);

        singleLinkedList.show();
    }
}

class listNode {
    public int no;
    public String name;
    public listNode next;

    public listNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "listNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}

class SingleLinkedList {
    private listNode head = new listNode(0, "");

    //添加
    public void add(listNode listNode) {
        listNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = listNode;
    }

    //按序添加
    public void addByOrder(listNode listNode) {
        listNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > listNode.no) {
                break;
            } else if (temp.next.no == listNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("要添加的节点已存在");
        } else {
            listNode.next = temp.next;
            temp.next = listNode;

        }
    }


    //删除
    public listNode del(int no) {
        listNode temp = head;
        listNode delNode = null;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            delNode = temp.next;
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在.....");
        }
        return delNode;
    }

    //更新
    public void update(listNode listNode) {
        listNode temp = head;
        boolean flag = false;
        if (head == null) {
            System.out.println("链表为空......");
            return;
        }
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == listNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = listNode.name;
        } else {
            System.out.println("要更新的节点不存在.....");
        }
    }

    //遍历
    public void show() {
        listNode temp = head.next;
        if (head == null) {
            System.out.println("链表为空......");
            return;
        }
        while (true) {

            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}
