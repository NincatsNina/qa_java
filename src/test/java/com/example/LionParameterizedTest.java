package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

class LionParameterizedTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void doesHaveReturnsCorrectValueBasedOnSex(String sex, boolean expectedHasMane) throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion(sex, predator);
        Assertions.assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}