package ru.itis.skill.recommendation.dto;

public record JobInfoRequest(
        Long experience,
        String positionName,
        Long salaryRate,
        String specialization
) {
}
