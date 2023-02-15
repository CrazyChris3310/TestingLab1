package function;

public class Calculator {

    public static final double PRECISION = 0.00001;

    private static double sinTaylorMember(double x, int n) {
        int sign = n % 2 == 0 ? 1 : -1;
        double res = sign * Math.pow(x, 2 * n + 1);
        return divideByFactorial(res, 2*n + 1);
    }

    private static double divideByFactorial(double res, int n) {
        for (int i = 1; i <= n; ++i) {
            res /= i;
        }
        return res;
    }

    public static double sin(double value) {
        double result = 0;
        double prev = 0;
        double current = Double.MAX_VALUE;
        int n = 0;
        while (Math.abs(current - prev) >= PRECISION) {
            prev = current;
            current = sinTaylorMember(value, n);
            result += current;
            n += 1;
        }
        return result;
    }

}
