package ru.itis.skill.recommendation.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "job_info")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long experience;
    private String positionName;
    private Long salaryRate;
    private String specialization;
    private Long userId;
}
