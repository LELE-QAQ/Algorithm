package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:堆排序
 * Created By KL
 * Date: 2019/6/27
 * Time: 15:37
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {4,9,8,5,6};
        heapSort(array);
        System.out.print(Arrays.toString(array)+" ");
    }

    public static void heapSort(int[] array){
        int temp = 0;

        //构建一个大顶堆
        for(int i=array.length/2-1;i>=0;i--){

            adjustHeap(array,i,array.length);
            System.out.println(Arrays.toString(array));
        }


        //将顶端与底端互换
        for(int j=array.length-1;j>0;j--){
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            //System.out.println(Arrays.toString(array));
            adjustHeap(array,0,j); //剩余数重新排大顶堆
            //System.out.println(Arrays.toString(array));
        }
    }

    //对以i为根节点的子树进行排序
    public static void adjustHeap(int[] array,int i,int length){
        int temp = array[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1 < length && array[k]<array[k+1]){
                k+=1;
            }
            if(array[k] > temp){ //如果子节点大于父节点
                array[i] = array[k]; //把较大的值赋给当前节点
                i = k; //继续遍历
            }
            else {
                break;
            }

            //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了 最顶(局部)
            array[i] = temp; //原来的arr[i]下移
        }
    }
}
