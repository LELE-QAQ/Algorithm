package tree;

/**
 * Created with IntelliJ IDEA
 * Description:二叉树
 * Created By KL
 * Date: 2019/6/24
 * Time: 19:52
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(1, "宋江");
        Node node2 = new Node(2, "吴用");
        Node node3 = new Node(3, "卢俊义");
        Node node4 = new Node(4, "林冲");
        Node node5 = new Node(5, "关胜");

        //说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(root);

        tree.delNode(4);
        //遍历
         tree.preOrder(); //1 2 3 5 4
        // tree.infixOrder(); //2 1 5 3 4
        //tree.postOrder(); //2 5 4 3 1

        //查找
        /*Node resNode = tree.preSearch(5);
        if (resNode != null) {
            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 5);
        }*/

        /*Node resNode = tree.infixSearch(4);
        if (resNode != null) {
            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 4);
        }*/
        /*Node resNode = tree.postSearch(4);
        if (resNode != null) {
            System.out.printf("找到了，信息为 no=%d name=%s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到 no = %d 的英雄", 4);
        }*/


    }

}

class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    public Node preSearch(int no) {
        if (root != null) {
            return root.preSearch(no);
        } else {
            return null;
        }
    }

    public Node infixSearch(int no) {
        if (root != null) {
            return root.infixSearch(no);
        } else {
            return null;
        }
    }

    public Node postSearch(int no) {
        if (root != null) {
            return root.postSearch(no);
        } else {
            return null;
        }
    }

    public void delNode(int no){
        if(root !=null){
            if(root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else{
            System.out.println("空树，不能删除~");
        }
    }
}


class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //前序查找
    public Node preSearch(int no) {
        if (this.no == no) {
            return this;
        }
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.preSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preSearch(no);
        }
        return resNode;
    }

    //中序查找
    public Node infixSearch(int no) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.infixSearch(no);
        }
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.infixSearch(no);
        }
        return resNode;
    }

    //后序查找
    public Node postSearch(int no) {
        Node resNode = null;
        if (this.left != null) {
            resNode = this.left.postSearch(no);
        }
        if (this.right != null) {
            resNode = this.right.postSearch(no);
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    //删除
    public void delNode(int no){
        //左子节点
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        //右子节点
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        //左子树遍历
        if(this.left != null){
            this.left.delNode(no);
        }
        //右子树遍历
        if(this.right != null){
            this.right.delNode(no);
        }
    }

}
