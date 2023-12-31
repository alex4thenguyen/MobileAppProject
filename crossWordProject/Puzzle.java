import java.util.*;

public class Puzzle {
    //Instance variables
    private ArrayList<String> words2Guess; //Words to guess
    private ArrayList<String>  originalWords2Guess; // Stores the original list of words
    private boolean isSolved = false; //If puzzle is solved
    private ArrayList<String> guessedWords = new ArrayList<>(); //Words guessed
    private ArrayList<String> hints = new ArrayList<>(); //Hints for words
    private ArrayList<Character> uniqueLetters = new ArrayList<>(); //Unique letters in from all the words
    private ArrayList<String> correctGuessedWords = new ArrayList<>(); //Words guessed correctly
    private int score = 0; //Self-explanatory
    private int deduction = 0; //Deduction for incorrect guesses and cheating

    //Constructor
    public Puzzle(ArrayList<String> words2Guess, ArrayList<String> hints) {
        this.originalWords2Guess = new ArrayList<>(words2Guess); // Store original list
        this.words2Guess = new ArrayList<>(words2Guess);
        this.hints = hints;
        //Userstory 2
        for (String word : words2Guess) {
            for (char ch : word.toCharArray()) {
                if (!uniqueLetters.contains(ch)) {
                    uniqueLetters.add(ch);
                }
            }
        }
    }
    //Userstory 7
    //See if the puzzle is solved through user's multiple guesses
    public void guess(String word) {
        
        if(word == null) {
            System.out.println("You did not enter a word!");
            return;
        }
        else if(word.length() > 15) {
            System.out.println("You entered a word that is too long!");
            deduction -= 5;
            score = calculateScore() + deduction;
        }
        else if(word.equals("?")) {
            System.out.println("The hints are: " + hints);
            return;
        }
        else if(word.equals("!")) {
            System.out.println("The words to guess are: " + words2Guess);
            deduction -= 1000;
            score = calculateScore() + deduction;
            return;
        }
        else if (word.equals("#")) {
            tracker();
            return;
        }
        else if(word.length() < 2) {
            System.out.println("You entered a word that is too short!");
            deduction -= 5;
            score = calculateScore() + deduction;
        }
        else if(words2Guess.contains(word)) {
            words2Guess.remove(word);
            correctGuessedWords.add(word);
            System.out.println("You guessed a word correctly!");
            score = calculateScore() + deduction;

            if (words2Guess.isEmpty()) {
                isSolved = true;
            }
        } 
        else if(guessedWords.contains(word)) {
            System.out.println("You already guessed that word!");
            return;
        }
        else {
            System.out.println("That word is not in the puzzle!");
            deduction -= 5;
            score = calculateScore() + deduction;
        }

        guessedWords.add(word);
    }

    //Calculate score
    public int calculateScore() {
        int scoring = 0;
        for (String word : correctGuessedWords) {
            scoring += word.length() * 10; // 10 points per letter
        }
       
        return scoring; 
    }

    //Tracker for words guessed
    public void tracker() {
        System.out.println("You have guessed the following words: " + guessedWords);
        System.out.println("You have guessed the following words correctly: " + correctGuessedWords);
        System.out.println("You have " + words2Guess.size() + " words left to guess.");
    }

    public void resetPuzzle() {
        isSolved = false;
        guessedWords.clear();
        correctGuessedWords.clear(); // Clear the list of correctly guessed words
        words2Guess = new ArrayList<>(originalWords2Guess); // Reset to original list
        score = 0; 
        deduction = 0;
    }
    
    //Setters
    public void setWords2Guess(ArrayList<String> words2Guess) {
        this.words2Guess = words2Guess;
    }

    public void setHints(ArrayList<String> hints) {
        this.hints = hints;
    }

    public void setUniqueLetters(ArrayList<Character> uniqueLetters) {
        this.uniqueLetters = uniqueLetters;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public void setGuessedWords(ArrayList<String> guessedWords) {
        this.guessedWords = guessedWords;
    }

    public void setCorrectGuessedWords(ArrayList<String> correctGuessedWords) {
        this.correctGuessedWords = correctGuessedWords;
    }

    //Getters
    public ArrayList<String> getGuessedWords() {
        return guessedWords;
    }

    public int getScore() {
        return score;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public ArrayList<String> getCorrectGuessedWords() {
        return correctGuessedWords;
    }


    public ArrayList<String> getWords2Guess() {
        return words2Guess;
    }

    public ArrayList<String> getHints() {
        return hints;
    }

    public ArrayList<Character> getUniqueLetters() {
        return uniqueLetters;
    }

    //Shows score and if puzzle is solved
    public String toString() {
        String result = isSolved ? "You solved the puzzle!\n" : "You have not solved the puzzle yet.\n";
        result += "Your score is " + score + "\n";
        return result;
    }


}