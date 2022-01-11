package top.chenqwwq.leetcode.daily._20210502;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chen
 * @date 2021/5/2
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void leastBricks() {
        assertEquals(0, solution.leastBricks(new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(100000000, 100000000));
                add(Arrays.asList(100000000, 100000000));
            }
        }));
        assertEquals(1, solution.leastBricks(new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(1, 1));
                add(Arrays.asList(2));
                add(Arrays.asList(1, 1));
            }
        }));

        assertEquals(3, solution.leastBricks(new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(1));
                add(Arrays.asList(1));
                add(Arrays.asList(1));
            }
        }));

        assertEquals(2, solution.leastBricks(new ArrayList<List<Integer>>() {
            {
                add(Arrays.asList(1, 2, 2, 1));
                add(Arrays.asList(3, 1, 2));
                add(Arrays.asList(1, 3, 2));
                add(Arrays.asList(2, 4));
                add(Arrays.asList(3, 1, 2));
                add(Arrays.asList(1, 3, 1, 1));
            }
        }));
    }
}