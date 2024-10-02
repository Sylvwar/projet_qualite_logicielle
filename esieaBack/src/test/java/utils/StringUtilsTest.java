package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    // test EstEntier()
    @Test
    public void testEstEntierCaseValide() {
        assertTrue(StringUtils.estEntier("1"));
    }

    @Test
    public void testEstEntierCaseNull() {
        assertFalse(StringUtils.estEntier(null));
    }

    // ce test n'est pas logique, ça devrait passer sans compter la limite de taille
    // des integer imo
    @Test
    public void testEstEntierWrongFormat() {
        assertFalse(StringUtils.estEntier("10000000000"));
    }

    // test nbOccurence
    @Test
    public void testNbOccurenceCaseOccurences() {
        assertEquals(5, StringUtils.nbOccurrence("aaaaa", 'a'));
    }

    @Test
    public void testNbOccurenceCaseNoOccurences() {
        assertEquals(0, StringUtils.nbOccurrence("aaaaa", 'b'));
    }
}