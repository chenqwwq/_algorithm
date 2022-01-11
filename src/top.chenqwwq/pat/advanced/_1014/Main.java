package top.chenqwwq.pat.advanced._1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chen
 * @date 2021-04-15
 **/
public class Main {

    static class Pair {
        int num;

        int time;

        public Pair(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    static DecimalFormat df = new DecimalFormat("00");

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 首行 窗口数 黄线内等待的最大人数 客户数 查询数
        final String[] first = reader.readLine().split(" ");
        final int n = Integer.parseInt(first[0]), m = Integer.parseInt(first[1]) - 1,
                k = Integer.parseInt(first[2]), q = Integer.parseInt(first[3]);

        // 第二行 客户的服务时间
        final String[] second = reader.readLine().split(" ");
        final int[] times = new int[k];
        for (int i = 0; i < k; i++) {
            times[i] = Integer.parseInt(second[i]);
        }

        // 直接模拟开搞
        // 初始化服务窗口
        final Pair[] inService = new Pair[n];
        int customerIdx = 0;
        // 第一批服务的
        for (; customerIdx < n; customerIdx++) {
            inService[customerIdx] = new Pair(customerIdx, times[customerIdx]);
        }
        // 初始化等待队列
        Queue<Pair>[] wait = new Queue[n];
        for (int i = 0; i < n; i++) {
            wait[i] = new LinkedList<>();
        }
        // 第一批排队的
        outer:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 没人了
                if (customerIdx >= k) {
                    break outer;
                }
                wait[j].offer(new Pair(customerIdx, times[customerIdx++]));
            }
        }
        // 记录的服务结束时间
        int[] finish = new int[k];
        // 8点开始到下午5点,一分钟一次循环
        for (int i = 1; i < 540; i++) {
            // 每个窗口服务时间减去
            for (int j = 0; j < n; j++) {
                if (inService[j] != null && --inService[j].time == 0) {
                    // 服务结束
                    finish[inService[j].num] = i;
                    inService[j] = null;

                    // 从等待队列钟弹出一个
                    final Pair ready = wait[j].poll();
                    if (ready != null) {
                        inService[j] = ready;
                    }

                    // 从黄线外进入等待队列
                    if (customerIdx < k) {
                        wait[j].offer(new Pair(customerIdx, times[customerIdx++]));
                    }
                }
            }
        }
        // 到点还在服务的
        for (int i = 0; i < n; i++) {
            if (inService[i] != null) {
                finish[inService[i].num] = 539 + inService[i].time;
            }
        }

        // 查询
        final String[] query = reader.readLine().split("\\s");
        for (int i = 0; i < q; i++) {
            final int idx = Integer.parseInt(query[i]) - 1;
            int number;
            if (finish[idx] == 0 || (number = 8 + finish[idx] / 60) > 17) {
                System.out.print("Sorry\n");
            } else {
                System.out.printf("%s:%s\n", df.format(number), df.format(finish[idx] % 60));
            }
        }

        reader.close();
    }
}
