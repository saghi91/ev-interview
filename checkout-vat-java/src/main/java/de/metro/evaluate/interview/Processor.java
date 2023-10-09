package de.metro.evaluate.interview;

import java.time.Instant;
import java.util.Map;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Processor {

    Double total = .0;

    Report process(Map<String, Double> articleNettPrices, Map<String, Integer> articleVatPercentages) {
        var vat = 0.0;
        total = 0.0;
        for (Map.Entry<String, Double> articlePrice : articleNettPrices.entrySet()) {
            for (Map.Entry<String, Integer> articleVat : articleVatPercentages.entrySet()) {
                if (articlePrice.getKey() == articleVat.getKey()) {
                    vat = (articleVat.getValue().doubleValue() / 100);
                }
                total += articlePrice.getValue() + articlePrice.getValue() * vat;
            }
        }
        return new Report( total, Instant.now() );
    }

    Report getTotalReport() {
        return new Report( total, Instant.now() );
    }
}

class Report {
    Double total;
    Instant timestamp;

    public Report(final Double total, final Instant timestamp) {
        this.total = total;
        this.timestamp = timestamp;
    }

    public Double getTotal() {
        return total;
    }

    public Instant getTimestamp() {
        return timestamp;
    }
}