package ex13;

public class BinarySearchTree {
    private int data;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinarySearchTree(int data, BinarySearchTree left, BinarySearchTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Nodeを上書き
     */
    public void set(BinarySearchTree btNode) {
        this.data = btNode.data;
        this.left = btNode.left;
        this.right = btNode.right;
    }

    public void printNode() {
        printNode("");
    }

    private void printNode(String prefix) {
        if (this.right != null) {
            this.right.printNode(prefix + "\t");
        }
        System.out.println(prefix + this.data);
        if (this.left != null) {
            this.left.printNode(prefix + "\t");
        }
    }

    /**
     * Nodeを探す(非破壊的)
     */
    public BinarySearchTree search(int key) {
        if (this.data == key) {
            return this;
        }
        if (key < this.data) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(key);
        }
        if (this.right == null) {
            return null;
        }
        return this.right.search(key);
    }

    /**
     * Nodeを追加(破壊的!)
     */
    public void add(int key) {
        this.set(this.insert(key));
    }

    /**
     * Nodeを追加(非破壊的)
     */
    private BinarySearchTree insert(int key) {
        if (this.data == key) {
            return this;
        }
        if (key < this.data) {
            if (this.left == null) {
                return new BinarySearchTree(this.data, new BinarySearchTree(key), this.right);
            }
            return new BinarySearchTree(this.data, this.left.insert(key), this.right);
        }
        if (this.right == null) {
            return new BinarySearchTree(this.data, this.left, new BinarySearchTree(key));
        }
        return new BinarySearchTree(this.data, this.left, this.right.insert(key));
    }

    /**
     * Nodeを削除(破壊的!)
     */
    public boolean remove(int key) {
        boolean isExist = this.search(key) != null;
        this.set(this.delete(key));
        return isExist;
    }

    /**
     * Nodeを削除(非破壊的)
     */
    public BinarySearchTree delete(int key) {
        if (key < this.data) {
            return new BinarySearchTree(this.data, this.left.delete(key), this.right);
        }
        if (this.data < key) {
            return new BinarySearchTree(this.data, this.left, this.right.delete(key));
        }
        if (this.left == null) {
            return this.right;
        }
        if (this.right == null) {
            return this.left;
        }
        return new BinarySearchTree(this.right.min().data, this.left, this.right.deleteMin());
    }

    /**
     * 最小のNodeを削除(非破壊的)
     */
    private BinarySearchTree deleteMin() {
        if (this.left == null) {
            return this.right;
        }
        return new BinarySearchTree(this.data, this.left.deleteMin(), this.right);
    }

    /**
     * 最小のNodeを取得
     */
    public BinarySearchTree min() {
        if (this.left == null) {
            return this;
        }
        return this.left.min();
    }

    /**
     * 最大のNodeを取得
     */
    public BinarySearchTree max() {
        if (this.right == null) {
            return this;
        }
        return this.right.max();
    }

    /**
     * 最小のものから並べた文字列
     */
    public String traverse() {
        if (this.left == null && this.right == null) {
            return String.valueOf(this.data);
        }
        if (this.left == null) {
            return this.right.traverse() + "->" + this.data;
        }
        if (this.right == null) {
            return this.data + "->" + this.left.traverse();
        }
        return this.left.traverse() + "->" + this.data + "->" + this.right.traverse();
    }

    public static void main(String[] args) {
        System.out.println("二分探索木の作成");
        BinarySearchTree root0 = new BinarySearchTree(13);

        root0.add(5);
        root0.add(21);
        root0.add(15);
        root0.add(7);
        root0.add(2);
        root0.add(6);

        root0.printNode();

        System.out.print("ノード3を探索:");
        BinarySearchTree result = root0.search(3);
        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("探索失敗");
        }

        System.out.print("ノード5を探索:");
        result = root0.search(5);
        if (result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("探索失敗");
        }

        System.out.println("ノード8を追加");
        root0.add(8);
        root0.printNode();


        System.out.println("子を1つだけ持ったノードの削除");
        BinarySearchTree root1 = new BinarySearchTree(9);

        root1.add(14);
        root1.add(5);
        root1.add(3);
        root1.add(4);
        root1.add(1);
        root1.add(14);
        root1.printNode();

        System.out.println("ノード5を削除");
        if (root1.remove(5)) {
            System.out.println("削除成功");
        }
        root1.printNode();


        System.out.println("子を2つ持ったノードの削除");
        BinarySearchTree root2 = new BinarySearchTree(20);

        root2.add(23);
        root2.add(29);
        root2.add(7);
        root2.add(18);
        root2.add(4);
        root2.add(2);
        root2.add(5);
        root2.add(10);
        root2.add(15);
        root2.printNode();

        System.out.println("ノード7を削除");
        if (root2.remove(7)) {
            System.out.println("削除成功");
        }
        root2.printNode();
    }
}
