package CodeTestCoverJava;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

public class TcqCleanCodingTest {

    // Test cases for generateSoundex method
    @Test
    public void testGenerateSoundex_EmptyString() {
        assertEquals("", TcqCleanCoding.generateSoundex(""));
    }

    @Test
    public void testGenerateSoundex_NullString() {
        assertEquals("", TcqCleanCoding.generateSoundex(null));
    }

    @Test
    public void testGenerateSoundex_SingleCharacter() {
        assertEquals("A000", TcqCleanCoding.generateSoundex("A"));
    }

    @Test
    public void testGenerateSoundex_CommonName() {
        assertEquals("R163", TcqCleanCoding.generateSoundex("Robert"));
    }

    @Test
    public void testGenerateSoundex_CaseInsensitivity() {
        assertEquals("R163", TcqCleanCoding.generateSoundex("Robert"));
        assertEquals("R163", TcqCleanCoding.generateSoundex("robert"));
    }

    @Test
    public void testGenerateSoundex_NonLetterCharacters() {
        assertEquals("R163", TcqCleanCoding.generateSoundex("R0b3rt"));
    }

    @Test
    public void testGenerateSoundex_MaxLength() {
        assertEquals("T522", TcqCleanCoding.generateSoundex("Tymczak"));
    }

    @Test
    public void testGenerateSoundex_DuplicateAdjacentCodes() {
        assertEquals("P236", TcqCleanCoding.generateSoundex("Pfister"));
    }

    @Test
    public void testGenerateSoundex_StartsWithVowel() {
        assertEquals("E460", TcqCleanCoding.generateSoundex("Euler"));
    }

    @Test
    public void testGenerateSoundex_AllVowels() {
        assertEquals("A000", TcqCleanCoding.generateSoundex("AEIOU"));
    }

    @Test
    public void testGenerateSoundex_LargeInput() {
        assertEquals("A452", TcqCleanCoding.generateSoundex("AlphanumericCharacterInputTest"));
    }

    // Test cases for buildSoundex method
    @Test
    public void testBuildSoundex_CommonName() {
        assertEquals(new StringBuilder("R163").toString(), TcqCleanCoding.buildSoundex("Robert").toString());
    }

    @Test
    public void testBuildSoundex_VowelStart() {
        assertEquals(new StringBuilder("E460").toString(), TcqCleanCoding.buildSoundex("Euler").toString());
    }

    @Test
    public void testBuildSoundex_SingleChar() {
        assertEquals(new StringBuilder("A000").toString(), TcqCleanCoding.buildSoundex("A").toString());
    }

    // Test cases for checkLength method
    @Test
    public void testCheckLength_Valid() {
        assertTrue(TcqCleanCoding.checkLength(1, 6, 1));
    }

    @Test
    public void testCheckLength_Exceeded() {
        assertFalse(TcqCleanCoding.checkLength(4, 6, 4));
    }

    // Test cases for doAppend method
    @Test
    public void testDoAppend_ValidCode() {
        assertTrue(TcqCleanCoding.doAppend('3', '1'));
    }

    @Test
    public void testDoAppend_InvalidCode() {
        assertFalse(TcqCleanCoding.doAppend('0', '3')); 
    }

    @Test
    public void testDoAppend_DuplicateCode() {
        assertFalse(TcqCleanCoding.doAppend('3', '3')); 
    }

    // Test cases for getSoundexCode method
    @Test
    public void testGetSoundexCode_ValidChar() {
        assertEquals('1', TcqCleanCoding.getSoundexCode('B'));
        assertEquals('2', TcqCleanCoding.getSoundexCode('C'));
        assertEquals('5', TcqCleanCoding.getSoundexCode('N'));
    }

    @Test
    public void testGetSoundexCode_InvalidChar() {
        assertEquals('0', TcqCleanCoding.getSoundexCode('A')); 
    }

    @Test
    public void testGetSoundexCode_NonAlphabetChar() {
        assertEquals('0', TcqCleanCoding.getSoundexCode('9')); 
    }

    // Test cases for buildSoundexMap method
    @Test
    public void testBuildSoundexMap_Valid() {
        Map<Character, Character> soundexMap = TcqCleanCoding.buildSoundexMap();
        assertEquals('1', soundexMap.get('B'));
        assertEquals('2', soundexMap.get('C'));
        assertEquals('3', soundexMap.get('D'));
    }

    // Test cases for populateSoundexMap method
    @Test
    public void testPopulateSoundexMap_Valid() {
        Map<Character, Character> populatedMap = TcqCleanCoding.populateSoundexMap(Arrays.asList('A', 'E', 'I', 'O', 'U'), '0');
        assertEquals('0', populatedMap.get('A'));
        assertEquals('0', populatedMap.get('E'));
        assertEquals('0', populatedMap.get('I'));
    }

    @Test
    public void testPopulateSoundexMap_EmptyList() {
        Map<Character, Character> populatedMap = TcqCleanCoding.populateSoundexMap(Arrays.asList(), '0');
        assertTrue(populatedMap.isEmpty()); 
    }

    // Test cases for isEmptyString method
    @Test
    public void testIsEmptyString_Null() {
        assertTrue(TcqCleanCoding.isEmptyString(null));
    }

    @Test
    public void testIsEmptyString_Empty() {
        assertTrue(TcqCleanCoding.isEmptyString(""));
    }

    @Test
    public void testIsEmptyString_NonEmpty() {
        assertFalse(TcqCleanCoding.isEmptyString("A"));
    }

    // Test cases for isEmptyList method
    @Test
    public void testIsEmptyList_Null() {
        assertFalse(TcqCleanCoding.isEmptyList(null)); 
    }

    @Test
    public void testIsEmptyList_Empty() {
        assertFalse(TcqCleanCoding.isEmptyList(Arrays.asList())); 
    }

    @Test
    public void testIsEmptyList_NonEmpty() {
        assertTrue(TcqCleanCoding.isEmptyList(Arrays.asList('A', 'B')));
    }
}
