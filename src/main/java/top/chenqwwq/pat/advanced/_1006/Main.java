package top.chenqwwq.pat.advanced._1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021-03-25
 **/
public class Main {

    private static Integer toSecond(String time) {
        final String[] t1 = time.split(":");
        return Integer.parseInt(t1[0]) * 3600 + Integer.parseInt(t1[1]) * 60 + Integer.parseInt(t1[2]);

    }

    public static void main(String[] args) throws IOException {
        // 输入
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 人数
        int cnt = Integer.parseInt(in.readLine());

        String i = "", o = "";
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (cnt-- > 0) {
            final String[] each = in.readLine().split(" ");
            String id = each[0];
            Integer lock = toSecond(each[1]), unlock = toSecond(each[2]);
            if (min > lock) {
                min = lock;
                i = id;
            }
            if (max < unlock) {
                max = unlock;
                o = id;
            }
        }
        System.out.printf("%s %s", i, o);
        System.out.println();
    }
}
