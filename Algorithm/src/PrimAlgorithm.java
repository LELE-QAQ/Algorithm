import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Description:普里姆算法
 * Created By KL
 * Date: 2019/9/12
 * Time: 15:15
 */
public class PrimAlgorithm {

    public static void main(String[] args) {

        //顶点
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        int node = data.length;

        //邻接矩阵关系，10000表示不连通
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};

        MGraph graph = new MGraph(node);
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, node, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph, 0);  //从下标0也就是结点A开始
    }

}

/**
 * 邻接矩阵
 */
class MGraph {
    int node;           //结点数
    char[] data;        //结点名称
    int[][] weight;     //边数据

    public MGraph(int node) {
        this.node = node;
        data = new char[node];
        weight = new int[node][node];
    }

}

/**
 * 创建最小生成树
 */
class MinTree {


    /**
     * 创建邻接矩阵
     *
     * @param mGraph
     * @param node
     * @param data
     * @param weight
     */
    public void createGraph(MGraph mGraph, int node, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < mGraph.node; i++) {
            mGraph.data[i] = data[i];
            for (j = 0; j < mGraph.node; j++) {
                mGraph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     * 显示邻接矩阵
     *
     * @param mGraph
     */
    public void showGraph(MGraph mGraph) {
        for (int[] link : mGraph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }


    /**
     * 普里姆算法
     *
     * @param graph
     * @param v
     */
    public void prim(MGraph graph, int v) {
        int[] visited = new int[graph.node];
        //记录是否访问过
        visited[v] = 1;
        //h1,h2记录两个顶点下标
        int h1 = -1;
        int h2 = -1;
        int min = 10000;  //表示走不通
        for (int k = 1; k < graph.node; k++) {          //每次找出一条路径，直到顶点全部连通
            for (int i = 0; i < graph.node; i++) {      //i表示访问过的结点
                for (int j = 0; j < graph.node; j++) {  //j表示未被访问过的结点

                    //找出从i到j的所有路径中权值最小的路径
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < min) {
                        min = graph.weight[i][j];  //找到更短的路径后后替换min
                        //记录下两个节点
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + min);

            //标记当前节点已被访问
            visited[h2] = 1;
            //重置min,进行下一轮
            min = 10000;
        }

    }


}
