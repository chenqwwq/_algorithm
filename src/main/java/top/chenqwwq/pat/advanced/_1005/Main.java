package top.chenqwwq.pat.advanced._1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/3/25
 **/
public class Main {
    private static String[] dict = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String num = in.readLine();
        long sum = 0L;
        for (Character c : num.toCharArray()) {
            sum += (c - '0');
        }
        char[] chars = String.valueOf(sum).toCharArray();
        System.out.printf("%s", dict[chars[0] - '0']);
        for (int i = 1; i < chars.length; i++) {
            System.out.printf(" %s", dict[chars[i] - '0']);
        }
        System.out.println();
    }
}
