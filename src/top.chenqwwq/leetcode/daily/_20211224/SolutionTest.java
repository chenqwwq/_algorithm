package top.chenqwwq.leetcode.daily._20211224;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author chenbingxin
 * @date 2021/12/24
 **/
class SolutionTest {

    @Test
    void eatenApples() {
        Solution solution = new Solution();
        Assertions.assertEquals(4,solution.eatenApples(new int[]{2,1,10},new int[]{2,10,1}));
        Assertions.assertEquals(7,solution.eatenApples(new int[]{1,2,3,5,2},new int[]{3,2,1,4,2}));
        Assertions.assertEquals(4,solution.eatenApples(new int[]{1,1,0,1,1},new int[]{1,1,0,1,1}));
        Assertions.assertEquals(5,solution.eatenApples(new int[]{3,0,0,0,0,2},new int[]{3,0,0,0,0,2}));
        Assertions.assertEquals(10,solution.eatenApples(new int[]{1,2,3,5,2,2,3,5,2},new int[]{3,2,1,4,2,3,2,1,4}));
    }
}