package top.chenqwwq.leetcode.daily._2022._20220703;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2022/7/3
 **/
public class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n != 0) {
            nums.add(n % 10);
            n /= 10;
        }

        int m = nums.size();
        int idx = -1;
        for (int i = 0; i < m - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                idx = i+1;
                break;
            }
        }
        if (idx == -1) {
            return -1;
        }
        int pos = 0;
        while (pos < idx && nums.get(pos) <= nums.get(idx)) {
            pos++;
        }
        int temp = nums.get(pos);
        nums.set(pos, nums.get(idx));
        nums.set(idx, temp);
        for (int l = 0, r = idx - 1; l < r; l++, r--){
            int t = nums.get(l);
            nums.set(l, nums.get(r));
            nums.set(r, t);
        }
        long ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            ans = ans * 10 + nums.get(i);
        }
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    public static void main(String[] args) {
        new Solution().nextGreaterElement(230241);
    }
}