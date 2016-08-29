package com.sd.automate;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Saurabh on 22.01.2016.022.
 */
public class Task {
    private UUID mId;
    private String taskName; //com.sd.automate.Task name
    private String[] taskDetail; //String array for task details
    private Date scheduleDate; //Next scheduled date
    private int nextDay; // 0-6 for Sunday-Saturday
    private int nextMonth; //1-12 for January-December
    private long nextDays; //no. of days the next task will schedule
    private int nextWeek; //next week task will schedule
    private int nextYear; //next year task will schedule
    private String[] appName; //App(s) to launch
    private Boolean complete;

    public UUID getId() { return mId; }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String[] getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String[] taskDetail) {
        this.taskDetail = taskDetail;
    }

    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public int getNextDay() {
        return nextDay;
    }

    public void setNextDay(int nextDay) {
        this.nextDay = nextDay;
    }

    public int getNextMonth() {
        return nextMonth;
    }

    public void setNextMonth(int nextMonth) {
        this.nextMonth = nextMonth;
    }

    public long getNextDays() {
        return nextDays;
    }

    public void setNextDays(long nextDays) {
        this.nextDays = nextDays;
    }

    public int getNextWeek() {
        return nextWeek;
    }

    public void setNextWeek(int nextWeek) {
        this.nextWeek = nextWeek;
    }

    public int getNextYear() {
        return nextYear;
    }

    public void setNextYear(int nextYear) {
        this.nextYear = nextYear;
    }

    public String[] getAppName() {
        return appName;
    }

    public void setAppName(String[] appName) {
        this.appName = appName;
    }

    public Task(Boolean complete) {
        this.mId = UUID.randomUUID();
        this.complete = complete;
        this.scheduleDate = new Date();
    }
}
