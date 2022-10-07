package top.chenqwwq.leetcode.contest.weekly._243._3;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author chen
 * @date 2021/5/30
 **/
public class Solution {

	static class InUse {
		int server;
		int time;

		public InUse(int server, int time) {
			this.server = server;
			this.time = time;
		}
	}

	public int[] assignTasks(int[] servers, int[] tasks) {
		// 就绪的服务器
		PriorityQueue<Integer> readyServer = new PriorityQueue<>(((Comparator<Integer>) (o1, o2) -> Integer.compare(servers[o1], servers[o2])).thenComparing(Integer::compare));
		PriorityQueue<InUse> inUseServer = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
		for (int i = 0; i < servers.length; i++) {
			readyServer.offer(i);
		}
		int second = 0;
		int currTask = 0;
		int[] ans = new int[tasks.length];
		while (currTask < tasks.length) {
			while (!inUseServer.isEmpty() && inUseServer.peek().time <= second) {
				readyServer.offer(inUseServer.poll().server);
			}
			// 如果还有就绪的服务器
			while (!readyServer.isEmpty() && currTask < second && currTask < tasks.length) {
				// 找到权重最小的服务
				final Integer server = readyServer.poll();
				ans[currTask] = server;
				// 添加任务,以及任务完成时间
				inUseServer.offer(new InUse(server, second + tasks[currTask++]));
			}

			if (readyServer.isEmpty()) {
				final InUse overServer = inUseServer.poll();
				second = overServer.time;
				readyServer.offer(overServer.server);
			} else {
				second++;
			}
		}
		return ans;
	}
}