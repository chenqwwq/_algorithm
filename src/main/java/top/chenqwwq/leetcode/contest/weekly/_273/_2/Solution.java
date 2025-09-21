package top.chenqwwq.leetcode.contest.weekly._273._2;

/**
 * @author chenbingxin
 * @date 2021/12/26
 **/
public class Solution {
//    public int[] executeInstructions(int n, int[] startPos, String s) {
//        final int m = s.length();
//        final int ml = startPos[1], mr = n - startPos[0] - 1, mu = startPos[0], md = n - startPos[1] - 1;
//        final int[] rc = new int[m + 1], lc = new int[m + 1], uc = new int[m + 1], dc = new int[m + 1];
//        for (int i = 1; i <= m; i++) {
//            lc[i] = lc[i - 1];
//            rc[i] = rc[i - 1];
//            uc[i] = uc[i - 1];
//            dc[i] = dc[i - 1];
//            if (s.charAt(i-1) == 'L') {
//                lc[i]++;
//            } else if (s.charAt(i-1) == 'D') {
//                dc[i]++;
//            } else if (s.charAt(i-1) == 'R') {
//                rc[i]++;
//            } else {
//                uc[i]++;
//            }
//        }
//
//        final int[] ans = new int[m];
//        for (int i = 0; i < m; i++) {
//
//        }
//    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        final int m = s.length();
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int t = 0;
            int x = startPos[0], y = startPos[1];
            for (int j = i; j < m; j++) {
                switch (s.charAt(j)) {
                    case 'L':
                        y--;
                        break;
                    case 'R':
                        y++;
                        break;
                    case 'U':
                        x--;
                        break;
                    default:
                        x++;
                }
                if (!check(n, x, y)) {
                    break;
                }
                t++;
            }
            ans[i] = t;
        }
        return ans;
    }

    public boolean check(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        new Solution().executeInstructions(3,new int[]{0,1},"RRDDLU");
    }
}
