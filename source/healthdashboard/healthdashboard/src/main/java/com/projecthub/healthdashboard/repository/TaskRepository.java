package com.projecthub.healthdashboard.repository;

import com.projecthub.healthdashboard.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository

public interface TaskRepository extends JpaRepository<Task, Long> {

    // Holt alle Tasks, die zu einem bestimmten Projekt gehören.
    List<Task> findByProjektId(Long projektId);


}