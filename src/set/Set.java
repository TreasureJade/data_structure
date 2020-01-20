package set;

/**
 * @author hobo
 * @description
 */
public interface Set<E> {
    /**
     * 集合中添加元素e
     * @param e
     */
    void  add(E e);

    /**
     * 集合中删除元素e
     * @param e
     */
    void remove(E e);

    /**
     * 判断集合中是否含有元素e
     * @param e
     * @return
     */
    boolean contains(E e);

    /**
     * 获取集合的长度
     * @return
     */
    int getSize();

    /**
     * 判断集合是否为空
     * @return
     */
    boolean isEmpty();

}
