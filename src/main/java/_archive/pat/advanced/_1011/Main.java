package top.chenqwwq.pat.advanced._1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021/3/28
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        float product = 1.0f;
        for (int i = 0; i < 3; i++) {
            final String[] inStr = reader.readLine().split(" ");
            float W = Float.parseFloat(inStr[0]), T = Float.parseFloat(inStr[1]), L = Float.parseFloat(inStr[2]);
            float max = Math.max(Math.max(W, T), L);
            if (max == W) {
                System.out.printf("%s ", "W");
            } else if (max == T) {
                System.out.printf("%s ", "T");
            } else {
                System.out.printf("%s ", "L");
            }
            product *= max;
        }

        System.out.printf("%.2f\n", (product * 0.65 - 1) * 2);
    }
}