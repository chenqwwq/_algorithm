package top.chenqwwq.leetcode.contest.weekly._344._4;

/**
 * @author 沽酒
 * @since 2023/05/09
 */
public class Solution {

    int[] cost, sums;
    int n, ans;

    public int minIncrements(int n, int[] cost) {
        this.cost = cost;
        this.n = n;
        this.sums = new int[n];
        this.ans = 0;
        getMax(0);
        handle(0, sums[0]);
        return ans;
    }

    public void handle(int cur, int sum) {
        if (cur >= n) return;
        ans += sum - sums[cur];
        int l = 2 * cur + 1, r = 2 * cur + 2;
        handle(l, sums[cur] - cost[cur]);
        handle(r,sums[cur] - cost[cur]);
    }


    private int getMax(int cur) {
        if(cur >= n) return 0;
        int l = 2 * cur + 1, r = 2 * cur + 2;
        sums[cur] = cost[cur] + Math.max(getMax(l), getMax(r));
        return sums[cur];
    }
}