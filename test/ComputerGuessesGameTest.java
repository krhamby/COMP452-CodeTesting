import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerGuessesGameTest {
    @Test
    void constructorTest() {
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(0, game.getNumGuesses());
        assertEquals(1000, game.getUpperBound());
        assertEquals(1, game.getLowerBound());
        assertEquals(501, game.getLastGuess());
    }

    @Test
    void makeHigherGuessTest() {
        // "human" guesses 1000
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(501, game.getLastGuess());
        game.makeHigherGuess();
        // TODO: finish
    }
}
