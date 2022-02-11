package top.chenqwwq.leetcode.daily._20211217;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Solution {
	public int numWaterBottles(int numBottles, int numExchange) {
		int ans = numBottles;
		while (numBottles >= numExchange){
			final int exchange = numBottles / numExchange;
			numBottles = numBottles % numExchange + exchange;
			ans += exchange;
		}
		return ans;
	}
}