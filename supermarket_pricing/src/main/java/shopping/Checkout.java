package shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import catalogue.Product;
import pricing.PricingModels;

public class Checkout {
    public static final Map<String, PricingModels> PRICING_MODEL = new HashMap<>();
    
    public static double checkout(ShoppingCart shoppingCart) {
    	Map<String, List<Product>> productMap = shoppingCart.getProductMap();
    	
        double totalPrice = 0d;
        for (Map.Entry<String, List<Product>> entry : productMap.entrySet()) {
        	if(PRICING_MODEL.containsKey(entry.getKey()))
        		totalPrice += PRICING_MODEL.get(entry.getKey()).getPriceCalculator().apply(entry.getValue());
        }            
        return totalPrice;
    }
}
