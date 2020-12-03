package com.github.saphyra.service;

import com.github.saphyra.read.IntegerValidationReader;
import com.github.saphyra.repository.user.User;
import com.github.saphyra.validation.PositiveNumberValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepositService {
    private final IntegerValidationReader integerValidationReader;
    private final PositiveNumberValidation positiveNumberValidation;

    public void deposit(User user) {
        System.out.println("How much do you want to deposit?");
        int depositValue = integerValidationReader.readNumber(positiveNumberValidation);

        user.increaseBalance(depositValue);
        System.out.println("Deposit successful.");
    }
}
