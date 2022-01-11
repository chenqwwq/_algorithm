package top.chenqwwq.leetcode.weekly._246._4;

/**
 * @author chen
 * @date 2021/6/20
 **/
public class Solution {
	public static void main(String[] args) {
		new Solution().minDifference(new int[]{1, 3, 4, 8}, new int[][]{
				{0, 1}, {1, 2}, {2, 3}, {0, 3}
		});
	}

	public int[] minDifference(int[] nums, int[][] queries) {
		int[] ans = new int[queries.length];
		int idx = 0;
		for (int[] query : queries) {
			int[] bucket = new int[101];
			for (int i = query[0]; i <= query[1]; i++) {
				bucket[nums[i]]++;
			}
			ans[idx++] = getMin(bucket);
		}
		return ans;
	}

	public int getMin(int[] bucket) {
		int ans = Integer.MAX_VALUE;
		int x = -1;
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] == 0) {
				continue;
			}
			if (x != -1) {
				ans = Math.min(ans, i - x);
			}
			x = i;
		}
		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}