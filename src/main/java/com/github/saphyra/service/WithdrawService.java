package com.github.saphyra.service;

import com.github.saphyra.read.IntegerValidationReader;
import com.github.saphyra.repository.user.User;
import com.github.saphyra.repository.user.UserRepository;
import com.github.saphyra.validation.PositiveNumberValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WithdrawService {
    private final IntegerValidationReader integerValidationReader;
    private final PositiveNumberValidation positiveNumberValidation;
    private final UserRepository userRepository;

    public void withdraw(User user) {
        System.out.println("How much money do you want to deposit? Available balance: " + user.getBalance());
        int withdrawValue = integerValidationReader.readNumber(positiveNumberValidation);

        if (withdrawValue > user.getBalance()) {
            System.err.println("You cannot withdraw so much.");
            withdraw(user);
            return;
        }

        user.decreaseBalance(withdrawValue);
        userRepository.save(user);
        System.out.println("Withdraw successful.");
    }
}
