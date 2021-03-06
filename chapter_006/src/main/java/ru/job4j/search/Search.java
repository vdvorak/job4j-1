package ru.job4j.search;

import daniils.IOHelper;

import java.io.File;
import java.util.*;
import java.util.function.Function;

/** Класс для поиска файлов в Файловой Системе по его расширению.
 * Задача: Написать метод, который возвращает список всех файлов с конкретным расширением.
 * Метод должен заходить во всех каталоги,
 * для этого нужно использовать алгоритм обхода дерева в ширину.
 *
 * @author Daniils Loputevs
 * @version 1.0
 * @since 18.02.20.
 * Last upd:  06.03.20.
 * Last JavaDoc upd:  06.03.20.
 */
public class Search {

    /** Поиск файлов по расширениям в Файловой Системе.
     * @param rootPath - Путь до каталога, с которого нужно осуществлять поиск.
     * @param exts -  расширения файлов, которые мы хотим получить.
     * @return List<File> подходящих файлов.
     */
    public List<File> files(String rootPath, Set<String> exts) {
        var current = new File(rootPath);
        var base = new LinkedList<>(List.of(new File(rootPath)));
        var result = new HashSet<File>();

        if (current.isDirectory()) {
            base.add(current);
        }
        while (!base.isEmpty()) {
            current = base.removeFirst();
            if (current.isDirectory()) {
                result.addAll(Set.of(current.listFiles(file -> exts.contains(IOHelper.getExt(file)))));
                base.addAll(Arrays.asList(current.listFiles()));
            }
        }
        return List.copyOf(result);
    }


    /** Поиск файлов при помощи лямбды {@code function} в Файловой Системе.
     ** Не эффективен при множественном использовании,
     ** для поиска List<File> лучше использовать другой метод.
     *
     * @param rootPath - Начальная директория поиска.
     * @param function - Лямбда выдаёт полное имя файла, описывает способ сравнение с внешними аргументами.
     * @return file - если он найдет, null - если нет.
     */
    public File findByLambda(String rootPath, Function<String, Boolean> function) {
        var current = new File(rootPath);
        var base = new LinkedList<>(List.of(new File(rootPath)));
        File result = null;

        if (current.isDirectory()) {
            base.add(current);
        }
        while (!base.isEmpty()) {
            current = base.removeFirst();
            if (current.isDirectory()) {
                List<File> temp = List.of(current.listFiles(file -> function.apply(file.getName())));
                if (temp.size() > 0) {
                    result = temp.get(0);
                    break;
                }
                base.addAll(Arrays.asList(current.listFiles()));
            }
        }
        return result;
    }

}