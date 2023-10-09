package de.metro.evaluate.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ProcessorTest {

    @Test
    fun process() {
        //given
        val prices = mapOf("pepsi" to 10.0)
        val articleVats = mapOf("pepsi" to 15)
        //when
        val processor = Processor()
        val report = processor.process(prices, articleVats)

        //then
        assertEquals(report.total, 11.5)
    }
}