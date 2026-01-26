package com.projecthub.healthdashboard.model;

public class Nachricht {

    private int id;               // ID der Nachricht
    private String absender;      // Absender der Nachricht (من أرسل الرسالة)
    private String inhalt;        // Inhalt der Nachricht (نص الرسالة)
    private String gesendetAm;    // Datum/Zeit wann gesendet wurde (تاريخ الإرسال)

    public Nachricht(int id, String absender, String inhalt, String gesendetAm) {
        this.id = id;
        this.absender = absender;
        this.inhalt = inhalt;
        this.gesendetAm = gesendetAm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbsender() {
        return absender;
    }

    public void setAbsender(String absender) {
        this.absender = absender;
    }

    public String getInhalt() {
        return inhalt;
    }

    public void setInhalt(String inhalt) {
        this.inhalt = inhalt;
    }

    public String getGesendetAm() {
        return gesendetAm;
    }

    public void setGesendetAm(String gesendetAm) {
        this.gesendetAm = gesendetAm;
    }



}
