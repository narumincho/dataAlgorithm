package ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class InsertionSort {
	private final int n = 50000;
	private int[] array = new int[n];

	public InsertionSort(String fileName) {
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
		for (int i = 1; i < this.array.length; i++) {
			int target = this.array[i];
			int j = i - 1;
			while (j > 0 && target < this.array[j] ) {
				this.array[j + 1] = this.array[j];
				j--;
			}
			this.array[j + 1] = target;
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
		String file2 = "result_ex3-3_rand2.txt";

		InsertionSort is = new InsertionSort(file1);
		is.sort();
		is.output(file2);
	}
}
