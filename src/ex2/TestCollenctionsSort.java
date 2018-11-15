package ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class TestCollenctionsSort {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		String file0 = "rand2.txt";
		String file1 = "result_ex2-1.txt";

		try {
			BufferedReader br = new BufferedReader(new FileReader(file0));
			while (true) {
				String str = br.readLine();
				if (str == null) {
					break;
				}
				list.add(str);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(list);

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
			for (String item : list) {
				bw.write(item);
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
