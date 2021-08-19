package top.chenqwwq.pat.advanced._1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BFS 求最大深度，以及图的连通兴
 *
 * @author chen
 * @date 2021-08-17
 **/
public class Main {
	static Map<Integer, Set<Integer>> map = new HashMap<>();

	private static void addNode(int i, int j) {
		final Set<Integer> orDefault = map.getOrDefault(i, new HashSet<>(n - 1));
		orDefault.add(j);
		map.put(i, orDefault);
	}

	static int n;
	static int deep = 0, components = 0;
	static Set<Integer> nodes = new HashSet<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		visit = new boolean[n + 1];
		for (int i = 0; i < n - 1; i++) {
			final String[] line = reader.readLine().split("\\s+");
			final int n1 = Integer.parseInt(line[0]), n2 = Integer.parseInt(line[1]);
			addNode(n1, n2);
			addNode(n2, n1);
		}
		reader.close();
		System.gc();

		// 判断是否连通
		if (!connected()) {
			System.out.printf("Error: %d components\n", components);
			return;
		}
		System.gc();

		// 找到最大根
		getDeepest();


		List<Integer> ans = new ArrayList<>(nodes);
		ans.sort(Integer::compare);

		for (int num : ans) {
			System.out.println(num);
		}
		System.gc();
	}

	static void getDeepest() {
		Arrays.fill(visit, false);
		for (int i = 1; i <= n; i++) {
			getDeep(i, visit, 1);
		}
	}

	static void getDeep(int num, boolean[] visit, int curr) {
		if (visit[num]) {
			return;
		}
		if (curr > deep) {
			nodes.clear();
			deep = curr;
			nodes.add(num);
		} else if (curr == deep) {
			nodes.add(num);
		}
		visit[num] = true;
		final Set<Integer> nexts = map.get(num);
		if (nexts == null || nexts.isEmpty()) {
			visit[num] = false;
			return;
		}
		for (int next : nexts) {
			getDeep(next, visit, curr + 1);
		}
		visit[num] = false;
	}

	static boolean connected() {
		for (int i = 1; i <= n; i++) {
			if (visit[i]) {
				continue;
			}
			components++;
			dfs(i);
		}
		return components == 1;
	}

	static void dfs(int curr) {
		if (visit[curr]) {
			return;
		}
		visit[curr] = true;
		final Set<Integer> nexts = map.get(curr);
		if (nexts == null || nexts.isEmpty()) {
			return;
		}
		for (int next : nexts) {
			dfs(next);
		}
	}
}
