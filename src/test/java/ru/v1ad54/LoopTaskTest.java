package ru.v1ad54;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoopTasksTest {

    @Test
    @DisplayName("Тесты метода blastOff")
    void blastOffTest() {
        // как в примере
        assertEquals("5 4 3 2 1 Поехали!", LoopTasks.blastOff(5));
        // с единицы
        assertEquals("1 Поехали!", LoopTasks.blastOff(1));
        // с нуля
        assertEquals("Поехали!", LoopTasks.blastOff(0));
        // отрицательное значение
        assertEquals("Поехали!", LoopTasks.blastOff(-3));
    }

    @Test
    @DisplayName("Тесты метода sumToN")
    void sumToNTest() {
        // положительные числа
        assertEquals(15, LoopTasks.sumToN(5), "Сумма от 1 до 5 должна быть равна 15");
        assertEquals(1, LoopTasks.sumToN(1), "Сумма от 1 до 1 должна быть равна 1");

        // нулевые и отрицательные числа
        assertEquals(0, LoopTasks.sumToN(0), "Сумма от 1 до 0 должна быть равна 0");
        assertEquals(0, LoopTasks.sumToN(-10), "Сумма от 1 до -10 должна быть равна 0");

        // Исключение ArithmeticException при слишком большом значении
        assertThrows(ArithmeticException.class, () -> LoopTasks.sumToN(77777),
                "При большом значении должно возникнуть исключение ArithmeticException");
    }

    @Test
    @DisplayName("Тесты метода hasBug")
    void hasBugTest() {
        // Bug есть - должен вернуть true
        assertTrue(LoopTasks.hasBug(new String[]{"Bug", "Hello", "World"}));
        assertTrue(LoopTasks.hasBug(new String[]{"Hello", "Bug", "World"}));
        assertTrue(LoopTasks.hasBug(new String[]{"Hello", "World", "Bug"}));

        // Bug нет - должен вернуть false
        assertFalse(LoopTasks.hasBug(new String[]{"Hello", "World", "Feature"}));

        // пустой массив - должен вернуть false
        assertFalse(LoopTasks.hasBug(new String[]{}));

        // массив содержит элементы null - не должен падать с NPE
        //   Bug есть - должен вернуть true
        assertTrue(LoopTasks.hasBug(new String[]{"Hello", null, "Bug"}));
        //   Bug нет - должен вернуть false
        assertFalse(LoopTasks.hasBug(new String[]{"Hello", null, "World"}));

        // при передаче null должно возникнуть исключение NullPointerException
        assertThrows(NullPointerException.class, () -> LoopTasks.hasBug(null),
                "при передаче null должно возникнуть исключение NullPointerException");
    }

    @Test
    @DisplayName("Тестирование метода getEvenInRange")
    void getEvenInRangeTest() {
        // положительный диапазон
        assertEquals("2 4 6", LoopTasks.getEvenInRange(1, 7));
        assertEquals("2 4 6", LoopTasks.getEvenInRange(2, 6));

        // диапазон из одного четного числа
        assertEquals("4", LoopTasks.getEvenInRange(4, 4));

        // диапазон из одного не четного числа
        assertEquals("", LoopTasks.getEvenInRange(5, 5));

        // границы не составляют диапазон (start > end)
        assertEquals("", LoopTasks.getEvenInRange(10, 5));

        // диапазон с отрицательными границами
        assertEquals("-4 -2 0 2", LoopTasks.getEvenInRange(-4, 2));
        assertEquals("-4 -2 0 2", LoopTasks.getEvenInRange(-5, 3));
    }
}
