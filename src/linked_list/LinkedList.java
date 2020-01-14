package linked_list;

/**
 * @author hobo
 * @description 链表  动态数据结构
 *
 * 时间复杂度：添加操作  addLast O(n)  addFirst O(1) add(index,e) O(n/2)=O(n)
 *           删除操作  removeLast O(n) removeFirst O(1)  remove(index) O(n/2)=O(n)
 *           修改操作  set(index,e) O(n)
 *           查找操作  find(e)  O(n)
 *
 */
public class LinkedList<E> {

    private class Node {
        // 存储的数据
        public E e;

        // 指向引用
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头结点
     * size=0的节点之前的节点
     */
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    /**
     * 获取链表中元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 指定位置添加元素
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }
        // 从虚拟头结点开始遍历
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;
    }


    /**
     * 在链表头添加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表尾添加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }
        // 从索引为0的位置开始
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表中的第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表中最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size);
    }

    /**
     * 更新操作
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 查询链表中是否含有元素e
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除index位置的元素，返回删除的元素
     *
     * @param index
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引非法");
        }
        Node prev = dummyHead.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("Null");
        return res.toString();
    }

}
