package ex11;

public class MyLinkedList {

    private Element head; // 先頭
    private Element tail; // 末尾

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        int count = 0;
        Element element = this.head;
        while (element != null) {
            element = element.getNext();
            count += 1;
        }
        return count;
    }

    public void addFirst(String str) {
        if (head == null) {
            head = new Element(str);
            tail = head;
            return;
        }
        Element element = new Element(str);
        element.setNext(this.head);
        this.head.setPrevious(element);
        this.head = element;
    }

    public void addLast(String str) {
        if (head == null) {
            head = new Element(str);
            tail = head;
            return;
        }
        Element element = new Element(str);
        element.setPrevious(this.tail);
        this.tail.setNext(element);
        this.tail = element;
    }

    public void add(int index, String str) {
        int size = this.size();
        if (index < 0 || size < index) {
            System.out.println("インデックスが範囲外です");
            return;
        }
        if (index == 0) {
            this.addFirst(str);
            return;
        }
        if (index == size) {
            this.addLast(str);
        }
        Element element = this.head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Element insertElement = new Element(str);
                Element prevElement = element.getPrevious();
                prevElement.setNext(insertElement);
                insertElement.setPrevious(prevElement);
                insertElement.setNext(element);
                element.setPrevious(insertElement);
                return;
            }
            element = element.getNext();
        }
    }

    public String removeFirst() {
        if (head == null) {
            System.out.println("削除する要素がありません．");
            return null;
        }
        if (head.getNext() == null) {
            Element target = head;
            head = null;
            tail = null;
            return target.getData();
        }
        String headData = this.head.getData();
        this.head = this.head.getNext();
        this.head.setPrevious(null);
        return headData;
    }

    public String removeLast() {
        if (head == null) {
            System.out.println("削除する要素がありません．");
            return null;
        }
        if (head.getNext() == null) {
            Element target = head;
            head = null;
            tail = null;
            return target.getData();
        }
        String tailData = this.tail.getData();
        this.tail = this.tail.getPrevious();
        this.tail.setNext(null);
        return tailData;
    }

    public String remove(int index) {
        int size = this.size();
        if (index < 0 || size <= index) {
            System.out.println("インデックスが範囲外です．");
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Element element = this.head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                Element prevElement = element.getPrevious();
                Element nextElement = element.getNext();
                prevElement.setNext(nextElement);
                nextElement.setPrevious(prevElement);
                return element.getData();
            }
            element = element.getNext();
        }
        return null;
    }

    public boolean contains(String str) {
        // 要素が含まれているかどうか返す
        // 要素がないならfalse
        if (head == null) {
            return false;
        }
        Element element = this.head;
        while (element!=null){
            if(element.getData().equals(str)){
                return true;
            }
            element = element.getNext();
        }
        return false;
    }

    public void print() {
        // 要素を先頭から表示
        System.out.print("リスト順: ");
        if (head == null) {
            System.out.println("null");
            return;
        }
        Element p = head;
        while (p != null) {
            System.out.print(p + " -> ");
            p = p.getNext();
        }
        System.out.println("null");
    }

    public void printReverse() {
        // 要素を末尾から表示
        System.out.print("リスト逆: ");
        if (tail == null) {
            System.out.println("null");
            return;
        }
        Element p = tail;
        while (p != null) {
            System.out.print(p + " -> ");
            p = p.getPrevious();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // いろいろと試す
        System.out.println("リストの生成");
        MyLinkedList list = new MyLinkedList();
        list.print();
        System.out.println("サイズ: " + list.size());
        System.out.println("dを先頭に追加");
        list.addFirst("d");
        list.print();
        System.out.println("サイズ: " + list.size());
        System.out.println("cを先頭に追加");
        list.addFirst("c");
        list.print();
        System.out.println("eを最後に追加");
        list.addLast("e");
        list.print();
        list.printReverse();
        System.out.println("bを先頭に追加");
        list.addFirst("b");
        list.print();
        System.out.println("fを最後に追加");
        list.addLast("f");
        list.print();
        list.printReverse();
        System.out.println("fが含まれているか?: " + list.contains("f"));
        System.out.println("bが含まれているか?: " + list.contains("b"));
        System.out.println("dが含まれているか?: " + list.contains("d"));
        System.out.println("zが含まれているか?: " + list.contains("z"));
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("最後を削除");
        list.removeLast();
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("最後を削除");
        list.removeLast();
        list.print();
        System.out.println("先頭を削除");
        list.removeFirst();
        list.print();
        System.out.println("0番目にdを追加");
        list.add(0, "d");
        list.print();
        System.out.println("0番目にbを追加");
        list.add(0, "b");
        list.print();
        System.out.println("2番目にfを追加");
        list.add(2, "f");
        list.print();
        System.out.println("1番目にcを追加");
        list.add(1, "c");
        list.print();
        System.out.println("3番目にeを追加");
        list.add(3, "e");
        list.print();
        System.out.println("5番目にgを追加");
        list.add(5, "g");
        list.print();
        list.printReverse();
        System.out.println("0番目を削除");
        list.remove(0);
        list.print();
        System.out.println("4番目を削除");
        list.remove(4);
        list.print();
        System.out.println("1番目を削除");
        list.remove(1);
        list.print();
        System.out.println("2番目を削除");
        list.remove(2);
        list.print();
        list.printReverse();
        System.out.println("1番目を削除");
        list.remove(1);
        list.print();
        System.out.println("0番目を削除");
        list.remove(0);
        list.print();
        System.out.println("end.");
    }
}
