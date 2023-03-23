import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanGuessesGame {
    @Test
    void constructorTest() {
        HumanGuessesGame game = new HumanGuessesGame();
        assertEquals(0, game.getNumGuesses());
        assertEquals(1000, game.getUpperBound());
        assertEquals(1, game.getLowerBound());
    }


}