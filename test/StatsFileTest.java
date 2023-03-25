import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.SortedMap;
import java.util.TreeMap;

class StatsFileTest {
    @Test
    void getStatsEntryTest() {
        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2020-01-01T00:00:00");
        String[] values = {"2020-01-02T00:00:00", "1"};

        statsFile.getStatsEntry(limit, values, statsMap);
        assertEquals(1, statsMap.get(1));
    }

    @Test
    void getStatsEntryNumberFormatExceptionTest() {
        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2020-01-01T00:00:00");
        String[] values = {"2020-01-02T00:00:00", "a"};

        assertThrows(NumberFormatException.class, () -> {
            statsFile.getStatsEntry(limit, values, statsMap);
        });
    }

    @Test
    void getStatsEntryDateTimeParseExceptionTest() {
        StatsFile statsFile = new StatsFile();
        SortedMap<Integer, Integer> statsMap = new TreeMap<>();
        LocalDateTime limit = LocalDateTime.parse("2020-01-01T00:00:00");
        String[] values = {"HEHE-01-02T00:00:00", "1"};

        assertThrows(DateTimeParseException.class, () -> {
            statsFile.getStatsEntry(limit, values, statsMap);
        });
    }
}
