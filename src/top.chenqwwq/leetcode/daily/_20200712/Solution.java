package top.chenqwwq.leetcode.daily._20200712;

/**
 * 174. 地下城游戏
 * <p>
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 *  
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *  
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chen
 * @date 2020/7/12 下午3:56
 */
public class Solution {
    // 从起点开始没法确定最小需要的生命值,需要确定的话可能还不如dfs
//    public int calculateMinimumHP(int[][] dungeon) {
//        // dp
//        int[][] dp = new int[dungeon.length][dungeon[0].length];
//        dp[0][0] = dungeon[0][0];
//
//        // 初始化左和上边
//        for (int i = 1; i < dungeon[0].length; i++) {
//            dp[0][i] = dp[0][i - 1] + dungeon[0][i];
//        }
//        for (int i = 1; i < dungeon.length; i++) {
//            dp[i][0] = dp[i - 1][0] + dungeon[i][0];
//        }
//
//        // 每次都只能向右或者下
//        // 所以每次的的最优解由上和左边决定
//        // dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1) + dungeon[i][j]
//        for (int i = 1; i < dungeon[0].length; i++) {
//            for (int j = 1; j < dungeon.length; j++) {
//                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + dungeon[i][j];
//            }
//        }
//
//        return dp[dungeon[0].length - 1][dungeon.length - 1];
//    }

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        final int bottom = dungeon.length - 1;
        final int right = dungeon[0].length - 1;
        dp[bottom][right] = greaterThan0Or1(1 - dungeon[bottom][right]);

        for (int i = dungeon.length - 2; i >= 0; --i) {
            dp[i][right] = greaterThan0Or1(dp[i + 1][right] - dungeon[i][right]);
        }

        for (int i = dungeon[0].length - 2; i >= 0; --i) {
            dp[bottom][i] = greaterThan0Or1(dp[bottom][i + 1] - dungeon[bottom][i]);
        }

        // 开始反向推导
        for (int i = dungeon.length - 2; i >= 0; --i) {
            for (int j = dungeon[0].length - 2; j >= 0; --j) {
                int t1 = greaterThan0Or1(dp[i + 1][j] - dungeon[i][j]);
                int t2 = greaterThan0Or1(dp[i][j + 1] - dungeon[i][j]);
                dp[i][j] = Math.min(t1, t2);
            }
        }

        return dp[0][0];
    }

    private int greaterThan0Or1(int i) {
        return i > 0 ? i : 1;
    }
}
