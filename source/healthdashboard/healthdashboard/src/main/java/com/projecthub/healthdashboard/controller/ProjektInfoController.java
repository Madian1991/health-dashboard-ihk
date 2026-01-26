package com.projecthub.healthdashboard.controller;

import com.projecthub.healthdashboard.model.ProjektInfo;
import com.projecthub.healthdashboard.model.Task;
import com.projecthub.healthdashboard.service.ProjektInfoService;
import com.projecthub.healthdashboard.service.TaskService;
import org.springframework.web.bind.annotation.*;
import com.projecthub.healthdashboard.model.ProjectResponse;


import java.util.List;

@RestController
@RequestMapping("/projekte")
public class ProjektInfoController {

    private final ProjektInfoService projektInfoService;
    private final TaskService taskService;

    // Konstruktor-Injektion
    public ProjektInfoController(ProjektInfoService projektInfoService, TaskService taskService) {
        this.projektInfoService = projektInfoService;
        this.taskService = taskService;
    }

    // ---------------------------------------------
    // GET: Alle Projekte holen
    // ---------------------------------------------
    @GetMapping
    public List<ProjektInfo> getAllProjekte() {
        return projektInfoService.findAll();
    }

    // ---------------------------------------------
    // GET: Ein Projekt per ID holen
    // ---------------------------------------------
    @GetMapping("/{id}")
    public ProjektInfo getProjektById(@PathVariable Long id) {
        return projektInfoService.findById(id);
    }

    // ---------------------------------------------
    // GET: Alle Tasks eines Projekts holen
    // ---------------------------------------------
    @GetMapping("/{id}/tasks")
    public List<Task> getTasksForProjekt(@PathVariable Long id) {
        return taskService.findByProjektId(id);
    }

    // ---------------------------------------------
    // POST: Neues Projekt erstellen
    // ---------------------------------------------
    @PostMapping
    public ProjektInfo createProjekt(@RequestBody ProjektInfo projekt) {
        return projektInfoService.save(projekt);
    }

    // ---------------------------------------------
    // PUT: Projekt aktualisieren
    // ---------------------------------------------
    @PutMapping("/{id}")
    public ProjektInfo updateProjekt(@PathVariable Long id, @RequestBody ProjektInfo projekt) {
        projekt.setId(id);
        return projektInfoService.save(projekt);
    }

    // ---------------------------------------------
    // DELETE: Projekt löschen
    // ---------------------------------------------
    @DeleteMapping("/{id}")
    public void deleteProjekt(@PathVariable Long id) {
        projektInfoService.deleteById(id);
    }

    @GetMapping("/dto")
    public List<ProjectResponse> getAllProjectsDto(){
        return projektInfoService.findAll().stream()
                .map(p -> new ProjectResponse(
                        p.getProjektName(),
                        p.getStatus(),
                        p.getFortschritt(),
                        p.getStartDatum(),
                        p.getEndDatum()
                ))
                .toList();
    }

}
