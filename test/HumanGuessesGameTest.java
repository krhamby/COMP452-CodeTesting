import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HumanGuessesGameTest {
    @Test
    void constructorTest() {
        HumanGuessesGame game = new HumanGuessesGame(300);
        assertEquals(0, game.getNumGuesses());
        assertEquals(1000, game.getUpperBound());
        assertEquals(300, game.getTarget());
        assertEquals(false, game.isDone());
    }




}