package com.projecthub.healthdashboard;

import com.projecthub.healthdashboard.model.ProjektInfo;
import com.projecthub.healthdashboard.model.Task;
import com.projecthub.healthdashboard.repository.ProjektInfoRepository;
import com.projecthub.healthdashboard.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class  HealthdashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthdashboardApplication.class, args);
    }

    // =========================
    // DEMO / MOCK DATEN (Seed)
    // =========================
    @Bean
    CommandLineRunner initDemoData(
            ProjektInfoRepository projektRepo,
            TaskRepository taskRepo
    ) {
        return args -> {

            // 🔹 Projekt 1
            ProjektInfo p1 = new ProjektInfo(
                    "Digitale Personalakte",
                    "OK",
                    40,
                    "2025-08-19",
                    "2025-10-10"
            );
            projektRepo.save(p1);

            taskRepo.save(new Task(null, "Use Cases definieren", "done", 100));
            taskRepo.save(new Task(null, "Architektur festlegen", "done", 100));
            taskRepo.save(new Task(null, "UI-Layout entwerfen", "in-progress", 60));

            // 🔹 Projekt 2
            ProjektInfo p2 = new ProjektInfo(
                    "IT Security Scanner",
                    "OK",
                    30,
                    "2025-08-01",
                    "2025-09-20"
            );
            projektRepo.save(p2);

            taskRepo.save(new Task(null, "Server vorbereiten", "done", 100));
            taskRepo.save(new Task(null, "API Grundstruktur", "in-progress", 50));

            // 🔹 Projekt 3
            ProjektInfo p3 = new ProjektInfo(
                    "Mobile App Health",
                    "RISIKO",
                    55,
                    "2025-07-10",
                    "2025-11-05"
            );
            projektRepo.save(p3);

            taskRepo.save(new Task(null, "Frontend Integration", "in-progress", 40));
            taskRepo.save(new Task(null, "Bugfixing", "pending", 0));

            // 🔹 Projekt 4
            ProjektInfo p4 = new ProjektInfo(
                    "Internes Health Projekt",
                    "OK",
                    15,
                    "2025-12-01",
                    "2026-02-15"
            );
            projektRepo.save(p4);

            taskRepo.save(new Task(null, "Projektstruktur anlegen", "done", 100));
        };
    }
}
