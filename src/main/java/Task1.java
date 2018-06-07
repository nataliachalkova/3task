/**
 * Написать программу, которая выводит числа от 1 до 100, но вместо чисел кратных 2
 * нужно выводить строку Two, вместо чисел кратных 7 - строку Seven, вместо чисел
 * кратных 2 и 7 - строку TwoSeven.
 */
public class Task1 {

    public static void main(String args[]) {

        for (int i = 1; i < 100; i++) {
            String out = String.valueOf(i);
            if (i % 2 == 0) {
                out = "Two";
                if (i % 7 == 0) {
                    out = "TwoSeven";
                }
            } else if (i % 7 == 0) {
                out = "Seven";
            }

            System.out.println(out);
        }
    }
}