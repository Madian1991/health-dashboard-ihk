package com.projecthub.healthdashboard.model;

public class TeamMember {
    private int id;              // رقم العضو
    private String name;         // اسم العضو
    private String role;         // دوره في الفريق (مثلاً: Backend, Frontend, Doku)
    private int hoursWorked;


    public TeamMember(int id, String name, String role, int hoursWorked) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.hoursWorked = hoursWorked;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


}



