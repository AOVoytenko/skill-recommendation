package ru.itis.skill.recommendation.dto;

import java.util.List;

public record RecommendedSkillsResponse(
        List<String> skills
) {
}
