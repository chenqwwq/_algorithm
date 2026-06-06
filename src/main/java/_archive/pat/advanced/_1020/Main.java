package top.chenqwwq.pat.advanced._1020;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1020 Tree Traversals (25 point(s))
 * Suppose that all the keys in a binary tree are distinct positive integers. Given the postorder and inorder traversal sequences, you are supposed to output the level order traversal sequence of the corresponding binary tree.
 * <p>
 * Input Specification:
 * Each input file contains one test case. For each case, the first line gives a positive integer N (≤30), the total number of nodes in the binary tree. The second line gives the postorder sequence and the third line gives the inorder sequence. All the numbers in a line are separated by a space.
 * <p>
 * Output Specification:
 * For each test case, print in one line the level order traversal sequence of the corresponding binary tree. All the numbers in a line must be separated by exactly one space, and there must be no extra space at the end of the line.
 * <p>
 * Sample Input:
 * 7
 * 2 3 1 5 7 6 4
 * 1 2 3 4 5 6 7
 * 结尾无空行
 * Sample Output:
 * 4 1 6 3 5 7 2
 * 结尾无空行
 *
 * @author chen
 * @date 2021-08-11
 **/
public class Main {

	public static void main(String[] args) {
		// 获取输入
		Scanner scanner = new Scanner(System.in);
		final int n = Integer.parseInt(scanner.nextLine());
		final String[] postLine = scanner.nextLine().split("\\s");
		final String[] inLine = scanner.nextLine().split("\\s");
		final int[] post = new int[n], in = new int[n];
		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(postLine[i]);
			in[i] = Integer.parseInt(inLine[i]);
		}
		scanner.close();

		int[] ans = new int[n];
		int idx = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{n - 1, 0, n - 1});
		while (!queue.isEmpty()) {
			final int size = queue.size();
			for (int i = 0; i < size; i++) {
				final int[] poll = queue.poll();
				if (poll[0] < 0 || poll[0] >= n || poll[1] > poll[2]) {
					continue;
				}
				ans[idx++] = post[poll[0]];
				if (poll[1] == poll[2]) {
					continue;
				}
				for (int j = poll[1]; j <= poll[2]; j++) {
					if (in[j] == post[poll[0]]) {
						queue.offer(new int[]{poll[0] - poll[2] + j - 1, poll[1], j - 1});
						queue.offer(new int[]{poll[0] - 1, j + 1, poll[2]});
						break;
					}
				}
			}
		}
		System.out.print(ans[0]);
		for (int i = 1; i < n; i++) {
			System.out.printf(" %d", ans[i]);
		}
		System.out.println();
	}
}
