package ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SelectionSort {
	private final int n = 50000;
	private int[] array = new int[n];

	public SelectionSort(String fileName) {
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

	public void sort() {
		for (int i = 0; i < this.array.length; i++) {
			int minValue = this.array[i];
			int minIndex = i;
			for (int j = i + 1; j < this.array.length; j++) {
				if (this.array[j] < minValue) {
					minValue = this.array[j];
					minIndex = j;
				}
			}
			this.array[minIndex] = this.array[i] ;
			this.array[i] = minValue;
		}
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

	public static void main(String[] args) {
		String file1 = "rand2.txt";
		String file2 = "result_ex3-2_rand2.txt";

		SelectionSort ss = new SelectionSort(file1);
		ss.sort();
		ss.output(file2);
	}
}
