package ex3;

public class TestSort {
	public static void main(String[] args) {
		String[] fileList = { "rand2.txt", "sorted2.txt", "reverse2.txt", "same2.txt" };
		for (int i = 0; i < fileList.length; i++) {
			final BubbleSort bubbleSort = new BubbleSort(fileList[i]);
			final SelectionSort selectionSort = new SelectionSort(fileList[i]);
			final InsertionSort insertionSort = new InsertionSort(fileList[i]);

			System.out.println(fileList[i] + "のソート");
			final long bubbleStart = System.currentTimeMillis();
			bubbleSort.sort();
			System.out.println("バブルソート:" + (System.currentTimeMillis() - bubbleStart)+ "[ms]");

			final long selectionStart = System.currentTimeMillis();
			selectionSort.sort();
			System.out.println("  選択ソート:" + (System.currentTimeMillis() - selectionStart)+ "[ms]");

			final long insertionStart = System.currentTimeMillis();
			insertionSort.sort();
			System.out.println("  挿入ソート:" + (System.currentTimeMillis() - insertionStart)+ "[ms]");
		}
	}
}
