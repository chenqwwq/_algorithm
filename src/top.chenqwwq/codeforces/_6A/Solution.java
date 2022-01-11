package top.chenqwwq.codeforces._6A;

import java.util.Scanner;

/**
 * @author chenbingxin
 * @date 2021/12/24
 **/
public class Solution {
    static final String TRIANGLE = "TRIANGLE";
    static final String SEGMENT = "SEGMENT";
    static final String IMPOSSIBLE = "IMPOSSIBLE";

    public static void main(String[] args) {
        final int n = 4;
        Scanner scanner = new Scanner(System.in);
        final int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        boolean isSegment = false;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    final int a = nums[i], b = nums[j], c = nums[k];
                    if (a + b > c && a + c > b && b + c > a) {
                        System.out.println(TRIANGLE);
                        return;
                    }
                    if(!isSegment && a + b >= c && b + c >= a && a + c >= b){
                        isSegment = true;
                    }
                }
            }
        }
        System.out.println(isSegment ? SEGMENT : IMPOSSIBLE);
    }
}
