package ru.itis.skill.recommendation.service.impl;

import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.skill.recommendation.dto.JobInfoRequest;
import ru.itis.skill.recommendation.dto.RecommendedSkillsResponse;
import ru.itis.skill.recommendation.service.IntegrationService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IntegrationServiceImpl implements IntegrationService {

    private final String SERVICE_BASE_URL = "https://localhost:8080/skill";
    public static final String APPLICATION_JSON_VALUE = "application/json";


    @Override
    public RecommendedSkillsResponse createSkillRecommendation(JobInfoRequest request) {
        boolean flag = true;
        if (flag) {
            return new RecommendedSkillsResponse(List.of("java", "docker", "postgresql"));
        }
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        RequestEntity<JobInfoRequest> requestEntity = RequestEntity.post(SERVICE_BASE_URL)
                .header("header", "header")
                .contentType(MediaType.valueOf(APPLICATION_JSON_VALUE))
                .body(request);

        ResponseEntity<RecommendedSkillsResponse> response =
                restTemplate.exchange(requestEntity, RecommendedSkillsResponse.class);

        RecommendedSkillsResponse body = response.getBody();
        return body;
    }
}
