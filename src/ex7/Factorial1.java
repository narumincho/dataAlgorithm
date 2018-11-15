package ex7;

public class Factorial1 {
    public static int factorial(int x) {
        int value = 1;
        for (int i = 0; i < x; i++) {
            value *= (i + 1);
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println("繰り返しを使って階乗を求めます．");
        for (int i = 0; i < 6; i++) {
            System.out.println(i + "の階乗は" + factorial(i));
        }
    }
}
