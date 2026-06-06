package template.dichotomy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2021-07-09
 **/
class DichotomyTest {
	Dichotomy search = new Dichotomy();

	@Test
	void ceiling() {
		Assertions.assertEquals(1, search.ceiling(new int[]{2}, 3));
		Assertions.assertEquals(0, search.ceiling(new int[]{2}, 2));
		Assertions.assertEquals(0, search.ceiling(new int[]{2}, 1));
		Assertions.assertEquals(2, search.ceiling(new int[]{1, 2, 4, 5, 6}, 3));
	}
}