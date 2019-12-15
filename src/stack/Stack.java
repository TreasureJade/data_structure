package stack;

/**
 * @author hobo
 * @description 数组实现栈
 */
public interface Stack<E> {

    /**
     * 获取栈内元素个数
     * @return
     */
    int getSize();

    /**
     * 判断栈内元素是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 添加元素
     */
    void push(E e) throws Exception;

    /**
     * 从栈顶取出元素
     * @return
     */
    E pop() throws Exception;

    /**
     * 获取栈顶元素
     * @return
     */
    E peek() throws Exception;
}
