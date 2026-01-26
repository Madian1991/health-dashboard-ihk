package com.projecthub.healthdashboard.service;

import com.projecthub.healthdashboard.model.ProjektInfo;
import com.projecthub.healthdashboard.repository.ProjektInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjektInfoService {

    private final ProjektInfoRepository projektInfoRepository;

    public ProjektInfoService(ProjektInfoRepository projektInfoRepository) {
        this.projektInfoRepository = projektInfoRepository;
    }

    public List<ProjektInfo> findAll() {
        // Gibt alle Projekte aus der Datenbank zurück.
        return projektInfoRepository.findAll();
    }

    public ProjektInfo findById(Long id) {
        // Holt ein einzelnes Projekt anhand der ID.
        return projektInfoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Projekt mit ID " + id + " existiert nicht."));
    }

    public ProjektInfo save(ProjektInfo projekt) {
        // Speichert ein neues oder aktualisiertes Projekt.
        return projektInfoRepository.save(projekt);
    }

    public void deleteById(Long id) {
        // Löscht ein Projekt anhand der ID.
        if (!projektInfoRepository.existsById(id)) {
            throw new IllegalArgumentException("Projekt mit ID " + id + " existiert nicht.");
        }
        projektInfoRepository.deleteById(id);
    }
}



