import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA
 * Description:贪心算法
 * Created By KL
 * Date: 2019/9/8
 * Time: 16:23
 */
public class Greedy {

    public static void main(String[] args) {


        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        HashSet<String> hashSet1 = new HashSet<String>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<String>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<String>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<String>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<String>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1",hashSet1);
        broadcasts.put("k2",hashSet2);
        broadcasts.put("k3",hashSet3);
        broadcasts.put("k4",hashSet4);
        broadcasts.put("k5",hashSet5);

        //存放所有区域
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");

        //存放电台集合
        ArrayList<String> select = new ArrayList<>();

        HashSet<String> temp = new HashSet<>();

        String maxkey = null;

        //每次选出包含包含地区最多的电台
        while (allAreas.size() != 0){
            maxkey = null;
            //遍历获取5个电台的k
            for (String key : broadcasts.keySet()) {
                //清空临时集合
                temp.clear();
                //获取每个电台包含的地区
                HashSet<String> areas = broadcasts.get(key);
                //加入临时集合
                temp.addAll(areas);
                //与所有的地区取交集
                temp.retainAll(allAreas);
                //如果当前temp集合中的值多于maxkey集合中的值
                if(temp.size()>0 && (maxkey == null || temp.size() > broadcasts.get(maxkey).size())){
                    maxkey = key; //maxkey重新赋值
                }
            }

            //遍历一次后，保存maxkey的值，将maxkey包含的地区从全部地区中去除
            if(maxkey != null){
                select.add(maxkey);
                allAreas.removeAll(broadcasts.get(maxkey));
            }
        }
        System.out.println("得到的选择结果是" + select);//[K1,K2,K3,K5]

    }


}
