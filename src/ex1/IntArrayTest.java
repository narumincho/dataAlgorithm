package ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IntArrayTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("配列の大きさを入れてください");
		int[] numbers = null;

		try {
			int n = scanner.nextInt();
			if (n <= 0) {
				System.out.println("0より大きな値を入れてください");
				return;
			}
			numbers = new int[n];

			System.out.println("整数値を" + n + "個入れてください。");
			for (int i = 0; i < n; i++) {
				System.out.println(i + "番目:");
				numbers[i] = scanner.nextInt();
			}

		} catch (InputMismatchException e) {
			System.out.println("数値の形式が違います。");
			e.printStackTrace();
			return;
		}
		System.out.println("入力された値は");
		System.out.println(arrayText(numbers));
		System.out.println("合計は" + sum(numbers));
		System.out.println("平均は" + average(numbers));

		scanner.close();
	}

	static String arrayText(int[] array) {
		String arrayText = "";
		for (int i = 0; i < array.length; i++) {
			arrayText += array[i] + "\t";
		}
		return arrayText;
	}

	static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	static double average(int[] array) {
		return ((double) sum(array)) / array.length;
	}
}
