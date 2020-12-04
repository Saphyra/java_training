package com.github.saphyra.menu;

import com.github.saphyra.read.ValidationReader;
import com.github.saphyra.repository.user.User;
import com.github.saphyra.repository.user.UserRepository;
import com.github.saphyra.validation.PasswordValidation;
import com.github.saphyra.validation.UsernameValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegistrationMenu implements Menu {
    private final ValidationReader validationReader;
    private final UsernameValidation usernameValidation;
    private final PasswordValidation passwordValidation;
    private final UserRepository userRepository;

    @Value("${registration.startBalance}")
    private int startBalance;

    @Override
    public void enterMenu() {
        System.out.println();
        System.out.println("Registering user...");
        System.out.println("Username:");
        String username = validationReader.readInput(usernameValidation);

        System.out.println();
        System.out.println("Password:");
        String password = validationReader.readInput(passwordValidation);

        User user = User.builder()
                .username(username)
                .password(password)
                .balance(startBalance)
                .build();
        userRepository.save(user);

        System.out.println("Registration successful.");
    }
}
