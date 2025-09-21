package top.chenqwwq.leetcode.daily._2021._20211024;

import java.util.Arrays;
import java.util.List;

/**
 * @author chen
 * @date 2021/10/24
 **/
public class Solution {
	int ans = Integer.MAX_VALUE;
	int n;
	List<Integer> price;
	List<List<Integer>> special;


	public int shoppingOffers(List<Integer> _price, List<List<Integer>> _special, List<Integer> needs) {
		n = _price.size();
		price = _price;
		special = _special;
		int status = 0;
		for (int i = 0; i < n; i++) {
			status |= (needs.get(i) << (4 * i));
		}

		dfs(status, 0);
		return ans;
	}

	public void dfs(int status, int curr) {
		if (curr >= ans) {
			return;
		}
		if (status == 0) {
			ans = curr;
			return;
		}

		int cost = 0, b = 0;
		for (int i = 0; i < n; i++) {
			cost += ((status >> b & 0x000F) * price.get(i));
			b += 4;
		}
		ans = Math.min(cost + curr, ans);

		out:
		for (List<Integer> nums : special) {
			int currStatus = 0, base = 0;
			for (int i = 0; i < n; i++) {
				final int cnt = status >> base & 0x000F;
				if (cnt < nums.get(i)) {
					continue out;
				}
				final int diff = cnt - nums.get(i);
				currStatus |= diff << base;
				base += 4;
			}
			dfs(currStatus, curr + nums.get(n));
		}
	}

	/**
	 * [2,5]
	 * [[3,0,5],[1,2,10]]
	 * [3,2]
	 */
	public static void main(String[] args) {
		new Solution().shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)), Arrays.asList(3, 2));
	}
}