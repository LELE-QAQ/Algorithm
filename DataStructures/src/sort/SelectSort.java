package sort;

/**
 * Created with IntelliJ IDEA
 * Description:选择排序
 * Created By KL
 * Date: 2019/6/10
 * Time: 10:51
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        //System.out.println(Arrays.toString(array));
        long startTime = System.currentTimeMillis();
        selectSort(array);
        //System.out.println(Arrays.toString(array));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static void selectSort(int[] array) {


        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIndex = i;

            //找出无序数组中最小的值以及下标
            for (int j = i + 1; j < array.length; j++) {
                //确定最小值
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            //交换，最小值放array[i],原来的放array[minIndex]即array[j]
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }

        }
    }
}
