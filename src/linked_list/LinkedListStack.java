package linked_list;

import stack.Stack;

/**
 * @author hobo
 * @description 用链表实现栈
 *
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }


    @Override
    public void push(E e) throws Exception {
        list.addFirst(e);
    }


    @Override
    public E pop() throws Exception {
        return list.removeFirst();
    }

    @Override
    public E peek() throws Exception {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
}
