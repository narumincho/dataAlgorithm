package ex12;

public class HashOpenAddressing {

    private MyKey[] table;
    private int bucketSize;

    public HashOpenAddressing() {
        this(23);
    }

    public HashOpenAddressing(int bucketSize) {
        this.bucketSize = bucketSize;
        this.table = new MyKey[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            this.table[i] = MyKey.empty();
        }
    }

    public int hash(String key) {
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum % bucketSize;
    }

    public int rehash(int hash) {
        return (hash + 1) % bucketSize;
    }

    public String search(String key) {
        int hashValue = this.hash(key);
        int firstHash = hashValue;
        while (true) {
            if (this.table[hashValue].equalFromKey(key)) {
                return this.table[hashValue].getData();
            }
            if (this.table[hashValue].isEmpty()) {
                return null;
            }
            hashValue = this.rehash(hashValue);
            if (firstHash == hashValue) {
                return null;
            }
        }
    }

    public boolean add(String key, String data) {
        int hashValue = this.hash(key);
        int firstHash = hashValue;
        while (true) {
            if (this.table[hashValue].isEmpty() || this.table[hashValue].isRemoved()) {
                this.table[hashValue] = new MyKey(key, data);
                return true;
            }
            hashValue = this.rehash(hashValue);
            if (firstHash == hashValue) {
                return false;
            }
        }
    }

    public boolean remove(String key) {
        int hashValue = this.hash(key);
        int firstHash = hashValue;
        while (true) {
            if (this.table[hashValue].equalFromKey(key)) {
                this.table[hashValue] = MyKey.removed();
                return true;
            }
            if (this.table[hashValue].isEmpty()) {
                return false;
            }
            hashValue = this.rehash(hashValue);
            if (firstHash == hashValue) {
                return false;
            }
        }
    }

    public String toString() {
        String outputText = "";
        int elementCount = 0;
        for (int i = 0; i < this.bucketSize; i++) {
            if(!this.table[i].isEmpty() && !this.table[i].isRemoved()){
                elementCount += 1;
            }
            outputText += "bucket" + i + ":" + this.table[i] + "\n";
        }
        return outputText + "要素数:" + elementCount;
    }

    public static void main(String[] args) {
        HashOpenAddressing bucket = new HashOpenAddressing(11);

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

        System.out.print("key:twoを探索: ");
        System.out.println(bucket.search("two"));
        System.out.println();

        System.out.print("key:fiveを探索: ");
        System.out.println(bucket.search("five"));
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

class MyKey {
    private Type type;
    private String key;
    private String data;

    static MyKey empty() {
        return new MyKey(Type.Empty, null, null);
    }

    static MyKey removed() {
        return new MyKey(Type.Removed, null, null);
    }

    public MyKey(String key, String data) {
        this.type = Type.Used;
        this.key = key;
        this.data = data;
    }

    private MyKey(Type type, String key, String data) {
        this.type = type;
        this.key = key;
        this.data = data;
    }

    public boolean isEmpty() {
        return this.type == Type.Empty;
    }

    public boolean isRemoved() {
        return this.type == Type.Removed;
    }

    public boolean equalFromKey(String key) {
        switch (this.type) {
            case Empty:
                return false;
            case Removed:
                return false;
            default:
                return this.key.equals(key);
        }
    }

    public String getData() {
        return this.data;
    }

    @Override
    public String toString() {
        switch (this.type) {
            case Empty:
                return "EMPTY";
            case Removed:
                return "REMOVED";
            default:
                return "key=[" + this.key + "] data=[" + this.data + "]";
        }
    }

    enum Type {
        Empty, Removed, Used
    }
}
