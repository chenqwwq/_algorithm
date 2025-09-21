package top.chenqwwq.pat.advanced._1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/3/6
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        String input = scanner.readLine();

        // 分割
        String[] nums = input.split(" ");
        int sum = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);

        String ssum = String.valueOf(sum);
        int mod = ssum.length() % 3;

        // 分割是从右边开始的
        for (int i = 0; i < ssum.length(); i++) {
            // 负数
            char c = ssum.charAt(i);
            if (c == '-') {
                System.out.print(c);
                continue;
            }
            // 输出
            System.out.print(c);
            if (i == ssum.length() - 1) {
                System.out.println();
            } else if ((i + 1) % 3 == mod) {
                System.out.print(",");
            }
        }
    }
}
