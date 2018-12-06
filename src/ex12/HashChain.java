package ex12;

public class HashChain {
    private class MyKey {
        String key;
        String data;
        MyKey next;

        public MyKey(String key, String data) {
            this.key = key;
            this.data = data;
        }

        public boolean isAlreadySetted(String key) {
            if (this.key.equals(key)) {
                return true;
            }
            if (this.next == null) {
                return false;
            }
            return this.next.isAlreadySetted(key);
        }

        public boolean remove(String myKey) {
            if (this.next == null) {
                return false;
            }
            if (this.next.key == myKey) {
                this.next = this.next.next;
                return true;
            }
            return this.next.remove(myKey);
        }

        public String getDataFromKey(String key) {
            if (this.key.equals(key)) {
                return this.data;
            }
            if (this.next == null) {
                return null;
            }
            return this.next.getDataFromKey(key);
        }
    }

    private MyKey[] table;
    private int bucketSize;

    public HashChain() {
        this(10);
    }

    public HashChain(int bucketSize) {
        this.bucketSize = bucketSize;
        this.table = new MyKey[this.bucketSize];
    }

    public int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % bucketSize;
    }

    public String search(String key) {
        int hashValue = this.hash(key);
        if (this.table[hashValue] == null) {
            return null;
        }
        return this.table[hashValue].getDataFromKey(key);
    }

    public boolean add(String key, String data) {
        int hashValue = this.hash(key);
        MyKey target = this.table[hashValue];
        if (target == null) {
            this.table[hashValue] = new MyKey(key, data);
            return true;
        }
        MyKey newMyKey = new MyKey(key, data);
        newMyKey.next = target;
        this.table[hashValue] = newMyKey;
        return target.isAlreadySetted(key);
    }

    public boolean remove(String key) {
        int hashValue = this.hash(key);
        MyKey target = this.table[hashValue];
        if (target == null) {
            return false;
        }
        if (target.key == key) {
            this.table[hashValue] = target.next;
            return true;
        }
        return target.remove(key);
    }

    public String toString() {
        String s = "";
        int n = 0;

        for (int i = 0; i < table.length; i++) {
            s += "bucket" + i + ":";
            for (MyKey p = table[i]; p != null; p = p.next) {
                n += 1;
                s += "[" + p.key + ":" + p.data + "] ";
            }
            s += "\n";
        }
        s += "要素数:" + n + "\n";
        return s;
    }

    public static void main(String[] args) {
        HashChain bucket = new HashChain();

        bucket.add("one", "one1");
        bucket.add("two", "two2");
        bucket.add("three", "three3");
        bucket.add("four", "four4");
        bucket.add("five", "five5");
        bucket.add("six", "six6");
        bucket.add("seven", "seven7");

        System.out.println(bucket.toString());

        System.out.print("key:fiveを探索: ");
        System.out.println(bucket.search("five"));
        System.out.println();

        System.out.println("key:threeを削除");
        if (bucket.remove("three")) {
            System.out.println(bucket.toString());
        }

        System.out.print("key:threeを探索: ");
        System.out.println(bucket.search("three"));
        System.out.println();

        bucket.add("eight", "eight8");
        bucket.add("nine", "nine9");
        bucket.add("ten", "ten10");

        System.out.println(bucket.toString());

        System.out.println("key:nineを削除");
        if (bucket.remove("nine")) {
            System.out.println(bucket.toString());
        }
    }
}
