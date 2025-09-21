package top.chenqwwq.leetcode.contest.weekly._376._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenqwwq
 * @date 2023/12/17
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().minimumCost(new int[]{1,2,3,4,5});
    }

    public long minimumCost(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        long n1 = nearestPalindromic(nums[n >> 1]),n2 = nearestPalindromic(nums[0]),n3 = nearestPalindromic(nums[n-1]);
        return Math.min(diff(nums,n2),Math.min(diff(nums,n3),diff(nums,n1)));
    }

    public long diff(int[] nums, long target) {
        long diff = 0;
        for (int num : nums) diff += Math.abs(target - num);
        return diff;
    }

    public Long nearestPalindromic(int s) {
        long selfNumber = s, ans = -1;
        List<Long> candidates = getCandidates(String.valueOf(s));
        for (long candidate : candidates) {
            if (candidate != selfNumber) {
                if (ans == -1 ||
                        Math.abs(candidate - selfNumber) < Math.abs(ans - selfNumber) ||
                        Math.abs(candidate - selfNumber) == Math.abs(ans - selfNumber) && candidate < ans) {
                    ans = candidate;
                }
            }else{
                return candidate;
            }
        }
        return ans;
    }

    public List<Long> getCandidates(String n) {
        int len = n.length();
        List<Long> candidates = new ArrayList<Long>() {{
            add((long) Math.pow(10, len - 1) - 1);
            add((long) Math.pow(10, len) + 1);
        }};
        long selfPrefix = Long.parseLong(n.substring(0, (len + 1) / 2));
        for (long i = selfPrefix - 1; i <= selfPrefix + 1; i++) {
            StringBuffer sb = new StringBuffer();
            String prefix = String.valueOf(i);
            sb.append(prefix);
            StringBuffer suffix = new StringBuffer(prefix).reverse();
            sb.append(suffix.substring(len & 1));
            String candidate = sb.toString();
            try {
                candidates.add(Long.parseLong(candidate));
            } catch (NumberFormatException ex) {
                continue;
            }
        }
        return candidates;
    }

    public long h(int l) {
        if (l < 10) return l;
        String s = String.valueOf(l);
        int j;
        char[] arr = s.toCharArray();
        final int n = arr.length;
        for (int i = 0; i < n >> 1; i++) {
            if (arr[i] <= arr[n - i - 1]) arr[n - i - 1] = arr[i];
            else {
                for (j = n - 2 - i; j >= 0 && arr[j] == '0'; j--) arr[j] = '9';
                arr[j]--;
                if (arr[j] == '0' && j == 0) {
                    arr[0] = '9';
                    char[] copy = new char[arr.length - 1];
                    System.arraycopy(arr, 0, copy, 0, arr.length - 1);
                    arr = copy;
                    break;
                }
                arr[n - 1 - i] = arr[i];
            }
        }
        return Long.parseLong(new String(arr));
    }
}
