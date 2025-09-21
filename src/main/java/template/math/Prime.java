package template.math;

import java.util.Arrays;

/**
 * 素数（质数）：除了1和本身没有别的数可以整除
 *
 * @author chenqwwq
 * @date 2024/2/27
 **/
public class Prime {
    // 埃氏筛
    private static final int N = 100001;
    private static final boolean[] isPrime = new boolean[N];

    static {
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        // 求出一个素数,任何素数的倍数都不是素数
        for (int i = 2; i * i < N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

}