package top.chenqwwq.pat.advanced._1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author chen
 * @date 2021/8/28
 **/
public class Main {
	static class Pair {
		String id;
		int score;
		int localNum;
		int localRank;

		public Pair(String id, int score, int localNum) {
			this.id = id;
			this.score = score;
			this.localNum = localNum;
		}
	}

	public static void main(String[] args) throws IOException {
		Comparator<Pair> pairComparator = ((Comparator<Pair>) (o1, o2) -> Integer.compare(o2.score, o1.score)).thenComparing(Comparator.comparing(o -> o.id));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		List<Pair> data = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			final int k = Integer.parseInt(reader.readLine());
			Pair[] local = new Pair[k];
			for (int j = 0; j < k; j++) {
				final String[] line = reader.readLine().split(" ");
				local[j] = new Pair(line[0], Integer.parseInt(line[1]), i + 1);
			}

			Arrays.sort(local, pairComparator);
			int preScore = 0, preRank = 0;
			for (int rank = 1; rank <= k; rank++) {
				if (local[rank - 1].score == preScore) {
					local[rank - 1].localRank = preRank;
				} else {
					preScore = local[rank - 1].score;
					preRank = rank;
					local[rank - 1].localRank = rank;
				}
				data.add(local[rank - 1]);
			}
		}
		reader.close();
		data.sort(pairComparator);
		final int total = data.size();
		System.out.println(total);
		int preRank = 0, preScore = 0;
		for (int rank = 1; rank <= total; rank++) {
			Pair pair = data.get(rank - 1);
			if (pair.score != preScore) {
				preScore = pair.score;
				preRank = rank;
			}
			System.out.println(pair.id + " " + preRank + " " + pair.localNum + " " + pair.localRank);
		}
	}
}
