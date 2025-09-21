package top.chenqwwq.leetcode.contest.biweek._135._1;

/**
 * @author chenqwwq
 * @date 2024/7/21
 **/
class Solution {
    public String losingPlayer(int x, int y) {
        int i = 1, j = 4;
        String[] ns = new String[]{"Alice", "Bob"};
        int flag = 1;
        while (x >= i && y >= j) {
            x -= i;
            y -= j;
            flag ^= 1;
        }
        return ns[flag];
    }
}