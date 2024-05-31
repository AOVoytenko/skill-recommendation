package ru.itis.skill.recommendation.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.skill.recommendation.db.entity.SkillEntity;

public interface SkillRepository  extends JpaRepository<SkillEntity, Long> {

    SkillEntity findBySkill(String skill);
}
