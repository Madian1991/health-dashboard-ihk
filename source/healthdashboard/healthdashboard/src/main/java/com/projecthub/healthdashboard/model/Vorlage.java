package com.projecthub.healthdashboard.model;

public class Vorlage {

    private int id;                 // ID der Vorlage
    private String name;            // Name der Vorlage
    private String beschreibung;    // Beschreibung der Vorlage
    private String verwendetSeit;   // Seit wann wird sie verwendet

    public Vorlage(int id, String name, String beschreibung, String verwendetSeit) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.verwendetSeit = verwendetSeit;
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

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getVerwendetSeit() {
        return verwendetSeit;
    }

    public void setVerwendetSeit(String verwendetSeit) {
        this.verwendetSeit = verwendetSeit;
    }


}
