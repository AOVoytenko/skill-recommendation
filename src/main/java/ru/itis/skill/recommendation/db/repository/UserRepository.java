package ru.itis.skill.recommendation.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.skill.recommendation.db.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}