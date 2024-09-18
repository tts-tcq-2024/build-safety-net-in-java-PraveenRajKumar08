package CodeTestCoverJava;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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

	 @Test
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

	    @Test
	    public void testPopulateSoundexMapWithValidList() {
	        Map<Character, Character> result = Soundex.populateSoundexMap(Arrays.asList('B', 'F', 'P', 'V'), '1');
	        Map<Character, Character> expectedMap = new HashMap<>();
	        expectedMap.put('B', '1');
	        expectedMap.put('F', '1');
	        expectedMap.put('P', '1');
	        expectedMap.put('V', '1');
	        assertEquals(expectedMap, result);
	    }

	   @Test
	    public void testPopulateSoundexMapWithEmptyList() {
	        Map<Character, Character> result = Soundex.populateSoundexMap(Arrays.asList(), '1');
	        assertTrue(result.isEmpty());
	    }

	    @Test
	    public void testIsEmptyString() {
	        assertTrue(Soundex.isEmptyString(""));
	        assertTrue(Soundex.isEmptyString(null));
	        assertFalse(Soundex.isEmptyString("NonEmpty"));
	    }

	    @Test
	    public void testIsEmptyList() {
	        assertTrue(Soundex.isEmptyList(Arrays.asList('A')));
	        assertFalse(Soundex.isEmptyList(Arrays.asList()));
	        assertFalse(Soundex.isEmptyList(null));
	    }

	   

	  
}
