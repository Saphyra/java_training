package com.github.saphyra.repository.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private String username;
    private String password;
    private int balance;

    public void increaseBalance(int depositValue) {
        balance += depositValue;
    }

    public void decreaseBalance(int withdrawValue) {
        balance -= withdrawValue;
    }
}
