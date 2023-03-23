import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {
    @Test
    void constructorTest() {
        GameResult result = new GameResult(true, 1, 5);
        assertEquals(true, result.humanWasPlaying);
        assertEquals(1, result.correctValue);
        assertEquals(5, result.numGuesses);
    }
}
