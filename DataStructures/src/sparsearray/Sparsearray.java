package sparsearray;

import com.sun.javafx.image.IntToIntPixelConverter;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA
 * Description:稀疏数组与二维数组的转换
 * Created By KL
 * Date: 2019/5/31
 * Time: 21:12
 */
public class Sparsearray {
    public static void main(String[] args) {

        //创建二维数组
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        System.out.println("原始二维数组");
        for(int row[] : chessArr){
            for (int data : row){
                System.out.print(data+" ");
            }
            System.out.println();
        }
        
        //1.遍历二维数组，得到不为0的个数
        int sum = 0;
        for (int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //3.遍历二维数组，给稀疏数组赋值

        int count = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(chessArr[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        for (int i=0;i<sparseArr.length;i++){
            System.out.println(sparseArr[i][0]+"  "+sparseArr[i][1]+"  "+sparseArr[i][2]);

        }

        //4.稀疏数组->二维数组

        int array[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i=1;i<sparseArr.length;i++){
            array[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for(int arr[] : array){
            for (int i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    
}
