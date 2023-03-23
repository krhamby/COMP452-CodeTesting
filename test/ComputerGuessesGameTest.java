import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerGuessesGameTest {
    @Test
    void defaultConstructorTest() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(0, game.getNumGuesses());
        assertEquals(1000, game.getUpperBound());
        assertEquals(1, game.getLowerBound());
        assertEquals(501, game.getLastGuess());
    }

    @Test
    void controllableConstructorTest() {
        ComputerGuessesGame game = new ComputerGuessesGame(500, 1000);
        assertEquals(0, game.getNumGuesses());
        assertEquals(1000, game.getUpperBound());
        assertEquals(500, game.getLowerBound());
        assertEquals(750, game.getLastGuess());
    }

    /**
     * This will check the three changes made by makeLowerGuess:
     * <ol>
     * <li> {@code lastGuess} - this is the primary focus of this test
     * <li> {@code upperBound}
     * <li> {@code numGuesses} - should incrememnt by 1 after each guess
     * </ol>
     * <p> This will also implictly test reaching the answer via the "Lower" button
     */
    @Test
    void makeLowerGuessTest() {
        // human's number is 1
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(501, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(501, game.getUpperBound());
        assertEquals(1, game.getNumGuesses());
        assertEquals(251, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(251, game.getUpperBound());
        assertEquals(2, game.getNumGuesses());
        assertEquals(126, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(126, game.getUpperBound());
        assertEquals(3, game.getNumGuesses());
        assertEquals(64, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(64, game.getUpperBound());
        assertEquals(4, game.getNumGuesses());
        assertEquals(33, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(33, game.getUpperBound());
        assertEquals(5, game.getNumGuesses());
        assertEquals(17, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(17, game.getUpperBound());
        assertEquals(6, game.getNumGuesses());
        assertEquals(9, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(9, game.getUpperBound());
        assertEquals(7, game.getNumGuesses());
        assertEquals(5, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(5, game.getUpperBound());
        assertEquals(8, game.getNumGuesses());
        assertEquals(3, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(3, game.getUpperBound());
        assertEquals(9, game.getNumGuesses());
        assertEquals(2, game.getLastGuess());

        game.makeLowerGuess();
        assertEquals(2, game.getUpperBound());
        assertEquals(10, game.getNumGuesses());
        assertEquals(1, game.getLastGuess());
    }

    /**
     * This will check the three changes made by makeHigherGuess:
     * <ol>
     * <li> {@code lastGuess} - this is the primary focus of this test
     * <li> {@code lowerBound}
     * <li> {@code numGuesses} - should incrememnt by 1 after each guess
     * </ol>
     * <p> This will also implictly test reaching the answer via the "Higher" button
     */
    @Test
    void makeHigherGuessTest() {
        // human's number is 1000
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(501, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(502, game.getLowerBound());
        assertEquals(1, game.getNumGuesses());
        assertEquals(751, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(752, game.getLowerBound());
        assertEquals(2, game.getNumGuesses());
        assertEquals(876, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(877, game.getLowerBound());
        assertEquals(3, game.getNumGuesses());
        assertEquals(939, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(940, game.getLowerBound());
        assertEquals(4, game.getNumGuesses());
        assertEquals(970, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(971, game.getLowerBound());
        assertEquals(5, game.getNumGuesses());
        assertEquals(986, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(987, game.getLowerBound());
        assertEquals(6, game.getNumGuesses());
        assertEquals(994, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(995, game.getLowerBound());
        assertEquals(7, game.getNumGuesses());
        assertEquals(998, game.getLastGuess());

        game.makeHigherGuess();
        assertEquals(999, game.getLowerBound());
        assertEquals(8, game.getNumGuesses());
        assertEquals(1000, game.getLastGuess());
    }
}
