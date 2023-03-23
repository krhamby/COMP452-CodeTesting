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

    public ComputerGuessesGame(int lowerBound, int upperBound) {
        this.numGuesses = 0;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.lastGuess = (lowerBound + upperBound + 1) / 2;
    }

    public void makeLowerGuess() {
        upperBound = Math.min(upperBound, lastGuess);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
    }

    public void makeHigherGuess() {
        lowerBound = Math.max(lowerBound, lastGuess + 1);

        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses += 1;
    }

    public void reset() {
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;
        lastGuess = (lowerBound + upperBound + 1) / 2;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    public int getLastGuess() {
        return lastGuess;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }
}
