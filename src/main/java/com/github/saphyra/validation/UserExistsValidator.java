package com.github.saphyra.validation;

import com.github.saphyra.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@RequiredArgsConstructor
public class UserExistsValidator implements Predicate<String> {
    private final UserRepository userRepository;

    @Override
    public boolean test(String username) {
        if(isBlank(username)){
            return true;
        }
        boolean result = userRepository.usernameExists(username);
        if (!result) {
            System.err.println("User not found.");
        }
        return result;
    }
}
