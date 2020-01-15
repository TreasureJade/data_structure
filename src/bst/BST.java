package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hobo
 * @description 二分搜索树
 * 继承Comparable<E> 要求元素具有可比较性
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    /**
     * 根节点
     */
    private Node root;

    private int size;


    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向以node为根的二分搜索树中插入元素e，递归算法
     *
     * @param node
     * @param e
     * @return 返回插入新节点后，二分搜索树的根
     */
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        // 左子树
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
            // 右子树
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    private void add(E e) {
        root = add(root, e);
    }

    /**
     * 查询树中是否含有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归遍历树中是否含有元素e
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        }
        // 左子树
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        // 右子树
        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 前序递归遍历树
     *
     * @param node 根节点
     */
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 前序遍历的非递归操作
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            // 先向栈中压入右子树
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    /**
     * 中序遍历
     */
    public void inOrder() {
        inOrder(root);
    }

    /**
     * 中序递归遍历
     *
     * @param node
     */
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        // 遍历左子树
        inOrder(node.left);
        // 访问该节点
        System.out.println(node.e);
        // 遍历右子树
        inOrder(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        // 遍历左子树
        postOrder(node.left);
        // 遍历右子树
        postOrder(node.right);
        // 访问该节点
        System.out.println(node.e);
    }


    /**
     * 层序遍历
     */
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 出队-->访问节点
            Node cur = queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    /**
     * 寻找最小节点
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("此树为空");
        }

        return minimum(root).e;
    }

    /**
     * 返回以 node 为根的二分搜索树的最小值的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    /**
     *
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("此树为空");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return maximum(node.right);
    }

    /**
     * 删除最小值
     *
     * @return
     */
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    /**
     * 递归删除最小值
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        // 左子树为空则最小值在右子树
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除以 node 为根的二分搜索树的最大节点
     * @param node
     * @return 返回删除节点后新的二分搜索树的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);

        return node;
    }

    /**
     * 删除任意节点
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }


    /**
     * 删除任意节点
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
        }

        if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        } else { // e == node.e

            // 待删除节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除的节点左右子树均不为空
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;

        }

        return null;

    }

    /**
     * 输出树
     *
     * @param depth 树的深度
     * @return
     */
    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }

    /**
     * 生成以 node 为根节点，深度为 depth 的描述二叉树的字符串
     *
     * @param node  根节点
     * @param depth 深度
     * @param res   字符串
     */
    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");

        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        generateBSTString(root, 0, res);

        return res.toString();
    }

}
