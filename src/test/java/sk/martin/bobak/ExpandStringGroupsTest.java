package sk.martin.bobak;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class ExpandStringGroupsTest {

    @Test
    public void shouldExpandDefaultInput() {
        String input = "a{b{c,d},e},f";
        List<String> combinations = ExpandStringGroups.printGroupCombinations(input);
        assertEquals(4,combinations.size());
        assertEquals("abc", combinations.get(0));
        assertEquals("abd", combinations.get(1));
        assertEquals("ae", combinations.get(2));
        assertEquals("f", combinations.get(3));
    }
}
