package top.chenqwwq.leetcode.daily._2021._20210724;

/**
 * 1736. Latest Time by Replacing Hidden Digits
 * You are given a string time in the form of hh:mm, where some of the digits in the string are hidden (represented by ?).
 * <p>
 * The valid times are those inclusively between 00:00 and 23:59.
 * <p>
 * Return the latest valid time you can get from time by replacing the hidden digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: time = "2?:?0"
 * Output: "23:50"
 * Explanation: The latest hour beginning with the digit '2' is 23 and the latest minute ending with the digit '0' is 50.
 * Example 2:
 * <p>
 * Input: time = "0?:3?"
 * Output: "09:39"
 * Example 3:
 * <p>
 * Input: time = "1?:22"
 * Output: "19:22"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * time is in the format hh:mm.
 * It is guaranteed that you can produce a valid time from the given string.
 *
 * @author chen
 * @date 2021/7/24
 **/
public class Solution {
	public String maximumTime(String time) {
		StringBuilder ans = new StringBuilder();
		final char c0 = time.charAt(0),
				c1 = time.charAt(1),
				c3 = time.charAt(3),
				c4 = time.charAt(4);
		ans.append(c0 != '?' ? c0 : (c1 == '?' || c1 < '4' ? '2' : '1'));
		ans.append(c1 != '?' ? c1 : (c0 == '?' || c0 == '2' ? '3' : '9'));
		ans.append(':');
		ans.append(c3 != '?' ? c3 : '5');
		ans.append(c4 != '?' ? c4 : '9');

		return ans.toString();
	}
}