package top.chenqwwq.leetcode.daily._20210520;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * <p>
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 * 出现次数依次为 4, 3, 2 和 1 次。
 * <p>
 * <p>
 * 注意：
 * <p>
 * 假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 * 输入的单词均由小写字母组成。
 * <p>
 * <p>
 * 扩展练习：
 * <p>
 * 尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 * @author chen
 * @date 2021/5/20
 **/
public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		// 优先级队列的板子题
		Map<String, Integer> hash = new HashMap<>();
		for (String word : words) {
			hash.put(word, hash.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparing(hash::get).thenComparing((o1, o2) -> ((String) o2).compareTo((String) o1)));
		for (String word : hash.keySet()) {
			queue.offer(word);
			while (queue.size() > k) {
				queue.poll();
			}
		}

		final List<String> ans = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ans.add(queue.poll());
		}
		Collections.reverse(ans);
		return ans;
	}
}
