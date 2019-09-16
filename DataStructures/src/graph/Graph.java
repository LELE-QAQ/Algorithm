package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA
 * Description:图
 * Created By KL
 * Date: 2019/9/9
 * Time: 15:33
 */
public class Graph {


    /*
    深度优先：A找到一个能走通的结点B之后，继续找B能走通的结点
    广度优先：A找遍所有能走通的结点，继续找B能走通的结点
            队列保存访问过的结点，无法走通时取出队列头结点访问
     */



    private ArrayList<String> list;  //存储顶点
    private int[][] edges;   //邻接矩阵
    private int nums;   //记录边的条数
    private boolean[] isvisited; //记录是否被访问过
    public static void main(String[] args) {
        int n = 8;
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};  //顶点
        Graph graph = new Graph(n);
        //插入顶点
        for (String vertex : Vertexs) {
            graph.insert(vertex);
        }

        //插入边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);

        //graph.showGraph();
        //graph.dfs();   //1->2->4->8->5->3->6->7->
        graph.bfs();   //1=>2=>3=>4=>5=>6=>7=>8=>
    }



    /**
     * 构造器
     * @param n
     */
    public Graph(int n){
        edges = new  int[n][n];
        list = new ArrayList<String>(n);
        nums = 0;
    }

    /**
     * 插入顶点
     * @param top
     */
    public void insert(String top){
        list.add(top);
    }

    /**
     * 插入边
     * @param v1
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        nums++;
    }

    /**
     * 显示矩阵
     */
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    /**
     * 返回节点个数
     * @return
     */
    public int getNumOfTop(){
        return list.size();
    }

    /**
     * 返回节点i对应的名称
     * @param i
     * @return
     */
    public String getValue(int i){
        return list.get(i);
    }

    /**
     * 返回第一个邻接结点的下标
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index){
        for(int j=0;j<list.size();j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }


    /**
     * 根据前一个邻接结点获取下一个邻接结点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1,int v2){
        for(int j=v2+1;j<list.size();j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }


    /**
     * 重载dfs，遍历所有结点
     */
    public void dfs(){
        isvisited = new boolean[list.size()];
        for(int i=0;i<getNumOfTop();i++){
            if(!isvisited[i]){
                dfs(isvisited,i);
            }
        }
    }

    /**
     * 深度优先遍历
     * @param isvisited
     * @param i
     */
    private void dfs(boolean[] isvisited, int i) {
        System.out.print(getValue(i) + "->");
        isvisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){   //有邻接节点
            if(!isvisited[w]){  //邻接节点未被访问过
                dfs(isvisited,w);
            }
            w = getNextNeighbor(i,w);  //邻接节点访问过，寻找下一个邻接结点
        }
    }


    /**
     * 重载广度优先遍历
     */
    public void bfs(){
        isvisited = new boolean[list.size()];
        for(int i=0;i<getNumOfTop();i++){
            if(!isvisited[i]){
                bfs(isvisited,i);
            }
        }
    }


    /**
     * 广度优先遍历
     * @param isvisited
     * @param i
     */
    private void bfs(boolean[] isvisited,int i){
        int u; //队列头结点对应下标
        int w;
        LinkedList<Object> linkedList = new LinkedList<>();  //记录结点访问顺序
        System.out.print(getValue(i) + "=>");
        isvisited[i] = true;
        linkedList.addLast(i);

        while (!linkedList.isEmpty()){
            u = (Integer)linkedList.removeFirst();  //取出队列头结点
            w = getFirstNeighbor(u);
            while(w != -1){
                if(!isvisited[w]){
                    System.out.print(getValue(w) + "=>");
                    isvisited[w] = true;
                    linkedList.addLast(w);
                }
                //以A为前驱点，找B后面的下一个邻接结点C
                w = getNextNeighbor(u,w);
            }

        }
    }
}
