package ex10;

public class BTNode {
    private String label;
    private BTNode left;
    private BTNode right;

    public BTNode(String label, BTNode left, BTNode right) {
        this.label = label;
        this.left = left;
        this.right = right;
    }

    public void printNode() {
        printNode("");
    }

    public void printNode(String prefix) {
        if (this.left != null) {
            this.left.printNode(prefix + "        ");
        }
        System.out.println(prefix + this);
        if (this.right != null) {
            this.right.printNode(prefix + "        ");
        }
    }

    public BTNode search(String name) {
        System.out.println(this);
        if (name == this.label) {
            return this;
        }
        if (this.left != null) {
            BTNode leftResult = this.left.search(name);
            if (leftResult != null) {
                return leftResult;
            }
        }
        if (this.right != null) {
            return this.right.search(name);
        }
        return null;
    }

    public String toString() {
        return "[" + this.label + "]";
    }

    public static void main(String[] args) {
        BTNode tree =
                new BTNode("A",
                        new BTNode("B",
                                new BTNode("C", null, null),
                                new BTNode("E", null, null)
                        ),
                        new BTNode("D",
                                new BTNode("F", null, null),
                                new BTNode("G", null, null)
                        )
                );
        tree.printNode();
        System.out.println("Aを探す");
        System.out.println("あった? " + tree.search("A"));

        System.out.println("Bを探す");
        System.out.println("あった? " + tree.search("B"));

        System.out.println("Cを探す");
        System.out.println("あった? " + tree.search("C"));

        System.out.println("Dを探す");
        System.out.println("あった? " + tree.search("D"));

        System.out.println("Eを探す");
        System.out.println("あった? " + tree.search("E"));

        System.out.println("Fを探す");
        System.out.println("あった? " + tree.search("F"));

        System.out.println("Gを探す");
        System.out.println("あった? " + tree.search("G"));

        System.out.println("Zを探す");
        System.out.println("あった? " + tree.search("Z"));
    }
}
