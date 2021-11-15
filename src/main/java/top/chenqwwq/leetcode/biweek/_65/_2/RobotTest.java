package top.chenqwwq.leetcode.biweek._65._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ["Robot","move","move","getPos","getDir","move","move","move","getPos","getDir"]
 * [[6,3],[2],[2],[],[],[2],[1],[4],[],[]]\
 *
 * @author chen
 * @date 2021-11-15
 **/
class RobotTest {

	static Robot robot = new Robot(6, 3);

	@Test
	void move() {
		robot.move(2);
		robot.move(2);
		Assertions.assertArrayEquals(new int[]{4, 0}, robot.getPos());
		Assertions.assertEquals("East", robot.getDir());

		robot.move(2);
		robot.move(1);
		robot.move(4);
		Assertions.assertArrayEquals(new int[]{1, 2}, robot.getPos());
		Assertions.assertEquals("West", robot.getDir());
	}
}