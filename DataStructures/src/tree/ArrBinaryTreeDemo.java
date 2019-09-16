package tree;

/**
 * Created with IntelliJ IDEA
 * Description:顺序存储转二叉树
 * Created By KL
 * Date: 2019/6/26
 * Time: 18:17
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] array = {1, 3, 6, 8, 10, 14};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
        //arrBinaryTree.preOrder(); // 1 2 4 5 3 6 7
        arrBinaryTree.infixOrder();
    }
}

class ArrBinaryTree {
    private int[] array;

    public ArrBinaryTree(int[] array) {
        this.array = array;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void infixOrder() {
        this.infixOrder(0);
    }

    public void preOrder(int index) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        //根节点
        System.out.println(array[index]);
        //左节点
        if ((index * 2 + 1) < array.length) {
            preOrder(index * 2 + 1);
        }
        //右节点
        if ((index * 2 + 2) < array.length) {
            preOrder(index * 2 + 2);
        }
    }

    public void infixOrder(int index) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        //左节点
        if ((index * 2 + 1) < array.length) {
            infixOrder(index * 2 + 1);
        }
        //根节点
        System.out.println(array[index]);
        //右节点
        if ((index * 2 + 2) < array.length) {
            infixOrder(index * 2 + 2);
        }
    }
}
