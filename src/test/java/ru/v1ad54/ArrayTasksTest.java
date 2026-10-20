package ru.v1ad54;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayTasksTest {

    @Test
    @DisplayName("Тесты метода findMax")
    void findMaxTest() {
        // массив с положительными и отрицательными числами
        assertEquals(7, ArrayTasks.findMax(new int[]{3, -1, 7, 5, 0, 2}));

        // массив в котором все числа одинаковые
        assertEquals(5, ArrayTasks.findMax(new int[]{5, 5, 5, 5, 5}));

        // массив из одного элемента
        assertEquals(55, ArrayTasks.findMax(new int[]{55}));

        // исключение IllegalArgumentException при пустом массиве
        assertThrows(IllegalArgumentException.class, () -> ArrayTasks.findMax(new int[]{}));

        // исключение NullPointerException при передаче null
        assertThrows(NullPointerException.class, () -> ArrayTasks.findMax(null));
    }

    @Test
    @DisplayName("Тесты метода reverse")
    void reverseTest() {
        // обычный строковый массив
        assertArrayEquals(new String[]{"Три", "Два", "Один"}, ArrayTasks.reverse(new String[]{"Один", "Два", "Три"}));

        // пустой массив
        assertArrayEquals(new String[]{}, ArrayTasks.reverse(new String[]{}));

        // исключение NullPointerException при передаче null
        assertThrows(NullPointerException.class, () -> ArrayTasks.reverse(null));
    }

    @Test
    @DisplayName("Тесты метода calcAverage")
    void calcAverageTest() {
        // просто список чисел
        assertEquals(5, ArrayTasks.calcAverage(Arrays.asList(2, 4, 6, 8)));

        // деление с потерей дробной части (целочисленный int)
        assertEquals(4, ArrayTasks.calcAverage(Arrays.asList(5, 4)));

        // исключение IllegalArgumentException на пустой список
        assertThrows(IllegalArgumentException.class, () -> ArrayTasks.calcAverage(new ArrayList<>()));

        // исключение NullPointerException при передаче null
        assertThrows(NullPointerException.class, () -> ArrayTasks.calcAverage(null));

        // исключение IllegalArgumentException, если внутри списка есть null
        assertThrows(IllegalArgumentException.class, () -> ArrayTasks.calcAverage(Arrays.asList(1, 2, null, 4)));
    }

    @Test
    @DisplayName("Тесты метода removeSpecificName")
    void removeSpecificNameTest() {
        // удаление существующего имени (одного и нескольких)
        assertEquals(
                        Arrays.asList("Петр", "Анна"),
                        ArrayTasks.removeSpecificName(Arrays.asList("Иван", "Петр", "Иван", "Анна"), "Иван")
        );

        // имя для удаления отсутствует в списке
        assertEquals(
                Arrays.asList("Иван", "Петр", "Вася", "Анна"),
                ArrayTasks.removeSpecificName(Arrays.asList("Иван", "Петр", "Вася", "Анна"), "Коля")
        );

        // исключение NullPointerException при передаче null в параметр list
        assertThrows(
                NullPointerException.class,
                () -> ArrayTasks.removeSpecificName(null, "Ольга")
        );

        // исключение IllegalArgumentException, если элемент списка равен null
        assertThrows(
                IllegalArgumentException.class,
                () -> ArrayTasks.removeSpecificName(Arrays.asList("Иван", null, "Петр"), "Ольга")
        );

        // исключение IllegalArgumentException при передаче null в параметр nameToRemove
        assertThrows(
                IllegalArgumentException.class,
                () -> ArrayTasks.removeSpecificName(Arrays.asList("Иван", "Петр", "Вася", "Анна"), null)
        );
    }

}
