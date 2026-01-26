package com.projecthub.healthdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String status;
    private int progress;

    @ManyToOne
    @JoinColumn(name = "projekt_id")
    private ProjektInfo projekt;

    public Task() {}

    public Task(Long id, String title, String status, int progress) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.progress = progress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public ProjektInfo getProjekt() {
        return projekt;
    }

    public void setProjekt(ProjektInfo projekt) {
        this.projekt = projekt;
    }
}
