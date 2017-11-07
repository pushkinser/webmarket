package ru.webmarket.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.webmarket.model.dto.UserDTO;
import ru.webmarket.service.UserService;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;

        if (userService.get(userDTO.getUserName()) != null) {
            errors.rejectValue("userName", "error.userName", "Логин "+userDTO.getUserName()+" уже занят.");
        }
    }
}
