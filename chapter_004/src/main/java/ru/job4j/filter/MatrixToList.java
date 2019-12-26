package ru.job4j.filter;

import java.util.*;
import java.util.ArrayList;

public class MatrixToList {

    public static List convert(int[][] matrix) {
        List result = new ArrayList();
        Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .forEach(result::add);
        return result;
    }
}
