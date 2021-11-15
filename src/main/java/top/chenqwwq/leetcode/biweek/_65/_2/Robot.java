package top.chenqwwq.leetcode.biweek._65._2;

/**
 * @author chen
 * @date 2021-11-15
 **/
public class Robot {

	String[] DIREC = new String[]{"East", "North", "West", "South"};
	int[] fx = new int[]{1, 0, -1, 0};
	int[] fy = new int[]{0, 1, 0, -1};

	int[] pos = new int[]{0, 0};
	int forward = 0;
	final int width, height;

	public Robot(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void move(int num) {
		int tx = pos[0] + num * fx[forward], ty = pos[1] + num * fy[forward];
		if (tx < 0) {
			pos[0] = 0;
			forward();
			move(-tx);
		} else if (tx >= width) {
			pos[0] = width - 1;
			forward();
			move(tx - width + 1);
		} else if (ty < 0) {
			pos[1] = 0;
			forward();
			move(-ty);
		} else if (ty >= height) {
			pos[1] = height - 1;
			forward();
			move(ty - height + 1);
		} else {
			pos[0] = tx;
			pos[1] = ty;
		}
	}

	public void forward() {
		forward = ++forward % 4;
	}

	public int[] getPos() {
		return pos;
	}

	public String getDir() {
		return DIREC[forward];
	}
}