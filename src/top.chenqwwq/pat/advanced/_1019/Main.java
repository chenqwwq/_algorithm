package top.chenqwwq.pat.advanced._1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021/8/16
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String[] line = reader.readLine().split("\\s+");
		int n = Integer.parseInt(line[0]), b = Integer.parseInt(line[1]);
		reader.close();

		List<Integer> nums = new ArrayList<>();
		while (n > 0) {
			nums.add(n % b);
			n /= b;
		}

		final int cnt = nums.size();
		boolean isOk = true;
		for (int i = 0; i < cnt >> 1; i++) {
			if (nums.get(i) != nums.get(cnt - i - 1)) {
				isOk = false;
				break;
			}
		}
		System.out.println(isOk ? "Yes" : "No");
		System.out.print(nums.get(cnt - 1));
		for (int i = cnt - 2; i >= 0; i--) {
			System.out.printf(" %d", nums.get(i));
		}
		System.out.println();
	}
}
