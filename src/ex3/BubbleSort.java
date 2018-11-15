package ex3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BubbleSort {
	private final int n = 50000;
	private int[] array = new int[n];

	public BubbleSort(String fileName) {
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
		for (int j = this.array.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				final int left = this.array[i];
				final int right = this.array[i + 1];
				if (left > right) {
					this.array[i] = right;
					this.array[i + 1] = left;
				}
			}
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
		String file2 = "result_ex3-1_rand2.txt";

		BubbleSort bs = new BubbleSort(file1);
		bs.sort();
		bs.output(file2);
	}
}
