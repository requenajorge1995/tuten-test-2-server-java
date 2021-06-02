package com.tuten.timeconverter.service;

import com.tuten.timeconverter.dto.ConvertedTimeDTO;
import com.tuten.timeconverter.dto.InputTimeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TimeConverterServiceTest  {
    private TimeConverterService timeConverter = new TimeConverterService();

    @Test
    void sameDayConvertTest () {
        InputTimeDTO input = new InputTimeDTO("12:00:00", -4);
        ConvertedTimeDTO convertedTime = timeConverter.convert(input);

        Assertions.assertNotNull(convertedTime);
        Assertions.assertEquals("16:00:00", convertedTime.getTime());
        Assertions.assertEquals("UTC", convertedTime.getTimeZone());
    }

    @Test
    void previousDayConvertTest () {
        InputTimeDTO input = new InputTimeDTO("22:30:10", -4.5);
        ConvertedTimeDTO convertedTime = timeConverter.convert(input);

        Assertions.assertNotNull(convertedTime);
        Assertions.assertEquals("03:00:10", convertedTime.getTime());
        Assertions.assertEquals("UTC", convertedTime.getTimeZone());
    }

    @Test
    void nextDayConvertTest () {
        InputTimeDTO input = new InputTimeDTO("04:25:00", 6);
        ConvertedTimeDTO convertedTime = timeConverter.convert(input);

        Assertions.assertNotNull(convertedTime);
        Assertions.assertEquals("22:25:00", convertedTime.getTime());
        Assertions.assertEquals("UTC", convertedTime.getTimeZone());
    }
}
