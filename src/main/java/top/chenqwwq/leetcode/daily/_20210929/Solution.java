package top.chenqwwq.leetcode.daily._20210929;

/**
 * @author chenqwwq
 */
public class Solution {
	public int findMinMoves(int[] machines) {
		final int n = machines.length;
		int sum = 0;
		for (int machine : machines){
			sum += machine;
		}
		if( sum % n != 0){
			return -1;
		}
		final int avg = sum / n;
		int[] dp = new int[n];
		dp[0] = machines[0] - avg;
		int ans = Math.abs(dp[0]);
		for(int i = 1;i < n;i++){
			final int curr = machines[i] - avg;
			dp[i] = dp[i-1] + curr;
			ans = Math.max(ans,Math.max(Math.abs(dp[i]),curr));
		}
		return ans;
	}

	public static void main(String[] args) {
		new Solution().findMinMoves(new int[]{9,1,8,8,9});
	}
}