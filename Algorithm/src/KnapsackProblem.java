/**
 * Created with IntelliJ IDEA
 * Description:背包问题（动态规划）
 * Created By KL
 * Date: 2019/9/6
 * Time: 17:57
 */
public class KnapsackProblem {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品的重量
        int[] val = {1500, 3000, 2000}; //物品的价值 这里val[i] 就是前面讲的v[i]
        int m = 4; //背包的容量
        int n = val.length; //物品个数

        //v[i][j    ] 表示在前i个物品中能够装入容量为j的背包中的最大价值
        int v[][] = new int[n+1][m+1];

        int path[][] = new int[n+1][m+1];

        for(int i=1;i<v.length;i++){
            for(int j=0;j<v[0].length;j++){
                if(w[i-1] > j){ //当第i-1个物品的容量大于当前背包的容量时
                    v[i][j] = v[i-1][j]; //采取上一种方法
                }else{
                    if(v[i-1][j] < val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        for(int i=0;i<v.length;i++){
            for(int j=0;j<v[i].length;j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

        int i = path.length-1;
        int j =path[0].length-1;
        while (i>0 && j>0){
            if(path[i][j] == 1){
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i-1]; //w[i-1]
            }
            i--;
        }



    }


}
