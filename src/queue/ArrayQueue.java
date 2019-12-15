package queue;

import array.Array;

/**
 * @author hobo
 * @description
 */
public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(int capacity) {
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
    public void enqueue(E e) throws Exception {
        array.addLast(e);
    }

    @Override
    public E dequeue() throws Exception {
        return array.removeLast();
    }

    @Override
    public E getFront() throws Exception {
        return array.getFirst();
    }
}
