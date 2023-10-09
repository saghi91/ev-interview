package de.metro.evaluate.interview;

import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ProcessorController {

    private final Processor processor;

    public ProcessorController(final Processor processor) {
        this.processor = processor;
    }

    @PostMapping("generate-report")
    void generateReport(@RequestBody ReportRequest reportRequest ) {
        processor.process( reportRequest.articleNettPrices, reportRequest.articleVatPercentages );

    }

}

class ReportRequest
{
    Map<String, Double> articleNettPrices;
    Map<String, Integer>articleVatPercentages;
}
