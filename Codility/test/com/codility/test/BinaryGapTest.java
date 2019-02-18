package com.codility.test;

import com.codility.java.BinaryGap;
import org.junit.Assert;
import org.junit.Test;

public class BinaryGapTest {
    BinaryGap binaryGap;

    @Test
    public void test_that_32_returns_zero_as_logest_binary_gap() throws Exception {

        binaryGap = new BinaryGap();
        int res = binaryGap.solution(32);

        Assert.assertEquals(0, res);
    }

    @Test
    public void test_that_1042_returns_five_as_logest_binary_gap() throws Exception {

        binaryGap = new BinaryGap();
        int res = binaryGap.solution(1041);

        Assert.assertEquals(5, res);


    }

    @Test
    public void test_that_529_returns_four_as_logest_binary_gap() throws Exception {

        binaryGap = new BinaryGap();
        int res = binaryGap.solution(529);

        Assert.assertEquals(4, res);

    }

}
