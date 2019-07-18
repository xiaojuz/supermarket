package pricing;

import java.util.List;
import java.util.function.Function;

import catalogue.Product;

public class PriceCalculatorRules {
	
	public static Function<List<Product>, Double> unitPriceRule() {
        return (List<Product> productList) -> productList.isEmpty() ? 0 : productList.size() * productList.get(0).getPrice();
    }

    public static Function<List<Product>, Double> weightPriceRule(double weight, double weightPrice) {
        return (List<Product> productList) -> productList.isEmpty()  ? 0 : (double)Math.round((productList.size() * productList.get(0).getWeight() * weightPrice / weight)*100)/100;
    }
    
    public static Function<List<Product>, Double> packPriceRule(int quantityInPack, double packPrice) {
        return (List<Product> productList) -> productList.isEmpty()  ? 0 : (productList.size() / quantityInPack) * packPrice + (productList.size() % quantityInPack) * productList.get(0).getPrice();
    }

    public static Function<List<Product>, Double> freeProductsInPackPriceRule(int payableQuantity, int freeQuantity) {
        return (List<Product> productList) -> productList.isEmpty()  ? 0 : (productList.size() / (payableQuantity + freeQuantity)) * payableQuantity * productList.get(0).getPrice() + (productList.size() % (payableQuantity + freeQuantity)) * productList.get(0).getPrice();
    }

}
