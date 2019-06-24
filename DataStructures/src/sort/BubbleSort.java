package sort;

/**
 * Created with IntelliJ IDEA
 * Description:冒泡排序
 * Created By KL
 * Date: 2019/6/10
 * Time: 9:25
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[80000];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
        long startTime = System.currentTimeMillis();
        bubbleSort(array);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println(time);

    }

    public static void bubbleSort(int[] array) {
        int temp;
        boolean flag = false;
        //第几次排序
        for (int i = 0; i < array.length - 1; i++) {
            //将最大的数放在最后一位，将第二大的数排在倒数第二位，以此类推
            for (int j = 0; j < array.length - 1 - i; j++) {
                //相邻两个数比较
                if (array[j] > array[j + 1]) {
                    temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    flag = true;
                }
            }
            //如果有一次排序没有交换位置，说明数组已经有序
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

    }
}
