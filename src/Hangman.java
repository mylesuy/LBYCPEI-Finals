import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

import java.io.*;

interface HangmanI {
    void intro();
    int playOneGame(String secretWord);
    String createHint(String secretWord, String guess);
    String getRandomWord(String filename);
    void gameStats(int gamesCount, int gamesWon, int best);
}

public class Hangman extends ConsoleProgram implements HangmanI {
    public void run() {
        int gameCount = 0, winCount = 0, bestGame = 0, gameState;

        intro();
        boolean keepPlay = true;
        while (keepPlay) {
            gameState = playOneGame(getRandomWord("assets/Hangman/dict.txt")); //gets a random word from the text file;

            if (gameState > 0) {
                winCount++; //add each victory
                if (gameState > bestGame) {
                    bestGame = gameState; //if current game is the best game, it will get that value for remaining guesses for the best game
                }
            }
            gameCount++; //game count

            int pa;
            do {
                pa = askPlayAgain();
                switch (pa) {
                    case 1 -> {
                        keepPlay = true;
                        clearScreen();
                        canvas.reset();
                    }
                    case 2 -> keepPlay = false;
                }
            } while (pa != 1 && pa != 2);
        }
        gameStats(gameCount, winCount, bestGame);
    }

    @Override
    public void intro() {
        println(centerTexts("@@@@@@@@@@@@@@@@@@@@@@@@@@@@",17));
        println(centerTexts("Welcome to Hangman!", 17));
        println(centerTexts("You'll try to guess its letters.", 17));
        println(centerTexts("Every time you guess a letter", 17));
        println(centerTexts("that isn't in my word, a new body", 17));
        println(centerTexts("part of the hanging man appears.", 17));
        println(centerTexts("Goodluck!", 17));
        println(centerTexts("@@@@@@@@@@@@@@@@@@@@@@@@@@@@",17));
    }

    @Override
    public int playOneGame(String secretWord) {
        int len;
        len = secretWord.length();
        int remaining = len;
        int i;
        int guessLeft = 8;
        String guesses = "", letter;  //stores the guessed words in a string
        char guess = ' ', wrd[] = new char[len];
        boolean guessedAlready = false, foundInGuessed = false;
        canvas.reset(); //resets current displayed hangman
        canvas.displayHangman(guessLeft);
        while (guessLeft != 0) {
            print("Secret word : " + createHint(secretWord, guesses)); //displays number of dashes
            print("\nYour guesses : " + guesses); //guessed letters
            println("\nGuesses Left: : " + guessLeft); //number of guesses left
            letter = readLine("Your guess? "); //acm console program
            while (letter.length() != 1)
            {
                println();
                println("Your guess? What do you mean?\n");
                println("Type a single letter from A-Z\n");
                letter = readLine("Your guess? "); //acm console program
            }
            guess = letter.toUpperCase().charAt(0); //gets the guess and capitalizes it and stores it in the array guess
            if (guesses.length() != 0) { //while there are still letters to be guessed
                for (i = 0; i < guesses.length(); i++) {
                    if (guess == guesses.charAt(i)) {
                        //if guessed letter is already guessed before
                        println("Letter already entered!!");
                        foundInGuessed = true;
                        for (i = 0; i < len; i++) {
                            if (guess == secretWord.charAt(i)) {
                                guessedAlready = true;
                            }
                        }
                        break;
                    }
                }
                //checks if the guessed letter is in the stored array so it wont have double letters in the guessed array
                if ((foundInGuessed) && (!guessedAlready)) {
                    guessLeft++;
                }
                else if ((!foundInGuessed) && (guessedAlready)) {
                    guesses = guesses + guess;
                    println("Letter guessed : " + guess);
                }
                else if ((!foundInGuessed) && (!guessedAlready)) {
                    guesses = guesses + guess;
                    println("Letter guessed : " + guess);

                }
            }
            else if (guesses.length() == 0) {
                guesses = guesses + guess;
                println("Letter guessed : " + guess); //prints none
            }
            foundInGuessed = false; guessedAlready = false;
            println();

            for (i = 0; i < len; i++) {
                if (guess == secretWord.charAt(i)) {
                    guessedAlready = true; //correct guess and adds that character as true in the already guessed array
                    if (wrd[i] != guess) {
                        wrd[i] = guess;
                        remaining--;
                    }
                }
            }
            if (!guessedAlready) { //wrong guess
                guessLeft--;
            }
            if (remaining == 0) {
                break;
            }
            canvas.reset();
            canvas.displayHangman(guessLeft);
        }

        if (guessLeft == 0) {
            //user lost
            println("Sorry! You lost and the person died. The secret word was " + secretWord + "");
        }
        else {
            //user win
            println("Congratulations! You saved the person! \nThe secret word is, " + secretWord);
        }
        return guessLeft;
    }

    @Override
    public String createHint(String secretWord, String guess) {
        String hide = "-", hint = "";
        boolean guessed;
        for(int i = 0; i < secretWord.length(); i++) {
            guessed = false;
            for(int j = 0; j < guess.length(); j++) {
                if (guess.charAt(j) == secretWord.charAt(i)) {
                    hint += guess.charAt(j);
                    guessed = true;
                    break;
                }
            }
            if(!guessed)
                hint += hide;
        }
        return hint;
    }

    @Override
    public String getRandomWord(String filename) {
        String secretWord = "";
        RandomGenerator random = RandomGenerator.getInstance();
        int wordCount = random.nextInt(1, 10); //for dict.txt
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(filename));
            for(int i = 0; i <= wordCount; i++)
            {
                secretWord = buffer.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return secretWord;
    }

    @Override
    public void gameStats(int gamesCount, int gamesWon, int best) {
        int percent = gamesWon * 100 / gamesCount * 100, i, width2 = 28;
        percent = percent / 100;
        clearScreen();
        println(centerTexts("@@@@@@@@@@@@@@@@@@@@@@@@@@@@",16));
        println(centerTexts("Overall Statistics:", 16));
        println(centerTexts("Games played: " + gamesCount + "", 16));
        println(centerTexts("Games won: " + gamesWon + "", 16));
        println(centerTexts("Win percent: " + percent + "%", 16));
        println(centerTexts("Best game: " + best + " guesses remaining", 16));
        println(centerTexts("Thanks for playing!", 16));
        println(centerTexts("@@@@@@@@@@@@@@@@@@@@@@@@@@@@",16));
        println();
    }

    private int askPlayAgain() {
        println("[1] - Play again");
        println("[2] - Quit");
        return readInt();
    }

    public void clearScreen() {
        for (int i=0;i<1000;i++) {
            println();
        }
    }

    private String centerTexts(String text, int width) {
        int spaces = (width - text.length() / 2);
        String space = "";
        for (int i = 0; i < spaces; i++) {
            space = " " + space;
        }
        return space + text;
    }

    public void init() {
            canvas = new HangmanCanvas();
            setFont("CourierNew");
            add(canvas);
            canvas.reset();
        }

    private HangmanCanvas canvas;

    public static void main(String[] args) {
        new Hangman().start(args);
    }
}
