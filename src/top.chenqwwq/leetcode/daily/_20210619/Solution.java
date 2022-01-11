package top.chenqwwq.leetcode.daily._20210619;

import java.util.List;

/**
 * 1239. 串联字符串的最大长度
 * 给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。
 * <p>
 * 请返回所有可行解 s 中最长长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = ["un","iq","ue"]
 * 输出：4
 * 解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
 * 示例 2：
 * <p>
 * 输入：arr = ["cha","r","act","ers"]
 * 输出：6
 * 解释：可能的解答有 "chaers" 和 "acters"。
 * 示例 3：
 * <p>
 * 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
 * 输出：26
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] 中只含有小写英文字母
 *
 * @author chen
 * @date 2021/6/19
 **/
public class Solution {
	public int maxLength(List<String> arr) {
		// 预处理
		final int n = arr.size();
		int[] prepare = new int[n];
		out:
		for (int i = 0; i < n; i++) {
			String target = arr.get(i);
			int num = 0;
			for (int j = 0; j < target.length(); j++) {
				final int idx = target.charAt(j) - 'a';
				// 如果单个字母里面已经有重复的字符了,就直接舍弃掉
				if ((num & (1 << idx)) != 0) {
					prepare[i] = 0;
					continue out;
				}
				num |= (1 << idx);
			}
			prepare[i] = num;
		}
		return dfs(prepare, 0, 0);
	}

	public int dfs(int[] prepare, int idx, int num) {
		if (idx >= prepare.length) {
			return get1Cnt(num);
		}
		final int ans = dfs(prepare, idx + 1, num);
		if ((num & prepare[idx]) != 0) {
			return ans;
		}
		return Math.max(dfs(prepare, idx + 1, num | prepare[idx]), ans);
	}

	public int get1Cnt(int num) {
		int ans = 0;
		while (num != 0) {
			ans++;
			num &= (num - 1);
		}
		return ans;
	}
}