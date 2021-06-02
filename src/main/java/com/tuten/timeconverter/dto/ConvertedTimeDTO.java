package com.tuten.timeconverter.dto;

public class ConvertedTimeDTO {
   private String time;
   private String timeZone;

    public ConvertedTimeDTO(String time, String timeZone) {
        this.time = time;
        this.timeZone = timeZone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
