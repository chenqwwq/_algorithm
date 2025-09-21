package top.chenqwwq.leetcode.contest.weekly._189._2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 5413. 重新排列句子中的单词 显示英文描述
 * 「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
 * <p>
 * 句子的首字母大写
 * text 中的每个单词都用单个空格分隔。
 * 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
 * <p>
 * 请同样按上述格式返回新的句子
 *
 * @author chen
 * @date 2020/5/17 上午11:12
 */
public class Solution {
    public String arrangeWords(String text) {
        if (text == null || text.length() == 0) {
            return "";
        }

        final String[] afterSplit = ((char) (text.charAt(0) + 32) + text.substring(1)).split(" ");
        Entity[] entities = new Entity[afterSplit.length];
        for (int i = 0; i < afterSplit.length; i++) {
            entities[i] = new Entity(afterSplit[i], i);
        }

        Arrays.sort(entities, Comparator.comparing((Entity o) -> o.value.length()).thenComparingInt(o -> o.idx));

        String[] res = new String[afterSplit.length];
        for (int i = 0; i < afterSplit.length; i++) {
            res[i] = entities[i].value;
        }

        final String join = String.join(" ", res);
        return (char) (join.charAt(0) - 32) + join.substring(1);
    }

    class Entity {
        String value;
        Integer idx;

        public Entity(String value, Integer idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}