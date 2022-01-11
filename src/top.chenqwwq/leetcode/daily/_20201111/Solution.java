package top.chenqwwq.leetcode.daily._20201111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 514. 自由之路
 * 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * 示例：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * 解释:
 * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 * 当然, 我们还需要1步进行拼写。
 * 因此最终的输出是 4。
 * 提示：
 * <p>
 * ring 和 key 的字符串长度取值范围均为 1 至 100；
 * 两个字符串中都只有小写字符，并且均可能存在重复字符；
 * 字符串 key 一定可以由字符串 ring 旋转拼出。
 *
 * @author chen
 * @date 2020-11-11
 **/
public class Solution {

    public int findRotateSteps(String ring, String key) {
        // dfs
        Map<Character, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            final char c = ring.charAt(i);
            final List<Integer> orDefault = hash.getOrDefault(c, new ArrayList<>());
            orDefault.add(i);
            hash.put(c, orDefault);
        }

        // 以上记录下每个字符的位置
        // 以首个字符作为0

        return dfs(hash, key, 0, 0, 0, ring.length());
    }

    public int dfs(Map<Character, List<Integer>> hash, String key, int curr, int idx, int step, int total) {
        // 已经完成了
        if (idx >= key.length()) {
            return step;
        }

        // 未完成，当前坐标在curr
        final List<Integer> idxs = hash.get(key.charAt(idx));
        int ans = Integer.MAX_VALUE;
        for (int i : idxs) {
            ans = Math.min(dfs(hash, key, i, idx + 1, 1 + step + Math.min(Math.abs(curr - i), Math.abs(total - curr + i)), total), ans);
        }
        return ans;
    }

}





















