package search;

/**
 * Created with IntelliJ IDEA
 * Description:线性查找
 * Created By KL
 * Date: 2019/6/12
 * Time: 9:30
 */
public class SeqSearch {

    public static void main(String[] args) {
        int[] array = {1,3,8,4,0,2};
        int i = seqSearch(array, 2);
        System.out.println("下标为:"+i);

    }

    public static int seqSearch(int[] array,int val){

        for(int i=0;i<array.length;i++){
            if(array[i] == val){
                return i;
            }
        }
        return -1;
    }
}
