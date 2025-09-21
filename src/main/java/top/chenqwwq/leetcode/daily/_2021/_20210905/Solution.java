package top.chenqwwq.leetcode.daily._2021._20210905;

/**
 * @author chen
 * @date 2021/9/5
 **/
public class Solution extends SolBase {
	public int rand10() {
		int ans = 1;
		for (int i = 0;i < 10;i++){
			i *= rand7();
		}
		return ans / 7+1;
	}
}

class SolBase {
	public int rand7() {
		return 1;
	}
}