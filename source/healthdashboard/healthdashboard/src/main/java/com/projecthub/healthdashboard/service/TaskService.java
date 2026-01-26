package com.projecthub.healthdashboard.service;

import com.projecthub.healthdashboard.model.Task;
import com.projecthub.healthdashboard.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    // Constructor Injection
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }


  //  Holt eine einzelne Task anhand der ID  // Wenn die Task nicht existiert, wird ein Fehler geworfen.

    public Task findById(Long id) {
        return taskRepository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("Task mit der ID " + id + " wurde nicht gefunden"));
    }

    public Task save(Task task) {
        // Speichert eine neue Task oder aktualisiert eine bestehende Task.
        // Spring erkennt automatisch, ob es ein Insert oder Update ist.
        return taskRepository.save(task);
    }

    public void deleteById(Long id) {
        if (!taskRepository.existsById(id)) {                          // Löscht eine Task anhand der ID.
                                                                         // Wenn keine Task existiert, wird ein Fehler geworfen.
            throw new IllegalArgumentException("Task mit der ID " + id + " existiert nicht");
        }
        taskRepository.deleteById(id);


    }

    public List<Task> findByProjektId(Long projektId) {
        // Holt alle Tasks eines Projektes anhand der Projekt-ID.
        return taskRepository.findByProjektId(projektId);

    }

    public Task updateStatus(Long id, String neuerStatus) {
        // Holt die Task über die ID. Wenn sie nicht existiert → Fehler.
        Task task = findById(id);

        // Setzt den neuen Status für die Task.
        task.setStatus(neuerStatus);

        // Speichert die aktualisierte Task in der Datenbank.
        return taskRepository.save(task);
    }





}

