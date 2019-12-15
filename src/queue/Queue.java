package queue;

/**
 * @author hobo
 * @description
 */
public interface Queue<E> {

    /**
     * 获取队列内元素个数
     * @return
     */
    int getSize();

    /**
     * 判断队列内元素是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 添加元素
     */
    void enqueue(E e) throws Exception;

    /**
     * 删除元素
     * @return
     */
    E dequeue() throws Exception;

    /**
     * 获取队首元素
     * @return
     */
    E getFront() throws Exception;

}
