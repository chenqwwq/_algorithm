package top.chenqwwq.leetcode.daily._2021._20211216;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenbingxin
 * @date 2021/12/16
 **/
public class Solution {
	public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
		// 题目主要是角度的表示
		// 按照角度排序，之后就是头尾相连的滑动窗口
		final int x = location.get(0),y = location.get(1);

		int ans = 0;
		List<Double> list  = new ArrayList<>();
		for (List<Integer> point : points){
			final int a = point.get(0),b = point.get(1);
			if(a == x && b == y) {
				ans++;
				continue;
			}
			list.add(Math.atan2(b-y,a-x) + Math.PI);
		}

		Collections.sort(list);
		final int n = list.size();
		for (int i = 0;i < n;i++){
			list.add(list.get(i) + Math.PI);
		}


		return -1;
	}
}