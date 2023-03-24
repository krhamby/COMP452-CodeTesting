import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinTest {

    @Test
    void getNameTest() {
        assertEquals("1", Bin.getName(0));
        assertEquals("2-3", Bin.getName(1));
        assertEquals("4-5", Bin.getName(2));
        assertEquals("6-7", Bin.getName(3));
        assertEquals("8-9", Bin.getName(4));
        assertEquals("10-11", Bin.getName(5));
        assertEquals("12-13", Bin.getName(6));
        assertEquals("14 or more", Bin.getName(7));
    }

    @Test
    void calculateNumGamesTest() {
        GameStatsTestingDouble gameStats = new GameStatsTestingDouble();
        int[] bins = Bin.calculateNumGames(gameStats);

        assertEquals(3, bins[0]);
        assertEquals(2, bins[1]);
        assertEquals(1, bins[2]);
        assertEquals(4, bins[3]);
        assertEquals(5, bins[4]);
        assertEquals(6, bins[5]);
        assertEquals(2, bins[6]);
        assertEquals(2, bins[7]);
    }

    //test with empty game stats maybe?
}
