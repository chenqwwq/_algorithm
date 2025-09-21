package top.chenqwwq.leetcode.archive.lcof2._30;

import java.util.*;

/**
 * @author chenbingxin
 * @date 2021/12/22
 **/
public class RandomizedSet {

	final List<Integer> list;
	final Map<Integer, Integer> map;
	final Random random;

	/**
	 * Initialize your data structure here.
	 */
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
		random = new Random();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		final Integer idx = map.remove(val);
		final Integer last = list.get(list.size() - 1);
		list.set(idx, last);
		map.put(last, idx);
		list.remove(list.size()-1);
		map.remove(val);
		return true;
	}

	/**
	 * Get a random element from the set.
	 */
	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
}

