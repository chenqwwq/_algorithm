package template.math;

/**
 * @author 沽酒
 * @since 2023/06/13
 */
public class Qpow {

    /**
     * 类似于 {@link Math#pow(double, double)}
     */
    public long pow(long base, long n) {
        if (n == 0) return 1;
        else if (n == 1) return base;
        if (base == 0) return 0;

        return (n & 1) == 1
                ? pow(base * base, n >> 1)
                : base * pow(base * base, n >> 1);
    }

    public static void main(String[] args) {
        final Qpow qp = new Qpow();

        System.out.println(qp.pow(2,4));
    }
}
