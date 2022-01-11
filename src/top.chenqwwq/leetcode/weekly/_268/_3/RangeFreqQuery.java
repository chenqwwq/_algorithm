package top.chenqwwq.leetcode.weekly._268._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021/11/21
 **/
public class RangeFreqQuery {

	private int[] raw;
	private Map<Integer, List<Integer>> hash;

	public RangeFreqQuery(int[] arr) {
		this.raw = arr;
		hash = new HashMap<>();
		final int n = arr.length;
		for (int i = 0; i < n; i++) {
			final List<Integer> orDefault = hash.getOrDefault(arr[i], new ArrayList<>());
			orDefault.add(i);
			hash.put(arr[i], orDefault);
		}
	}

	public int query(int left, int right, int value) {
		final List<Integer> idxs = hash.get(value);
		if (idxs == null || idxs.size() == 0) {
			return 0;
		}

		return floorIndex(idxs, right) - ceilingIndex(idxs, left) + 1;
	}


	/**
	 * 找出大于等于 target 的第一个数
	 */
	public int ceilingIndex(List<Integer> data, int target) {
		int l = 0, r = data.size() - 1;
		while (l <= r) {
			final int mid = (l + r) >> 1;
			if (data.get(mid) < target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}

	/**
	 * 找到比 target 小或者等于的最后一个数
	 */
	public int floorIndex(List<Integer> data, int target) {
		// 找到最后一个比 target 小的值
		int l = 0, r = data.size() - 1;
		while (l <= r) {
			final int mid = (l + r) >> 1;
			if (data.get(mid) > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return r;
	}

}