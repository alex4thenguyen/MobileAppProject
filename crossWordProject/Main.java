
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // List of words for the puzzle0 or level 1
        ArrayList<String> words2Guess0 = new ArrayList<>(Arrays.asList("lame", "meal", "male", "mela", "leam"));
        // Corresponding hints for each word
        ArrayList<String> hints0 = new ArrayList<>(Arrays.asList(
            "Uninspiring and dull.",
            "The food served and eaten at one time.",
            "Referring to one of the two human sexes.",
            "A fair or Hindu festival in Indian subcontinent.",
            "Chiefly Scottish: a gleam of light."));
        // Create a Puzzle object with the words and hints
        Puzzle puzzle0 = new Puzzle(words2Guess0, hints0);

        // List of words for the puzzle1 or level 2
        ArrayList<String> words2Guess1 = new ArrayList<>(Arrays.asList("slate", "stale", "least", "steal", "tales"));
        ArrayList<String> hints1 = new ArrayList<>(Arrays.asList(
            "A type of rock often used for roofing.",
            "Not fresh anymore.",
            "Minimum or smallest amount.",
            "To take something without permission.",
            "Plural of a story or narrative."));
        Puzzle puzzle1 = new Puzzle(words2Guess1, hints1);

        // List of words for the puzzle2 or level 3
        ArrayList<String> words2Guess2 = new ArrayList<>(Arrays.asList("master", "stream", "tamers", "ramets", "maters"));
        ArrayList<String> hints2 = new ArrayList<>(Arrays.asList(
            "A person with outstanding skill in a particular activity or as a leader.",
            "A small, narrow river.",
            "Plural form of someone who domesticates or controls wild animals.",
            "Plural form for any of the individuals in a group of clones in botanical term.",
            "Informal, somewhat archaic term for mothers."));
        Puzzle puzzle2 = new Puzzle(words2Guess2, hints2);

        // List of words for the puzzle3 or level 4
        ArrayList<String> words2Guess3 = new ArrayList<>(Arrays.asList("parties", "pirates", "pastier", "traipse", "piaster"));
        ArrayList<String> hints3 = new ArrayList<>(Arrays.asList(
            "Social gatherings or celebrations with music, food, and entertainment.",
            "Outlaws who rob or commit illegal violence at sea.",
            "Comparative adjective for something that resembles paste in texture.",
            "To walk or move wearily or reluctantly, often aimlessly.",
            "A unit of currency in various countries, especially in the Middle East and North Africa." ));
        Puzzle puzzle3 = new Puzzle(words2Guess3, hints3);
        
        // List of words for the puzzle4 or level 5
        ArrayList<String> words2Guess4 = new ArrayList<>(Arrays.asList(
            "painters", "pantries", "pertains", "pinaster", "pristane"));
        ArrayList<String> hints4 = new ArrayList<>(Arrays.asList(
            "Professionals who apply color to surfaces, such as walls and canvases.",
            "Storage areas in a home for food, dishes, and provisions.",
            "To be relevant or applicable to a particular matter or subject.",
            "A type of pine tree, often found in Mediterranean regions.",
            "A type of saturated terpenoid hydrocarbon, commonly used in scientific research." ));
        Puzzle puzzle4 = new Puzzle(words2Guess4, hints4);

        // Add all the puzzles to an list
        ArrayList<Puzzle> puzzles = new ArrayList<>(Arrays.asList(puzzle0, puzzle1, puzzle2, puzzle3, puzzle4));

        // User chooses the mode
        System.out.println("\nWhat mode you want to play? (Enter 1 for classic, 2 for blitz, or 3 to exit): ");
        int mode = input.nextInt();
        while(mode != 3){
            while(mode != 1 && mode != 2 && mode != 3){
                System.out.println("Invalid mode! Please enter 1 for classic, 2 for blitz, or 3 to exit: ");
                mode = input.nextInt();
            }
            if(mode == 1){
                playClassic(puzzles);
            }
            else if(mode == 2){
                playBlitz(puzzles);
            }
            System.out.println("What mode you want to play? (Enter 1 for classic, 2 for blitz, or 3 to exit): ");
            mode = input.nextInt();
        }

        System.out.println("Thank you for playing!");
        input.close();
    }

    public static void playBlitz(ArrayList<Puzzle> puzzles) { //blitz mode
        Scanner input = new Scanner(System.in);
        int currentScore = 0;
        long startTime = System.currentTimeMillis();
        long timeLimit = 3 * 60 * 1000; // 10 minutes in milliseconds
        int totalScore = 0;
        System.out.println("You have 3 minutes to solve all 5 puzzles and the game begins now.");

        for (Puzzle puzzle : puzzles) {
            System.out.println("\nThis is puzzle " + (puzzles.indexOf(puzzle) + 1) + ".");
            while (!puzzle.isSolved()) {
                if (System.currentTimeMillis() - startTime > timeLimit) {
                    System.out.println("\nTime's up! You couldn't solve all puzzles within the time limit.");
                    System.out.println("Total Score: " + totalScore);
                    return;
                }

                // Display hints and accept guesses

                //Letters to choose from
                System.out.println("\n" + "Letters to choose from: " + puzzle.getUniqueLetters() + "\n");
                // Get the user's guess and convert it to lowercase to match with correct answers
                System.out.print("Enter your guess (Press ? for hints, # for tracking words used, ! for cheating): ");
                String guess = input.next().toLowerCase();

                puzzle.guess(guess); // Use the existing guess method
                // Print the puzzle
                System.out.println(puzzle);
                currentScore = puzzle.getScore();

                // Assuming puzzle.getScore() gets the current score of the puzzle.
                if(puzzle.isSolved())
                    totalScore += puzzle.getScore();
            }
        }
        totalScore += currentScore;

        long totalTimeTaken = System.currentTimeMillis() - startTime;

        if (totalTimeTaken <= timeLimit) {
            // Add bonus points if all puzzles are solved within the time limit
            int timeBonus = calculateTimeBonus(totalTimeTaken, timeLimit);
            totalScore += timeBonus;

            System.out.println("\nCongratulations! You solved all puzzles.");
            System.out.println("Total time taken: " + formatTime(totalTimeTaken));
            System.out.println("Time bonus: " + timeBonus);
        }

        System.out.println("Total Score: " + totalScore);

    }

    public static void playClassic(ArrayList<Puzzle> puzzles){ //classic mode
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a level from  1 to 5: ");
        int level = input.nextInt();
        Puzzle puzzle = null;
        while(level > 5 || level < 1){
            System.out.println("Invalid level! Please enter a level from 1 to 5:");
            level = input.nextInt();
        }
        switch (level) {
            case 1:
                puzzle = puzzles.get(0);
                break;
            case 2:
                puzzle = puzzles.get(1);
                break;
            case 3:
                puzzle = puzzles.get(2);
                break;
            case 4:
                puzzle = puzzles.get(3);
                break;
            default:
                puzzle = puzzles.get(4);
                break;
        }
        
        if(puzzle.isSolved()){
            System.out.println("You already solved this puzzle!");
            System.out.println("Would you like to solve another puzzle? (Enter 1 for yes, 0 for no): ");
            int choice = input.nextInt();
            while(choice != 1 && choice != 0){
                System.out.println("Invalid choice! Please enter 1 for yes, 0 for no: ");
                choice = input.nextInt();
            }
            if(choice == 1)
                return;
            else 
            puzzle.resetPuzzle();
    
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
    }

    // Calculate bonus points based on total time taken in blitz mode
    private static int calculateTimeBonus(long timeTaken, long timeLimit) {
        // Calculate bonus points based on total time taken
        // More points for faster completion
        double timeRatio = (double) timeTaken / timeLimit;
        int maxBonus = 100; // Maximum bonus points
        return (int) (maxBonus * (1 - timeRatio));
    }

    // Format time in milliseconds to minutes and seconds
    private static String formatTime(long timeInMillis) {
        long minutes = (timeInMillis / 1000) / 60;
        long seconds = (timeInMillis / 1000) % 60;
        return String.format("%d minutes and %d seconds", minutes, seconds);
    }

}