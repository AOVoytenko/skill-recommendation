package ru.itis.skill.recommendation.db.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skills_recommendations")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SkillRecommendationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long recommendationId;
    private Long skillId;
}
