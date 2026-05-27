package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    @Mock
    private Feline feline;
    @Test
    void getKittensReturnsCorrectCountAndVerifiesCall() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);

        Assertions.assertEquals(1, lion.getKittens());
        Mockito.verify(feline).getKittens();
    }
    @Test
    void getFoodReturnsPredatorFoodAndVerifiesCall() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(mockFood);

        Assertions.assertEquals(mockFood, lion.getFood());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
    @Test
    void constructorThrowsExceptionOnInvalidSex() {
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                new Lion("InvalidSex", feline)
        );
        Assertions.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        Mockito.verifyNoInteractions(feline);
    }
}
