package top.chenqwwq.leetcode.lcof2._85;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/6
 **/
public class Solution {

	List<String> ans;

	public List<String> generateParenthesis(int n) {
		ans = new ArrayList<>();
		if (n == 0) {
			return ans;
		}
		backtrace(n, n , "");
		return ans;
	}

	public void backtrace(int left, int right, String curr) {
		if (right == 0 && left == 0) {
			ans.add(curr);
			return;
		}
		if (left > 0) {
			backtrace(left - 1, right, curr + '(');
		}
		if (left < right) {
			backtrace(left, right - 1, curr + ')');
		}
	}
}