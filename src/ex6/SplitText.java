package ex6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

public class SplitText {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader("english.txt"));
            while (true) {
                String str = br.readLine();
                if (str == null) {
                    break;
                }
                sb.append(str);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.asList(sb.toString().split("\\s")).forEach(s ->
                System.out.println(s)
        );
    }
}
