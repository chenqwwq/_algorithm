package top.chenqwwq.leetcode.contest.biweek._57._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021/7/24
 **/
class SolutionTest {


	@Test
	void smallestChair() {
		Solution solution = new Solution();
		Assertions.assertEquals(2, solution.smallestChair(new int[][]{
				{33889, 98676}, {80071, 89737}, {44118, 52565}, {52992, 84310}, {78492, 88209}, {21695, 67063}, {84622, 95452}, {98048, 98856}, {98411, 99433}, {55333, 56548}, {65375, 88566}, {55011, 62821}, {48548, 48656}, {87396, 94825}, {55273, 81868}, {75629, 91467}
		}, 6));
	}
}