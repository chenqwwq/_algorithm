package top.chenqwwq.leetcode.contest.weekly._241._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021/5/16
 **/
public class FindSumPairs {

	Map<Integer, Integer> hash1 = new HashMap<>();
	List<Integer> nums1KeyList;
	Map<Integer, Integer> hash2 = new HashMap<>();
	int[] nums1;
	int[] nums2;

	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums1 = nums1;
		this.nums2 = nums2;

		for (int i : nums1) {
			hash1.put(i, hash1.getOrDefault(i, 0) + 1);
		}

		nums1KeyList = new ArrayList<>(hash1.keySet());
		nums1KeyList.sort(Integer::compareTo);

		for (int i : nums2) {
			hash2.put(i, hash2.getOrDefault(i, 0) + 1);
		}
	}

	public void add(int index, int val) {
		hash2.put(nums2[index], hash2.get(nums2[index]) - 1);
		nums2[index] += val;
		hash2.put(nums2[index], hash2.getOrDefault(nums2[index], 0) + 1);
	}

	public int count(int tot) {
		int ans = 0;
		for (int key : nums1KeyList) {
			if (tot < key) {
				return ans;
			}
			ans += hash2.getOrDefault(tot - key, 0) * hash1.getOrDefault(key, 0);
		}
		return ans;
	}
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */