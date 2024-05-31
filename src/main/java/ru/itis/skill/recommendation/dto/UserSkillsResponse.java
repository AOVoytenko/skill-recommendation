package ru.itis.skill.recommendation.dto;

import java.util.List;

public record UserSkillsResponse(
        List<String> skills,
        Long experience,
        String positionName,
        Long salaryRate,
        String specialization,
        UserInfoResponse userInfoResponse
) {
}
