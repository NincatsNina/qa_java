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
    private Predator predator;
    @Test
    void getKittensReturnsCorrectCountAndVerifiesCall() throws Exception {
        Lion lion = new Lion("Самец", predator);
        Mockito.when(predator.getKittens()).thenReturn(1);

        Assertions.assertEquals(1, lion.getKittens());
        Mockito.verify(predator).getKittens();
    }
    @Test
    void getFoodReturnsPredatorFoodAndVerifiesCall() throws Exception {
        Lion lion = new Lion("Самка", predator);
        List<String> mockFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(predator.eatMeat()).thenReturn(mockFood);

        Assertions.assertEquals(mockFood, lion.getFood());
        Mockito.verify(predator, Mockito.times(1)).eatMeat();
    }
    @Test
    void constructorThrowsExceptionOnInvalidSex() {
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                new Lion("InvalidSex", predator)
        );
        Assertions.assertEquals("Используйте допустимые значения пола животного - самей или самка", exception.getMessage());
        Mockito.verifyNoInteractions(predator);
    }
}
