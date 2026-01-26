package com.projecthub.healthdashboard.repository;

import com.projecthub.healthdashboard.model.ProjektInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjektInfoRepository extends JpaRepository<ProjektInfo, Long> {
}
