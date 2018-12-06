package ex12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LinearSearch {
    private final int n = 9999;
    private int[] table = new int[n];

    public LinearSearch(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            for (int i = 0; i < n; i++) {
                table[i] = (Integer.parseInt(br.readLine()));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(fileName + "が見つかりません。");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void search(int key) {
        for (int i = 0; i < n; i++) {
            if (key == table[i]) {
                System.out.println(i + "回の探索で" + key + "が見つかりました");
                return;
            }
        }
        System.out.println(key + "は見つかりませんでした");
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.println(i + "=" + table[i]);
        }
    }

    public static void main(String[] args) {
        // 以下の3行のいずれかを使う
        String filename = "rand.txt";
        //String filename = "reverse.txt";
        //String filename = "sorted.txt";

        LinearSearch table = new LinearSearch(filename);
        table.show();
        System.out.println("key=1000を探索");
        table.search(1000);
        System.out.println("key=9412を探索");
        table.search(9412);
        System.out.println("key=2を探索");
        table.search(2);
        System.out.println("key=10000を探索");
        table.search(10000);
    }
}
