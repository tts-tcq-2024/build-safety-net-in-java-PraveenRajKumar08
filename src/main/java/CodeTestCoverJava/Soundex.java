package CodeTestCoverJava;

public class Soundex {
private static final Map<Character, Character> soundexMap = new HashMap<>();
	 
	 static {
	        initializeSoundexMap();
	    }
	 public static String generateSoundex(String name) {
	        if (name == null || name.isEmpty()) {
	            return "";
	        }

	        StringBuilder soundex = new StringBuilder();
	        soundex.append(Character.toUpperCase(name.charAt(0)));
	        char prevCode = mapCharToSoundexCode(name.charAt(0));

	        generateSoundexForRemainingChars(name, soundex, prevCode);

	        return padWithZeros(soundex);
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

	    private static String padWithZeros(StringBuilder soundex) {
	        while (soundex.length() < 4) {
	            soundex.append('0');
	        }
	        return soundex.toString();
	    }

	    private static char mapCharToSoundexCode(char c) {
	        return soundexMap.getOrDefault(Character.toUpperCase(c), '0');
	    }

	    private static boolean isValidCode(char code, char prevCode) {
	        return code != '0' && code != prevCode; 
	    }

	    private static void initializeSoundexMap() {
	        String[] groups = {"BFPV", "CGJKQSXZ", "DT", "L", "MN", "R"};
	        char[] codes = {'1', '2', '3', '4', '5', '6'};

	        for (int i = 0; i < groups.length; i++) {
	            for (char c : groups[i].toCharArray()) {
	                soundexMap.put(c, codes[i]);
	            }
	        }
	    }
	
    
}
