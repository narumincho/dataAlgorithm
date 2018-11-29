package ex11;

import java.util.Scanner;
import java.util.Stack;

public class MathFormulaTree {
    private MathFormulaTree left;
    private MathFormulaTree right;
    private String label;

    public static MathFormulaTree createFromReversePolish(String equation) {
        // 逆ポーランド記法で書かれた式の文字列から数式の木を作る．
        // スタックを使用するが，スタックの要素は文字列や数値ではなく数式の木（部分木）を用いる．
        Stack<MathFormulaTree> stack = new Stack<>();
        Scanner scanner = new Scanner(equation);
        while (scanner.hasNext()) {
            String elem = scanner.next();
            try {
                Integer.parseInt(elem);
                stack.push(new MathFormulaTree(null, null, elem));
            } catch (NumberFormatException e) {
                final MathFormulaTree left = stack.pop();
                final MathFormulaTree right = stack.pop();
                stack.push(new MathFormulaTree(left, right, elem));
            }
        }
        scanner.close();
        return stack.pop();
    }

    private MathFormulaTree(MathFormulaTree left, MathFormulaTree right, String label) {
        // ここは createFromReversePolish() から呼び出して使用される．
        this.left = left;
        this.right = right;
        this.label = label;
    }

    public void printTree() {
        printTree("");
    }

    public void printTree(String prefix) {
        if (right != null) {
            right.printTree(prefix + "    ");
        }
        System.out.println(prefix + "[" + label + "]");
        if (left != null) {
            left.printTree(prefix + "    ");
        }
    }

    public String toPolish() {
        if (this.left == null || this.right == null) {
            return this.label;
        }
        return this.label + " " + this.left.toPolish() + " " + this.right.toPolish();
    }

    public static void main(String[] args) {
        String input = "2 6 * 5 3 + *";
        MathFormulaTree tree = MathFormulaTree.createFromReversePolish(input);
        System.out.println("数式の木");
        tree.printTree();
        System.out.println("変換結果");
        System.out.println(tree.toPolish());
    }
}
