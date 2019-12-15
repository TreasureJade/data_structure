package stack;

import array.Array;

/**
 * @author hobo
 * @description
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) throws Exception {
        array.addLast(e);
    }

    @Override
    public E pop() throws Exception {
        return array.removeLast();
    }

    @Override
    public E peek() throws Exception {
        return array.getLast();
    }
}
