import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // List of words for the puzzle0
        ArrayList<String> words2Guess0 = new ArrayList<>(Arrays.asList("slate", "stale", "least", "steal", "tales"));
        // Corresponding hints for each word
        ArrayList<String> hints0 = new ArrayList<>(Arrays.asList(
            "A type of rock often used for roofing",
            "Not fresh anymore",
            "Minimum or smallest amount",
            "To take something without permission",
            "Plural of a story or narrative"));
        // Create a Puzzle object with the words and hints
        Puzzle puzzle0 = new Puzzle(words2Guess0, hints0);

        // List of words for the puzzle1
        ArrayList<String> words2Guess1 = new ArrayList<>(Arrays.asList("master", "stream", "tamers", "ramets", "maters"));
        // Corresponding hints for each word
        ArrayList<String> hints1 = new ArrayList<>(Arrays.asList(
            "A person with outstanding skill in a particular activity or as a leader.",
            "A small, narrow river.",
            "Plural form of someone who domesticates or controls wild animals.",
            "Botanical term for individual plants that are part of a larger cloned organism.",
            "Informal, somewhat archaic term for mothers."));
        // Create a Puzzle object with the words and hints
        Puzzle puzzle1 = new Puzzle(words2Guess1, hints1);
        
        System.out.println("Welcome to the Word Puzzle Game!");
        System.out.println("You will be given a list of letters to guess words and their corresponding hints.");
        System.out.println("You will be given a score based on the number of words you guess correctly.");
        System.out.println("You will also be deducted points for incorrect guesses and cheating.");

        System.out.println("Please enter a level from  1 to 2: ");
        int level = input.nextInt();
        Puzzle puzzle = null;
        switch (level) {
            case 1:
                puzzle = puzzle0;
                break;
            case 2:
                puzzle = puzzle1;
                break;
            default:
                System.out.println("Invalid level!");
                System.exit(0);
        }


        while(!puzzle.isSolved()) {
            //Letters to choose from
            System.out.println("\n" + "Letters to choose from: " + puzzle.getUniqueLetters() + "\n");

            // Get the user's guess and convert it to lowercase to match with correct answers
            System.out.print("Enter your guess (Press ? for hints, # for tracking words used, ! for cheating): ");
            String word = input.next().toLowerCase();

      
            // Check if the guess is correct
            puzzle.guess(word);
            
            // Print the puzzle
            System.out.println(puzzle);
        }

        // Print the final status of the puzzle
        System.out.println(puzzle);

        input.close();
    }

}