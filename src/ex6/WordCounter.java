package ex6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String, Integer> map = new HashMap<>();
        Arrays.asList(sb.toString().split("\\s")).forEach(s -> map.merge(s.toLowerCase(), 1, (a, b) -> a + b));
        map.forEach((k, c) -> System.out.println(k + "→" + c));
    }
}
