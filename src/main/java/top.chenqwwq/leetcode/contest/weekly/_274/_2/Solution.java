package top.chenqwwq.leetcode.contest.weekly._274._2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenbingxin
 * @date 2022/1/2
 **/
public class Solution {
    Map<Integer, Integer> cache = new HashMap<>();

    public int numberOfBeams(String[] bank) {
        return numberOfBeams(bank,0,1);
    }

    public int numberOfBeams(String[] banks, int l, int r) {
        if(r >= banks.length || l >= banks.length){
            return 0;
        }
        final Integer lc = cache.computeIfAbsent(l, integer -> getCnt(banks[integer]));
        if (lc == 0) {
            return numberOfBeams(banks, l + 1, r + 1);
        }
        final Integer rc = cache.computeIfAbsent(r, r1 -> getCnt(banks[r1]));
        if (rc == 0) {
            return numberOfBeams(banks, l, r + 1);
        }
        return lc * rc + numberOfBeams(banks, r, r + 1);
    }

    public int getCnt(String bank) {
        int cnt = 0;
        for (int i = 0; i < bank.length(); i++) {
            if (bank.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}
