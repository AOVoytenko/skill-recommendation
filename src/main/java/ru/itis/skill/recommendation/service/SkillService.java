package ru.itis.skill.recommendation.service;

import ru.itis.skill.recommendation.dto.JobInfoRequest;
import ru.itis.skill.recommendation.dto.RecommendationResponse;
import ru.itis.skill.recommendation.dto.UserSkillsResponse;

public interface SkillService {
    UserSkillsResponse getAllSkillsByRecommendationId(Long userId);
    RecommendationResponse createSkillRecommendation(JobInfoRequest request, Long userId);
}
