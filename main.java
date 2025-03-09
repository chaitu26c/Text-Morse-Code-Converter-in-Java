import java.util.HashMap;
import java.util.Scanner;

/**
 * MorseCodeConverter
 * ---------------------
 * This Java program allows the user to:
 * 1. Convert Text to Morse Code.
 * 2. Convert Morse Code back to Text.
 * 
 * Features:
 * - Uses a static HashMap to store Morse Code mappings.
 * - Handles spaces as "/" in Morse Code.
 * - Handles both uppercase and lowercase text.
 * - Provides a clean console interface for user input.
 */
public class MorseCodeConverter {

    // ✅ Static HashMap to store Morse Code mappings.
    // This map is shared across all functions without needing object instantiation.
    static HashMap<Character, String> morseMap = new HashMap<>();

    // ✅ Static Block to initialize Morse Code mappings.
    // This block executes only once when the class is loaded.
    static {
        morseMap.put('A', ".-");    morseMap.put('B', "-...");   morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");   morseMap.put('E', ".");      morseMap.put('F', "..-.");
        morseMap.put('G', "--.");   morseMap.put('H', "....");   morseMap.put('I', "..");
        morseMap.put('J', ".---");  morseMap.put('K', "-.-");    morseMap.put('L', ".-..");
        morseMap.put('M', "--");    morseMap.put('N', "-.");     morseMap.put('O', "---");
        morseMap.put('P', ".--.");  morseMap.put('Q', "--.-");   morseMap.put('R', ".-.");
        morseMap.put('S', "...");   morseMap.put('T', "-");      morseMap.put('U', "..-");
        morseMap.put('V', "...-");  morseMap.put('W', ".--");    morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");  morseMap.put('Z', "--..");
        morseMap.put(' ', "/");     // Space is represented by "/"
    }

    /**
     * ✅ Function to Convert Text → Morse Code
     * ---------------------------------------------------
     * - Takes a text input from the user.
     * - Converts each character to Morse Code.
     * - Handles spaces and non-matching characters.
     * - Returns the final Morse Code string.
     */
    public static String textToMorse(String text) {
        StringBuilder morseCode = new StringBuilder();

        // Convert text to uppercase and loop through each character
        for (char c : text.toUpperCase().toCharArray()) {
            // Check if the character exists in the HashMap
            if (morseMap.containsKey(c)) {
                morseCode.append(morseMap.get(c)).append(" ");
            } else {
                // Handle unknown characters (Optional)
                System.out.println("Warning: Unsupported character -> " + c);
            }
        }
        return morseCode.toString().trim();
    }

    /**
     * ✅ Function to Convert Morse Code → Text
     * ---------------------------------------------------
     * - Takes Morse Code input (separated by space).
     * - Splits the Morse Code by spaces.
     * - Matches Morse Code to corresponding characters.
     * - Handles '/' as a space.
     * - Returns the decoded text.
     */
    public static String morseToText(String morse) {
        StringBuilder text = new StringBuilder();

        // Split the Morse Code by space
        String[] morseChars = morse.split(" ");

        // Iterate through each Morse Code
        for (String m : morseChars) {
            // Handle space represented by '/'
            if (m.equals("/")) {
                text.append(" ");
                continue;
            }

            // Iterate through the HashMap to find the matching character
            for (var entry : morseMap.entrySet()) {
                if (entry.getValue().equals(m)) {
                    text.append(entry.getKey());
                    break;
                }
            }
        }
        return text.toString();
    }

    /**
     * ✅ Main Function
     * ---------------------------------------------------
     * - Provides a console interface to choose conversion type.
     * - Handles user input and output.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display menu options
        System.out.println("==================================");
        System.out.println("💻 Morse Code Converter in Java");
        System.out.println("==================================");
        System.out.println("1. Convert Text to Morse Code");
        System.out.println("2. Convert Morse Code to Text");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer

        // Handle user choice
        if (choice == 1) {
            // Convert Text to Morse Code
            System.out.print("Enter text: ");
            String text = scanner.nextLine();
            System.out.println("Morse Code: " + textToMorse(text));
        } 
        else if (choice == 2) {
            // Convert Morse Code to Text
            System.out.print("Enter Morse Code (use space between letters, '/' for space): ");
            String morse = scanner.nextLine();
            System.out.println("Text: " + morseToText(morse));
        } 
        else {
            System.out.println("❌ Invalid choice. Please restart the program.");
        }

        // Close the scanner
        scanner.close();
    }
}
