/**
 * Created with IntelliJ IDEA
 * Description:字符串匹配()
 * Created By KL
 * Date: 2019/9/6
 * Time: 18:35
 */
public class StrMatch {


    public static void main(String[] args) {
        String s1 = "asdfghjhgfdssdfgfsdfdsfsdf";
        String s2 = "fgfs";
        int match = match(s1, s2);
        System.out.println(match);


    }


    /**
     * 暴力匹配
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int match(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int s1l = s1.length;
        int s2l = s2.length;

        int i = 0;
        int j = 0;

        while (i < s1l && j < s2l) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                //没有匹配上
                i = i - (j - 1); //i回到上次开始位的下一位
                j = 0;
            }
        }
        if (j == s2l) {
            return i - j;
        } else {
            return -1;
        }
    }


}
