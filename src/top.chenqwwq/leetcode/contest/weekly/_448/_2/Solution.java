package top.chenqwwq.leetcode.contest.weekly._448._2;

/**
 * @author chenqwwq
 * @date 2025/5/4
 **/
class Solution {
    public int[][] specialGrid(int N) {
        if (N == 0) {
            return new int[][]{{0}};
        }
        return h(0, (int) Math.pow(2, 2 * N));
    }

    public int[][] h(int start, int size) {
        if (size == 4) {
            return new int[][]{{start + 3, start}, {start + 2, start + 1}};
        }
        // 子模块的大小
        final int st = size >> 2;
        // 子模块的边长
        final int ht = (int) Math.sqrt(st);

        // 当前返回的边长
        int t = (int) Math.sqrt(size);
        // 当前的返回数组
        int[][] cur = new int[t][t];

        // 计算子模块
        int[][] t1 = h(start, st);
        // 赋值
        for (int i = 0; i < ht; i++) {
            System.arraycopy(t1[i], 0, cur[i], ht, ht);
        }
        int[][] t2 = h(start + st, st);
        for (int i = ht; i < t; i++) {
            System.arraycopy(t2[i - (ht)], 0, cur[i], ht, ht);
        }
        int[][] t3 = h(start + 2 * st, st);
        for (int i = ht; i < t; i++) {
            System.arraycopy(t3[i - (ht)], 0, cur[i], 0, ht);
        }
        int[][] t4 = h(start + 3 * st, st);
        for (int i = 0; i < ht; i++) {
            System.arraycopy(t4[i], 0, cur[i], 0, ht);
        }
        return cur;
    }

    public static void main(String[] args) {
        final int[][] ints = new Solution().specialGrid(3);
        System.out.println(ints);
//        System.out.println(Math.pow(2,2 *3));
    }


}