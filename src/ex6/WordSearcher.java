package ex6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordSearcher {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        dictionary.put("Rust", "enum Card {\n  Joker,\n  Heart {n: N},\n  Spade {n: N}, \n  Club {n: N},\n  Diamond {n: N}\n}\n enum N{\n  A,\n  N2,\n  N3,\n  N4,\n  N5,\n  N6,\n  N7,\n  N8,\n  N9,\n  N10,\n  J,\n  Q,\n  K\n}");
        dictionary.put("Swift", "enum Card {\n  case Joker, Heart(n: N), Spade(n: N), Club(n: N), Diamond(n: N)\n}\n\nenum N {\n  case A, N2, N3, N4, N5, N6, N7, N8, N9, N10, J, Q, K\n}");
        dictionary.put("Elm", "type Card\n    = Joker\n    | Heart { n : N }\n    | Spade { n : N }\n    | Club { n : N }\n    | Diamond { n : N }\n\ntype N\n    = A\n    | N2\n    | N3\n    | N4\n    | N5\n    | N6\n    | N7\n    | N8\n    | N9\n    | N10\n    | J\n    | Q\n    | K");

        System.out.println("プログラミング言語の名前を入力してください("+dictionary.keySet()+"のどれか)");
        Scanner scanner = new Scanner(System.in);
        String inputString;
        while ((inputString = scanner.next()) != null) {
            String description = dictionary.get(inputString);
            if (description == null) {
                System.out.println(inputString + "という言語の代数的データ型の定義方法を知らない");
            } else {
                System.out.println(inputString + "という言語の代数的データ型の定義方法は\n" + description);
            }
        }
    }
}
