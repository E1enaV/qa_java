package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CatTest {

    @Mock
    Feline feline;

    @Test
    void testGetSoundReturnsMeow() {
        Cat cat = new Cat(feline);

        String expected = "Мяу";
        String actual = cat.getSound();

        assertEquals(expected, actual);
    }

    @Test
    void testGetFoodDelegatesToPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.eatMeat()).thenReturn(expected);

        Cat cat = new Cat(feline);

        // Act
        List<String> actual = cat.getFood();

        // Assert
        assertEquals(expected, actual);
        verify(feline, times(1)).eatMeat();  // Проверка вызова метода
    }
}

