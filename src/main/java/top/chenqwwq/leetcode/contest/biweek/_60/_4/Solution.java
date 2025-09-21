package top.chenqwwq.leetcode.contest.biweek._60._4;

/**
 * @author chen
 * @date 2021/9/4
 **/
public class Solution {

	boolean[] PRIME = new boolean[31];
	int mod = (int) 1e9 + 7;

	{
		PRIME[2] = true;
		PRIME[3] = true;
		PRIME[5] = true;
		PRIME[7] = true;
		PRIME[11] = true;
		PRIME[13] = true;
		PRIME[17] = true;
		PRIME[19] = true;
		PRIME[23] = true;
		PRIME[29] = true;
	}

	public int numberOfGoodSubsets(int[] nums) {
		int[] cnt = new int[31];
		for (int num : nums) {
			cnt[num]++;
		}
		int ans = getOne(cnt[1]);

		int c = 0, mul = 1;
		for (int i = 2; i <= 30; i++) {
			if (PRIME[i] && cnt[i] > 0) {
				c++;
				if (cnt[i] > 1) {
					mul = cnt[i] * mul % mod;
				}
			}
		}
		ans = ans * getOne(c) % mod;
		ans = ans * mul % mod;
		return ans;
	}

	private int getOne(int cnt) {
		int ans = cnt, t = cnt;
		for (int i = 2; i <= cnt; i++) {
			t = (t * --cnt) % mod;
			ans = (ans + t / 2) % mod;
		}
		return Math.max(1, ans);
	}

	public static void main(String[] args) {
		new Solution().numberOfGoodSubsets(new int[]{4, 2, 3, 15});
	}
}