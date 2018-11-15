package ex5;

import java.util.Deque;
import java.util.LinkedList;

public class QueueByLinkedList<E> extends LinkedList<E> {
    public static void main(String[] args) {
        Deque<String> deque = new QueueByLinkedList<>();

        deque.add("Alice");
        deque.add("Bob");
        deque.add("Charlie");
        deque.add("Diana");
        deque.add("Elmo");
        deque.add("Fred");

        while (!deque.isEmpty()) {
            deque.remove();
        }
    }

    public boolean add(E element) {
        System.out.println(element + "を追加");
        boolean result = super.add(element);
        System.out.println(this);
        return result;
    }

    public E remove() {
        E removeElement = super.remove();
        System.out.println(removeElement+"を削除");
        System.out.println(this);
        return removeElement;
    }
}
