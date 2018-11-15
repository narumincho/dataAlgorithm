package ex6;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest<E> extends HashSet<E> {
    static public void main(String[] args) {
        Set<String> set = new HashSetTest();
        set.add("Alice");
        set.add("Bob");
        set.add("Charlie");
        set.add("Diana");
        set.add("Elmo");
        set.add("Fred");
        set.add("Diana");
        set.add("Bob");
    }

    @Override
    public boolean add(E e) {
        boolean result = super.add(e);
        if (result) {
            System.out.println(e + "を追加");
        } else {
            System.out.println(e + "を追加(重複により変化なし)");
        }
        System.out.println(this);
        return result;
    }
}
