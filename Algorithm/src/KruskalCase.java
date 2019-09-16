/**
 * Created with IntelliJ IDEA
 * Description:克鲁斯卡尔算法
 * Created By KL
 * Date: 2019/9/15
 * Time: 15:05
 */
public class KruskalCase {

    private int edgeNum;    //边的个数
    private char[] node;    //顶点
    private int[][] matrix; //矩阵


    private static final int INF = Integer.MAX_VALUE;  //表示不连通

    public static void main(String[] args) {

        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};

        //邻接矩阵
        int matrix[][] = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {0, 12, INF, INF, INF, 16, 14},
                /*B*/ {12, 0, 10, INF, INF, 7, INF},
                /*C*/ {INF, 10, 0, 3, 5, 6, INF},
                /*D*/ {INF, INF, 3, 0, 4, INF, INF},
                /*E*/ {INF, INF, 5, 4, 0, 2, 8},
                /*F*/ {16, 7, 6, INF, 2, 0, 9},
                /*G*/ {14, INF, INF, INF, 8, 9, 0}};

        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);

        /*Data[] edges = kruskalCase.getEdges();
        System.out.println(Arrays.toString(edges));
        kruskalCase.sort(edges);
        System.out.println(Arrays.toString(edges));*/
        kruskalCase.kruskal();

    }

    /**
     * 构造器
     *
     * @param node
     * @param matrix
     */
    public KruskalCase(char[] node, int[][] matrix) {
        int vlen = node.length; //顶点的个数
        this.matrix = matrix;
        this.node = node;

        //统计边的个数
        for (int i = 0; i < vlen; i++) {
            for (int j = i + 1; j < vlen; j++) { //j=i+1表示不统计对角
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    /**
     * 打印邻接矩阵
     */
    public void print() {
        for (int i = 0; i < node.length; i++) {
            for (int j = 0; j < node.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 找到下标对应的名称 0->A 1->B
     *
     * @param ch
     * @return
     */
    public int getPosition(char ch) {
        for (int i = 0; i < node.length; i++) {
            if (node[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 将所有边放入Data[]数组中
     * EData[] 形式 [['A','B', 12], ['B','F',7], .....]
     *
     * @return
     */
    public Data[] getEdges() {
        int index = 0;
        Data[] edges = new Data[edgeNum];
        for (int i = 0; i < node.length; i++) {
            for (int j = i + 1; j < node.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index++] = new Data(node[i], node[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 将Data[]中的边按权值大小进行排序(冒泡)
     *
     * @param edges
     */
    public void sort(Data[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Data tmp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 获取下标为i的顶点的终点，用于判断两个顶点的终点是否相同，相同则会形成回路
     * 终点是在遍历过程中逐步形成的
     * @param ends
     * @param i
     * @return
     */
    public int getEnds(int[] ends, int i) {  // i = 4 [0,0,0,0,5,0,0,0,0,0,0,0]
        while (ends[i] != 0) {      //当前顶点有终点时
            i = ends[i];            //返回终点下标
        }
        return i;                   //否则放回顶点本身下标
    }


    /**
     * 算法主体
     */
    public void kruskal() {
        int index = 0;
        int[] ends = new int[edgeNum];
        Data[] rets = new Data[edgeNum];

        //获取包含所有边的Data[]数组
        Data[] edges = getEdges();
        sort(edges);  //对所有边进行排序
        for (int i = 0; i < edgeNum; i++) {
            int p1 = getPosition(edges[i].start);   //获取第i条边对应的起点p1
            int p2 = getPosition(edges[i].end);     //获取第i条边对应的终点p2
            int m = getEnds(ends, p1);              //获取p1的终点
            int n = getEnds(ends, p2);               //获取p2的终点
            if (m != n) {                             //如果两个终点不相同
                ends[m] = n;                        //将p1的终点设置成p2
                rets[index++] = edges[i];           //将第i条边加入rets[]数组
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.println(rets[i]);    //遍历并输出最终结果
        }
    }


}

/**
 * 对象实例表示一条边
 */
class Data {
    char start;     //边的开始点
    char end;       //边的结束点
    int weight;    //边的权值

    public Data(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Data{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
