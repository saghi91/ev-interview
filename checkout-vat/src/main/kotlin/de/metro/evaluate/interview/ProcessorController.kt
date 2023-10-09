package de.metro.evaluate.interview

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProcessorController(val processor: Processor) {

    @PostMapping("generate-report")
    fun generateReport(@RequestBody reportRequest: ReportRequest) =
        processor.process(reportRequest.articleNettPrices, reportRequest.articleVatPercentages)


}

data class ReportRequest(val articleNettPrices: Map<String, Double>, val articleVatPercentages: Map<String, Int>)

