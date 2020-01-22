package map;

import linked_list.LinkedList;

/**
 * @author hobo
 * @description
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        // 键
        public K key;
        public V value;

        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }

    /**
     * 头指针
     */
    private Node dummyHead;

    /**
     * 长度
     */
    private int size;


    /**
     * 根据传入的key查询映射中的key
     *
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            throw new IllegalArgumentException("该键已存在");
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        // 获取要删除的键
        while (prev.next != null) {
            if (prev.next.value.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next!=null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (key == null) {
            throw new IllegalArgumentException("要修改的键不存在");
        } else {
            node.value = newValue;
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
