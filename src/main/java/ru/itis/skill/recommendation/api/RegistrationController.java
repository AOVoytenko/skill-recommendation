package ru.itis.skill.recommendation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.skill.recommendation.dto.SignUpForm;
import ru.itis.skill.recommendation.service.impl.UserService;

@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public Long registration(@RequestBody SignUpForm signUpForm) {
        return userService.saveUser(signUpForm);
    }
}
