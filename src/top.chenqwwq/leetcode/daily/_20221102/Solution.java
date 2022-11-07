package top.chenqwwq.leetcode.daily._20221102;

/**
 * @author chenqwwq
 * @date 2022/11/2
 **/
public class Solution {
    int N = 101;

    public int[] bestCoordinate(int[][] towers, int radius) {
        int[][] signal = new int[N][N];
        for (var tower : towers) {
            int x = tower[0], y = tower[1], p = tower[2];
            for (int i = Math.max(x - radius, 0); i <= x + radius; i++) {
                for (int j = Math.max(y - radius, 0); j < y + radius; j++) {
                    double d = Math.sqrt((x - i) * (x - i) + (y - j) * (y - j));
                    if (d > radius) continue;
                    signal[i][j] += p / (1 + d);
                }
            }
        }
        String a = "a";
        int[] ans = new int[2];
        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (signal[i][j] > max) {
                    ans[0] = i;
                    ans[1] = j;
                    max = signal[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().bestCoordinate(new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2);
    }

}
