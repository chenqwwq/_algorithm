package top.chenqwwq.leetcode.daily._20220924;

import com.sun.org.apache.xerces.internal.impl.xs.XSAttributeUseImpl;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author chenqwwq
 * @date 2022/9/24
 **/
public class Solution {
    public int[] decrypt(int[] code, int k) {
        final int n = code.length;
        final int m = n * 2 + 1;
        int[] ans = new int[n];
        if (k == 0) return ans;
        int[] sum = new int[m];
        for (int i = 1; i < m; i++) sum[i] = sum[i - 1] + code[(i - 1) % n];
        for (int i = 1; i <= n; i++) {
            if (k < 0) ans[i - 1] = sum[i + n - 1] - sum[i + n + k - 1];
            else ans[i - 1] = sum[i + k] - sum[i];
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        // 小顶堆
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> exist = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            long n = random.nextInt(100000);
            if (exist.contains(n)) continue;

            if (queue.isEmpty() || queue.size() < 10) {
                queue.add(n);
                exist.add(n);
            } else if (queue.peek() < n) {
                exist.remove(queue.poll());
                queue.add(n);
                exist.add(n);
            }
            // 剩余的100个就是
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}