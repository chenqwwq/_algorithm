package top.chenqwwq.leetcode.topic.hash._1010;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 *
 * @author chen
 * @date 2020/5/18 下午9:24
 */
public class Solution {


    public int numPairsDivisibleBy60(int[] time) {
        if (time == null || time.length == 0) {
            return 0;
        }

        int[] hash = new int[60];
        for (int i : time) {
            hash[(i % 60)]++;
        }
        hash[0] = (((hash[0] * (hash[0] - 1))) / 2 + ((hash[30] * (hash[30] - 1)) / 2));

        for (int i = 1; i < 30; i++) {
            hash[0] += (hash[i] * hash[60 - i]);
        }

        return hash[0];
    }
}