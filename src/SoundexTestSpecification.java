package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Test Specification for Soundex Class
 *
 * This document outlines the test cases for the Soundex class, which is designed
 * to generate Soundex codes based on names and perform related string manipulation
 * and validation operations.
 */

public class SoundexTestSpecification {

    /**
     * Test Case: testEmptyString
     * 
     * Description: Verifies that the Soundex generation handles empty strings correctly.
     * 
     * Input: Empty string ""
     * Expected Output: An empty string "" as the Soundex code
     */
    public void testEmptyString() {
        String emptyString = "";
        assertEquals("", Soundex.generateSoundex(emptyString));
    }

    /**
     * Test Case: testNullString
     * 
     * Description: Verifies that the Soundex generation handles null strings correctly.
     * 
     * Input: Null string
     * Expected Output: An empty string "" as the Soundex code
     */
    public void testNullString() {
        String nullString = null;
        assertEquals("", Soundex.generateSoundex(nullString));
    }

    /**
     * Test Case: testSingleLetterName
     * 
     * Description: Verifies that the Soundex generation correctly handles single-letter names.
     * 
     * Input: String with one character "A"
     * Expected Output: "A000" as the Soundex code
     */
    public void testSingleLetterName() {
        String name = "A";
        assertEquals("A000", Soundex.generateSoundex(name));
    }

    /**
     * Test Case: testNameWithRepeatingCharacters
     * 
     * Description: Tests the Soundex generation for a name with repeating characters.
     * 
     * Input: Name string "David"
     * Expected Output: "D130" as the Soundex code
     */
    public void testNameWithRepeatingCharacters() {
        String name = "David";
        assertEquals("D130", Soundex.generateSoundex(name));
    }

    /**
     * Test Case: testCheckLengthTrue
     * 
     * Description: Verifies that the checkLength function returns true for valid indices and Soundex length.
     * 
     * Input: Index 2, Soundex length 5, and required length 2
     * Expected Output: true
     */
    public void testCheckLengthTrue() {
        assertTrue(Soundex.checkLength(2, 5, 2));
    }

    /**
     * Test Case: testCheckLengthFalseWhenIndexExceeds
     * 
     * Description: Verifies that the checkLength function returns false when the index exceeds the length.
     * 
     * Input: Index 5, Soundex length 4, required length 2
     * Expected Output: false
     */
    public void testCheckLengthFalseWhenIndexExceeds() {
        assertFalse(Soundex.checkLength(5, 4, 2));
    }

    /**
     * Test Case: testCheckLengthFalseWhenSoundexLengthExceeds
     * 
     * Description: Verifies that the checkLength function returns false when the Soundex length exceeds the required length.
     * 
     * Input: Index 2, Soundex length 5, required length 4
     * Expected Output: false
     */
    public void testCheckLengthFalseWhenSoundexLengthExceeds() {
        assertFalse(Soundex.checkLength(2, 5, 4));
    }

    /**
     * Test Case: testDoAppendTrue
     * 
     * Description: Verifies that doAppend returns true for distinct non-zero Soundex codes.
     * 
     * Input: Characters '2' and '1'
     * Expected Output: true
     */
    public void testDoAppendTrue() {
        assertTrue(Soundex.doAppend('2', '1'));
    }

    /**
     * Test Case: testDoAppendFalseWhenCodeIsZero
     * 
     * Description: Verifies that doAppend returns false when the first code is '0'.
     * 
     * Input: Characters '0' and '1'
     * Expected Output: false
     */
    public void testDoAppendFalseWhenCodeIsZero() {
        assertFalse(Soundex.doAppend('0', '1'));
    }

    /**
     * Test Case: testDoAppendFalseWhenCodesAreSame
     * 
     * Description: Verifies that doAppend returns false when the two codes are the same.
     * 
     * Input: Characters '1' and '1'
     * Expected Output: false
     */
    public void testDoAppendFalseWhenCodesAreSame() {
        assertFalse(Soundex.doAppend('1', '1'));
    }

    /**
     * Test Case: testGetSoundexCodeWithMappedCharacter
     * 
     * Description: Verifies that getSoundexCode returns the correct mapped code for a character.
     * 
     * Input: Character 'B'
     * Expected Output: '1' (as B is mapped to '1' in the Soundex algorithm)
     */
    public void testGetSoundexCodeWithMappedCharacter() {
        assertEquals('1', Soundex.getSoundexCode('B'));
    }

    /**
     * Test Case: testGetSoundexCodeWithUnmappedCharacter
     * 
     * Description: Verifies that getSoundexCode returns '0' for unmapped characters.
     * 
     * Input: Character 'A'
     * Expected Output: '0' (as A is not mapped in the Soundex algorithm)
     */
    public void testGetSoundexCodeWithUnmappedCharacter() {
        assertEquals('0', Soundex.getSoundexCode('A'));
    }

    /**
     * Test Case: testBuildSoundexMap
     * 
     * Description: Verifies that the Soundex map is built correctly using the buildSoundexMap method.
     * 
     * Input: None (method call)
     * Expected Output: A map with correctly mapped Soundex values for all characters
     */
    public void testBuildSoundexMap() {
        Map<Character, Character> expectedMap = new HashMap<>();
        expectedMap.putAll(Soundex.populateSoundexMap(Arrays.asList('B', 'F', 'P', 'V'), '1'));
        expectedMap.putAll(Soundex.populateSoundexMap(Arrays.asList('C', 'G', 'J', 'K', 'Q', 'S', 'X', 'Z'), '2'));
        expectedMap.putAll(Soundex.populateSoundexMap(Arrays.asList('D', 'T'), '3'));
        expectedMap.putAll(Soundex.populateSoundexMap(Arrays.asList('L'), '4'));
        expectedMap.putAll(Soundex.populateSoundexMap(Arrays.asList('M', 'N'), '5'));
        expectedMap.putAll(Soundex.populateSoundexMap(Arrays.asList('R'), '6'));
        
        Map<Character, Character> result = Soundex.buildSoundexMap();
        assertEquals(expectedMap, result);
    }

    /**
     * Test Case: testPopulateSoundexMapWithValidList
     * 
     * Description: Verifies that the populateSoundexMap method correctly maps characters to Soundex codes.
     * 
     * Input: List of characters ['B', 'F', 'P', 'V'] and code '1'
     * Expected Output: A map with 'B', 'F', 'P', 'V' mapped to '1'
     */
    public void testPopulateSoundexMapWithValidList() {
        Map<Character, Character> result = Soundex.populateSoundexMap(Arrays.asList('B', 'F', 'P', 'V'), '1');
        Map<Character, Character> expectedMap = new HashMap<>();
        expectedMap.put('B', '1');
        expectedMap.put('F', '1');
        expectedMap.put('P', '1');
        expectedMap.put('V', '1');
        assertEquals(expectedMap, result);
    }

    /**
     * Test Case: testIsEmptyString
     * 
     * Description: Verifies that the isEmptyString method correctly identifies empty and non-empty strings.
     * 
     * Input: Empty string "", null, and non-empty string "NonEmpty"
     * Expected Output: true for "", true for null, and false for "NonEmpty"
     */
    public void testIsEmptyString() {
        assertTrue(Soundex.isEmptyString(""));
        assertTrue(Soundex.isEmptyString(null));
        assertFalse(Soundex.isEmptyString("NonEmpty"));
    }
}
