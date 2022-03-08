package top.chenqwwq;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-21
 **/
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void getMinShop() {
        Assertions.assertArrayEquals(new int[]{3}, solution.getMinShop(new int[]{2, 3, 4, 5}, new int[][]{

                {1, 1, 1, 1},
                {1, 2, 3, 4},
                {3, 2, 0, 4},
                {8, 3, 5, 5}
        }).stream().mapToInt(Integer::intValue).toArray());

        final int[] actual = solution.getMinShop(new int[]{2, 3, 4, 5}, new int[][]{
                {1, 1, 1, 1},
                {1, 2, 3, 4},
                {3, 2, 0, 4},
                {1, 3, 1, 5}
        }).stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertArrayEquals(new int[]{0, 1}, actual);

        Assertions.assertNull(solution.getMinShop(new int[]{2, 3, 4, 5}, new int[][]{
                {1, 1, 1, 1},
                {1, 1, 3, 1},
                {3, 2, 0, 1},
                {1, 3, 5, 1}
        }));
    }
}