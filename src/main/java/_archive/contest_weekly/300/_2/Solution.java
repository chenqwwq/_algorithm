package top.chenqwwq.leetcode.contest.weekly._300._2;

import top.chenqwwq.leetcode.common.ListNode;

/**
 * @author chenqwwq
 * @date 2022/7/3
 **/
public class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int i = 0, j = 0,c = 0;
        int total = n * m;
        // 逐层便利
        while (i < m * n) {
            int x = j, y = j;
            while (c < total && y < n - j) {
                c++;
                i++;
                ans[x][y++] = (head == null) ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            ++x;
            --y;
            while (c < total && x < m - j) {
                c ++;
                i++;
                ans[x++][y] = (head == null) ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            y--;
            --x;
            while (c < total && y >= j) {
                c++;
                i++;
                ans[x][y--] = (head == null) ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            --x;
            ++y;
            while (c < total && x > j) {
                c++;
                i++;
                ans[x--][y] = (head == null) ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Solution().spiralMatrix(1, 4, new ListNode(0,new ListNode(1,new ListNode(2))));
    }
}