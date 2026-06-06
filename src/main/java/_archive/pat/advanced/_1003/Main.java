package top.chenqwwq.pat.advanced._1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chen
 * @date 2021-03-24
 * @see <a href="https://pintia.cn/problem-sets/994805342720868352/problems/994805523835109376"></a>
 **/
public class Main {
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;
    static int max = Integer.MIN_VALUE;

    static void dfs(int src, int des, int currDst, int rescueCnt, int cityCnt, int[][] roads, int[] marked, int[] rescuesCnt) {
        if (src == des) {
            if (currDst == min) {
                cnt++;
                max = Math.max(rescueCnt, max);
            } else if (currDst < min) {
                min = currDst;
                cnt = 1;
                max = rescueCnt;
            }
            return;
        }

        // 最后一个测试用例，此处必须拦截，否则会超时
        if (currDst > min) {
            return;
        }

        for (int i = 0; i < cityCnt; i++) {
            if (marked[i] == -1 || src == i || roads[src][i] == 0) {
                continue;
            }
            marked[i] = -1;
            dfs(i, des, currDst + roads[src][i], rescueCnt + rescuesCnt[i], cityCnt, roads, marked, rescuesCnt);
            marked[i] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 读取城市数目，道路数目，当前所在城市，目标城市
        String[] arr = in.readLine().split(" ");
        final int cityCnt = Integer.parseInt(arr[0]), roadCnt = Integer.parseInt(arr[1]), currCity = Integer.parseInt(arr[2]), mustSave = Integer.parseInt(arr[3]);

        // 读取各城市救援队人数
        int[] rescueCnt = new int[cityCnt];
        arr = in.readLine().split(" ");
        for (int i = 0; i < cityCnt; i++) {
            rescueCnt[i] = Integer.parseInt(arr[i]);
        }
        int[][] roads = new int[cityCnt][cityCnt];
        // 读取道路信息
        for (int i = 0; i < roadCnt; i++) {
            arr = in.readLine().split(" ");
            final int s1 = Integer.parseInt(arr[0]), s2 = Integer.parseInt(arr[1]), len = Integer.parseInt(arr[2]);
            roads[s1][s2] = roads[s2][s1] = len;
        }

        int[] marked = new int[cityCnt];
        marked[currCity] = -1;

        dfs(currCity, mustSave, 0, rescueCnt[currCity], cityCnt, roads, marked, rescueCnt);

        System.out.printf("%d %d\n", cnt, max);
    }
}
