package sort;

/**
 * Created with IntelliJ IDEA
 * Description:归并排序
 * Created By KL
 * Date: 2019/6/24
 * Time: 17:53
 */
public class MergetSort {
    public static void main(String[] args) {
        //int[] array = {1,8,7,5,66,55,33,888,555,666,3333,555,66};
        int[] array = new int[80000000];
        for(int i=0;i<array.length;i++){
            array[i] = (int)(Math.random()*100);
        }
        int[] temp = new int[array.length];
        //System.out.println(Arrays.toString(array)+" ");
        long l = System.currentTimeMillis();
        mergeSort(array,0,array.length-1,temp);
        //System.out.println(Arrays.toString(array)+" ");
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }

    //分解+合并
    public static void mergeSort(int[] array,int left,int right,int[] temp){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid+1,right,temp);
            merge(array,left,mid,right,temp);
        }
    }

    //合并
    public static void merge(int[] array,int left,int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        int t=0;
        while (i <= mid && j<=right){
            if(array[i] <= array[j]){
                temp[t] = array[i];
                i+=1;
                t+=1;
            }else {
                temp[t] = array[j];
                j+=1;
                t+=1;
            }
        }
        while (i<=mid){
            temp[t] = array[i];
            i+=1;
            t+=1;
        }
        while (j<=right){
            temp[t] = array[j];
            j+=1;
            t+=1;
        }


        //将temp数据拷贝入array
        t = 0;
        int l = left;
        while (l <= right){
            array[l] = temp[t];
            l+=1;
            t+=1;
        }
    }
}
