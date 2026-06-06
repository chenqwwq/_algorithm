package top.chenqwwq.pat.advanced._1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/3/6
 * @see <a href="https://pintia.cn/problem-sets/994805342720868352/problems/994805526272000000"></a>
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        float[] hash = new float[1001];
        int cnt = 0;
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        // 读取两行输入
        for (int q = 0; q < 2; q++) {
            String line = scanner.readLine();
            final String[] str = line.split(" ");
            int num = Integer.parseInt(str[0]);
            for (int i = 1; i < str.length && num-- > 0; ) {
                final int coefficient = Integer.parseInt(str[i++]);
                final float exponent = Float.parseFloat(str[i++]);
                if (hash[coefficient] == 0.0) {
                    cnt++;
                }
                hash[coefficient] += exponent;
                if (hash[coefficient] == 0.0) {
                    cnt--;
                }
            }
        }
        System.out.printf("%d", cnt);
        for (int i = 1000; i >= 0; i--) {
            if (hash[i] != 0.0) {
                System.out.printf(" %d %.1f", i, hash[i]);
            }
        }
    }
}
