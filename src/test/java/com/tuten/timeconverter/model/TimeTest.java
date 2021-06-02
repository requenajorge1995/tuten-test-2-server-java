package com.tuten.timeconverter.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeTest {

    @Test
    void toStringTest() {
        Time time = new Time(43200, -4);
        Assertions.assertEquals("12:00:00", time.toString());
        Assertions.assertEquals(-4, time.getTimezone());
    }

    @Test
    void constructorFromStringTest() {
        Time time = new Time("12:00:00", -4);
        Assertions.assertEquals(43200, time.getTotalSeconds());
        Assertions.assertEquals(-4, time.getTimezone());
    }
}
