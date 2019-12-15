package array;

import java.util.Arrays;

/**
 * @author hobo
 * @description 动态数组
 */
public class Array<E> {

    /**
     * 数据元素
     */
    private E[] data;

    /**
     * 数组容量
     */
    private int size;

    public E[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    /**
     * 创建一个动态数组
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无指定大小，则默认为10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组大小
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * 获取数组容量
     *
     * @return int
     */
    public int getCapacity() {
        return data.length;
    }

    /***
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向指定位置添加元素
     *
     * @param index 目标位置
     * @param e     元素
     */
    public void add(int index, E e) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("索引不合法");
        }
        // 如果数组已满，则扩容
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向数组头添加元素
     *
     * @param e
     */
    public void addFirst(E e) throws Exception {
        add(0, e);
    }

    /**
     * 向数组尾添加元素
     *
     * @param e
     * @throws Exception
     */
    public void addLast(E e) throws Exception {
        add(size - 1, e);
    }

    /**
     * 获取 index 位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("索引不合法");
        }
        return data[index];
    }

    /**
     * 判断数组中是否含有元素e
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (E result : data) {
            if (result.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询数组中e的索引，不存在返回 -1
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 修改index位置的元素
     * @param index
     * @param e
     * @throws Exception
     */
    public void set(int index, E e) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("索引位置不合法");
        }
        data[index] = e;
    }

    /**
     * 删除index位置的元素
     * @param index
     * @return
     */
    public E remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("索引位置不合法");
        }
        E ret = data[index];
        for (int i = 0; i < index - 1; i++) {
            // 所有节点数据左移一位
            data[i-1] = data[i];
        }
        size--;
        // 如果当前的数组空间大小为原来的一半，则缩容
        if (size==data.length/2){
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 删除最后一个元素
     * @return
     * @throws Exception
     */
    public E removeLast() throws Exception {
        return remove(size-1);
    }

    /**
     * 删除元素中第一个元素
     * @return
     * @throws Exception
     */
    public E removeFirst() throws Exception {
        return remove(0);
    }

    /**
     * 获取数组中最后一个元素
     * @return
     * @throws Exception
     */
    public E getLast() throws Exception {
        return get(size-1);
    }

    /**
     * 获取数组中第一个元素
     * @return
     * @throws Exception
     */
    public E getFirst() throws Exception {
        return get(0);
    }

    /**
     * 数组扩容
     *
     * @param newCapacity 要扩容的大小
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            // 将data中的元素赋于新数组
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

}
