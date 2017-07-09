package uk.ac.ebi.jimmy.ebiprogrammingtaskcli.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import uk.ac.ebi.jimmy.ebiprogrammingtaskcli.logic.Processor;
import uk.ac.ebi.jimmy.ebiprogrammingtaskcli.logic.Storage;

public class EBIProgrammingTaskCLITest {

    Processor processorObj = new Processor();

    @Test
    public void testFilter() {

        // Should only allow valid L..LN..N patterns without strange symbols
        String validStr = "ABCDEF123456";
        assertThat(processorObj.filter(validStr), is("ABCDEF123456"));

        // Ignore when formatting errors are present at the input
        String invalidStr = "ABCDEF1255AD666";
        assertThat(processorObj.filter(invalidStr), is(""));

        // Further test for errors present at the input
        invalidStr = "ABCD*EF%ZZ155";
        assertThat(processorObj.filter(invalidStr), is(""));
    }

    @Test
    public void testSeparator() {

        // Should only allow valid L..LN..N patterns without strange symbols
        String validStr = "ABCDEF123456";
        String[] resultArray = {"ABCDEF", "123456"};
        assertArrayEquals(processorObj.lettersDigitSeparator(validStr).toArray(), resultArray);

    }

    @Test
    public void testCorrectRangedOutput() {

        // Should only allow valid L..LN..N patterns without strange symbols
        String[] inputArray = {"ERR000111", "AB!C45F", "ERR000112", "ERR000113", "ERR000115", "ERR000116", "ERR100114"};
        String expectedResultStr = "ERR000111-ERR000113, ERR000115-ERR000116, ERR100114";

        // use mock array as input
        processorObj.setTokenizedInputArray(inputArray);
        
        // process data
        processorObj.startProcess();
        
        assertEquals(processorObj.getStorage().getRangedResult(),expectedResultStr);

    }
}
