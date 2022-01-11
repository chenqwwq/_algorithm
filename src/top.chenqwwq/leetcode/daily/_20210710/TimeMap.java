package top.chenqwwq.leetcode.daily._20210710;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chen
 * @date 2021/7/10
 **/
public class TimeMap {

	Map<String, TreeMap<Integer, String>> data;

	/**
	 * Initialize your data structure here.
	 */
	public TimeMap() {
		data = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> map = data.getOrDefault(key, new TreeMap<>());
		map.put(timestamp, value);
		data.put(key, map);
	}

	public String get(String key, int timestamp) {
		TreeMap<Integer, String> ts = data.get(key);
		if (ts == null) {
			return "";
		}
		Map.Entry<Integer, String> entry = ts.floorEntry(timestamp);
		return entry == null ? "" : entry.getValue();
	}
}
