package top.chenqwwq.leetcode.contest.weekly._350._1;

/**
 * @author chenqwwq
 * @date 2023/6/18
 **/
public class Solution {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int cnt = mainTank;
        while (mainTank >= 5 && additionalTank > 0){
            mainTank -= 5;
            additionalTank--;
            mainTank++;
            cnt++;
        }
        return cnt * 10;
    }
}