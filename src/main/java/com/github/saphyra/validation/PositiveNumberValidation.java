package com.github.saphyra.validation;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class PositiveNumberValidation implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        if (integer < 0) {
            System.out.println("Number most be positive.");
            return false;
        }
        return true;
    }
}
