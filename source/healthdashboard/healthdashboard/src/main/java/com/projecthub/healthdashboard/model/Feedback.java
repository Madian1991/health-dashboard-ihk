package com.projecthub.healthdashboard.model;

public class Feedback {
    private int id;               // Feedback-ID
    private String autor;         // Name des Autors
    private String kommentar;     // Inhalt des Feedbacks
    private String erstelltAm;    // Erstellungsdatum

    // Konstruktor
    public Feedback(int id, String autor, String kommentar, String erstelltAm) {
        this.id = id;
        this.autor = autor;
        this.kommentar = kommentar;
        this.erstelltAm = erstelltAm;
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public String getErstelltAm() {
        return erstelltAm;
    }

    public void setErstelltAm(String erstelltAm) {
        this.erstelltAm = erstelltAm;
    }
}

