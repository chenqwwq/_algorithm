package top.chenqwwq.leetcode.archive.$20200418.by_topics.hash;

import java.util.HashMap;

/**
 * 1001. 网格照明
 * <p>
 * 在 N x N 的网格上，每个单元格 (x, y) 上都有一盏灯，其中 0 <= x < N 且 0 <= y < N 。
 * <p>
 * 最初，一定数量的灯是亮着的。lamps[i] 告诉我们亮着的第 i 盏灯的位置。每盏灯都照亮其所在 x 轴、y 轴和两条对角线上的每个正方形（类似于国际象棋中的皇后）。
 * <p>
 * 对于第 i 次查询 queries[i] = (x, y)，如果单元格 (x, y) 是被照亮的，则查询结果为 1，否则为 0 。
 * <p>
 * 在每个查询 (x, y) 之后 [按照查询的顺序]，我们关闭位于单元格 (x, y) 上或其相邻 8 个方向上（与单元格 (x, y) 共享一个角或边）的任何灯。
 * <p>
 * 返回答案数组 answer。每个值 answer[i] 应等于第 i 次查询 queries[i] 的结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：N = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
 * 输出：[1,0]
 * 解释：
 * 在执行第一次查询之前，我们位于 [0, 0] 和 [4, 4] 灯是亮着的。
 * 表示哪些单元格亮起的网格如下所示，其中 [0, 0] 位于左上角：
 * 1 1 1 1 1
 * 1 1 0 0 1
 * 1 0 1 0 1
 * 1 0 0 1 1
 * 1 1 1 1 1
 * 然后，由于单元格 [1, 1] 亮着，第一次查询返回 1。在此查询后，位于 [0，0] 处的灯将关闭，网格现在如下所示：
 * 1 0 0 0 1
 * 0 1 0 0 1
 * 0 0 1 0 1
 * 0 0 0 1 1
 * 1 1 1 1 1
 * 在执行第二次查询之前，我们只有 [4, 4] 处的灯亮着。现在，[1, 0] 处的查询返回 0，因为该单元格不再亮着。
 *  
 * 提示：
 * <p>
 * 1 <= N <= 10^9
 * 0 <= lamps.length <= 20000
 * 0 <= queries.length <= 20000
 * lamps[i].length == queries[i].length == 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/grid-illumination
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2019/12/14 下午9:55
 */
public class $1001_GridIllumination {

    class Solution {
        private final int[] dx = {0, 1, -1, 0, 0, 1, 1, -1, -1};
        private final int[] dy = {0, 0, 0, 1, -1, 1, -1, 1, -1};
        // 记录所有点亮的灯光
        // key = N * x + y
        private final HashMap<Integer, Boolean> light = new HashMap<>();
        // 行
        private final HashMap<Integer, Integer> row = new HashMap<>();
        // 列
        private final HashMap<Integer, Integer> col = new HashMap<>();
        // 正斜线
        private final HashMap<Integer, Integer> forwardSlash = new HashMap<>();
        // 反斜线
        private final HashMap<Integer, Integer> backslash = new HashMap<>();

        private int N = -1;

        public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

            this.N = N;

            // 亮灯
            for (int[] lamp : lamps) {
                openOrDown(true, lamp[0], lamp[1]);
            }

            // 查询
            int[] res = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                res[i] = isLight(queries[i][0], queries[i][1]) ? 1 : 0;
                // 灭灯
                for (int j = 0; j < 9; j++) {
                    openOrDown(false, dx[j] + queries[i][0], dy[j] + queries[i][1]);
                }
            }

            return res;
        }

        private boolean isLight(int x, int y) {
            return row.getOrDefault(x, 0) > 0
                    || col.getOrDefault(y, 0) > 0
                    || forwardSlash.getOrDefault(x - y, 0) > 0
                    || backslash.getOrDefault(x + y, 0) > 0;
        }


        private void openOrDown(boolean openOrDown, int x, int y) {
            // 校验开关正确
            final Boolean orDefault = light.getOrDefault(N * x + y, false);
            if (x >= N || x < 0 || y >= N || y < 0 || orDefault.equals(openOrDown)) {
                return;
            }

            int opera = openOrDown ? 1 : -1;
            row.put(x, row.getOrDefault(x, 0) + opera);
            col.put(y, col.getOrDefault(y, 0) + opera);
            final int i = x - y;
            forwardSlash.put(i, forwardSlash.getOrDefault(i, 0) + opera);
            final int j = x + y;
            backslash.put(j, backslash.getOrDefault(j, 0) + opera);
            light.put(N * x + y, openOrDown);
        }
    }

    // 以数组记录在N较大时直接分配大数组会导致内存超限
   /* class Solution {

        private final int[] dx = {0, 1, -1, 0, 0, 1, 1, -1, -1};
        private final int[] dy = {0, 0, 0, 1, -1, 1, -1, 1, -1};

        public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {

            // 记录所有点亮的灯光
            int[][] light = new int[N][N];
            // 行
            int[] row = new int[N];
            // 列
            int[] col = new int[N];
            // 正斜线 正斜线的坐标(x,y) x-y 范围在(-N+1,N-1)
            // 处理时需要加上一个N-1
            int[] forwardSlash = new int[2 * N - 1];
            // 反斜线 反斜线的坐标(x,y) x+y范围在(0,2N-2)
            int[] backslash = new int[2 * N - 1];


            // 亮灯
            for (int[] lamp : lamps) {
                row[lamp[0]]++;
                col[lamp[1]]++;
                forwardSlash[N - 1 + lamp[0] - lamp[1]]++;
                backslash[lamp[0] + lamp[1]]++;
                light[lamp[0]][lamp[1]]++;
            }

            // 查询
            int[] res = new int[queries.length];

            for (int i = 0; i < queries.length; i++) {
                final boolean isLight = row[queries[i][0]] > 0
                        || col[queries[i][1]] > 0
                        || forwardSlash[N - 1 + queries[i][0] - queries[i][1]] > 0
                        || backslash[queries[i][0] + queries[i][1]] > 0;
                res[i] = isLight ? 1 : 0;
                // 熄灭
                for (int j = 0;j < 9;j++){
                    final int x = dx[j]+ queries[i][0];
                    final int y = dy[j]+ queries[i][1];
                    if(x >= N || x < 0 || y >= N || y < 0 || light[x][y] <= 0){
                        continue;
                    }
                    light[x][y]--;
                    row[x]--;
                    col[y]--;
                    forwardSlash[N - 1 + x - y]--;
                    backslash[x + y]--;
                }
            }

            return res;
        }
    }*/
}


























