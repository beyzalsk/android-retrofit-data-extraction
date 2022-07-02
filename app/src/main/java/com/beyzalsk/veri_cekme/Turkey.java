package com.beyzalsk.veri_cekme;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Turkey {
    @SerializedName("utc_datetime")
    @Expose
    private String dateTime;

    @SerializedName("day_of_week")
    @Expose
    private int dayOfweek;

    @SerializedName("week_number")
    @Expose
    private int weekNumber;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getDayOfweek() {
        return dayOfweek;
    }

    public void setDayOfweek(int dayOfweek) {
        this.dayOfweek = dayOfweek;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }
}

