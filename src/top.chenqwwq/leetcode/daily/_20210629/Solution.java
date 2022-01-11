package top.chenqwwq.leetcode.daily._20210629;

/**
 * @author chen
 * @date 2021-06-29
 **/
public class Solution {
	public String convertToTitle(int columnNumber) {
		StringBuilder ans = new StringBuilder();
		do {
			ans.insert(0, (char) (((columnNumber - 1) % 26) + 'A'));
			columnNumber = (columnNumber - 1) / 26;
		} while (columnNumber > 0);
		return ans.toString();
	}
}