package ex1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IntArrayListTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayList<Integer> intList = new ArrayList<Integer>();
		try {
			System.out.println("整数値を入力してください。整数以外を入力するまで繰り返します。");
			int i = 0;
			while (true) {
				System.out.println(i + "番目:");
				intList.add(scanner.nextInt());
				i += 1;
			}
		} catch (InputMismatchException e) {
			System.out.println("入力が完了しました。データの数は" + intList.size());
		}
		System.out.println("入力された値は");
		System.out.println(toString(intList));

		System.out.println("合計は" + sum(intList));
		System.out.println("平均は" + average(intList));

		scanner.close();
	}

	static String toString(ArrayList<Integer> list) {
		String text = "";
		for (int item : list) {
			text += item + "\t";
		}
		return text;
	}

	static int sum(ArrayList<Integer> list) {
		int sum = 0;
		for(int item: list) {
			sum += item;
		}
		return sum;
	}

	static double average(ArrayList<Integer> list) {
		return ((double)sum(list)) / list.size();
	}
}
