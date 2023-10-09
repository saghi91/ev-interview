package de.metro.evaluate.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class ProcessorTest {

    @Test
    void process() {
        //given
        var prices = Map.of("pepsi", 10.0);
        var articleVats = Map.of("pepsi", 15);
        //when
        var processor = new Processor();
        var report = processor.process(prices, articleVats);

        //then
        assertEquals(report.total, 11.5);
    }
}