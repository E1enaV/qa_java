package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlexTest {

    @Test
    void validateGetFriendsAlex() throws Exception {
        Alex alex = new Alex(null);
        List<String> actual = alex.getFriends();
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, actual);
    }

    @Test
    void validateGetPlaceOfLivingAlex() throws Exception {
        Alex alex = new Alex(null);
        String actual = alex.getPlaceOfLiving();
        String expected = "Нью-Йоркский зоопарк";
        assertEquals(expected, actual);
    }

    @Test
    void validateGetKittensAlex() throws Exception {
        Alex alex = new Alex(null);
        int actual = alex.getKittens();
        int expected = 0;
        assertEquals(expected, actual);
    }
}

