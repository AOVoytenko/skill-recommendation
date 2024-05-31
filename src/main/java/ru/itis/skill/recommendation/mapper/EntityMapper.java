package ru.itis.skill.recommendation.mapper;

import org.mapstruct.Mapper;
import ru.itis.skill.recommendation.db.entity.SkillRecommendationEntity;

@Mapper(componentModel = "spring")
public interface EntityMapper {
    SkillRecommendationEntity toUserSkillsEntity(Long recommendationId, Long skillId);
}
