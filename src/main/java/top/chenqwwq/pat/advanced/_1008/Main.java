package top.chenqwwq.pat.advanced._1008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/3/25
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        // 输入
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = in.readLine().split(" ");

        int cnt = Integer.parseInt(line[0]);
        int curr = 0, ans = 0;
        for (int i = 1; i <= cnt; i++) {
            final int target = Integer.parseInt(line[i]);
            if (target > curr) {
                ans += (target - curr) * 6;
            } else if (target < curr) {
                ans += (curr - target) * 4;
            }
            curr = target;
        }

        System.out.printf("%d\n", ans + cnt * 5);
    }
}
