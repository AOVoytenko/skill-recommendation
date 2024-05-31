package ru.itis.skill.recommendation.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.skill.recommendation.db.entity.JobInfoEntity;
import ru.itis.skill.recommendation.db.entity.SkillEntity;
import ru.itis.skill.recommendation.db.entity.SkillRecommendationEntity;
import ru.itis.skill.recommendation.db.repository.SkillRepository;
import ru.itis.skill.recommendation.db.repository.UserRepository;
import ru.itis.skill.recommendation.db.repository.SkillRecommendationRepository;
import ru.itis.skill.recommendation.dto.JobInfoRequest;
import ru.itis.skill.recommendation.db.repository.JobInfoRepository;
import ru.itis.skill.recommendation.dto.RecommendationResponse;
import ru.itis.skill.recommendation.dto.RecommendedSkillsResponse;
import ru.itis.skill.recommendation.dto.UserSkillsResponse;
import ru.itis.skill.recommendation.mapper.EntityMapper;
import ru.itis.skill.recommendation.mapper.ResponseMapper;
import ru.itis.skill.recommendation.service.IntegrationService;
import ru.itis.skill.recommendation.service.SkillService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRecommendationRepository skillRecommendationRepository;
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;
    private final JobInfoRepository jobInfoRepository;
    private final ResponseMapper responseMapper;
    private final EntityMapper entityMapper;
    private final IntegrationService integrationService;

    @Override
    public UserSkillsResponse getAllSkillsByRecommendationId(Long id) {
        List<SkillRecommendationEntity> recommendationEntities = skillRecommendationRepository.findAllByRecommendationId(id);
        JobInfoEntity recommendation = jobInfoRepository.getById(id);

        var skillIds = recommendationEntities.stream().map(SkillRecommendationEntity::getSkillId).collect(Collectors.toSet());
        var skills = skillRepository.findAllById(skillIds).stream().map(SkillEntity::getSkill).toList();

        var userInfo = userRepository.findById(recommendation.getUserId()).orElse(null);

        return responseMapper.toUserSkillsResponse(skills, userInfo, recommendation);
    }

    @Override
    public RecommendationResponse createSkillRecommendation(JobInfoRequest request, Long userId) {
        var entity = new JobInfoEntity(
                null,
                request.experience(),
                request.positionName(),
                request.salaryRate(),
                request.specialization(),
                userId);
        JobInfoEntity jobInfoEntity = jobInfoRepository.save(entity);

        RecommendedSkillsResponse skillRecommendation = integrationService.createSkillRecommendation(request);

        List<SkillRecommendationEntity> entities = skillRecommendation.skills().stream().map(skill -> {
                    Long skillId = skillRepository.findBySkill(skill).getId();
                    return entityMapper.toUserSkillsEntity(jobInfoEntity.getId(), skillId);
                }
        ).toList();

        skillRecommendationRepository.saveAll(entities);
        return new RecommendationResponse(jobInfoEntity.getId());
    }
}
