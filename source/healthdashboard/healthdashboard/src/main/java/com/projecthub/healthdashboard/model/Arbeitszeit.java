package com.projecthub.healthdashboard.model;

public class Arbeitszeit {
    private int id;               // ID der Arbeitszeit
    private String mitarbeiter;   // Name des Mitarbeiters
    private String datum;         // Datum der Arbeitszeit
    private int stunden;   // Anzahl der geleisteten Stunden

    public Arbeitszeit(int id, String mitarbeiter, String datum, int stunden) {
        this.id = id;
        this.mitarbeiter = mitarbeiter;
        this.datum = datum;
        this.stunden = stunden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(String mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        this.stunden = stunden;
    }


}


