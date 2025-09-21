package top.chenqwwq.leetcode.contest.weekly._190._1;

/**
 * 5416. 检查单词是否为句中其他单词的前缀
 * <p>
 * 给你一个字符串 sentence 作为句子并指定检索词为 searchWord ，其中句子由若干用 单个空格 分隔的单词组成。
 * <p>
 * 请你检查检索词 searchWord 是否为句子 sentence 中任意单词的前缀。
 * <p>
 * 如果 searchWord 是某一个单词的前缀，则返回句子 sentence 中该单词所对应的下标（下标从 1 开始）。
 * 如果 searchWord 是多个单词的前缀，则返回匹配的第一个单词的下标（最小下标）。
 * 如果 searchWord 不是任何单词的前缀，则返回 -1 。
 * 字符串 S 的 「前缀」是 S 的任何前导连续子字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence 由小写英文字母和空格组成。
 * searchWord 由小写英文字母组成。
 * 前缀就是紧密附着于词根的语素，中间不能插入其它成分，并且它的位置是固定的——-位于词根之前。（引用自 前缀_百度百科 ）
 *
 * @author chen
 * @date 2020/5/24 上午10:30
 */
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        if (sentence == null || sentence.length() == 0) {
            return -1;
        }
        int i = 1;
        for (String s : sentence.split(" ")) {
            if (s.startsWith(searchWord)) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
