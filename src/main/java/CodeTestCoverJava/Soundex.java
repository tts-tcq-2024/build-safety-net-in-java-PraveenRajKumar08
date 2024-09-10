package CodeTestCoverJava;

public class Soundex {
 private static final Map<Character, Character> SOUNDEX_MAP = new HashMap<>();

	    static {
	        SOUNDEX_MAP.put('B', '1'); SOUNDEX_MAP.put('F', '1'); SOUNDEX_MAP.put('P', '1'); SOUNDEX_MAP.put('V', '1');
	        SOUNDEX_MAP.put('C', '2'); SOUNDEX_MAP.put('G', '2'); SOUNDEX_MAP.put('J', '2'); SOUNDEX_MAP.put('K', '2');
	        SOUNDEX_MAP.put('Q', '2'); SOUNDEX_MAP.put('S', '2'); SOUNDEX_MAP.put('X', '2'); SOUNDEX_MAP.put('Z', '2');
	        SOUNDEX_MAP.put('D', '3'); SOUNDEX_MAP.put('T', '3');
	        SOUNDEX_MAP.put('L', '4');
	        SOUNDEX_MAP.put('M', '5'); SOUNDEX_MAP.put('N', '5');
	        SOUNDEX_MAP.put('R', '6');
	    }

	    public static String generateSoundex(String name) {
	        if (isInvalidName(name)) {
	            return "";
	        }

	        StringBuilder soundex = new StringBuilder();
	        char firstChar = appendFirstChar(name, soundex);
	        char prevCode = getSoundexCode(firstChar);

	        processRemainingChars(name, soundex, prevCode);

	        return padWithZeros(soundex).toString();
	    }

	    private static boolean isInvalidName(String name) {
	        return name == null || name.isEmpty();
	    }

	    private static char appendFirstChar(String name, StringBuilder soundex) {
	        char firstChar = Character.toUpperCase(name.charAt(0));
	        soundex.append(firstChar);
	        return firstChar;
	    }

	    private static void processRemainingChars(String name, StringBuilder soundex, char prevCode) {
	        for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
	            char currentChar = Character.toUpperCase(name.charAt(i));
	            char code = getSoundexCode(currentChar);

	            if (isValidCode(code, prevCode)) {
	                soundex.append(code);
	                prevCode = code;
	            }
	        }
	    }

	    private static boolean isValidCode(char code, char prevCode) {
	        return code != '0' && code != prevCode;
	    }

	    private static StringBuilder padWithZeros(StringBuilder soundex) {
	        while (soundex.length() < 4) {
	            soundex.append('0');
	        }
	        return soundex;
	    }

	    private static char getSoundexCode(char c) {
	        return SOUNDEX_MAP.getOrDefault(c, '0');
	    }
	
    
}
