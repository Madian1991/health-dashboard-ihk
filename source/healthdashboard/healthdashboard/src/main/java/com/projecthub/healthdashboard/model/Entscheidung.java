package com.projecthub.healthdashboard.model;

public class Entscheidung {

    private int id;                // ID der Entscheidung
    private String titel;          // Titel oder Thema der Entscheidung
    private String entschiedenVon; // Wer hat entschieden
    private String datum;          // Datum der Entscheidung
    private String begruendung;    // Begründung oder warum wurde entschieden

    public Entscheidung(int id, String titel, String entschiedenVon, String datum, String begruendung) {
        this.id = id;
        this.titel = titel;
        this.entschiedenVon = entschiedenVon;
        this.datum = datum;
        this.begruendung = begruendung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getEntschiedenVon() {
        return entschiedenVon;
    }

    public void setEntschiedenVon(String entschiedenVon) {
        this.entschiedenVon = entschiedenVon;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getBegruendung() {
        return begruendung;
    }

    public void setBegruendung(String begruendung) {
        this.begruendung = begruendung;
    }


}
