package top.chenqwwq.leetcode.topic.greedy._1353;

import java.util.Arrays;

/**
 * 1353. Maximum Number of Events That Can Be Attended
 * Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
 * <p>
 * You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.
 * <p>
 * Return the maximum number of events you can attend.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: events = [[1,2],[2,3],[3,4]]
 * Output: 3
 * Explanation: You can attend all the three events.
 * One way to attend them all is as shown.
 * Attend the first event on day 1.
 * Attend the second event on day 2.
 * Attend the third event on day 3.
 * Example 2:
 * <p>
 * Input: events= [[1,2],[2,3],[3,4],[1,2]]
 * Output: 4
 * Example 3:
 * <p>
 * Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
 * Output: 4
 * Example 4:
 * <p>
 * Input: events = [[1,100000]]
 * Output: 1
 * Example 5:
 * <p>
 * Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 * Output: 7
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= events.length <= 105
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 105
 *
 * @author chen
 * @date 2021-05-17
 **/
public class Solution {
	public int maxEvents(int[][] events) {
		int ans = 0, idx = 1;
		boolean[] days = new boolean[100001];
		// 贪心策略很简单就是尽量使用最早的天次
		// 但是排序要以endDay升序
		// 如果排序以 startDay 升序,会存在 [1,5][1,2][1,2] 这种错认为false
		Arrays.sort(events, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
		for (int[] event : events) {
			if (days[event[1]]) {
				continue;
			}
			for (int i = Math.max(idx, event[0]); i <= event[1]; i++) {
				if (!days[i]) {
					ans++;
					if (i == idx + 1) {
						idx++;
					}
					days[i] = true;
					break;
				}
			}
		}
		return ans;
	}
}