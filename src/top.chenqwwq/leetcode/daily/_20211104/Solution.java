package top.chenqwwq.leetcode.daily._20211104;

/**
 * @author chen
 * @date 2021-11-04
 **/
public class Solution {
	public boolean isPerfectSquare(int num) {
		for(int i = 1;i <= num;i++){
			long res = (long) i * i;
			if(res == num){
				return true;
			}else if(res > num){
				return false;
			}
		}
		return false;
	}
}