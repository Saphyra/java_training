package com.github.saphyra.service;

import com.github.saphyra.read.IntegerValidationReader;
import com.github.saphyra.read.ValidationReader;
import com.github.saphyra.repository.user.User;
import com.github.saphyra.repository.user.UserRepository;
import com.github.saphyra.validation.PositiveNumberValidation;
import com.github.saphyra.validation.UserExistsValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransferService {
    private final IntegerValidationReader integerValidationReader;
    private final PositiveNumberValidation positiveNumberValidation;
    private final ValidationReader validationReader;
    private final UserExistsValidator userExistsValidator;
    private final UserRepository userRepository;

    public void transfer(User user) {
        System.out.println("How much money do you want to transfer? Available balance: " + user.getBalance());
        int transferValue = integerValidationReader.readNumber(positiveNumberValidation);

        if(transferValue == 0){
            System.out.println("Transaction cancelled.");
            return;
        }

        if (transferValue > user.getBalance()) {
            System.err.println("You cannot transfer so much.");
            transfer(user);
            return;
        }

        System.out.println("Who do you want to send money to?");
        String username = validationReader.readInput(userExistsValidator);
        if(isBlank(username)){
            System.out.println("Transaction cancelled.");
            return;
        }

        System.out.println(String.format("Transferring %s money to %s", transferValue, username));
        User target = userRepository.findByUsername(username);

        target.increaseBalance(transferValue);
        user.decreaseBalance(transferValue);

        System.out.println("Transaction successful.");
    }
}
