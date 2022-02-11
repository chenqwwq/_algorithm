package top.chenqwwq.leetcode.daily._20210718;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题 10.02. 变位词组
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * @author chen
 * @date 2021/7/18
 **/
public class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> hb = new HashMap<>();
		for (String s : strs) {
			final String hash = getHash(s);
			final List<String> list = hb.getOrDefault(hash, new ArrayList<>());
			list.add(s);
			hb.put(hash, list);
		}

		return new ArrayList<>(hb.values());
	}

	public String getHash(String s) {
		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		StringBuilder ans = new StringBuilder();
		for (int num : cnt) {
			ans.append(num);
		}
		return ans.toString();
	}
}