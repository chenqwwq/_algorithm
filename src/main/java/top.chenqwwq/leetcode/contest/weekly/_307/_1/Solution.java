package top.chenqwwq.leetcode.contest.weekly._307._1;

/**
 * @author chenqwwq
 * @date 2022/8/21
 **/
public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        final int n = energy.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (initialEnergy <= energy[i]) {
                cnt += energy[i] + 1 - initialEnergy;
                initialEnergy = energy[i] + 1;
            }
            if (initialExperience <= experience[i]) {
                cnt += experience[i] + 1 - initialExperience;
                initialExperience = experience[i] + 1;
            }
            initialEnergy -= energy[i];
            initialExperience += experience[i];
        }
        return cnt;
    }

    public static void main(String[] args) {
        new Solution().minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50});
    }
}