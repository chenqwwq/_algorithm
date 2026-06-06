package top.chenqwwq.pat.advanced._1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chen
 * @date 2021-04-09
 **/
public class Main {
    static char[] types = {'A', 'C', 'M', 'E'};

    static String UNKNOWN = "N/A";

    static class Pair {
        int rank = Integer.MAX_VALUE;
        int type;

        public Pair() {
        }

        public Pair(int rank, int type) {
            this.rank = rank;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] line = reader.readLine().split(" ");
        // 最后要的是zu排名和学科

        // N表示有N个学生  M表示查成绩的学生
        int N = Integer.parseInt(line[0]), M = Integer.parseInt(line[1]);
        // 首位是学号 后面是学科成绩
        // studentId | A | C | M | E
        int[][] scores = new int[N][5];

        // 读取每个学生的成绩
        for (int i = 0; i < N; i++) {
            final String[] tmp = reader.readLine().split(" ");
            System.out.println(Arrays.toString(tmp));
            int sum = 0;
            final int studentId = Integer.parseInt(tmp[0]);
            scores[i][0] = studentId;
            for (int j = 2; j <= 4; j++) {
                final int score = Integer.parseInt(tmp[j - 1]);
                scores[i][j] = score;
                sum += score;
            }
            scores[i][1] = sum / 3;
        }
        Map<Integer, Pair> hash = new HashMap<>();
        // 分别按照 CMEA 排序
        for (int i = 1; i < 5; i++) {
            final int t = i;
            // 全数组排序的方式会连带着一起移动,所以造成超时
            Arrays.sort(scores, Comparator.comparingInt(a -> -a[t]));
            int j = 1;
            for (int q = 0; q < N; q++) {
                if (q > 0 && scores[q][i] < scores[q - 1][i]) {
                    j++;
                }
                final Pair orDefault = hash.getOrDefault(scores[q][0], new Pair());
                if (j < orDefault.rank) {
                    hash.put(scores[q][0], new Pair(j, types[i - 1]));
                }
            }
        }

        while (--M >= 0) {
            final int studentId = Integer.parseInt(reader.readLine());
            final Pair pair = hash.get(studentId);
            if (pair == null) {
                System.out.printf("%s\n", UNKNOWN);
            } else {
                System.out.printf("%d %c\n", pair.rank, pair.type);
            }
        }
        reader.close();
    }
}
