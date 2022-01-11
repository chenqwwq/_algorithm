package top.chenqwwq.pat.advanced._1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/3/27
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        // 输入
        final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        float[] ans = new float[2001], first = new float[1001];

        // 低于贵】
        final String[] firstLine = in.readLine().split(" ");
        int cnt = Integer.parseInt(firstLine[0]);
        for (int i = 1; i < 2 * cnt; ) {
            first[Integer.parseInt(firstLine[i++])] = Float.parseFloat(firstLine[i++]);
        }

        // 读取第二行并且相乘
        final String[] second = in.readLine().split(" ");
        cnt = Integer.parseInt(second[0]);
        for (int i = 1; i < 2 * cnt; ) {
            // coefficient * X ^ expoonent
            int exponent = Integer.parseInt(second[i++]);
            float coefficient = Float.parseFloat(second[i++]);
            // 指数相加，系数相乘
            for (int j = 0; j <= 1000; j++) {
                ans[j + exponent] += first[j] * coefficient;
            }
        }

        int num = 0;
        for (double d : ans) {
            if (d != 0.0d) {
                num++;
            }
        }
        System.out.printf("%d", num);
        for (int i = 2000; i >= 0; i--) {
            if (ans[i] != 0.0d) {
                System.out.printf(" %d %.1f", i, ans[i]);
            }
        }
        System.out.println();
    }
}
