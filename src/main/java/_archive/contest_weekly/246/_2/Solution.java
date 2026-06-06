package top.chenqwwq.leetcode.contest.weekly._246._2;

/**
 * @author chen
 * @date 2021/6/20
 **/
public class Solution {
	public int numberOfRounds(String startTime, String finishTime) {
		final String[] start = startTime.split(":"), end = finishTime.split(":");
		int startM = Integer.parseInt(start[1]),
				startH = Integer.parseInt(start[0]),
				endM = Integer.parseInt(end[1]),
				endH = Integer.parseInt(end[0]);
		if (startH == endH && startM < endM) {
			return (endM / 15 * 15 - (startM / 15 + (startM % 15 > 0 ? 1 : 0)) * 15) / 15;
		}
		startH += (startM > 0) ? 1 : 0;
		return (endH - startH < 0 ? endH - startH + 24 : endH - startH) * 4 + (startM > 0 ? (60 - startM) / 15 : 0) + endM / 15;
	}
}