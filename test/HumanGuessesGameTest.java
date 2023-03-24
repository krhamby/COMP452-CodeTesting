import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanGuessesGameTest {
    
    // using dependency injection
    @Test
    void testingDoubleConstructorTest() {
        RandomTestingDouble randGen = new RandomTestingDouble();

        HumanGuessesGame game = new HumanGuessesGame(randGen);
        assertEquals(0, game.getNumGuesses());
        assertEquals(1000, game.getUpperBound());
        assertEquals(48, game.getTarget());
        assertEquals(false, game.isDone());
    }

    @Test
    void controllableConstructorTest() {
        HumanGuessesGame game = new HumanGuessesGame(300);
        assertEquals(0, game.getNumGuesses());
        assertEquals(1000, game.getUpperBound());
        assertEquals(300, game.getTarget());
        assertEquals(false, game.isDone());
    }

    @Test
    void makeLowGuessTest() {
        HumanGuessesGame game = new HumanGuessesGame(300);
        assertEquals(GuessResult.LOW, game.makeGuess(200));
        assertEquals(1, game.getNumGuesses());
        assertEquals(false, game.isDone());
    }

    @Test
    void makeHighGuessTest() {
        HumanGuessesGame game = new HumanGuessesGame(300);
        assertEquals(GuessResult.HIGH, game.makeGuess(400));
        assertEquals(1, game.getNumGuesses());
        assertEquals(false, game.isDone());
    }

    /**
     * Fails because the game is not marked as done after a correct guess
     */
    @Test
    void makeCorrectGuessTest() {
        HumanGuessesGame game = new HumanGuessesGame(300);
        assertEquals(GuessResult.CORRECT, game.makeGuess(300));
        assertEquals(1, game.getNumGuesses());
        assertEquals(true, game.isDone());
    }
}