package ru.v1ad54;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTasksTest {

    @Test
    @DisplayName("Тесты метода isEven")
    void testIsEvenTest() {
        // Положительные числа
        assertTrue(LogicTasks.isEven(2), "2 должно быть четным");
        assertFalse(LogicTasks.isEven(3), "3 не должно быть четным");

        // Ноль
        assertTrue(LogicTasks.isEven(0), "0 должен быть четным");

        // Отрицательные числа
        assertTrue(LogicTasks.isEven(-4), "-4 должно быть четным");
        assertFalse(LogicTasks.isEven(-5), "-5 не должно быть четным");
    }

    @Test
    @DisplayName("Тесты метода checkAccess")
    void testCheckAccessTest() {
        // Меньше 18
        assertEquals("Denied", LogicTasks.checkAccess(17), "Для 17 доступ должен быть Denied");

        // Граничное значение 18 (в условии строго больше 'age > 18')
        assertEquals("Denied", LogicTasks.checkAccess(18), "Для 18 доступ должен быть Denied");

        // Больше 18
        assertEquals("Allowed", LogicTasks.checkAccess(19), "Для 19 доступ должен быть Allowed");
        assertEquals("Allowed", LogicTasks.checkAccess(50), "Для 50 доступ должен быть Allowed");
    }

    @Test
    @DisplayName("Тесты метода isPositive")
    void testIsPositiveTest() {
        // Положительные числа
        assertTrue(LogicTasks.isPositive(1), "1 должно быть positive");
        assertTrue(LogicTasks.isPositive(100), "100 должно быть positive");

        // Ноль (в условии 'больше или равно 0')
        assertTrue(LogicTasks.isPositive(0), "0 должен быть positive");

        // Отрицательные числа
        assertFalse(LogicTasks.isPositive(-1), "-1 не должно быть positive");
        assertFalse(LogicTasks.isPositive(-100), "-100 не должно быть positive");
    }

    @Test
    @DisplayName("Тесты метода getGrade")
    void testGetGradeTest() {
        // Границы диапазона E (0-20)
        assertEquals("E", LogicTasks.getGrade(0));
        assertEquals("E", LogicTasks.getGrade(10));
        assertEquals("E", LogicTasks.getGrade(20));

        // Границы диапазона D (21-40)
        assertEquals("D", LogicTasks.getGrade(21));
        assertEquals("D", LogicTasks.getGrade(30));
        assertEquals("D", LogicTasks.getGrade(40));

        // Границы диапазона C (41-60)
        assertEquals("C", LogicTasks.getGrade(41));
        assertEquals("C", LogicTasks.getGrade(50));
        assertEquals("C", LogicTasks.getGrade(60));

        // Границы диапазона B (61-80)
        assertEquals("B", LogicTasks.getGrade(61));
        assertEquals("B", LogicTasks.getGrade(70));
        assertEquals("B", LogicTasks.getGrade(80));

        // Границы диапазона A (81-100)
        assertEquals("A", LogicTasks.getGrade(81));
        assertEquals("A", LogicTasks.getGrade(90));
        assertEquals("A", LogicTasks.getGrade(100));

//        // Исключение IllegalArgumentException при отрицательных баллах
//        assertThrows(IllegalArgumentException.class, () -> LogicTasks.getGrade(-1),
//                "Должно быть исключение IllegalArgumentException при отрицательных баллах");
//        // Исключение IllegalArgumentException при баллах больше 100
//        assertThrows(IllegalArgumentException.class, () -> LogicTasks.getGrade(101),
//                "Должно быть исключение IllegalArgumentException при баллах больше 100");
        // Если переданное число не входит в границы — вернуть строку Error.
        assertEquals("Error", LogicTasks.getGrade(-1));
        assertEquals("Error", LogicTasks.getGrade(101));
    }
}
