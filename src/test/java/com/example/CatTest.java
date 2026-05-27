package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CatTest {
    @Mock
    private Feline feline;
    @Test
    void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        Assertions.assertEquals("Мяу", cat.getSound());
    }
    @Test
    void getFoodReturnsCorrectList() throws Exception {
        Cat cat = new Cat(feline);
        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(mockFood);

        Assertions.assertEquals(mockFood, cat.getFood());
    }
}
