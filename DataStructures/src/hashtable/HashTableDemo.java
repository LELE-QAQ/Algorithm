package hashtable;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:哈希表
 * Created By KL
 * Date: 2019/6/24
 * Time: 19:24
 */

public class HashTableDemo {

    public static void main(String[] args) {
        //创建哈希表
        HashTable hashTab = new HashTable(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.find(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }

}


class HashTable {
    private EmpLinkedList[] empLinkedArray;
    private int size;

    public HashTable(int size) {
        this.size = size;
        empLinkedArray = new EmpLinkedList[size];

        //初始化每条链表，否则会抛空指针
        for (int i = 0; i < size; i++) {
            empLinkedArray[i] = new EmpLinkedList();
        }
    }

    //散列函数
    public int hash(int id) {
        return id % size;
    }
    //添加

    public void add(Emp emp) {
        int no = hash(emp.id);
        empLinkedArray[no].add(emp);
    }

    //遍历
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedArray[i].list(i);
        }
    }

    //查找
    public void find(int id) {
        int no = hash(id);
        Emp emp = empLinkedArray[no].findEmpById(id);
        if (emp != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (no + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }


}

class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class EmpLinkedList {

    private Emp head;

    //添加雇员
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = emp;
    }

    //遍历链表
    public void list(int no) {
        if (head == null) {
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        System.out.print("第 " + (no + 1) + " 链表的信息为");
        Emp temp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", temp.id, temp.name);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        System.out.println();
    }

    //查找
    public Emp findEmpById(int no) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp temp = head;
        while (true) {
            if (temp.id == no) {
                break;
            }
            if (temp.next == null) {
                temp = null;
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

}
