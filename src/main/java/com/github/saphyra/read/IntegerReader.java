package com.github.saphyra.read;

import com.github.saphyra.validation.IntegerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntegerReader {
    private final ValidationReader validationReader;
    private final IntegerValidator integerValidator;

    public int readNumber() {
        String numberString = validationReader.readInput(integerValidator);

        return Integer.parseInt(numberString);
    }
}
