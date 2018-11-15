package ex5;

import java.util.Deque;
import java.util.LinkedList;

public class StackByLinkedList<E> extends LinkedList<E> {

    public static void main(String[] args) {
        Deque<String> deque = new StackByLinkedList<>();

        deque.push("Alice");
        deque.push("Bob");
        deque.push("Charlie");
        deque.push("Diana");
        deque.push("Elmo");
        deque.push("Fred");

        while (!deque.isEmpty()) {
            deque.poll();
        }
    }

    public void push(E element) {
        System.out.println(element + "を追加");
        super.push(element);
        System.out.println(this);
    }

    public E poll() {
        E pollElement = super.poll();
        System.out.println(pollElement + "を削除");
        System.out.println(this);
        return pollElement;
    }
}

