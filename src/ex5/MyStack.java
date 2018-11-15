package ex5;

public class MyStack {
    private String[] stack; // 要素を入れる配列
    private int sp;       // 空き場所を指すインデックス
    private static final int MAX_SIZE = 10; // スタックの最大サイズ

    public MyStack() {
        // スタック用配列の初期化
        stack = new String[this.MAX_SIZE];
        // スタックポインタの初期化
        this.sp = 0;
    }

    public void push(String str) {
        if(this.MAX_SIZE <= this.sp){
            System.out.println("最大サイズ"+this.MAX_SIZE+"を超えてしまった");
            return;
        }
        this.stack[this.sp] = str;
        this.sp += 1;
    }

    public String pop() {
        if(this.sp<=0){
            System.out.println("スタックが空だ(pop呼び出し時)");
            return null;
        }
        this.sp -= 1;
        return this.stack[this.sp];
    }

    public String peek() {
        if(this.sp<=0){
            System.out.println("スタックが空だ(peek呼び出し時)");
            return null;
        }
        return this.stack[this.sp - 1];
    }

    public boolean empty() {
        return this.sp <= 0;
    }

    public String toString() {
        // スタックの文字列表現
        String str = "aMyStack(";
        for (int i = 0; i < sp; i++) {
            str = str + stack[i] + " ";
        }
        str = str + ")";
        return str;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        System.out.println("スタックにプッシュ");
        System.out.println(stack);
        stack.push("abc");
        stack.push("def");
        stack.push("ghi");
        stack.push("jkl");
        System.out.println(stack);
        stack.push("mno");
        stack.push("pqr");
        System.out.println(stack);
        System.out.println("peekしてみる: " + stack.peek());
        System.out.println("スタックからポップ");
        while (!stack.empty()) {
            System.out.println(stack.pop() + "を取り出した．");
            System.out.println(stack);
        }
        // 以下はエラーチェック用
        System.out.println("エラーを出してみる．");
        System.out.println(stack);
        stack.pop();       // 空のはずなのにpop!
        stack.peek();      // 空のはずなのにpeek!
        System.out.println(stack);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        System.out.println(stack);
        stack.push("10");
        System.out.println(stack);
        stack.push("11");       // 一杯なはずなのにpush!
        System.out.println(stack);
    }
}
