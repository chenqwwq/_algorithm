package top.chenqwwq.leetcode.archive.lcof2._87;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/7
 **/
public class Solution {

	List<String> ans;

	public List<String> restoreIpAddresses(String s) {
		// IP 地址的要求就是四位 并且每位都是 0～255
		ans = new ArrayList<>();
		if(s.length() > 12){
			return ans;
		}

		backtrace(s, 0, 0, "");
		return ans;
	}

	private void backtrace(String s, int idx, int level, String curr) {
		if (level == 4 && idx == s.length()) {
			ans.add(curr);
			return;
		}
		if (level == 4 || idx >= s.length() || s.length() > idx + 3 * (4 - level)) {
			return;
		}

		int t = 0;
		String st = level == 0 ? "" : ".";
		for (int i = idx; i < s.length(); i++) {
			final char c = s.charAt(i);
			t = t * 10 + (c - '0');
			if(t > 255){
				break;
			}
			st += c;
			backtrace(s,i+1,level+1,curr+st);
			if(i == idx && c == '0'){
				break;
			}
		}
	}

}