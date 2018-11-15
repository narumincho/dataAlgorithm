package ex4;

import java.io.*;

public class QuickSort {
    private final int n = 50000;
    private int[] array = new int[n];

    public QuickSort(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            int i = 0;
            while (true) {
                String str = br.readLine();
                if (str == null) {
                    break;
                }
                this.array[i] = Integer.parseInt(str);
                i += 1;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int partition(int left, int right) {
        int biggerThanTargetIndex;
        while(true) {
            int target = this.array[right];
            int i = left;
            while (true) {
                if (target < this.array[i]) {
                    biggerThanTargetIndex = i;
                    break;
                }
                i++;
                if (right <= i) {
                    return right;
                }
            }
            i = right - 1;
            int smallThanTargetIndex;
            while (true) {
                if (this.array[i] < target) {
                    smallThanTargetIndex = i;
                    break;
                }
                i--;
                if (i <= left) {
                    for (int j = right - 1; j > left; j--) {
                        this.array[j] = this.array[j - 1];
                    }
                    this.array[left] = target;
                    return left;
                }
            }
            if (smallThanTargetIndex <= biggerThanTargetIndex) {
                this.array[right] = this.array[biggerThanTargetIndex];
                this.array[biggerThanTargetIndex] = target;
                break;
            }
            int biggerThanTargetValue = this.array[biggerThanTargetIndex];
            this.array[biggerThanTargetIndex] = this.array[smallThanTargetIndex];
            this.array[smallThanTargetIndex] = biggerThanTargetValue;
        }
        return biggerThanTargetIndex;
    }

    private void quickSort(int left, int right){
        if(right<=left){
            return;
        }
        int newPivotIndex = partition(left, right);
        System.out.println(newPivotIndex);
        quickSort(left, newPivotIndex - 1);
        quickSort(newPivotIndex + 1, right);
    }

    public void sort() {
        quickSort(0, array.length - 1);
    }

    public void output(String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < this.array.length; i++) {
                bw.write(String.valueOf(this.array[i]));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void  main(String[] args){
        String file1 = "rand2.txt";
        String file2 = "result_ex4-1_sorted2.txt";

        QuickSort qs = new QuickSort(file1);
        qs.sort();
        qs.output(file2);
    }
}
