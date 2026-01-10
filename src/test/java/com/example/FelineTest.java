package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FelineTest {

    private final Feline feline = new Feline();

    // Обычные тесты (без параметров)
    @Test
    void testEatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    void testGetFamilyReturnsFelineFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    void testGetKittensNoParamsReturnsOne() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals(expected, actual);
    }

    // Параметризованный тест для getKittens(int)
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "0, 0",
            "-1, -1",
            "5, 5"
    })
    void testGetKittensWithParameter(int input, int expected) {
        int actual = feline.getKittens(input);
        assertEquals(expected, actual);
    }
}

