package com.github.saphyra.config;

import com.github.saphyra.repository.user.User;
import com.github.saphyra.repository.user.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Data
@RequiredArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "registration")
public class DefaultUserConfiguration {
    private final UserRepository userRepository;

    private List<User> defaultUsers;

    @PostConstruct
    public void addDefaultUsers() {
        for (User user : defaultUsers) {
            userRepository.save(user);
        }
    }
}
