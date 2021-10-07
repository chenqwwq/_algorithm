package top.chenqwwq.leetcode.daily._20211001;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chen
 * @date 2021/10/1
 **/
public class Solution {
	public String destCity(List<List<String>> paths) {
		Set<String> out = new HashSet<>();
		for (List<String> path : paths) {
			out.add(path.get(0));
		}
		for (List<String> path : paths) {
			if(!out.contains(path.get(1))){
				return path.get(1);
			}
		}
		return null;
	}
}