package sort;

/**
 * Created with IntelliJ IDEA
 * Description:桶排序
 * Created By KL
 * Date: 2019/6/24
 * Time: 19:02
 */
public class RadixSort {
    public static void main(String[] args) {
        //int[] array = {1,3,2,55,3,43,4,3,42,4,24,2,3423,4,23,4,234,55,6,67,9,6,4,345};
        int[] array = new int[30000000];
        for(int i=0;i<array.length;i++){
            array[i] = (int)(Math.random() * 1000);
        }
        long l = System.currentTimeMillis();
        radixSort(array);
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
        //System.out.println(Arrays.toString(array)+" ");
    }

    public static void radixSort(int[] array){
        int max = array[0];
        for(int i=0;i<array.length;i++){
            if(array[i] > max){
                max = array[i];
            }
        }
        int maxLen = (max+"").length(); //最大数据的位数
        int bucket[][] = new int[10][array.length]; //十个桶
        int[] count = new int[10];  //用来存放每个桶中数据的个数


        for(int i=0,n=1;i<maxLen;i++,n*=10){

            for(int j=0;j<array.length;j++){
                //取出每个元素的对应位的值
                int element = array[j]/n%10;
                //放入到对应的桶中
                bucket[element][count[element]] = array[j];
                count[element]++;
            }

            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            for(int k=0;k<count.length;k++){
                if(count[k] != 0){
                    for(int l=0;l<count[k];l++){
                        array[index++] = bucket[k][l];
                    }
                }
                //每轮处理后需要将count[k] = 0！！！！
                count[k] = 0;
            }

        }
    }
}
