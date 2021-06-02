package com.tuten.timeconverter.model;

public class Time {
    private final int totalSeconds;
    private final double timeZone;

    public Time(int totalSeconds, float timeZone) {
        this.totalSeconds = totalSeconds;
        this.timeZone = timeZone;
    }

     public Time(String time, double timeZone){
        String[] timeArray = time.split(":");
        int hours  = Integer.parseInt(timeArray[0]),
            minutes = Integer.parseInt((timeArray[1])),
            seconds = Integer.parseInt((timeArray[2]));

        this.totalSeconds = hours * 3600 + minutes * 60 + seconds;
        this.timeZone = timeZone;
    }

    public int getTotalSeconds(){
       return this.totalSeconds;
    }

    public double getTimezone(){
        return this.timeZone;
    }

    public String toString() {
        int seconds = this.totalSeconds % 60,
            totalMinutes = (this.totalSeconds - seconds) / 60,
            minutes = totalMinutes % 60,
            hours = totalMinutes/60;

        return String.format("%02d", hours) +
                ':' +
                String.format("%02d", minutes ) +
                ':' +
                String.format("%02d", seconds);
    }
}
