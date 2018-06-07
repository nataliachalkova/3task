import java.math.BigInteger;

/**
 * Написать программу, вычисляющую для любых натуральных m и r, таких что r ≤ m, значение функции
 * f(m,r)=m!/r!(m-r)!
 */

/**
 * Предположения: разность m-r в знаменателе и эта формула числа сочетаний.
 * Формулу Стирлинга для оценки значения использовать нецелесообразно при вычислениях.
 */
public class Task2 {

    public static void main(String args[]) {

        BigInteger m, r;
        m = BigInteger.valueOf(10);
        r = BigInteger.valueOf(3);

        BigInteger result = factorial(m, r);

        System.out.println(result);
    }

    /**
     * Вычисляет факториал m!/(r!(m-r)!)
     */
    private static BigInteger factorial(BigInteger m, BigInteger r) {

        if (r.signum() == -1 || m.signum() == -1) {
            throw new IllegalArgumentException("Numbers m and r must be positive");
        }
        if (r.compareTo(m) == 1) {
            throw new IllegalArgumentException("r must be less or equal than m");
        }

        BigInteger rm = m.subtract(r); //r - m
        BigInteger mFactorial = BigInteger.ONE;
        BigInteger rFactorial = BigInteger.ONE;
        BigInteger mrFactorial = BigInteger.ONE;

        BigInteger i = BigInteger.ONE;

        while (i.compareTo(m) <= 0) {
            mFactorial = mFactorial.multiply(i);
            if (i.compareTo(r) == 0) {
                rFactorial = mFactorial;
            }
            if (i.compareTo(rm) == 0) {
                mrFactorial = mFactorial;
            }
            i = i.add(BigInteger.ONE);
        }
        return mFactorial.divide(rFactorial.multiply(mrFactorial));
    }

}