package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    private final Animal animal = new Animal();

    // Тест для Травоядного
    @ParameterizedTest
    @MethodSource("травоядноеFoodProvider")
    void testGetFoodForHerbivore(String animalKind, List<String> expectedFood) throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals(expectedFood, actual);
    }

    // Тест для Хищника
    @ParameterizedTest
    @MethodSource("хищникFoodProvider")
    void testGetFoodForPredator(String animalKind, List<String> expectedFood) throws Exception {
        List<String> actual = animal.getFood(animalKind);
        assertEquals(expectedFood, actual);
    }

    // Тест для неизвестного вида (исключение)
    @ParameterizedTest
    @MethodSource("неверныйТипProvider")
    void testGetFoodForUnknownTypeThrowsException(String animalKind) {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood(animalKind);
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage());
    }

    // Источники данных

    static Stream<Arguments> травоядноеFoodProvider() {
        return Stream.of(
                Arguments.of("Травоядное", List.of("Трава", "Различные растения"))
        );
    }

    static Stream<Arguments> хищникFoodProvider() {
        return Stream.of(
                Arguments.of("Хищник", List.of("Животные", "Птицы", "Рыба"))
        );
    }

    static Stream<Arguments> неверныйТипProvider() {
        return Stream.of(
                Arguments.of("Птица"),
                Arguments.of("Рыба"),
                Arguments.of("")
        );
    }

    // Тест метода getFamily()
    @ParameterizedTest(name = "Проверка getFamily возвращает корректный текст")
    @MethodSource("familyProvider")
    void testGetFamily(String expected) {
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }

    static Stream<Arguments> familyProvider() {
        return Stream.of(
                Arguments.of("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи")
        );
    }
}
