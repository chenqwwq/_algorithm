package top.chenqwwq.leetcode.contest.weekly._189._2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author chen
 * @date 2020/5/17 上午11:19
 */
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void arrangeWords() {
        Assertions.assertEquals("Is cool leetcode", solution.arrangeWords("Leetcode is cool"));
        Assertions.assertEquals("On and keep calm code", solution.arrangeWords("Keep calm and code on"));
        Assertions.assertEquals("To be or to be not", solution.arrangeWords("To be or not to be"));
        Assertions.assertEquals("Gzni vzkdo trpge qwwpz csljl zbbyu jlhet xqegx lkchg efwrp uxwlha klukaw jqzqbs xyqhan jitujj yqfzij vuwiyf mcirgs lxqtbe xwnopy eyocyxo rnpowjs wmqerrs rvtlymg iqfcxax xwespxz wozdclg emyjgor fszjyon diftsrym paecqitg hwhvjcjv uwkcquzu npwfcxhzs xqqghawjp chyenhxez etkxlxdmx vxyntzvpa kwyvqfwve xflitpgxl gwpiomzlh vdsdiyryer egrriqsivq otyerkmmnk amcnilipmj riytunnotn ktbbursmxl qrtufudlap oxxzctzolz", solution.arrangeWords("Npwfcxhzs diftsrym vzkdo uxwlha eyocyxo vdsdiyryer xqqghawjp rnpowjs wmqerrs egrriqsivq rvtlymg paecqitg klukaw otyerkmmnk chyenhxez trpge iqfcxax qwwpz amcnilipmj xwespxz jqzqbs riytunnotn ktbbursmxl xyqhan jitujj etkxlxdmx csljl zbbyu vxyntzvpa qrtufudlap hwhvjcjv yqfzij jlhet vuwiyf wozdclg xqegx kwyvqfwve lkchg oxxzctzolz efwrp xflitpgxl gwpiomzlh mcirgs uwkcquzu lxqtbe emyjgor fszjyon xwnopy gzni"));
    }
}