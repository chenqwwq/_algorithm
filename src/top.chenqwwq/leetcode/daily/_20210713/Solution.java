package top.chenqwwq.leetcode.daily._20210713;

import java.util.*;

/**
 * 218. The Skyline Problem
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 * <p>
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 * <p>
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 * <p>
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
 * Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
 * Explanation:
 * Figure A shows the buildings of the input.
 * Figure B shows the skyline formed by those buildings. The red points in figure B represent the key points in the output list.
 * Example 2:
 * <p>
 * Input: buildings = [[0,2,3],[2,5,3]]
 * Output: [[0,3],[5,0]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= buildings.length <= 104
 * 0 <= lefti < righti <= 231 - 1
 * 1 <= heighti <= 231 - 1
 * buildings is sorted by lefti in non-decreasing order.
 *
 * @author chen
 * @date 2021-07-13
 **/
public class Solution {

	public List<List<Integer>> getSkyline(int[][] buildings) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		for (int[] building : buildings) {
			addMap(map, building[0], -building[2]);
			addMap(map, building[1], building[2]);
		}

		List<List<Integer>> ans = new ArrayList<>();

		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		queue.offer(0);
		for (Integer idx : map.keySet()) {
			final Integer currHeight = queue.peek();
			final List<Integer> heights = map.get(idx);
			for (int height : heights) {
				if (height < 0) {
					queue.add(-height);
				} else {
					queue.remove(height);
				}
			}
			if (!currHeight.equals(queue.peek())) {
				ans.add(Arrays.asList(idx, queue.peek()));
			}
		}
		return ans;
	}

	private void addMap(TreeMap<Integer, List<Integer>> map, Integer key, Integer value) {
		final List<Integer> orDefault = map.getOrDefault(key, new ArrayList<>());
		orDefault.add(value);
		map.put(key, orDefault);
	}
}