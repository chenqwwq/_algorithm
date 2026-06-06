package top.chenqwwq.leetcode.contest.biweek._66._1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2021/11/28
 **/
public class Solution {
	public int countWords(String[] words1, String[] words2) {
		Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
		for (String s : words1) {
			m1.put(s, m1.getOrDefault(s, 0) + 1);
		}
		for (String s : words2) {
			m2.put(s, m2.getOrDefault(s, 0) + 1);
		}
		int ans=  0;
		for (Map.Entry<String, Integer> entry : m1.entrySet()){
			if(entry.getValue() == 1 && m2.getOrDefault(entry.getKey(),0) == 1){
				ans ++;
			}
		}
		return ans;
	}
}