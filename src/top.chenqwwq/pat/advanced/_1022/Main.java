package top.chenqwwq.pat.advanced._1022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Each input file contains one test case. For each case, the first line contains a positive integer N (≤10
 * 4
 * ) which is the total number of books. Then N blocks follow, each contains the information of a book in 6 lines:
 * <p>
 * Line #1: the 7-digit ID number;
 * Line #2: the book title -- a string of no more than 80 characters;
 * Line #3: the author -- a string of no more than 80 characters;
 * Line #4: the key words -- each word is a string of no more than 10 characters without any white space, and the keywords are separated by exactly one space;
 * Line #5: the publisher -- a string of no more than 80 characters;
 * Line #6: the published year -- a 4-digit number which is in the range [1000, 3000].
 * It is assumed that each book belongs to one author only, and contains no more than 5 key words; there are no more than 1000 distinct key words in total; and there are no more than 1000 distinct publishers.
 * <p>
 * After the book information, there is a line containing a positive integer M (≤1000) which is the number of user's search queries. Then M lines follow, each in one of the formats shown below:
 * <p>
 * 1: a book title
 * 2: name of an author
 * 3: a key word
 * 4: name of a publisher
 * 5: a 4-digit number representing the year
 * Output Specification:
 * For each query, first print the original query in a line, then output the resulting book ID's in increasing order, each occupying a line. If no book is found, print Not Found instead.
 *
 * @author chen
 * @date 2021-08-26
 **/
public class Main {

	private static void add(Map<String, Set<Integer>> map, String key, Integer id) {
		final Set<Integer> orDefault = map.getOrDefault(key, new HashSet<>());
		orDefault.add(id);
		map.put(key, orDefault);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final int n = Integer.parseInt(reader.readLine());
		Map<String, Set<Integer>>[] map = new HashMap[5];
		for (int i = 0; i < 5; i++) {
			map[i] = new HashMap<>();
		}

		for (int i = 0; i < n; i++) {
			int id = Integer.parseInt(reader.readLine());
			for (int j = 0; j < 5; j++) {
				final String value = reader.readLine();
				if (j == 2) {
					for (String v : value.split(" ")) {
						add(map[j], v, id);
					}
				} else {
					add(map[j], value, id);
				}
			}
		}

		final int m = Integer.parseInt(reader.readLine());
		for (int i = 0; i < m; i++) {
			final String line = reader.readLine();
			final String[] split = line.split(":");
			int type = Integer.parseInt(split[0]);
			String search = split[1].trim();
			System.out.println(line);
			final Set<Integer> res = map[type - 1].get(search);
			if (res == null || res.size() == 0) {
				System.out.println("Not Found");
				continue;
			}
			final List<Integer> integers = new ArrayList<>(res);
			integers.sort(Integer::compare);
			for (Integer ans : integers) {
				System.out.println(ans);
			}
		}
	}
}
