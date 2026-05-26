package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FelineTest {
    @Spy
    private Feline feline;
    @Test
    void eatMeatReturnsPredatorFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assertions.assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    void getFamilyReturnsCorrectString() {
        Assertions.assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    void getKittensWithArgReturnsArgValue() {
        Assertions.assertEquals(7, feline.getKittens(7));
    }
    @Test
    void getKittensNoParamInvokesGetKittensWithOne() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

}
