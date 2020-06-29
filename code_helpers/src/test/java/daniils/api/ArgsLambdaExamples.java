package daniils.api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ArgsLambdaExamples {
    @Test
    public void runFlag() {
        var args = new String[]{"-exe", "something"};

        Properties prop = new ArgsLambda.Builder()
                .load(args)   // load(...) like first option.
                .add("-exe")  // add flag
                .run();       // start processing args

        assertEquals("-exe", prop.getProperty("-exe"));
    }

    @Test
    public void runNormalKey() {
        var args = new String[]{"url", "w.leningrad.ru"};
        var log = new ArrayList<String>();

        Properties prop = new ArgsLambda.Builder()
                .load(args)
                .add("url", arg -> arg.contains(".org"))  // add normal-key
                .print(log::add)              // print option (save all warnings to log)
                .run();

        var expected = "WARNING - ArgsLambda: This key and value fail validate:"
                + System.lineSeparator()
                + "key:   " + "url" + System.lineSeparator()
                + "value: " + "w.leningrad.ru";

        assertEquals(expected, log.get(0));
    }

    @Test
    public void runMultiKey() {
        var args = new String[]{"-exe", "1", "kb", "s"};

        Map<String, String> prop = new ArgsLambda.Builder()
                .add("-exe", List.of(          // add multi-key
                        arg -> arg.equals("1"),    // first param validate
                        arg -> arg.equals("kb"),   // second param validate
                        arg -> arg.equals("s")))   // third param validate
                .load(args)                        // load like last option
                .runToMap();                       // start and return like Map<String, String>

        var values = prop.get("-exe").split("-");
        assertEquals("1", values[0]);
        assertEquals("kb", values[1]);
        assertEquals("s", values[2]);
    }

    /* ######## Specific cases ######## */
    // overload params && update properties.

    @Test
    public void runOverloadKeyParams() {
        var args = new String[]{"-exe", "10", "mb"};

        Properties prop = new ArgsLambda.Builder()
                .add("-exe", List.of(
                        arg -> arg.equals("1"),
                        arg -> arg.equals("kb"),
                        arg -> arg.equals("s")))
                .continuable()            // Very important option if you want to overload key param!
                .loadAndRun(args);        // * if we have args for second way to validate,
        // it's mean that first way fail and must have option {.continuable()}

        Properties alternativeValidate = new ArgsLambda.Builder()
                .add("-exe", List.of(          // add overload to multi-key validate
                        arg -> arg.equals("10"),   // new variant that you wait from args
                        arg -> arg.equals("mb")))
                .loadAndRun(args);                 // loadAndRun(...) in use.

        new ArgsLambda.Builder()
                .update(prop, alternativeValidate);   // update first prop with new prop from second prop

        /* How it work
            first properties with option {.continuable()} will save:
            key = "-exe" --> value = null
            second properties will accept args like right key and param:
            key = "-exe" --> value = "10-mb"
            finally we update first prop with new key-value pair.
            update mean: add all pairs that doesn't contains or value = null
         */

        var values = prop.getProperty("-exe").split("-");
        assertEquals("10", values[0]);
        assertEquals("mb", values[1]);
    }

}