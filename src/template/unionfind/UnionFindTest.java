package top.chenqwwq.basis.unionfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-06-08
 **/
class UnionFindTest {

	@Test
	void compressionFind() {
		final UnionFind unionFind = new UnionFind(6);
		unionFind.merge(0, 1);
		unionFind.merge(3, 4);
		unionFind.merge(3, 2);
		unionFind.merge(2, 1);
		unionFind.merge(5, 1);
		for (int i = 0; i < 6; i++) {
			unionFind.compressionFind(i);
		}
		int ans = 0;
		for (int num : unionFind.data) {
			ans ^= num;
		}
		Assertions.assertEquals(ans,0);

	}
}