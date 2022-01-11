package top.chenqwwq.leetcode.lcof2._9_$;

/**
 * @author chenbingxin
 * @date 2021/12/10
 **/
public class Solution {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		final int n = nums.length;
		int ans = 0, left = 0, right = 0, curr = 1;
		while (right < n) {
			curr *= nums[right++];
			while (left < right && curr >= k) {
				curr /= nums[left++];
			}
			if (right > left) {
				ans += (right - left);
			}
		}
//		for (int i = 0; i < n; i++) {
//			int curr = nums[i];
//			if(curr < k){
//				ans++;
//			}
//			for (int j = i + 1; j < n; j++) {
//				curr *= nums[j];
//				if(curr >= k){
//					break;
//				}
//				ans++;
//			}
//		}
		return ans;
	}
}
