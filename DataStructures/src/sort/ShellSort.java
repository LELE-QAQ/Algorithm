package sort;

/**
 * Created with IntelliJ IDEA
 * Description:希尔排序
 * Created By KL
 * Date: 2019/6/10
 * Time: 15:03
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[80000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        //System.out.println(Arrays.toString(array));
        long startTime = System.currentTimeMillis();
        //shellSort(array);
        shellSort2(array);
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
        //System.out.println(Arrays.toString(array));

    }

    //交换式
    public static void shellSort(int[] array) {
        int temp;
        //确定增量
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            //分组，每组的两个数进行比较
            //第一次：0和gap比较
            //第二次：1和1+gap比较。。。。。。
            for (int i = gap; i < array.length; i++) {
                //每组进行比较
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j + gap];
                        array[j + gap] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    //插入式
    public static void shellSort2(int[] array) {
        int temp;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        //将j-gap后移
                        array[j] = array[j - gap];
                        //减小j，继续与j-gap比较
                        j -= gap;
                    }
                    array[j] = temp;
                }
            }
        }
    }
}
