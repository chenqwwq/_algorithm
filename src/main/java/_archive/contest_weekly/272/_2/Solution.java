package top.chenqwwq.leetcode.contest.weekly._272._2;

/**
 * @author chenbingxin
 * @date 2021/12/19
 **/
public class Solution {
	public String addSpaces(String s, int[] spaces) {
		if(s == null || s.length() == 0){
			return s;
		}
		StringBuilder ans = new StringBuilder();
		int curr = 0;
		for (int idx : spaces){
			ans.append(s, curr, idx).append(" ");
			curr = idx;
		}
		ans.append(s.substring(curr));
		return ans.toString();
	}
}