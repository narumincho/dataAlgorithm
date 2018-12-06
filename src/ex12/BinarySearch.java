package ex12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BinarySearch {
    private final int n = 9999;
    private int[] table = new int[n];

    public BinarySearch(String fileName) {
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
        int left = 0;
        int right = n - 1;
        int searchNum = 0;
        while (true) {
            if (right <= left) {
                System.out.println((searchNum + 1) + "回探索しましたが" + key + "は見つかりませんでした");
                return;
            }
            int centerIndex = (left + right) / 2;
            int centerValue = table[centerIndex];
            if (centerValue == key) {
                System.out.println((searchNum + 1) + "回の探索で" + key + "が見つかりました");
                return;
            }
            if (centerValue < key) {
                left = centerIndex + 1;
            } else {
                right = centerIndex - 1;
            }
            searchNum += 1;
        }
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.println(i + "=" + table[i]);
        }
    }

    public static void main(String[] args) {
        BinarySearch table = new BinarySearch("sorted.txt");

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
