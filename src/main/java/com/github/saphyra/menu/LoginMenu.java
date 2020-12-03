package com.github.saphyra.menu;

import com.github.saphyra.read.ConsoleReader;
import com.github.saphyra.repository.user.User;
import com.github.saphyra.repository.user.UserRepository;
import com.github.saphyra.util.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginMenu implements Menu {
    private final ConsoleReader consoleReader;
    private final UserRepository userRepository;
    private final AccountMenu accountMenu;
    private final Session session;

    @Override
    public void enterMenu() {
        System.out.println();
        System.out.println("Login");

        System.out.println("Username:");
        String username = consoleReader.readInput();

        System.out.println("Password:");
        String password = consoleReader.readInput();

        User user = userRepository.findByUsername(username);

        if (isNull(user)) {
            System.err.println("User not found");
            return;
        }

        if (!password.equals(user.getPassword())) {
            System.err.println("Incorrect password");
            return;
        }

        System.out.println("Login successful.");

        session.setUsername(username);
        accountMenu.enterMenu();
    }
}
