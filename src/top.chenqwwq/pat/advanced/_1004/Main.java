package top.chenqwwq.pat.advanced._1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author chen
 * @date 2021/3/25
 **/
public class Main {

    private static void bfs(List<Integer> curr, Map<Integer, List<Integer>> nodes, boolean printSpace) {
        if (curr.isEmpty()) {
            return;
        }
        List<Integer> next = new ArrayList<>();
        int cnt = 0;
        for (int i : curr) {
            if (!nodes.containsKey(i)) {
                cnt++;
                continue;
            }
            next.addAll(nodes.get(i));
        }

        if (printSpace) {
            System.out.printf("%d", cnt);
        } else {
            System.out.printf(" %d", cnt);
        }
        bfs(next, nodes, false);
    }

    public static void main(String[] args) throws IOException {
        // 输入
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String regex = " ";
        String[] firstLine = in.readLine().split(regex);
        int nodeCnt = Integer.parseInt(firstLine[0]), notLeafCnt = Integer.parseInt(firstLine[1]);
        if (nodeCnt == 0 || notLeafCnt == 0) {
            System.out.printf("%d", nodeCnt);
            return;
        }

        // 将节点整理为一个Map <ID,chileList>
        Map<Integer, List<Integer>> nodes = new HashMap<>(notLeafCnt);
        while (notLeafCnt-- > 0) {
            String[] line = in.readLine().split(regex);
            int id = Integer.parseInt(line[0]), childCnt = Integer.parseInt(line[1]);
            if (childCnt == 0) {
                continue;
            }
            List<Integer> child = new ArrayList<>(childCnt);
            for (int i = 0; i < childCnt; i++) {
                child.add(Integer.parseInt(line[i + 2]));
            }
            nodes.put(id, child);
        }

        // bfs
        bfs(Arrays.asList(1), nodes, true);

        // 末尾空行
        System.out.println();
    }
}
