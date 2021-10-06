package top.chenqwwq.leetcode.daily._20211002;

/**
 * @author: chenqwwq
 * @date: 2021/10/2 9:17 下午
 **/
public class Solution {
	private final static char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

	public String toHex(int num) {
		if(num == 0){
			return "0";
		}
		StringBuilder ans = new StringBuilder();
		while (num != 0 && ans.length() < 8) {
			ans.append(HEX[num & 0xf]);
			num >>= 4;
		}
		return ans.reverse().toString();
	}
}
