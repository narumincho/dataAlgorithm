package ex9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {
    private final static int INFINITY = Integer.MAX_VALUE; // これを無限大とする

    private class Node {
        int key;
        int label;
        boolean isFixed;
        List<Edge> edgeList = new ArrayList<>();

        public Node(int key) {
            this.key = key;
            this.label = INFINITY;
            this.isFixed = false;
        }

        public void setLabelIfLessThanBefore(int newLabel) {
            if (newLabel < label) {
                label = newLabel;
            }
        }
    }

    private class Edge {
        Node to;    // 隣接するノード
        int weight; // エッジの重み

        Edge(Node to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    Node start;
    List<Node> nodes;

    public Dijkstra() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.edgeList = Arrays.asList(
                new Edge(node2, 20),
                new Edge(node3, 10),
                new Edge(node4, 15)
        );

        node2.edgeList = Arrays.asList(
                new Edge(node1, 20),
                new Edge(node4, 10)
        );

        node3.edgeList = Arrays.asList(
                new Edge(node1, 10),
                new Edge(node4, 20),
                new Edge(node5, 10)
        );

        node4.edgeList = Arrays.asList(
                new Edge(node1, 15),
                new Edge(node2, 10),
                new Edge(node3, 20)
        );

        node5.edgeList = Arrays.asList(
                new Edge(node3, 10),
                new Edge(node4, 20)
        );

        nodes = Arrays.asList(node1, node2, node3, node4, node5);
        start = nodes.get(0);
        start.label = 0;
    }

    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra();
        Node targetNode = graph.start;
        while (true) {
            targetNode.isFixed = true;
            for (Edge edge : targetNode.edgeList) {
                edge.to.setLabelIfLessThanBefore(targetNode.label + edge.weight);
            }

            Node minNode = null;
            for (Node node : graph.nodes) {
                if(node.isFixed){
                    continue;
                }
                if (minNode == null) {
                    minNode = node;
                    continue;
                }
                if (node.label < minNode.label) {
                    minNode = node;
                }
            }
            if (minNode == null) {
                break;
            }
            targetNode = minNode;
        }

        for (Node node : graph.nodes) {
            System.out.println("Node" + node.key + ": " + node.label);
        }
    }
}
