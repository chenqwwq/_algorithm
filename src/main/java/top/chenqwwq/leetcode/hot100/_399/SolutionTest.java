package top.chenqwwq.leetcode.hot100._399;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [["x1","x2"],["x2","x3"],["x3","x4"],["x4","x5"]]
 * [3.0,4.0,5.0,6.0]
 * [["x1","x5"],["x5","x2"],["x2","x4"],["x2","x2"],["x2","x9"],["x9","x9"]]
 *
 * @author chen
 * @date 2021-08-31
 **/
class SolutionTest {

	@Test
	void calcEquation() {
		Solution solution = new Solution();
		Assertions.assertArrayEquals(new double[]{360.00000,0.00833,20.00000,1.00000,-1.00000,-1.00000}, solution.calcEquation(
				new ArrayList<List<String>>() {{
					add(Arrays.asList("x1", "x2"));
					add(Arrays.asList("x2", "x3"));
					add(Arrays.asList("x3", "x4"));
					add(Arrays.asList("x4", "x5"));
				}},
				new double[]{3.0,4.0,5.0,6.0},
				new ArrayList<List<String>>() {{
					add(Arrays.asList("x1", "x5"));
					add(Arrays.asList("x5", "x2"));
					add(Arrays.asList("x2", "x4"));
					add(Arrays.asList("x2", "x2"));
					add(Arrays.asList("x2", "x9"));
					add(Arrays.asList("x9", "x9"));
				}}
		));
		/**
		 * [["a","b"],["b","c"]]
		 * [2.0,3.0]
		 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
		 */
		Assertions.assertArrayEquals(new double[]{6.00000, 0.50000, -1.00000, 1.00000, -1.00000}, solution.calcEquation(
				new ArrayList<List<String>>() {{
					add(Arrays.asList("a", "b"));
					add(Arrays.asList("b", "c"));
				}},
				new double[]{2.0d, 3.0d},
				new ArrayList<List<String>>() {{
					add(Arrays.asList("a", "c"));
					add(Arrays.asList("b", "a"));
					add(Arrays.asList("a", "e"));
					add(Arrays.asList("a", "a"));
					add(Arrays.asList("x", "x"));
				}}
		));
	}
}