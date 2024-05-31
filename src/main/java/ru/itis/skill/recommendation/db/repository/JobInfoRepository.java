package ru.itis.skill.recommendation.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.skill.recommendation.db.entity.JobInfoEntity;

public interface JobInfoRepository extends JpaRepository<JobInfoEntity, Long> {
}
