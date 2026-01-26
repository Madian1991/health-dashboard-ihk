package com.projecthub.healthdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

import java.util.List;

@Entity
public class ProjektInfo {

    @Id
    @GeneratedValue
    private Long id;

    private String projektName;     // اسم المشروع
    private String status;          // الحالة العامة (مثلاً: on track, delayed)
    private int fortschritt;
    private String startDatum;
    private String endDatum;

    @OneToMany(mappedBy = "projekt", cascade = CascadeType.ALL)
    private List<Task> tasks;   // Alle Tasks, die zu diesem Projekt gehören.

    // ✅ مهم جدًا: JPA/Hibernate يحتاج Constructor فارغ
    public ProjektInfo() {
    }

    public ProjektInfo(String projektName, String status, int fortschritt, String startDatum, String endDatum) {
        this.projektName = projektName;
        this.status = status;
        this.fortschritt = fortschritt;
        this.startDatum = startDatum;
        this.endDatum = endDatum;
    }

    public Long getId() {
        // Gibt die ID des Projekts zurück.
        return id;
    }

    public void setId(Long id) {
        // Setzt die ID des Projekts.
        this.id = id;
    }

    public String getProjektName() {
        return projektName;
    }

    public void setProjektName(String projektName) {
        this.projektName = projektName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFortschritt() {
        return fortschritt;
    }

    public void setFortschritt(int fortschritt) {
        this.fortschritt = fortschritt;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
