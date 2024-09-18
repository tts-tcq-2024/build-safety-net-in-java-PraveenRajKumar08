package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;




public class SoundexTest { // Test cases for generateSoundex method
	    @Test
	    public void testEmptyString() {
	        String emptyString = "";
	        assertEquals("", Soundex.generateSoundex(emptyString));
	    }

	    @Test
	    public void testNullString() {
	        String nullString = null;
	        assertEquals("", Soundex.generateSoundex(nullString));
	    }


	    @Test
	    public void testSingleLetterName() {
	        String name = "A";
	        assertEquals("A000", Soundex.generateSoundex(name));
	    }

	    @Test
	    public void testNameWithRepeatingCharacters() {  
	        String name = "David";
	        assertEquals("D130", Soundex.generateSoundex(name));
	    }

	    @Test
	    public void testCheckLengthTrue() {
	        assertTrue(Soundex.checkLength(2, 5, 2));
	    }

	    @Test
	    public void testCheckLengthFalseWhenIndexExceeds() {
	        assertFalse(Soundex.checkLength(5, 4, 2));
	    }

	    @Test
	    public void testCheckLengthFalseWhenSoundexLengthExceeds() {
	        assertFalse(Soundex.checkLength(2, 5, 4));
	    }

	 @Test
	    public void testDoAppendTrue() {
	        assertTrue(Soundex.doAppend('2', '1'));
	    }

	    @Test
	    public void testDoAppendFalseWhenCodeIsZero() {
	        assertFalse(Soundex.doAppend('0', '1'));
	    }

	    @Test
	    public void testDoAppendFalseWhenCodesAreSame() {
	        assertFalse(Soundex.doAppend('1', '1'));
	    }

	    @Test
	    public void testGetSoundexCodeWithMappedCharacter() {
	        assertEquals('1', Soundex.getSoundexCode('B'));
	    }

	    @Test
	    public void testGetSoundexCodeWithUnmappedCharacter() {
	        assertEquals('0', Soundex.getSoundexCode('A'));
	    }

	   

	  
}
