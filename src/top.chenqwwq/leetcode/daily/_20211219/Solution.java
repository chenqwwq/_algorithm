package top.chenqwwq.leetcode.daily._20211219;

/**
 * @author chenbingxin
 * @date 2021/12/19
 **/
public class Solution {
	public int findJudge(int n, int[][] trust) {
		final int[] in = new int[n+1],out = new int[n+1];
		for (int[] t :trust){
			out[t[0]]++;
			in[t[1]]++;
		}

		for (int i = 1;i <= n;i++){
			if(in[i] == n-1 && out[i] == 0){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		new Solution().findJudge(1,new int[][]{});
	}
}