package ru.itis.skill.recommendation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itis.skill.recommendation.db.entity.JobInfoEntity;
import ru.itis.skill.recommendation.db.entity.User;
import ru.itis.skill.recommendation.dto.UserInfoResponse;
import ru.itis.skill.recommendation.dto.UserSkillsResponse;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponseMapper {

    @Mapping(target = "positionName", source = "jobInfoEntity.positionName")
    @Mapping(target = "experience", source = "jobInfoEntity.experience")
    @Mapping(target = "salaryRate", source = "jobInfoEntity.salaryRate")
    @Mapping(target = "specialization", source = "jobInfoEntity.specialization")
    @Mapping(target = "userInfoResponse", source = "user")
    UserSkillsResponse toUserSkillsResponse(List<String> skills, User user, JobInfoEntity jobInfoEntity);

    UserInfoResponse toUserInfoResponse(User user);
}