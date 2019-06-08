package queue;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Created By KL
 * Date: 2019/6/3
 * Time: 15:36
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.get();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.getHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }
}

class CircleArray {
    private int maxsize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrSize) {
        maxsize = arrSize;
        arr = new int[maxsize];
    }

    //队列空
    public boolean isEmpty() {
        return rear == front;
    }

    //队列满
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
    }

    //添加
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxsize;
    }

    //出队列
    public int get() {
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        int val = arr[front];
        front = (front + 1) % maxsize;
        return val;
    }

    /*//显示队列
    public void show() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxsize, arr[i % maxsize]);
        }
    }*/
    public void show() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        // 动脑筋
        for (int i = front; i < front + size() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxsize, arr[i % maxsize]);
        }
    }

    //队列长
    public int size() {
        return (rear + maxsize - front) % maxsize;
    }

    //头数据
    public int getHead() {
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
        }
        return arr[front];

    }
}
