package set;

import bst.BST;

/**
 * @author hobo
 * @description 基于二分搜索树实现集合SET
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet(BST<E> bst) {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        // 二分搜索树本来就去重
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
