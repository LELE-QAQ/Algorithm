/**
 * Created with IntelliJ IDEA
 * Description:汉诺塔问题(分治算法)
 * Created By KL
 * Date: 2019/9/6
 * Time: 12:39
 */
public class Hanoitower {

    public static void main(String[] args) {

        hanoitower(10,'A','B','C');
    }

    public static void hanoitower(int num,char a,char b,char c){
        if(num == 1){
            System.out.println("第1个盘从 " + a + "->" + c);
        }else {
            //把上面的盘子从a借助c移到b
            hanoitower(num-1,a,c,b);
            //最下面的盘子a->c
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //把b上的盘子借助a移到c
            hanoitower(num-1,b,a,c);

        }
    }
}
