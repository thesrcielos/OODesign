import org.eci.MathUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathUtilsTest {
    @Test
    void testColumn1() {
        List<Double> data = List.of(160d, 591d, 114d, 229d, 230d, 270d, 128d, 1657d, 624d, 1503d);
        assertEquals(550.6, MathUtils.mean(data), 0.1);
        assertEquals(572.03, MathUtils.stdDev(data), 0.1);
    }

    @Test
    void testColumn2() {
        List<Double> data = List.of(15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2);
        assertEquals(60.32, MathUtils.mean(data), 0.1);
        assertEquals(62.26, MathUtils.stdDev(data), 0.1);
    }
}
