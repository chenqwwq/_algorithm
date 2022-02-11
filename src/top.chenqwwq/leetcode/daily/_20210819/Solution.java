package top.chenqwwq.leetcode.daily._20210819;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 * Given a string s, reverse only all the vowels in the string and return it.
 * <p>
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both cases.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: "leotcede"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 105
 * s consist of printable ASCII characters.
 *
 * @author chen
 * @date 2021/8/19
 **/
public class Solution {
	Set<Character> vowels = new HashSet() {{
		add('A');
		add('E');
		add('I');
		add('O');
		add('U');
		add('a');
		add('e');
		add('i');
		add('o');
		add('u');
	}};

	public String reverseVowels(String s) {
		int n = s.length();
		if (n < 2) {
			return s;
		}
		int i = 0, j = n - 1;
		final char[] cs = s.toCharArray();
		while (i < j) {
			while (i < j && !vowels.contains(cs[i])) {
				i++;
			}

			while (i < j && !vowels.contains(cs[j])) {
				j--;
			}
			if (i < j) {
				cs[j] ^= cs[i];
				cs[i] ^= cs[j];
				cs[j--] ^= cs[i++];
			}
		}
		return new String(cs);
	}
}