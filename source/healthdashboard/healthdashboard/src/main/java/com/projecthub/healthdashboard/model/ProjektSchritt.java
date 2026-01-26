package com.projecthub.healthdashboard.model;

public class ProjektSchritt {

        private int nummer;              // Schritt-Nummer (z. B. 1, 2, 3)
        private String name;             // Name des Schritts (z. B. Analyse, Design)
        private String status;           // Status (z. B. geplant, aktiv, abgeschlossen)
        private String startDatum;       // Startdatum des Schritts
        private String endDatum;         // Enddatum des Schritts


    public ProjektSchritt(int nummer, String name, String status, String startDatum, String endDatum) {
        this.nummer = nummer;
        this.name = name;
        this.status = status;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(String startDatum) {
        this.startDatum = startDatum;
    }

    public String getEndDatum() {
        return endDatum;
    }

    public void setEndDatum(String endDatum) {
        this.endDatum = endDatum;
    }






}
