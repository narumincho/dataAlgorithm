package ex9;

import java.util.*;

public class DepthFirstSearch {
    private class Node {
        int label;
        List<Node> children = new ArrayList<>();
        boolean isVisited;

        public Node(int label) {
            this.label = label;
            this.isVisited = false;
        }

        public Node getNotVisitedChild() {
            for(Node child : children){
                if(!child.isVisited){
                    return child;
                }
            }
            return  null;
        }

        @Override
        public String toString() {
            return String.valueOf(label);
        }
    }

    Node root;
    Deque<Node> stack = new LinkedList<>();

    public DepthFirstSearch() {
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
        DepthFirstSearch dfs = new DepthFirstSearch();

        Node rootNode = dfs.root;
        rootNode.isVisited = true;
        dfs.stack.push(rootNode);
        System.out.println(rootNode.label);

        while (!dfs.stack.isEmpty()) {
            Node target = dfs.stack.peek();
            Node child = target.getNotVisitedChild();
            if(child == null) {
                dfs.stack.pop();
                continue;
            }
            child.isVisited = true;
            dfs.stack.push(child);
            System.out.println(child);
        }
    }
}
