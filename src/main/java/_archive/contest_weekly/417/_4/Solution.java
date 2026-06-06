package top.chenqwwq.leetcode.contest.weekly._417._4;

/**
 * @author chenqwwq
 * @date 2024/9/29
 **/
public class Solution {
    public char kthCharacter(long k, int[] operations) {
        return handle(k-1,operations);
    }

    public char handle(long k, int[] operations){
        if (k == 0) return 'a';
        int idx = pos(k);       // 当前位置是否需要+1
        long curK = k - tf(k);
        final char c = handle(curK, operations);
        return operations[idx] == 0 ? c : ch(c);
    }

    public char ch(char c) {
        if (c == 'z') return 'a';
        return (char) (c + 1);
    }

    long tf(long cap) {
        long sum = 1;
        for (; ; ) {
            if (sum << 1 > cap) return sum;
            sum <<= 1;
        }
    }

    int pos(long t) {
        return (int) (Math.log(tf(t)) / Math.log(2));
    }

}
