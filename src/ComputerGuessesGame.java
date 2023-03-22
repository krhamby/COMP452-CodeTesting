// added by Kevin
public class ComputerGuessesGame {
    private int upperBound;
    private int lowerBound;

    private int numGuesses;
    private int lastGuess;

    public ComputerGuessesGame() {
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;
        lastGuess = (lowerBound + upperBound + 1) / 2;
    }

    int makeHigherGuess() {
        upperBound = Math.min(upperBound, lastGuess);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
        return lastGuess;
    }

    int makeLowerGuess() {
        lowerBound = Math.max(lowerBound, lastGuess + 1);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
        return lastGuess;
    }

    int getNumGuesses() {
        return numGuesses;
    }

    int getLastGuess() {
        return lastGuess;
    }
}
