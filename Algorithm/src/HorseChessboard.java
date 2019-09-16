import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA
 * Description:骑士周游问题
 * Created By KL
 * Date: 2019/9/16
 * Time: 15:08
 */
public class HorseChessboard {

    private static int X;   //棋盘列数
    private static int Y;   //棋盘行数
    private static boolean visited[];   //记录位置是否被访问过
    private static boolean finished;    //判断任务是否完成

    public static void main(String[] args) {
        X = 8;
        Y = 8;
        int row = 1;
        int column = 1;
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X * Y];
        traversalChessboard(chessboard, row - 1, column - 1, 1);
        for (int[] ints : chessboard) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }


    /**
     * 根据当前位置cp，计算出还能走的位置p1，并将位置加入一个集合
     *
     * @param cp
     * @return
     */
    private static ArrayList<Point> next(Point cp) {
        ArrayList<Point> points = new ArrayList<>();
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if ((p1.x = cp.x - 2) >= 0 && (p1.y = cp.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        //判断马儿可以走6这个位置
        if ((p1.x = cp.x - 1) >= 0 && (p1.y = cp.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = cp.x + 1) < X && (p1.y = cp.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = cp.x + 2) < X && (p1.y = cp.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = cp.x + 2) < X && (p1.y = cp.y + 1) < Y) {
            points.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = cp.x + 1) < X && (p1.y = cp.y + 2) < Y) {
            points.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = cp.x - 1) >= 0 && (p1.y = cp.y + 2) < Y) {
            points.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = cp.x - 2) >= 0 && (p1.y = cp.y + 1) < Y) {
            points.add(new Point(p1));
        }
        return points;
    }


    /**
     * 算法
     *
     * @param chessboard
     * @param row        所在行->p.y
     * @param column     所在列->p.x
     * @param step       第几步，初始为1
     */
    private static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;  ///将当前位置设为第几步
        visited[row * X + column] = true;  //将当前位置设为已访问
        ArrayList<Point> next = next(new Point(column, row));  //得到下一步所能走的位置集合

        sort(next);

        while (!next.isEmpty()) {
            Point p = next.remove(0); //取出集合的第一个位置
            if (!visited[p.y * X + p.x]) {    //如果该位置没有被访问过
                traversalChessboard(chessboard, p.y, p.x, step + 1);  //进行递归
            }
        }

        //判读是否已经完成任务
        //如果没有达到数量，则表示没有完成任务，将整个棋盘置0
        //说明: step < X * Y  成立的情况有两种
        //1. 棋盘到目前位置,仍然没有走完
        //2. 棋盘处于一个回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;     //棋盘置0
            visited[row * X + column] = false; //访问数组置0
        } else {
            finished = true;
        }
    }


    /**
     * 根据当前位置的所有下一位置进行非递减排序，减少回溯次数
     *
     * @param points
     */
    public static void sort(ArrayList<Point> points) {
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int c1 = next(o1).size();
                int c2 = next(o2).size();
                if (c1 < c2) {
                    return -1;
                } else if (c1 == c2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }
}
