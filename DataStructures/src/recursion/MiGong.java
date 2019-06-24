package recursion;

/**
 * Created with IntelliJ IDEA
 * Description:走迷宫
 * Created By KL
 * Date: 2019/6/5
 * Time: 9:42
 */
public class MiGong {
    public static void main(String[] args) {
        int map[][] = new int[8][8];

        for (int i = 0; i < 8; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
            map[i][0] = 1;
            map[i][7] = 1;
        }

        map[3][3] = 1;
        map[4][4] = 1;
        map[5][5] = 1;
        map[3][6] = 1;
        map[3][7] = 1;
        map[2][6] = 1;
        map[4][7] = 1;
        map[5][7] = 1;


        for (int[] ints : map) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println("*********************");
        for (int[] ints : map) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }

    public static boolean setWay(int map[][], int i, int j) {
        if (map[6][6] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                //向上走
                if (setWay(map, i - 1, j)) {
                    //System.out.print("向上走  ");
                    return true;
                }
                //向右走
                if (setWay(map, i, j + 1)) {
                    //System.out.print("向右走  ");
                    return true;
                }
                //向下走
                if (setWay(map, i + 1, j)) {
                    //System.out.print("向下走  ");
                    return true;
                }
                //向左走
                if (setWay(map, i, j - 1)) {
                    //System.out.print("向左走  ");
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            }
        }
        return false;
    }


}
