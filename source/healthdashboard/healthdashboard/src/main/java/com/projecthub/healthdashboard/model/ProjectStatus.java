package com.projecthub.healthdashboard.model;

public class ProjectStatus {
    private String date;            // تاريخ التقرير أو التحديث
    private String overallStatus;   // الحالة العامة (مثلاً: on track, at risk, delayed)
    private int tasksCompleted;     // عدد المهام المنجزة
    private int pendingTasks;       // عدد المهام المتبقية


    public ProjectStatus(String date, String overallStatus, int tasksCompleted, int pendingTasks) {
        this.date = date;
        this.overallStatus = overallStatus;
        this.tasksCompleted = tasksCompleted;
        this.pendingTasks = pendingTasks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOverallStatus() {
        return overallStatus;
    }

    public void setOverallStatus(String overallStatus) {
        this.overallStatus = overallStatus;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    public int getPendingTasks() {
        return pendingTasks;
    }

    public void setPendingTasks(int pendingTasks) {
        this.pendingTasks = pendingTasks;
    }


}
