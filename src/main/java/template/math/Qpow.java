package template.math;

/**
 * 快速幂（快速求 base ^ n
 *
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
}
