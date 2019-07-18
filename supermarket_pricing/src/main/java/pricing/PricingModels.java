package pricing;

import java.util.List;
import java.util.function.Function;

import catalogue.Product;

public enum PricingModels {
	
	UNIT_PRICE(PriceCalculatorRules.unitPriceRule()),
	THREE_FOR_A_DOLLAR(PriceCalculatorRules.packPriceRule(3, 1)),
    EACH_POUND_1_99(PriceCalculatorRules.weightPriceRule(1, 1.99d)),
    THIRD_FREE(PriceCalculatorRules.freeProductsInPackPriceRule(2, 1)),
	FIVE_FOR_TWO_FREE(PriceCalculatorRules.freeProductsInPackPriceRule(3, 2));

    private final Function<List<Product>, Double> calculator;

    PricingModels(Function<List<Product>, Double> calculator) {
        this.calculator = calculator;
    }

    public Function<List<Product>, Double> getPriceCalculator() {
        return this.calculator;
    }
}