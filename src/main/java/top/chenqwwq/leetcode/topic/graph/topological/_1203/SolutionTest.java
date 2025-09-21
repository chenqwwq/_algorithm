package top.chenqwwq.leetcode.topic.graph.topological._1203;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author chen
 * @date 2021-05-13
 **/
class SolutionTest {

	Solution solution = new Solution();

	@Test
	void sortItems() {


		/**
		 * [5,2,6,3,4,0,1,7]
		 * [6,3,4,1,5,2,0,7]
		 * [7,1,5,2,0,6,3,4]
		 */
		Assertions.assertArrayEquals(new int[]{5, 2, 6, 3, 4, 0, 1, 7}, solution.sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, new LinkedList<java.util.List<Integer>>() {
			{
				add(Arrays.asList());
				add(Arrays.asList(6));
				add(Arrays.asList(5));
				add(Arrays.asList(6));
				add(Arrays.asList(3, 6));
				add(Arrays.asList());
				add(Arrays.asList());
				add(Arrays.asList());
			}
		}));

		/**
		 * * 5
		 *  * 5
		 *  * [2,0,-1,3,0]
		 *  * [[2,1,3],[2,4],[],[],[]]
		 *  *
		 *  * [3,2,4,1,0]
		 *  *
		 *  * [3,4,1,0,2]
		 *
		 *  [2, 3, 4, 1, 0]
		 */

		Assertions.assertArrayEquals(new int[]{2, 3, 4, 1, 0}, solution.sortItems(5, 5, new int[]{2, 0, -1, 3, 0}, new LinkedList<java.util.List<Integer>>() {
			{
				add(Arrays.asList(2, 1, 3));
				add(Arrays.asList(2, 4));
				add(Arrays.asList());
				add(Arrays.asList());
				add(Arrays.asList());
			}
		}));
		/**
		 *4
		 * 1
		 * [-1,0,0,-1]
		 * [[],[0],[1,3],[2]]
		 */
		Assertions.assertArrayEquals(new int[]{}, solution.sortItems(4, 1, new int[]{-1, 0, 0, -1}, new LinkedList<java.util.List<Integer>>() {
			{
				add(Arrays.asList());
				add(Arrays.asList(0));
				add(Arrays.asList(1, 3));
				add(Arrays.asList(2));
			}
		}));

		Assertions.assertArrayEquals(new int[]{}, solution.sortItems(8, 2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, new LinkedList<java.util.List<Integer>>() {
			{
				add(Arrays.asList());
				add(Arrays.asList(6));
				add(Arrays.asList(5));
				add(Arrays.asList(6));
				add(Arrays.asList(3));
				add(Arrays.asList());
				add(Arrays.asList(4));
				add(Arrays.asList());
			}
		}));
	}
}