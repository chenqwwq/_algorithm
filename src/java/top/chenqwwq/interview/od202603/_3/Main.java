package top.chenqwwq.interview.od202603._3;

/**
 * @author chenqwwq
 * @date 2026/3/8
 **/

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            final int N = Integer.parseInt(in.nextLine());
            char[][] map = new char[N][N];
            for (int i = 0; i < N; i++) {
                final String line = in.nextLine();
                final String[] split = line.split(",");
                for (int j = 0; j < N; j++) {
                    map[i][j] = split[j].charAt(0);
                }
            }
            final String target = in.nextLine();

            System.out.println(search(map, target, 0, -1, -1));
        }
    }

    static int[] xx = new int[]{-1, 0, 1, 0};
    static int[] yy = new int[]{0, 1, 0, -1};

    static String search(char[][] map, String s, int cur, int x, int y) {
        if (cur >= s.length()) return "";
        final int n = map.length;
        if (x == -1 || y == -1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == s.charAt(cur)) {
                        map[i][j] = '.';
                        final String search = search(map, s, cur + 1, i, j);
                        if (search != "N") {
                            if (search == "") return i + "," + j;
                            return i + "," + j + "," + search;
                        }
                        map[i][j] = s.charAt(cur);
                    }
                }
            }
            return "N";
        }

        for (int i = 0; i < 4; i++) {
            final int nx = x + xx[i], ny = y + yy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != s.charAt(cur)) continue;
            map[nx][ny] = '.';
            final String search = search(map, s, cur + 1, nx, ny);
            if (search != "N") {
                if (search == "") return nx + "," + ny;
                return nx + "," + ny + "," + search;
            }
            map[nx][ny] = s.charAt(cur);
        }
        return "N";
    }
}