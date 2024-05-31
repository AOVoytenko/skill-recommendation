package ru.itis.skill.recommendation.service;

import ru.itis.skill.recommendation.dto.JobInfoRequest;
import ru.itis.skill.recommendation.dto.RecommendedSkillsResponse;

public interface IntegrationService {
    RecommendedSkillsResponse createSkillRecommendation(JobInfoRequest request);
}
