import java.util.SortedMap;

class GameStatsTestingDouble extends GameStats {

    private SortedMap<Integer, Integer> statsMap;

    public GameStatsTestingDouble(SortedMap<Integer, Integer> statsMap) {
        this.statsMap = statsMap;
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
