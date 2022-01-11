package top.chenqwwq.leetcode.biweek._49._4;

/**
 * @author chen
 * @date 2021/4/3
 **/
public class Solution {
    public int maxHappyGroups(int batchSize, int[] groups) {
        int[] hash = new int[batchSize];
        for (int i : groups) {
            hash[i % batchSize]++;
        }

        for (int i = 1; i < batchSize; i++) {
            final int idx = batchSize - i;
            if (i == idx) {
                hash[0] += hash[i] / 2;
                hash[i] = hash[i] % 2;
                continue;
            }
            if (hash[i] > hash[idx]) {
                hash[0] += hash[idx];
                hash[i] -= hash[idx];
                hash[idx] = 0;
            } else {
                hash[0] += hash[i];
                hash[idx] -= hash[i];
                hash[i] = 0;
            }
        }

        int remain = 0;

        for (int i = batchSize - 1; i >= 1; i--) {
            int cnt = hash[i];
            if (cnt == 0) {
                continue;
            }
            while (cnt-- > 0) {
                if (remain == 0) {
                    hash[0]++;
                } else if (hash[remain] > 0) {
                    hash[remain]--;
                    remain = 0;
                    continue;
                }
                remain = (remain >= i ? remain : (batchSize + remain)) - i;
            }
        }

        return hash[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxHappyGroups(7, new int[]{
                710639308, 382066319, 278191472, 196733926, 581541006, 223163180, 329983542, 213906448, 264549796, 387044831, 87369044, 880443655, 301492451, 96008417, 808835417, 480931370, 97161221}));
    }
}
