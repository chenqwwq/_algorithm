package top.chenqwwq.pat.advanced._1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021-03-25
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        // 输入
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        final int cnt = Integer.parseInt(in.readLine());
        if (cnt == 0) {
            System.out.printf("%d %d %d\n", 0, 0, 0);
            return;
        }
        final String[] str = in.readLine().split(" ");

        // dp[i] 表示以 str[i] 为末尾的最大和
        // dp[i] = Math.max(dp[i-1]+curr,curr)
        int pre = 0, max = -1, ms = 0, me = str.length - 1, cs = 0;

        for (int i = 0; i < cnt; i++) {
            // pre 表示以当前下标为末尾的子序列的最大和
            pre += Integer.parseInt(str[i]);
            if (pre < 0) {
                pre = 0;
                cs = i + 1;
            } else if (pre > max) {
                max = pre;
                ms = cs;
                me = i;
            }
        }

        if (max < 0) {
            max = 0;
        }

        System.out.printf("%d %d %d\n", max, Integer.parseInt(str[ms]), Integer.parseInt(str[me]));
    }
}
