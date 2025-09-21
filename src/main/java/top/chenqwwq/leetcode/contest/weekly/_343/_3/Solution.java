package top.chenqwwq.leetcode.contest.weekly._343._3;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.security.PublicKey;

/**
 * @author chenqwwq
 * @date 2023/4/30
 **/
public class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int ans = Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]);
        if(specialRoads.length == 0) return ans;
        return -1;
    }
}