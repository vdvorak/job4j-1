package ru.job4j.design.srp;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.helpers.StringHelper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class ReportEngineTest {
    // 1) init
    private MemStore store = new MemStore();
    private Calendar now = Calendar.getInstance();
    private Employee worker = new Employee("Ivan", now, now, 100);

    @Before
    public void setUp() {
        // 2) prepare
        store.add(worker);
    }

    @Test
    public void defaultGenerator() {
        // 3) action
        var result = new ReportEngine(store).generate(employee -> true);
        // 4) expected
        var tempHired = DateHelper.dateFormat("yyy-MM-dd  HH:mm:ss", worker.getHired());
        var tempFired = DateHelper.dateFormat("yyy-MM-dd  HH:mm:ss", worker.getFired());
        var expect = "Name; Hired; Fired; Salary;"
                + worker.getName() + ";"
                + tempHired + ";"
                + tempFired + ";"
                + worker.getSalary() + ";"
                + System.lineSeparator();
        // 5) compare
        assertEquals(expect, result);
    }

    @Test
    public void htmlGenerator() {
        // 3) action
        var result = new ReportEngine(store).generateHtml(employee -> true);
        // 4) expected
        List<String> list = List.of(
                "<!DOCTYPE html>",
                "<html>",
                "<table>",
                "<caption>Employee</caption>",
                "    <tr>",
                "        <th>Name</th>",
                "        <th>Hired</th>",
                "        <th>Fired</th>",
                "        <th>Salary</th>",
                "    </tr>"
        );
        var tempList = new ArrayList<>(list);
        for (Employee employee : store.findBy(employee -> true)) {
            var tempHired = DateHelper.dateFormat("yyy-MM-dd  HH:mm:ss", employee.getHired());
            var tempFired = DateHelper.dateFormat("yyy-MM-dd  HH:mm:ss", employee.getFired());
            List<String> loopList = List.of(
                    "    <tr>",
                    "        <td>" + employee.getName() + "</td>",
                    "        <td>" + tempHired + "</td>",
                    "        <td>" + tempFired + "</td>",
                    "        <td>" + employee.getSalary() + "</td>",
                    "    </tr>"
            );
            tempList.addAll(loopList);
        }
        tempList.add("</table>");
        tempList.add("</html>");
        var temp = StringHelper.separateLines(tempList);
        var expected = StringHelper.mergeToOne(temp);
        // 5) compare
        assertEquals(expected, result);
    }

    @Test
    public void hrGenerator() {
        // 2) prepare
        Employee second = new Employee("Vasja", now, now, 125);
        Employee third = new Employee("Anja", now, now, 97);
        store.add(second);
        store.add(third);
        // 3) action
        var result = new ReportEngine(store).generateForHr(employee -> true);
        // 4) expected
        var expected = "Name; Salary;" + System.lineSeparator()
                + "Vasja;125.0;" + System.lineSeparator()
                + "Ivan;100.0;" + System.lineSeparator()
                + "Anja;97.0;" + System.lineSeparator();
        // 5) compare
        assertEquals(expected, result);
    }

    @Test
    public void accountingGenerator() {
        // 3) action
        var result = new ReportEngine(store).generateForAccounting(employee -> true);
        // 4) expected
        var tempHired = DateHelper.dateFormat("yyy-MM-dd  HH:mm:ss", worker.getHired());
        var tempFired = DateHelper.dateFormat("yyy-MM-dd  HH:mm:ss", worker.getFired());
        var expect = "Name; Hired; Fired; Salary;"
                + worker.getName() + ";"
                + tempHired + ";"
                + tempFired + ";"
                + (int) worker.getSalary() + ";"
                + System.lineSeparator();
        // 5) compare
        assertEquals(expect, result);
    }
}