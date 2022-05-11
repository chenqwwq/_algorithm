package top.chenqwwq.leetcode.biweek._77._3;

/**
 *
 * @author chenqwwq
 * @date 2022/4/30
 **/
public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // 分别统计上下左右的视野
        boolean[][] tLeft = new boolean[m][n], tRight = new boolean[m][n];
        boolean[][] tTop = new boolean[m][n], tBottom = new boolean[m][n];

        int[][] map = new int[m][n];
        for (int[] guard : guards) {
            map[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            map[wall[0]][wall[1]] = -1;
        }

        for (int i = 0; i < m; i++) {
            boolean f1 = false, f2 = false;
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    f1 = true;
                } else if (map[i][j] == -1) {
                    f1 = false;
                } else {
                    tLeft[i][j] = f1;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    f2 = true;
                } else if (map[i][j] == -1) {
                    f2 = false;
                } else {
                    tRight[i][j] = f2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            boolean f1 = false, f2 = false;
            for (int j = 0; j < m; j++) {
                if (map[j][i] == 1) {
                    f1 = true;
                } else if (map[j][i] == -1) {
                    f1 = false;
                } else {
                    tBottom[j][i] = f1;
                }
            }

            for (int j = m - 1; j >= 0; j--) {
                if (map[j][i] == 1) {
                    f2 = true;
                } else if (map[j][i] == -1) {
                    f2 = false;
                } else {
                    tTop[j][i] = f2;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    continue;
                }
                if (!tLeft[i][j] && !tTop[i][j] && !tBottom[i][j] && !tRight[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //  输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
        new Solution().countUnguarded(4, 6, new int[][]{{0, 0}, {1, 1}, {2, 3}}, new int[][]{{0, 1}, {2, 2}, {1, 4}});
    }
}