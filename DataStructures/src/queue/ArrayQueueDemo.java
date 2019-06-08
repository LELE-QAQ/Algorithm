package queue;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Description:
 * Created By KL
 * Date: 2019/6/3
 * Time: 14:44
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop)

        {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.show();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.get();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.getHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
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


class ArrayQueue {
    private int front;
    private int rear;
    private int maxsize;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxsize = arrMaxSize;
        arr = new int[maxsize];
        front = -1;
        rear = -1;
    }

    //判断空
    public boolean isEmpty() {
        return rear == front;
    }

    //判断满
    public boolean isFull() {
        return rear == front - 1;
    }

    //添加
    public void add(int n) {
        if (isFull()) {
            System.out.println("队列满.....");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    /*//出队列
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        front++;
        return arr[front];
    }*/
    public int get() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++; // front后移
        return arr[front];

    }

    //显示队列
    public void show() {
        if (isEmpty()) {
            System.out.println("队列空。。。");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);

        }
    }

    //显示头数据
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }


}
