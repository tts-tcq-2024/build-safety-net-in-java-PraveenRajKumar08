package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;




public class SoundexTest { // Test cases for generateSoundex method
	    @Test
	    public void testGenerateSoundex_EmptyString() {
	        assertEquals("", Soundex.generateSoundex(""));
	    }

	    @Test
	    public void testGenerateSoundex_NullString() {
	        assertEquals("", Soundex.generateSoundex(null));
	    }

	    @Test
	    public void testGenerateSoundex_SingleCharacter() {
	        assertEquals("A000", Soundex.generateSoundex("A"));
	    }

	    @Test
	    public void testGenerateSoundex_CommonName() {
	        assertEquals("R163", Soundex.generateSoundex("Robert"));
	    }

	    @Test
	    public void testGenerateSoundex_CaseInsensitivity() {
	        assertEquals("R163", Soundex.generateSoundex("Robert"));
	        assertEquals("R163", Soundex.generateSoundex("robert"));
	    }

	    @Test
	    public void testGenerateSoundex_NonLetterCharacters() {
	        assertEquals("R163", Soundex.generateSoundex("R0b3rt"));
	    }

	    @Test
	    public void testGenerateSoundex_MaxLength() {
	        assertEquals("T522", Soundex.generateSoundex("Tymczak"));
	    }

	    @Test
	    public void testGenerateSoundex_DuplicateAdjacentCodes() {
	        assertEquals("P236", Soundex.generateSoundex("Pfister"));
	    }

	    @Test
	    public void testGenerateSoundex_StartsWithVowel() {
	        assertEquals("E460", Soundex.generateSoundex("Euler"));
	    }

	    @Test
	    public void testGenerateSoundex_AllVowels() {
	        assertEquals("A000", Soundex.generateSoundex("AEIOU"));
	    }

	    @Test
	    public void testGenerateSoundex_LargeInput() {
	        assertEquals("A452", Soundex.generateSoundex("AlphanumericCharacterInputTest"));
	    }

	    // Test cases for buildSoundex method
	    @Test
	    public void testBuildSoundex_CommonName() {
	        assertEquals(new StringBuilder("R163").toString(), Soundex.buildSoundex("Robert").toString());
	    }

	    @Test
	    public void testBuildSoundex_VowelStart() {
	        assertEquals(new StringBuilder("E460").toString(), Soundex.buildSoundex("Euler").toString());
	    }

	    @Test
	    public void testBuildSoundex_SingleChar() {
	        assertEquals(new StringBuilder("A000").toString(), Soundex.buildSoundex("A").toString());
	    }

	    // Test cases for checkLength method
	    @Test
	    public void testCheckLength_Valid() {
	        assertTrue(Soundex.checkLength(1, 6, 1));
	    }

	    @Test
	    public void testCheckLength_Exceeded() {
	        assertFalse(Soundex.checkLength(4, 6, 4));
	    }

	    // Test cases for doAppend method
	    @Test
	    public void testDoAppend_ValidCode() {
	        assertTrue(Soundex.doAppend('3', '1'));
	    }

	    @Test
	    public void testDoAppend_InvalidCode() {
	        assertFalse(Soundex.doAppend('0', '3')); 
	    }

	    @Test
	    public void testDoAppend_DuplicateCode() {
	        assertFalse(Soundex.doAppend('3', '3')); 
	    }

	    // Test cases for getSoundexCode method
	    @Test
	    public void testGetSoundexCode_ValidChar() {
	        assertEquals('1', Soundex.getSoundexCode('B'));
	        assertEquals('2', Soundex.getSoundexCode('C'));
	        assertEquals('5', Soundex.getSoundexCode('N'));
	    }

	    @Test
	    public void testGetSoundexCode_InvalidChar() {
	        assertEquals('0', Soundex.getSoundexCode('A')); 
	    }

	    @Test
	    public void testGetSoundexCode_NonAlphabetChar() {
	        assertEquals('0', Soundex.getSoundexCode('9')); 
	    }

	    

	    // Test cases for isEmptyString method
	    @Test
	    public void testIsEmptyString_Null() {
	        assertTrue(Soundex.isEmptyString(null));
	    }

	    @Test
	    public void testIsEmptyString_Empty() {
	        assertTrue(Soundex.isEmptyString(""));
	    }

	    @Test
	    public void testIsEmptyString_NonEmpty() {
	        assertFalse(Soundex.isEmptyString("A"));
	    }

	    // Test cases for isEmptyList method
	    @Test
	    public void testIsEmptyList_Null() {
	        assertFalse(Soundex.isEmptyList(null)); 
	    }

	   

	  
}
