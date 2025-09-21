package top.chenqwwq.leetcode.contest.weekly._271._1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chenbingxin
 * @date 2021/12/12
 **/
public class Solution {
	public int countPoints(String rings) {
		Map<Character, Set<Character>> hash = new HashMap<>();
		for (int i = 0;i < rings.length();i+=2){
			final char key = rings.charAt(i + 1);
			final Set<Character> characters = hash.getOrDefault(key, new HashSet<>());
			characters.add(rings.charAt(i));
			hash.put(key,characters);
		}

		int ans = 0;
		for (Map.Entry<Character,Set<Character>> entry : hash.entrySet()){
			if(entry.getValue().size() >= 3){
				ans++;
			}
		}
		return ans;
	}
}