package ru.job4j.exam;

public class Algorithms {
    /** Термины:
     * O >> Бремя выполнения итерации.
     * n >> Кол-во, итераций/элементов/проверок.
     * *Скорость алгоритмов измеряется не в секундах, а в темпе роста количе­ства операций.
     * *По сути формула описывает, насколько быстро возрастает время выпол­нения алгоритма
     * с увеличением размера входных данных.
     *
     *
     * Простой/Линейниый/Тупой поиск (алогоритм)
     * Время: O(n) - Линейное время
     * Скорость роста: 1 к 1 с кол-во, Элементов.  100 = 100 >> 120 = 120
     * 100 элементов = 100 проверок
     * 4 000 000 000 элементов = 4 000 000 000 проверок
     *
     * + Можно проводить всегда и везде.
     * - Являеться не самым быстрым поиском.
     *
     *
     *
     * Бинарный поиск
     * Время: O(Long n) - логарифмияческое время
     * Скорость роста: +1 итерация к удваению кол-во, Элементов.  128 = 7 >> 256 = 8
     * 100 элементов = 7 проверок
     * 4 000 000 000 элементов = 32 проверок
     *
     * + Краткий и быстрый
     * - ТОЛЬКО для сортировынных "Массивов-Списков".
     *** Каждую итерацию сокращает границы поиска на 1/2(половину) от прошлой итерации,
     * при помощи знаков сравнения "<, >, =="
     * Пример:
     * 0     1     2      3       4   5    7        8         - Итерации
     * 100 - 50 - 25 - 12.5(13) - 6 - 3 - 1.5(2) - 0.75(1)    - Кол-во элементов в границе поиска.
     * Пример 2:
     * 0      1    2    3     4        5         6        7   - Итерации
     * 128 - 68 - 34 - 17 - 8.5(9) - 4.25(4) - 2.125(2) - 1   - Кол-во элементов в границе поиска.
     * ФИШКИ:
     ** Если кол-во элементов удваивается, то будет + 1 к итерации.
     ** Хорошо работает с чётным количеством жлементов.
     *
     *
     * Ниже перечислены пять разновидностей «О-большого», которые будут встре­чаться вам особенно часто,
     *  в порядке убывания скорости выполнения:
     *   O(log п ), или логарифмическое время. Пример: бинарный поиск.
     *   О(п), или линейное время. Пример: простой поиск.
     *   О(п * log п). Пример: эффективные алгоритмы сортировки (быстрая сортировка).
     *   О(п2). Пример: медленные алгоритмы сортировки (сортировка выбо­ром).
     *   О(п/). Пример: очень медленные алгоритмы (задача о коммивояжере).
     *
     *
     *
     *
     *
     *
     *
     */
}
