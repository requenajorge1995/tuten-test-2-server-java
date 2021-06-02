package com.tuten.timeconverter.service;

import com.tuten.timeconverter.dto.ConvertedTimeDTO;
import com.tuten.timeconverter.dto.InputTimeDTO;
import com.tuten.timeconverter.model.Time;
import org.springframework.stereotype.Service;

@Service
public class TimeConverterService {
    private static final int CONVERT_TO = 0;
    private static final String NAME = "UTC";

    public ConvertedTimeDTO convert(InputTimeDTO input) {
        Time time  = new Time(input.getTime(), input.getTimeZone());

        double hoursDifference =  CONVERT_TO - time.getTimezone();
        int convertedTimeInSeconds = time.getTotalSeconds() + (int) (hoursDifference * 3600);

        //in case is a next day
        convertedTimeInSeconds %= 24 * 3600;

        //in case is a previous day
        while (convertedTimeInSeconds < 0)
            convertedTimeInSeconds += 24 * 3600;

        Time convertedTime = new  Time(convertedTimeInSeconds, CONVERT_TO);
        return  new ConvertedTimeDTO(convertedTime.toString(), NAME);
    }
}
