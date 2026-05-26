package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AlexTest {
    @Mock
    private Predator predator;

    @Test
    void getKittensAlwaysReturnsZeroForAlex() throws Exception {
        Alex alex = new Alex(predator);
        Assertions.assertEquals(0, alex.getKittens());
    }

    @Test
    void getFriendsReturnsCorrectList() throws Exception {
        Alex alex = new Alex(predator);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        Assertions.assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    void getPlaceOfLivingReturnsZoo() throws Exception {
        Alex alex = new Alex(predator);
        Assertions.assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void alexAlwaysHasManeTrue() throws Exception {
        Alex alex = new Alex(predator);
        Assertions.assertTrue(alex.doesHaveMane());
    }
}
