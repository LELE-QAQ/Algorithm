package search;

/**
 * Created with IntelliJ IDEA
 * Description:插值查找
 * Created By KL
 * Date: 2019/6/24
 * Time: 16:05
 */
public class InsertValueSearch {
    static int count;
    public static void main(String[] args) {

        //int[] array = {1,2,3,4,5,6,7,8};
        int[] array = new int[1000];
        for (int i=0;i<array.length;i++){
            array[i] = i;
        }
        int i = insertValueSearch(array, 0, array.length - 1, 999);
        System.out.println(i);
        System.out.println(count);
    }



    public static int insertValueSearch(int[] array, int left, int right, int value){
        count++;
        //必须写value > array[right] || value < array[left]，防止数组越界
        if(left > right || value > array[right] || value < array[left]){
            return -1;
        }

        int mid = left+(right - left)*(value-array[left])/(array[right]-array[left]);
        int midvalue = array[mid];
        if(value > midvalue){
            //向右递归
            return insertValueSearch(array , mid+1 , right , value);
        }else if(value < mid){
            //向左递归
            return insertValueSearch(array , left , mid-1 , value);
        }else {
            return mid;
        }

    }
}
