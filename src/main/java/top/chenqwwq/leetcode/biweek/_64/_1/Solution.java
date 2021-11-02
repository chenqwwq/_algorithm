package top.chenqwwq.leetcode.biweek._64._1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021/10/30
 **/
public class Solution {
	public String kthDistinct(String[] arr, int k) {
		List<String> anss = new ArrayList<>();
		Map<String, Integer> hash = new HashMap<>();
		for (String s : arr) {
			if (!hash.containsKey(s)) {
				anss.add(s);
			} else {
				anss.remove(s);
			}
			hash.put(s, hash.getOrDefault(s, 0) + 1);
		}
		return anss.size() >= k ? anss.get(k - 1) : "";
	}

	public static void main(String[] args) {
		new Solution().kthDistinct(new String[]{"a", "b", "a"}, 3);
	}
}