package com.tw.practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberTest {
    private final String VALUE = "1234";
    private final String MOCK_TOTAL_EQUAL_VALUE = "1234";
    private final String MOCK_DIGIT_EQUAL_VALUE = "4321";
    private final String MOCK_DIFFERENT_VALUE = "5678";
    private final String MOCK_NORMAL_VALUE = "3214";


    private Number mNumber = new Number(VALUE);

    /**
     * 完全一样时
     */
    @Test
    public void shouldReturn4A0B() {
        assertTrue(compare(mNumber, MOCK_TOTAL_EQUAL_VALUE, "4A0B"));
    }

    /**
     * 数字相同，数位都不同
     */
    @Test
    public void shouldReturn0A4B() {
        assertTrue(compare(mNumber, MOCK_DIGIT_EQUAL_VALUE, "0A4B"));
    }

    /**
     * 完全不一样
     */
    @Test
    public void shouldReturn0A0B() {
        assertTrue(compare(mNumber, MOCK_DIFFERENT_VALUE, "0A0B"));
    }

    /**
     * 一般值
     */
    @Test
    public void shouldReturn2A2B() {
        assertTrue(compare(mNumber, MOCK_NORMAL_VALUE, "2A2B"));
    }

    private boolean compare(Number number, String value, String expectedResult){
        if (number != null) {
            return number.compare(value).equals(expectedResult);
        }
        return false;
    }
}