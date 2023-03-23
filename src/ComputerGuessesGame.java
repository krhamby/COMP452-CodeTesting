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

    public int makeHigherGuess() {
        upperBound = Math.min(upperBound, lastGuess);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
        return lastGuess;
    }

    public int makeLowerGuess() {
        lowerBound = Math.max(lowerBound, lastGuess + 1);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
        return lastGuess;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public int getLastGuess() {
        return lastGuess;
    }
}
