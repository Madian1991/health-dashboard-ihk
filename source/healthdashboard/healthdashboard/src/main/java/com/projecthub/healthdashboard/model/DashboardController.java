package com.projecthub.healthdashboard.model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.*;

@CrossOrigin(origins = "*")   //
@RestController
public class DashboardController {


    // PROJECT INFO

    @GetMapping("/api/project-info")
    public Map<String, Object> getProjectInfo() {
        Map<String, Object> data = new HashMap<>();
        data.put("projectName", "Health Dashboard");
        data.put("status", "OK");
        data.put("progress", 40);
        return data;
    }

    // ---------------------------
    // TASK LIST
    // ---------------------------
    @GetMapping("/api/tasks")
    public List<Map<String,Object>> getTasks() {

        List<Map<String, Object>> tasks = new ArrayList<>();

        Map<String, Object> t1 = new HashMap<>();
        t1.put("id", 1);
        t1.put("title", "Backend vorbereiten");
        t1.put("status", "in-progress");
        t1.put("progress", 40);
        tasks.add(t1);

        Map<String, Object> t2 = new HashMap<>();
        t2.put("id", 2);
        t2.put("title", "API-Struktur planen");
        t2.put("status", "done");
        t2.put("progress", 100);
        tasks.add(t2);

        Map<String, Object> t3 = new HashMap<>();
        t3.put("id", 3);
        t3.put("title", "Frontend Wireframe erstellen");
        t3.put("status", "pending");
        t3.put("progress", 0);
        tasks.add(t3);

        return tasks;
    }

    // ---------------------------
    // TEAM INFO
    // ---------------------------
    @GetMapping("/api/team")
    public List<Map<String, Object>> getTeam() {
        List<Map<String, Object>> team = new ArrayList<>();

        Map<String, Object> m1 = new HashMap<>();
        m1.put("id", 1);
        m1.put("name", "Madian");
        m1.put("role", "Backend Developer");
        m1.put("email", "madian@example.com");
        m1.put("notes", "Erstellt die Backend-APIs.");
        m1.put("milestones", List.of("API-Struktur", "Datenbankanbindung"));
        team.add(m1);

        Map<String, Object> m2 = new HashMap<>();
        m2.put("id", 2);
        m2.put("name", "Lina");
        m2.put("role", "Frontend Developer");
        m2.put("email", "lina@example.com");
        m2.put("notes", "Entwirft das Design mit HTML/CSS.");
        m2.put("milestones", List.of("Startseite", "Dashboard UI"));
        team.add(m2);

        Map<String, Object> m3 = new HashMap<>();
        m3.put("id", 3);
        m3.put("name", "Omar");
        m3.put("role", "Project Manager");
        m3.put("email", "omar@example.com");
        m3.put("notes", "Plant die Aufgaben und Deadlines.");
        m3.put("milestones", List.of("Projektplan", "Meeting Protokolle"));
        team.add(m3);

        return team;
    }

    // ---------------------------
    // NOTES
    // ---------------------------
    @GetMapping("/api/notes")
    public List<Map<String, String>> getNotes() {
        List<Map<String, String>> notes = new ArrayList<>();

        Map<String, String> n1 = new HashMap<>();
        n1.put("author", "Madian");
        n1.put("message", "Datenanbindung an die API testen.");
        notes.add(n1);

        Map<String, String> n2 = new HashMap<>();
        n2.put("author", "Sven");
        n2.put("message", "Diagramm-Komponente im Frontend vorbereiten.");
        notes.add(n2);

        Map<String, String> n3 = new HashMap<>();
        n3.put("author", "Nadine");
        n3.put("message", "Rückmeldung vom Kunden steht noch aus.");
        notes.add(n3);

        return notes;
    }

    // ---------------------------
    // SYSTEM STATUS
    // ---------------------------
    @GetMapping("/api/status")
    public List<Map<String, String>> getSystemStatus() {
        List<Map<String, String>> statusList = new ArrayList<>();

        statusList.add(Map.of("check", "Backend Verbindung", "status", "OK"));
        statusList.add(Map.of("check", "Frontend geladen", "status", "OK"));
        statusList.add(Map.of("check", "API erreichbar", "status", "OK"));
        statusList.add(Map.of("check", "Letzter Datenabgleich", "status", "Fehlgeschlagen"));

        return statusList;
    }

    // ---------------------------
// PROJECTS (korrigierte Version mit Step & Team)
// ---------------------------
    @GetMapping("/api/projects")
    public List<Map<String, Object>> getProjects() {
        List<Map<String, Object>> projects = new ArrayList<>();

        Map<String, Object> p1 = new HashMap<>();
        p1.put("id", 1);
        p1.put("name", "Digitale Personalakte");
        p1.put("step", "3 / 8 — Design & Planung");
        p1.put("status", "in-progress");
        p1.put("progress", 40);
        p1.put("start", "2025-08-19");
        p1.put("end", "2025-10-10");
        p1.put("team", "Looking for 2 members for Frontend");
        projects.add(p1);

        Map<String, Object> p2 = new HashMap<>();
        p2.put("id", 2);
        p2.put("name", "IT Security Scanner");
        p2.put("step", "2 / 7 — Infrastruktur");
        p2.put("status", "in-progress");
        p2.put("progress", 35);
        p2.put("start", "2025-08-01");
        p2.put("end", "2025-09-20");
        p2.put("team", "Looking for 1 Backend Dev");
        projects.add(p2);

        Map<String, Object> p3 = new HashMap<>();
        p3.put("id", 3);
        p3.put("name", "Mobile App Health");
        p3.put("step", "5 / 9 — Development");
        p3.put("status", "in-progress");
        p3.put("progress", 55);
        p3.put("start", "2025-07-10");
        p3.put("end", "2025-11-05");
        p3.put("team", "3 Frontend, 2 Backend");
        projects.add(p3);

        Map<String, Object> p4 = new HashMap<>();
        p4.put("id", 4);
        p4.put("name", "Internes Health Projekt");
        p4.put("step", "1 / 6 — Setup");
        p4.put("status", "pending");
        p4.put("progress", 15);
        p4.put("start", "2025-12-01");
        p4.put("end", "2026-02-15");
        p4.put("team", "Internal testing team");
        projects.add(p4);

        return projects;
    }


    // ---------------------------
    // RISKS
    // ---------------------------
    @GetMapping("/api/risiken")
    public List<Map<String, Object>> getRisiken() {
        List<Map<String, Object>> risks = new ArrayList<>();

        risks.add(Map.of("id", 1, "description", "Server überlastet", "severity", "hoch", "status", "offen"));
        risks.add(Map.of("id", 2, "description", "Keine Backups", "severity", "mittel", "status", "in Bearbeitung"));
        risks.add(Map.of("id", 3, "description", "Unklare Zuständigkeiten", "severity", "niedrig", "status", "behoben"));

        return risks;
    }

    // ---------------------------
    // DEADLINES (1)
    // ---------------------------
    @GetMapping("/api/deadlines")
    public List<Map<String, Object>> getDeadlines() {
        List<Map<String, Object>> deadlines = new ArrayList<>();

        deadlines.add(Map.of("id", 1, "milestone", "Projektplanung", "dueDate", "2025-12-01", "status", "done"));
        deadlines.add(Map.of("id", 2, "milestone", "Backend fertigstellen", "dueDate", "2025-12-05", "status", "in-progress"));
        deadlines.add(Map.of("id", 3, "milestone", "Frontend starten", "dueDate", "2025-12-10", "status", "pending"));

        return deadlines;
    }

    // ---------------------------
    // DEADLINES (2) FIXED — CHANGED NAME
    // ---------------------------
    @GetMapping("/api/deadlines-phasen")
    public List<Map<String, Object>> getProjectDeadlines() {
        List<Map<String, Object>> deadlines = new ArrayList<>();

        deadlines.add(Map.of("phase", "Analyse & Planung", "start", "2025-10-01", "end", "2025-10-07"));
        deadlines.add(Map.of("phase", "Backend", "start", "2025-10-08", "end", "2025-10-21"));
        deadlines.add(Map.of("phase", "Frontend", "start", "2025-10-22", "end", "2025-11-05"));

        return deadlines;
    }

    // ---------------------------
    // TODO LIST
    // ---------------------------
    @GetMapping("/api/todo")
    public List<Map<String, Object>> getToDoListe() {
        List<Map<String, Object>> alle = getTasks();
        List<Map<String, Object>> todo = new ArrayList<>();

        for (var task : alle) {
            String s = (String) task.get("status");
            if ("in-progress".equals(s) || "pending".equals(s)) {
                todo.add(task);
            }
        }

        return todo;
    }

    // ---------------------------
    // ADD NEW TASK
    // ---------------------------
    @PostMapping("/api/tasks")
    public Map<String, Object> addTask(@RequestBody Map<String, Object> taskData) {
        return taskData; // placeholder
    }

    // ---------------------------
    // FEEDBACK
    // ---------------------------
    @PostMapping("/api/feedback")
    public Map<String, String> addFeedback(@RequestBody Map<String, String> feedbackData) {
        return Map.of(
                "status", "received",
                "message", feedbackData.get("message")
        );
    }

    // ---------------------------
    // GOALS
    // ---------------------------
    @GetMapping("/api/goals")
    public List<Map<String, Object>> getGoals() {
        List<Map<String, Object>> goals = new ArrayList<>();

        goals.add(Map.of("id", 1, "title", "Backend fertigstellen", "status", "in-progress"));
        goals.add(Map.of("id", 2, "title", "Frontend verbinden", "status", "planned"));
        goals.add(Map.of("id", 3, "title", "Testing & Review", "status", "not started"));

        return goals;
    }

    // ---------------------------
    // PROJECT PROGRESS
    // ---------------------------
    @GetMapping("/api/progress")
    public Map<String, Object> getProjectProgress() {
        return Map.of(
                "overall", 72,
                "onTrack", true,
                "lastUpdated", "2025-11-18"
        );
    }

    // ---------------------------
    // ISSUES
    // ---------------------------
    @GetMapping("/api/issues")
    public List<Map<String, Object>> getProjectIssues() {
        List<Map<String, Object>> issues = new ArrayList<>();

        issues.add(Map.of("id", 1, "title", "Testing verzögert", "severity", "hoch", "status", "offen"));
        issues.add(Map.of("id", 2, "title", "API Dokumentation fehlt", "severity", "mittel", "status", "in Bearbeitung"));
        issues.add(Map.of("id", 3, "title", "UI Fehler", "severity", "niedrig", "status", "gelöst"));

        return issues;
    }

    // ---------------------------
    // EXPORT
    // ---------------------------
    @PostMapping("/api/export")
    public Map<String, Object> exportProjectData(@RequestBody Map<String, String> request) {

        String format = request.getOrDefault("format", "PDF");

        return Map.of(
                "status", "success",
                "message", "Projekt wurde erfolgreich exportiert",
                "format", format,
                "timestamp", "2025-11-18T15:30:00Z"
        );
    }
}
