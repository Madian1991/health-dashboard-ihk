package com.projecthub.healthdashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SidebarController {

    @GetMapping("/assistant")
    public Map<String, Object> assistant() {
        return Map.of(
                "text", "Dies ist der Projekt-Assistent (Mock-Daten).",
                "tips", List.of(
                        "Projekt über Öffnen anzeigen",
                        "Details zeigen Team-Informationen",
                        "Developer Diary folgt als nächstes"
                )
        );
    }

    @GetMapping("/diary")
    public Map<String, Object> diary() {
        return Map.of(
                "title", "Developer Diary",
                "entries", List.of(
                        "2025-08-01: Projektstart",
                        "2025-08-05: Dashboard umgesetzt",
                        "2025-08-10: Team-API angebunden"
                )
        );
    }

    @GetMapping("/archive")
    public Map<String, Object> archive() {
        return Map.of(
                "title", "Archiv",
                "items", List.of(
                        "2025-07: Projekt „IT Security Scanner“ — abgeschlossen",
                        "2025-07: Release Notes — v0.3",
                        "2025-06: Meeting Summary — 2025-06-20",
                        "2025-06: Risk Review — Q2/2025"
                )
        );
    }

    @GetMapping("/settings")
    public Map<String, Object> settings() {
        return Map.of(
                "title", "Einstellungen",
                "items", List.of(
                        Map.of("id", "theme", "label", "Theme: Dark (fix)"),
                        Map.of("id", "lang", "label", "Sprache: Deutsch"),
                        Map.of("id", "login", "label", "Login: LocalStorage (Mock)"),
                        Map.of("id", "datasource", "label", "Datenquelle: Mock-Daten"),
                        Map.of("id", "backend", "label", "Backend: Spring Boot REST"),
                        Map.of("id", "version", "label", "Version: v0.4 (Prototype)"),
                        Map.of("id", "mode", "label", "Modus: Entwicklungsmodus")
                )
        );
    }
    @GetMapping("/settings/{id}")
    public Map<String, Object> settingDetail(@PathVariable String id) {

        return switch (id) {
            case "theme" -> Map.of(
                    "title", "Theme",
                    "text", "Das UI nutzt aktuell ein festes Dark-Theme (dashboard.css)."
            );
            case "lang" -> Map.of(
                    "title", "Sprache",
                    "text", "Aktuell ist die Sprache auf Deutsch gesetzt (Mock)."
            );
            case "login" -> Map.of(
                    "title", "Login",
                    "text", "Login wird über LocalStorage (loggedIn=true) simuliert."
            );
            case "datasource" -> Map.of(
                    "title", "Datenquelle",
                    "text", "Die Daten stammen aktuell aus Mock-Endpoints ohne Datenbank."
            );
            case "backend" -> Map.of(
                    "title", "Backend",
                    "text", "Spring Boot REST API liefert JSON an das Frontend (fetch)."
            );
            case "version" -> Map.of(
                    "title", "Version",
                    "text", "Prototype-Version zur Demonstration der Funktionen."
            );
            case "mode" -> Map.of(
                    "title", "Modus",
                    "text", "Entwicklungsmodus: Fokus auf Mock-Daten und UI-Flow."
            );
            default -> Map.of(
                    "title", "Unbekannt",
                    "text", "Kein Detail verfügbar."
            );
        };
    }

    @GetMapping("/theme")
    public Map<String, Object> theme() {
        return Map.of(
                "title", "Theme",
                "text", "Das UI nutzt aktuell ein festes Dark-Theme (dashboard.css)."
        );
    }

}
