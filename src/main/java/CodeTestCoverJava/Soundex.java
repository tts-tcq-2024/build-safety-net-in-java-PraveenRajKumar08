package CodeTestCoverJava;

public class Soundex {

	public static String generateSoundex(String name) {
	    if (name == null || name.isEmpty()) {
	        return "";
	    }

	    StringBuilder soundex = new StringBuilder();
	    soundex.append(Character.toUpperCase(name.charAt(0)));
	    char prevCode = mapCharToSoundexCode(name.charAt(0));

	    generateSoundexForRemainingChars(name, soundex, prevCode);

	    while (soundex.length() < 4) {
	        soundex.append('0');
	    }

	    return soundex.toString();
	}

	private static void generateSoundexForRemainingChars(String name, StringBuilder soundex, char prevCode) {
	    for (int i = 1; i < name.length() && soundex.length() < 4; i++) {
	        char code = mapCharToSoundexCode(name.charAt(i));
	        if (isValidCode(code, prevCode)) {
	            soundex.append(code);
	            prevCode = code;
	        }
	    }
	}

	private static boolean isValidCode(char code, char prevCode) {
	    return code != '0' && code != prevCode;
	}

	private static char mapCharToSoundexCode(char c) {
	    c = Character.toUpperCase(c);
	    if ("BFPV".indexOf(c) >= 0) return '1';
	    if ("CGJKQSXZ".indexOf(c) >= 0) return '2';
	    if ("DT".indexOf(c) >= 0) return '3';
	    if (c == 'L') return '4';
	    if ("MN".indexOf(c) >= 0) return '5';
	    if (c == 'R') return '6';
	    return '0'; // For A, E, I, O, U, H, W, Y
	}
    
}
