package sort;

/**
 * Created with IntelliJ IDEA
 * Description:快速排序
 * Created By KL
 * Date: 2019/6/10
 * Time: 16:22
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[80000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        long startTime = System.currentTimeMillis();
        quickSort(array, 0, array.length - 1);
        //System.out.println(Arrays.toString(array));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }


    public static void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        int mid = array[(left + right) / 2];
        //左边的数都小于mid，右边的数都大于mid
        while (l < r) {
            while (array[l] < mid) {
                l += 1;
            }
            while (array[r] > mid) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            if (array[l] == mid) {
                r -= 1;
            }
            if (array[r] == mid) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }
        //向左递归
        if (left < r) {
            quickSort(array, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(array, l, right);
        }


    }


}
