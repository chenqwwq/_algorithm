package top.chenqwwq.leetcode.daily._2021._20210429;

/**
 * 403. Frog Jump
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
 * <p>
 * Example 1:
 * Input: stones = [0,1,3,5,6,8,12,17]
 * Output: true
 * Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * <p>
 * Input: stones = [0,1,2,3,4,8,9,11]
 * Output: false
 * Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 * <p>
 * Constraints:
 * 2 <= stones.length <= 2000
 * 0 <= stones[i] <= 231 - 1
 * stones[0] == 0
 *
 * @author chen
 * @date 2021-04-29
 **/
public class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) {
            return false;
        }
        // 先用递归，基本就是超时的方法
        return recursion(stones, 1, 1);
    }

    private boolean recursion(int[] stones, int idx, int k) {
        if (idx == stones.length - 1) {
            return true;
        }
        int target = idx;
        int len = 0;
        while (++target < stones.length) {
            if (Math.abs((len = stones[target] - stones[idx]) - k) <= 1) {
                if (recursion(stones, target, len)) {
                    return true;
                }
                // len 超过 k+1，之后的就不用看了
            } else if (len > k + 1) {
                return false;
            }
        }
        return false;
    }
}