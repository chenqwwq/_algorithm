package top.chenqwwq.leetcode.contest.weekly._270._1;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/5
 **/
public class Solution {
	public int[] findEvenNumbers(int[] digits) {
		List<Integer> first = new ArrayList<>(), last = new ArrayList<>();
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] != 0) {
				first.add(i);
			}
			if ((digits[i] & 1) == 0) {
				last.add(i);
			}
		}

		final Set<Integer> set = new HashSet<>();
		for (int i = 0; i < first.size(); i++) {
			for (int j = 0; j < digits.length; j++) {
				if(first.get(i) == j){
					continue;
				}
				for (int k = 0; k < last.size(); k++) {
					if(Objects.equals(first.get(i), last.get(k)) || j == last.get(k)){
						continue;
					}
					set.add(digits[first.get(i)] * 100 + digits[j] * 10 + digits[last.get(k)]);
				}
			}
		}
		List<Integer> ans = new ArrayList<>(set);
		ans.sort(Integer::compare);
		int[] fin = new int[ans.size()];
		for (int i = 0;i <  ans.size();i++){
			fin[i] = ans.get(i);
		}
		return fin;
	}

	public static void main(String[] args) {
		new Solution().findEvenNumbers(new int[]{0,0,2,0});
	}
}
/**
 *[102,132,201,231,301,302,312,321]
 * [222,228,282,288,822,828,882]
 * []
 * [0,2,20]
 * []
 */