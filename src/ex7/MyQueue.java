package ex7;


public class MyQueue {
    private Node head;

    public MyQueue() {
        head = null;
    }

    public void offer(String str) {
        if (head == null) {
            head = new Node(str);
            return;
        }
        Node n = head;
        while (true) {
            if (n.getNext() == null) {
                n.setNext(new Node(str));
                return;
            }
            n = n.getNext();
        }
    }

    public String peek() {
        if (head == null) {
            return null;
        }
        return head.toString();
    }

    public String poll() {
        if (head == null) {
            return null;
        }
        head = head.getNext();
        if (head == null) {
            return null;
        }
        return head.toString();
    }

    public void print() {
        System.out.print("キューの中身: ");
        print(head);
    }

    public void print(Node p) {
        if (p == null) {
            System.out.println("null");
            return;
        }
        System.out.print(p.toString() + " -> ");
        print(p.getNext());
    }

    public static void main(String[] args) {
        // キューを作って，いろいろやってみる
        MyQueue queue = new MyQueue();
        queue.print();
        queue.offer("abc");
        queue.print();
        queue.offer("def");
        queue.print();
        queue.offer("ghi");
        queue.print();
        queue.offer("jkl");
        queue.print();
        queue.offer("mno");
        queue.print();
        System.out.println("peek: " + queue.peek());
        queue.print();
        System.out.println("poll: " + queue.poll());
        queue.print();
        System.out.println("poll: " + queue.poll());
        queue.print();
        System.out.println("poll: " + queue.poll());
        queue.print();
        System.out.println("peek: " + queue.peek());
        queue.print();
        System.out.println("poll: " + queue.poll());
        queue.print();
        System.out.println("poll: " + queue.poll());
        queue.print();
        System.out.println("poll: " + queue.poll());
        queue.print();
        System.out.println("peek: " + queue.peek());
        queue.print();
    }
}
