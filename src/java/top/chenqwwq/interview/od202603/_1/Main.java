package top.chenqwwq.interview.od202603._1;

/**
 * @author chenqwwq
 * @date 2026/3/8
 **/

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        out:
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            final String s = in.nextLine();
            final String[] ss = s.split(" ");
            int[] nums = new int[ss.length];
            for (int i = 0; i < ss.length; i++) {
                try {
                    nums[i] = Integer.parseInt(ss[i]);
                } catch (Exception e) {
                    // 输出异常
                    System.out.println("[]");
                    continue out;
                }
            }

            h(nums, true, 0);
            for (int i = 0; i < ss.length; i++) {
                System.out.printf("%d", nums[i]);
                if (i != ss.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    static int[] h(int[] nums, boolean flag, int t) {
        if (t >= nums.length - 1) return nums;
        if (flag) {     // 要大于等于
            if (nums[t] >= nums[t + 1]) {
                return h(nums, !flag, t + 1);
            }
        } else {
            if (nums[t] <= nums[t + 1]) {
                return h(nums, !flag, t + 1);
            }
        }
        swap(nums, t, t + 1);
        return h(nums, !flag, t + 1);
    }
}