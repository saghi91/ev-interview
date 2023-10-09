package de.metro.evaluate.interview

import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import java.time.Instant

@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class Processor {

    var total: Double = .0

    fun process(articleNettPrices: Map<String, Double>, articleVatPercentages: Map<String, Int>): Report {
        var vat = 0.0
        total = 0.0
        for (articlePrice in articleNettPrices) {
            for (articleDiscount in articleVatPercentages) {
                if (articlePrice.key == articleDiscount.key) {
                    vat = (articleDiscount.value.toDouble() / 100)
                }
                total += articlePrice.value + articlePrice.value * vat
            }
        }
        return Report(total, Instant.now())
    }

}

data class Report(val total: Double, val timestamp: Instant)