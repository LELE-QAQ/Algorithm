package sort;

/**
 * Created with IntelliJ IDEA
 * Description:插入排序
 * Created By KL
 * Date: 2019/6/10
 * Time: 11:18
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = new int[500000];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        //System.out.println(Arrays.toString(array));
        long startTime = System.currentTimeMillis();
        insertSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        //System.out.println(Arrays.toString(array));

    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int insertVal = array[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                array[insertIndex + 1] = insertVal;
            }

        }
    }
}
