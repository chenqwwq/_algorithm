package top.chenqwwq.leetcode.daily._2025._20250308;

import java.util.Arrays;
import java.util.Map;

/**
 * @author chenqwwq
 * @date 2025/3/8
 **/
public class Solution {

    public static void main(String[] args) {
        final long l = new Solution().maximumBeauty(new int[]{8, 2}, 24, 18, 6, 3);
        System.out.println(l);
    }

    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        final int n = flowers.length;
        // 排序
        Arrays.sort(flowers);
        // 前缀和
        final long[] ps = new long[n];
        // 满的花园数量
        int cnt = 0;
        // 不满花园花的数量
        long fc = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) ps[i] = flowers[i];
            else ps[i] = ps[i - 1] + flowers[i];
            if (flowers[i] >= target) cnt++;
            else fc += flowers[i];
        }

        if (cnt == n) return (long) n * full;

        // 能全部填满
        if ((long) (n - cnt) * target - fc <= newFlowers) {
            System.out.println(1);
            return Math.max((long) (target - 1) * partial + (long) (n - 1) * full, (long) n * full);
        }


        // 无法全部填满
        // 遍历能填满的花园
        long nf = 0, ans = 0;
        for (int i = 1; i <= n; i++) {
            // 填满所需要的花
            nf += Math.max(target - flowers[n - i], 0);
            // 剩余的花,用于填充数组前半部分不满 target 的
            // 尽量抬高最低数
            long lf = newFlowers - nf;
            if (lf < 0) break;
            long num = h(ps, flowers, lf, n - i - 1);
            ans = Math.max(ans, num * partial + (long) i * full);
        }
        return ans;
    }

    private long h(long[] fs, int[] flowers, long lf, int r) {
        // num 填充 flowers 的 l-r 的部分所能获取得到最大最小值
        int l = 0;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            long nf = (long) flowers[mid] * (mid + 1) - fs[mid];
            // 需要的花不够
            if (nf > lf) r = mid - 1;
            else l = mid;
        }
        return (fs[l] + lf) / (l + 1);
    }
}