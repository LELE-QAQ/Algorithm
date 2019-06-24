package search;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Description:二分查找
 * Created By KL
 * Date: 2019/6/12
 * Time: 9:35
 */
public class BinarySearch {
    static int count = 0;
    public static void main(String[] args) {

        //int[] array = {1,2,3,4,5,6,7,8,10,22,33,44,55,66,77};
        /*int[] array = new int[1000];
        for (int i=0;i<array.length;i++){
            array[i] = i;
        }*/
        int[] array = {1,2,3,4,5,5,5,5,5,6,6,6,6,7,7,8,8,9,0};
        /*int i = binarySearch(array, 0, array.length-1, 999);
        System.out.println(i);
        System.out.println(count);*/

        ArrayList<Integer> list = binarySearch2(array, 0, array.length, 6);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }
    public static int binarySearch(int[] array,int left,int right,int val){
        count++;
        if(left > right){
            return -1;
        }
        int mid = (left + right)/2;
        int midVal = array[mid];
        if(val < midVal){
            return binarySearch(array,left,mid-1,val);
        }
        else if(val > midVal){
            return binarySearch(array,mid+1,right,val);
        }else {
            return mid;
        }

    }


    //查找多个相同元素

    public static ArrayList<Integer> binarySearch2(int[] array, int left, int right, int value){
        if(left > right){
            return new ArrayList<>();
        }
        int mid = (right+left)/2;
        int midValue = array[mid];
        if(value > midValue){
            return binarySearch2(array,mid+1,right,value);
        }else if(value < midValue){
            return binarySearch2(array,left,mid-1,value);
        }else {
            ArrayList<Integer> list = new ArrayList<>();
            //向左查找与value相同的值有几个
            int temp = mid-1;
            while (true){
                if(temp < 0 || array[temp] != value){
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            //向右查找与value相同的值有几个
            temp = mid+1;
            while(true){
                if(temp > array.length || array[temp] != value){
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            //mid添加入list
            list.add(mid);
            return list;
        }
    }
}
