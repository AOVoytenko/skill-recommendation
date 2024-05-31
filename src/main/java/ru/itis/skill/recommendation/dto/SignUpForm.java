package ru.itis.skill.recommendation.dto;

import lombok.Data;

@Data
public class SignUpForm {
    String firstName;
    String lastName;
    Integer age;
    String dateOfBirth;
    String email;
    String password;
}
