import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.SortedMap;
import java.util.TreeMap;

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

    /**
     * This test fails because each bin's value is the sum of
     * {@code numGames} for the given bin and the next bin.
     */
    @Test
    void calculateNumGamesTestFullList() {
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        statsMap.put(1, 3 + statsMap.getOrDefault(1, 0));
        statsMap.put(2, 2 + statsMap.getOrDefault(2, 0));
        statsMap.put(4, 1 + statsMap.getOrDefault(4, 0));
        statsMap.put(6, 4 + statsMap.getOrDefault(6, 0));
        statsMap.put(8, 5 + statsMap.getOrDefault(8, 0));
        statsMap.put(10, 6 + statsMap.getOrDefault(10, 0));
        statsMap.put(12, 2 + statsMap.getOrDefault(12, 0));
        statsMap.put(14, 1 + statsMap.getOrDefault(14, 0));
        statsMap.put(23, 1 + statsMap.getOrDefault(23, 0));
        statsMap.put(30, 1 + statsMap.getOrDefault(30, 0));

        GameStatsTestingDouble gameStats = new GameStatsTestingDouble(statsMap);
        int[] bins = Bin.calculateNumGames(gameStats);

        assertEquals(3, bins[0]);
        assertEquals(2, bins[1]);
        assertEquals(1, bins[2]);
        assertEquals(4, bins[3]);
        assertEquals(5, bins[4]);
        assertEquals(6, bins[5]);
        assertEquals(2, bins[6]);
        assertEquals(3, bins[7]);
    }

    @Test
    void calculateNumGamesTestEmptyStats() {
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();

        GameStatsTestingDouble gameStats = new GameStatsTestingDouble(statsMap);
        int[] bins = Bin.calculateNumGames(gameStats);

        assertEquals(0, bins[0]);
        assertEquals(0, bins[1]);
        assertEquals(0, bins[2]);
        assertEquals(0, bins[3]);
        assertEquals(0, bins[4]);
        assertEquals(0, bins[5]);
        assertEquals(0, bins[6]);
        assertEquals(0, bins[7]);
    }

    @Test
    void calculateNumGamesTestOneLowValue() {
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        statsMap.put(1, 1 + statsMap.getOrDefault(1, 0));

        GameStatsTestingDouble gameStats = new GameStatsTestingDouble(statsMap);
        int[] bins = Bin.calculateNumGames(gameStats);

        assertEquals(1, bins[0]);
        assertEquals(0, bins[1]);
        assertEquals(0, bins[2]);
        assertEquals(0, bins[3]);
        assertEquals(0, bins[4]);
        assertEquals(0, bins[5]);
        assertEquals(0, bins[6]);
        assertEquals(0, bins[7]);
    }

    @Test
    void calculateNumGamesTestMultipleLowValues() {
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        statsMap.put(1, 1 + statsMap.getOrDefault(1, 0));
        statsMap.put(2, 3 + statsMap.getOrDefault(2, 0));
        statsMap.put(3, 1 + statsMap.getOrDefault(3, 0));

        GameStatsTestingDouble gameStats = new GameStatsTestingDouble(statsMap);
        int[] bins = Bin.calculateNumGames(gameStats);

        assertEquals(1, bins[0]);
        assertEquals(4, bins[1]);
        assertEquals(0, bins[2]);
        assertEquals(0, bins[3]);
        assertEquals(0, bins[4]);
        assertEquals(0, bins[5]);
        assertEquals(0, bins[6]);
        assertEquals(0, bins[7]);
    }

    /**
     * This test fails because of an off-by-one error in the for-loop on line
     * 33 in {@code Bin.java}
     */
    @Test
    void calculateNumGamesTestOneLargeValue() {
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        statsMap.put(30, 1 + statsMap.getOrDefault(30, 0));

        GameStatsTestingDouble gameStats = new GameStatsTestingDouble(statsMap);
        int[] bins = Bin.calculateNumGames(gameStats);

        assertEquals(0, bins[0]);
        assertEquals(0, bins[1]);
        assertEquals(0, bins[2]);
        assertEquals(0, bins[3]);
        assertEquals(0, bins[4]);
        assertEquals(0, bins[5]);
        assertEquals(0, bins[6]);
        assertEquals(1, bins[7]);
    }

    @Test
    void calculateNumGamesTestMultipleLargeValues() {
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        statsMap.put(30, 1 + statsMap.getOrDefault(30, 0));
        statsMap.put(18, 1 + statsMap.getOrDefault(18, 0));
        statsMap.put(23, 3 + statsMap.getOrDefault(23, 0));

        GameStatsTestingDouble gameStats = new GameStatsTestingDouble(statsMap);
        int[] bins = Bin.calculateNumGames(gameStats);

        // we know the other bins are incorrect per calculateNumGamesTest(),
        // so we only need to check the last bin
        assertEquals(5, bins[7]);
    }
}
