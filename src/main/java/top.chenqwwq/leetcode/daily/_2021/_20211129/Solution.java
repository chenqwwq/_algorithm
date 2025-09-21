package top.chenqwwq.leetcode.daily._2021._20211129;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chenbingxin
 * @date 2021/11/29
 **/
public class Solution {
	public int[] kthSmallestPrimeFraction(int[] arr, int k) {
		final int n = arr.length;
		final Comparator<int[]> comparator = (o1, o2) -> Integer.compare(o1[0] * o2[1], o2[0] * o1[1]);
		PriorityQueue<int[]> queue = new PriorityQueue<>(comparator.reversed());
		for (int i = 0; i < n; i++) {
			for (int j = i + 1;j < n;j++ ){
				final int[] target = new int[]{arr[i],arr[j]};
				if(queue.size() < k){
					queue.offer(target);
				}else if(comparator.compare(queue.peek(),target) > 0){
					queue.poll();
					queue.offer(target);
				}
			}
		}
		return queue.poll();
	}
}