package com.tuten.timeconverter.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class InputTimeDTO {
    @NotNull( message = "Time is required")
    @Pattern(regexp = "^\\d\\d:\\d\\d:\\d\\d$", message = "Invalid time format")
    private String time;
    @NotNull(message =  "Time zone required")
    @Max(value = 24, message = "Invalid time zone")
    @Min(value = -24, message = "Invalid time zone")
   private Double timeZone;

    public InputTimeDTO(String time, double timeZone) {
        this.time = time;
        this.timeZone = timeZone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Double timeZone) {
        this.timeZone = timeZone;
    }
}
