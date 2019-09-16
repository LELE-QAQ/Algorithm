/**
 * Created with IntelliJ IDEA
 * Description:KMP
 * Created By KL
 * Date: 2019/9/8
 * Time: 14:31
 */
public class KMP {

    public static void main(String[] args) {

        String s1 = "BBC ABCDAB ABCDABCDAB DE";
        String s2 = "ABCDAB D";
        int[] next = kmpNext(s2);
        int i = kmpSearch(s1, s2, next);
        System.out.println(i);

    }


    /**
     * kmp算法
     * @param str1
     * @param str2
     * @param next
     * @return
     */
    public static int kmpSearch(String str1,String str2,int[] next){
        for(int i=1,j=0;i<str1.length();i++){
            while(j>0 && str1.charAt(i) != str2.charAt(j)){
                //当i=10，j=6时进入循环，j=2；然后继续进入循环j=0，跳出循环；
                //找到上一次匹配的位置i=10，j=？
                j = next[j-1]; //调整j的位置
            }
            if(str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if(str2.length() == j){
                return i-j+1;
            }
        }
        return -1;
    }

    /**
     * 部分匹配表
     * @param str
     * @return
     */
    public static int[] kmpNext(String str){
        int[] next = new int[str.length()];
        next[0] = 0; //只有一个字符时为0
        for(int i=1,j=0;i<str.length();i++){
            //匹配不上时
            while (j>0 && str.charAt(i) != str.charAt(j)){
                j = next[j-1]; //往前找上一次出现的位置
            }
            if(str.charAt(i) == str.charAt(j)){
                j++;  //一个相同的字符+1
            }
            next[i] = j;
        }
        return next;
    }


}
