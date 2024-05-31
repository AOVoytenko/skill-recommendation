package ru.itis.skill.recommendation.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.skill.recommendation.db.entity.SkillRecommendationEntity;

import java.util.List;

public interface SkillRecommendationRepository extends JpaRepository<SkillRecommendationEntity, Long> {
    List<SkillRecommendationEntity> findAllByRecommendationId(Long id);
}
