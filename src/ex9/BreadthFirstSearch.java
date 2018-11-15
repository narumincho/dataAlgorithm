package ex9;

import java.util.*;

public class BreadthFirstSearch {
    private class Node {
        int label;
        List<Node> children = new ArrayList<>();
        boolean isVisited;

        public Node(int label) {
            this.label = label;
            this.isVisited = false;
        }

        public Node getNotVisitedChild() {
            for (Node child : children) {
                if (!child.isVisited) {
                    return child;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }

    Node root;
    Queue<Node> queue = new LinkedList<>();

    public BreadthFirstSearch() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node1.children = Arrays.asList(node2, node3, node4);
        node2.children = Arrays.asList(node5);
        node3.children = Arrays.asList(node6, node7);

        root = node1;
    }

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        Node node = bfs.root;
        node.isVisited = true;
        bfs.queue.offer(node);
        System.out.println(node.label);

        while (!bfs.queue.isEmpty()) {
            Node target = bfs.queue.peek();
            Node child = target.getNotVisitedChild();
            if (child == null) {
                bfs.queue.poll();
                continue;
            }
            child.isVisited = true;
            bfs.queue.add(child);
            System.out.println(child);
        }
    }
}
