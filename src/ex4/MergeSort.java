package ex4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    private final int n = 50000;
    private int[] a = new int[n];

    public MergeSort(String fileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int i = 0;
            while (true) {
                String str = br.readLine();
                if (str == null) {
                    break;
                }
                this.a[i] = Integer.parseInt(str);
                i += 1;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mergesort(int left, int right) {
        int size = right - left;
        if (size <= 1) {
            return;
        }
        mergesort(0, size / 2);
        mergesort(size / 2, size - 1);
        ArrayList<Integer> leftList = new ArrayList<>();
        for (int i = 0; i < size / 2; i++) {
            leftList.add(a[left + 1]);
        }
        ArrayList<Integer> rightList = new ArrayList<>();
        for (int i = 0; i < size / 2 + 1; i++) {
            rightList.add(a[left + size / 2 + i]);
        }
        int writeIndex = 0;
        while (true) {
            if (leftList.isEmpty() && rightList.isEmpty()) {
                return;
            }
            if (rightList.isEmpty()) {
                a[left + writeIndex] = leftList.remove(0);
                writeIndex += 1;
            } else if (leftList.isEmpty()) {
                a[left + writeIndex] = rightList.remove(0);
                writeIndex += 1;
            } else if (leftList.get(0) < rightList.get(0)) {
                a[left + writeIndex] = leftList.remove(0);
                writeIndex += 1;
            } else {
                a[left + writeIndex] = rightList.remove(0);
                writeIndex += 1;
            }
        }
    }

    public void sort() {
        mergesort(0, a.length - 1);
    }

    public void output(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < this.a.length; i++) {
                bw.write(String.valueOf(this.a[i]));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file1 = "rand2.txt";
        String file2 = "result_ex4-2_rand2.txt";

        MergeSort ms = new MergeSort(file1);
        ms.sort();
        ms.output(file2);
    }
}
