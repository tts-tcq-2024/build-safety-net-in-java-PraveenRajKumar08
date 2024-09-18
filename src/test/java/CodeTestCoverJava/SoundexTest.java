package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;

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
	    public void testNameWithRepeatingCharacters() {  
	        String name = "David";
	        assertEquals("D130", Soundex.generateSoundex(name));
	    }
	    
	    
	    @Test
	    public void testGenerateSoundexWithValidName() {
	        String result = Soundex.generateSoundex("Robert");
	        assertEquals("R163", result);
	    }

	    @Test
	    public void testGenerateSoundexWithEmptyString() {
	        String result = Soundex.generateSoundex("");
	        assertEquals("", result);
	    }

	    @Test
	    public void testGenerateSoundexWithNull() {
	        String result = Soundex.generateSoundex(null);
	        assertEquals("", result);
	    }
	   

	  
}
