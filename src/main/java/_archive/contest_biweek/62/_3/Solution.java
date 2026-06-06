package top.chenqwwq.leetcode.contest.biweek._62._3;

/**
 * @author: chenqwwq
 * @date: 2021/10/4 9:50 下午
 **/
public class Solution {
	public int maxConsecutiveAnswers(String answerKey, int k) {
		// 滑动窗口
		if (answerKey == null || answerKey.length() == 0) {
			return 0;
		}
		final int n = answerKey.length();
		int ans = 1;
		int left = 0, right = 0,tc = 0,fc = 0;
		while (right < n){
			if(answerKey.charAt(right++) == 'T'){
				tc++;
			}else {
				fc++;
			}
			if(tc <= k || fc <= k){
				ans = Math.max(ans,tc + fc);
			}else{
				if(answerKey.charAt(left++) == 'T'){
					tc--;
				}else{
					fc--;
				}
			}
		}
		return ans;
	}
}
