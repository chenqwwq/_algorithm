package top.chenqwwq.interview.od202603._2;

/**
 * @author chenqwwq
 * @date 2026/3/8
 **/

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int n = Integer.parseInt(in.nextLine());
        int[][] ns = new int[n][n];
        int t = 0;
        while (t < n) {
            final String line = in.nextLine();
            final String[] ss = line.split(" ");
            for (int i = 0; i < n; i++) {
                ns[t][i] = Integer.parseInt(ss[i]);
            }
            t++;
        }
        int k = Integer.parseInt(in.nextLine()) - 1;
        // dfs 求最长的依赖路径所需时间
        final int ans = dfs(ns, k);
        System.out.println(ans);
    }

    private static int dfs(int[][] ns, int k) {
        if (k == -1) return 0;
        int time = 0;
        for (int i = 0; i < ns.length; i++) {
            if (ns[k][i] == 0 || i == k) continue;
            time = Math.max(time, dfs(ns, i));
        }
        return time + ns[k][k];
    }
}