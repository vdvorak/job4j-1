package ru.job4j.io;

import daniils.IOHelper;
import daniils.StringHelper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AnalizyTest {
    private String sourcePath = "./src/main/resources/analysis/analise_input.txt";
    private String targetPath = "./src/main/resources/analysis/analise_answers.txt";

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void unavailable() {
        new Analizy().unavailable(sourcePath, targetPath);
        var expectedList = List.of(
                "10:57:01 - 10:59:01",
                "11:01:02 - 11:02:02"
        );
        assertThat(IOHelper.compareInfoFromFileWithList(targetPath, expectedList), is(true));
    }

    @Test
    public void tryWithTempFolder() throws IOException {
        var testFile = tempFolder.newFile("test.check");
        var answerFile = tempFolder.newFile("answer.check");

        IOHelper.writeListToFile(testFile.getPath(), List.of(
                StringHelper.separateLines(
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "200 11:02:02"
        )), "");

        new Analizy().unavailable(testFile.getPath(), answerFile.getPath());
        var fileLines = (LinkedList) IOHelper.readFileToList(answerFile.getPath(), LinkedList::new);

        assertEquals(fileLines.removeFirst(), "10:57:01 - 10:59:01");
        assertEquals(fileLines.removeFirst(), "11:01:02 - 11:02:02");
    }
}