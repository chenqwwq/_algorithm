package top.chenqwwq.pat.advanced._1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen
 * @date 2021/8/15
 **/
public class Main {
	private static final String regex = "\\s+";

	static int perfect, stationCnt, sp, rodeCnt;
	static Map<Integer, List<int[]>> rodes;
	static int[] bikeCnt;

	static int send = 0, takeBack = 0, distance = Integer.MAX_VALUE;
	static List<Integer> finalPath;

	public static void main(String[] args) throws IOException {

		/*
		 * dfs 的实现,使用数组去除重复路径
		 * 使用 Dijkstra 或者 Floyd 应该能更快
		 */

		// input
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String[] l1 = reader.readLine().split(regex);
		perfect = Integer.parseInt(l1[0]) >> 1;
		stationCnt = Integer.parseInt(l1[1]);
		sp = Integer.parseInt(l1[2]);
		rodeCnt = Integer.parseInt(l1[3]);

		final String[] l2 = reader.readLine().split(regex);
		bikeCnt = new int[stationCnt + 1];
		for (int i = 0; i < stationCnt; i++) {
			bikeCnt[i + 1] = Integer.parseInt(l2[i]);
		}
		rodes = new HashMap<>();
		for (int i = 0; i < rodeCnt; i++) {
			final String[] rode = reader.readLine().split(regex);
			final int station = Integer.parseInt(rode[0]), station2 = Integer.parseInt(rode[1]), dist = Integer.parseInt(rode[2]);
			final List<int[]> orDefault = rodes.getOrDefault(station, new ArrayList<>());
			orDefault.add(new int[]{station2, dist});
			rodes.put(station, orDefault);

			final List<int[]> orDefault1 = rodes.getOrDefault(station2, new ArrayList<>());
			orDefault1.add(new int[]{station, dist});
			rodes.put(station2, orDefault1);
		}
		reader.close();

		// handle
		List<Integer> path = new ArrayList<>();
		path.add(0);
		dfs(new boolean[rodeCnt + 1], path, 0, 0, 0, 0);

		// print output
		System.out.printf("%d ", send);
		if (finalPath != null && finalPath.size() > 0) {
			System.out.print(finalPath.get(0));
			for (int i = 1; i < finalPath.size(); i++) {
				System.out.printf("->%d", finalPath.get(i));
			}
		}
		System.out.printf(" %d\n", takeBack);
	}

	public static void dfs(boolean[] exist, List<Integer> path, int curr, int s, int t, int dis) {
		if (curr == sp) {
			if (dis < distance || (dis == distance && (send > s || (send == s && takeBack > t)))) {
				send = s;
				takeBack = t;
				finalPath = new ArrayList<>(path);
				distance = dis;
			}
			return;
		}

		final List<int[]> nexts = rodes.get(curr);
		if (nexts == null) {
			return;
		}
		for (int[] next : nexts) {
			if (exist[next[0]] || next[0] == 0) {
				continue;
			}
			int changeCnt = bikeCnt[next[0]] - perfect;
			int send = s, takeBack = t;
			if (changeCnt > 0) {
				takeBack += changeCnt;
			} else if (changeCnt < 0) {
				changeCnt = -changeCnt;
				if (takeBack >= changeCnt) {
					takeBack -= changeCnt;
				} else {
					send += changeCnt - takeBack;
					takeBack = 0;
				}
			}
			path.add(next[0]);
			exist[next[0]] = true;
			dfs(exist, path, next[0], send, takeBack, dis + next[1]);
			path.remove(path.size() - 1);
			exist[next[0]] = false;
		}
	}
}
