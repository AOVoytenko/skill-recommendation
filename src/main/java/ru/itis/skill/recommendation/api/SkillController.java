package ru.itis.skill.recommendation.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.itis.skill.recommendation.db.entity.User;
import ru.itis.skill.recommendation.dto.JobInfoRequest;
import ru.itis.skill.recommendation.dto.RecommendationResponse;
import ru.itis.skill.recommendation.dto.UserSkillsResponse;
import ru.itis.skill.recommendation.service.SkillService;

@RestController
@RequestMapping("/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/{id}")
    UserSkillsResponse getAllSkills(@PathVariable Long id) {
        return skillService.getAllSkillsByRecommendationId(id);
    };

    @PostMapping
    RecommendationResponse createSkillRecommendation(
            @AuthenticationPrincipal User user,
            @RequestBody JobInfoRequest request
    ) {
        return skillService.createSkillRecommendation(request, user.getId());
    };
}
