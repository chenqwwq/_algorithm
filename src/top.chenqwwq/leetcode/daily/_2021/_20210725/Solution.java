package top.chenqwwq.leetcode.daily._2021._20210725;

import java.util.*;

/**
 * 1743. Restore the Array From Adjacent Pairs
 * There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
 * <p>
 * You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
 * <p>
 * It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
 * <p>
 * Return the original array nums. If there are multiple solutions, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: adjacentPairs = [[2,1],[3,4],[3,2]]
 * Output: [1,2,3,4]
 * Explanation: This array has all its adjacent pairs in adjacentPairs.
 * Notice that adjacentPairs[i] may not be in left-to-right order.
 * Example 2:
 * <p>
 * Input: adjacentPairs = [[4,-2],[1,4],[-3,1]]
 * Output: [-2,4,1,-3]
 * Explanation: There can be negative numbers.
 * Another solution is [-3,1,4,-2], which would also be accepted.
 * Example 3:
 * <p>
 * Input: adjacentPairs = [[100000,-100000]]
 * Output: [100000,-100000]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * nums.length == n
 * adjacentPairs.length == n - 1
 * adjacentPairs[i].length == 2
 * 2 <= n <= 105
 * -105 <= nums[i], ui, vi <= 105
 * There exists some nums that has adjacentPairs as its pairs.
 *
 * @author chen
 * @date 2021/7/25
 **/
public class Solution {
	public int[] restoreArray(int[][] adjacentPairs) {
		final int n = adjacentPairs.length;
		Map<Integer, List<Integer>> hash = new HashMap<>();
		for (int[] adjacentPair : adjacentPairs) {
			final List<Integer> orDefault = hash.getOrDefault(adjacentPair[0], new ArrayList<>(2));
			orDefault.add(adjacentPair[1]);
			hash.put(adjacentPair[0], orDefault);

			final List<Integer> orDefault1 = hash.getOrDefault(adjacentPair[1], new ArrayList<>(2));
			orDefault1.add(adjacentPair[0]);
			hash.put(adjacentPair[1], orDefault1);
		}

		Deque<Integer> pa = new LinkedList<>();
		pa.add(adjacentPairs[0][0]);
		pa.add(adjacentPairs[0][1]);
		int left = adjacentPairs[0][0], right = adjacentPairs[0][1], pre = adjacentPairs[0][0];
		while (true) {
			final List<Integer> list = hash.get(right);
			if (list.size() == 1) {
				break;
			}
			for (int num : list) {
				if (num != pre) {
					pa.addLast(num);
					pre = right;
					right = num;
					break;
				}
			}
		}

		pre = adjacentPairs[0][1];
		while (true) {
			final List<Integer> list = hash.get(left);
			if (list.size() == 1) {
				break;
			}
			for (int num : list) {
				if (num != pre) {
					pa.addFirst(num);
					pre = left;
					left = num;
					break;
				}
			}
		}

		int[] ans = new int[n+1];
		int i = 0;
		while (!pa.isEmpty()){
			ans[i++] = pa.pop();
		}
		return ans;
	}
}