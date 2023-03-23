import java.util.SortedMap;
import java.util.TreeMap;

class GameStatsTestingDouble extends GameStats {

    private SortedMap<Integer, Integer> statsMap;

    public GameStatsTestingDouble() {
        statsMap = new TreeMap<>();
        statsMap.put(1, 3 + statsMap.getOrDefault(1, 0));
        statsMap.put(2, 2 + statsMap.getOrDefault(2, 0));
        statsMap.put(4, 1 + statsMap.getOrDefault(4, 0));
        statsMap.put(6, 4 + statsMap.getOrDefault(6, 0));
        statsMap.put(8, 5 + statsMap.getOrDefault(8, 0));
        statsMap.put(10, 6 + statsMap.getOrDefault(10, 0));
        statsMap.put(12, 2 + statsMap.getOrDefault(12, 0));
        statsMap.put(14, 1 + statsMap.getOrDefault(14, 0));
        statsMap.put(23, 1 + statsMap.getOrDefault(23, 0));
    }

    @Override
    public int numGames(int numGuesses) {
        return statsMap.getOrDefault(numGuesses, 0);
    }

    @Override
    public int maxNumGuesses(){
        return (statsMap.isEmpty() ? 0 : statsMap.lastKey());
    }
}
