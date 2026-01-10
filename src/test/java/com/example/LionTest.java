package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    Feline feline;

    @Test
    void testGetKittensDelegatesToFeline() throws Exception {
        // Arrange
        when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самец", feline);

        // Act
        int actual = lion.getKittens();

        // Assert
        assertEquals(1, actual);
        verify(feline, times(1)).getKittens();
    }

    @Test
    void testDoesHaveManeReturnsTrueForMale() throws Exception {
        Lion lion = new Lion("Самец", feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void testDoesHaveManeReturnsFalseForFemale() throws Exception {
        Lion lion = new Lion("Самка", feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void testGetFoodDelegatesToFeline() throws Exception {
        // Arrange
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expected);

        Lion lion = new Lion("Самец", feline);

        // Act
        List<String> actual = lion.getFood();

        // Assert
        assertEquals(expected, actual);
        verify(feline, times(1)).getFood("Хищник");
    }

    @Test
    void testConstructorThrowsExceptionForInvalidSex() {
        // Act & Assert
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Другое", feline);
        });

        assertEquals("Используйте допустимые значения пола животного - самец или самка",
                exception.getMessage());
    }
}

