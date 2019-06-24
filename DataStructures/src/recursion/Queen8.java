package recursion;

/**
 * Created with IntelliJ IDEA
 * Description:八皇后问题
 * Created By KL
 * Date: 2019/6/24
 * Time: 10:52
 */
public class Queen8 {
    private int max = 8;
    private int[] array = new int[max];
    static int count;
    static int judgeCount;
    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("一共有%d解法",count);
        System.out.println(judgeCount);
    }

    //放置棋子
    public void check(int n){
        if(n == max){
            print();
            return;
        }
        //把当前棋子n放在本行第一个位置
        for(int i=0;i<max;i++){
            array[n] = i;
            if(judge(n)){
                check(n+1);
            }
        }
    }



    //判断是否冲突
    public boolean judge(int n) {
        judgeCount++;
        //如果array[n] == array[i]，在同一行
        //如果Math.abs(array[n-i]) == Math.abs(array[n]-array[i]，在同一列
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] ||
                    Math.abs(n-i) == Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //打印解法
    public void print(){
        count++;
        for (int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
