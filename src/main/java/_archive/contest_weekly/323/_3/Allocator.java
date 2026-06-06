package top.chenqwwq.leetcode.contest.weekly._323._3;

import java.sql.Array;
import java.util.*;

/**
 * @author chenqwwq
 * @date 2022/12/11
 **/
public class Allocator {

    int[] mem;
    int n, free;

    public Allocator(int n) {
        this.mem = new int[n];
        this.n = n;
        this.free = n;
    }

    public int allocate(int size, int mID) {
        if (free < size) return -1;
        for (int i = 0; i < n; i++) {
            if (mem[i] != 0) continue;
            int j = i;
            while (j < n && j - i < size && mem[j] == 0) j++;
            if (j - i == size) {
                for (int k = i; k < j; k++) mem[k] = mID;
                free -= size;
                return i;
            }
        }
        return -1;
    }

    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (mem[i] == mID) {
                mem[i] = 0;
                cnt++;
            }
        }
        free += cnt;
        return cnt;
    }
}