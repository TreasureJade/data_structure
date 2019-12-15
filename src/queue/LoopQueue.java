package queue;


/**
 * @author hobo
 * @description 循环队列
 */
public class LoopQueue<E> {

    private E[] data;

    private int front;

    private int tail;

    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity - 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 获取当前队列容量
     *
     * @return
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 获取队列大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 插入元素
     *
     * @param e
     */
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 删除队首元素（出队）
     * @return
     * @throws Exception
     */
    public E dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("队列为空");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 扩容
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


}
