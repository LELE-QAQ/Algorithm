/**
 * Created with IntelliJ IDEA
 * Description:二分查找（非递归）
 * Created By KL
 * Date: 2019/9/5
 * Time: 16:34
 */
public class BinarySearchNoRecur {

    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 10);
        System.out.println("index=" + index);//
    }


    public static int binarySearch(int arr[],int target){
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                right = mid - 1;
            }else if(arr[mid] < target){
                left = mid + 1;
            }

        }
        return -1;
    }
}
