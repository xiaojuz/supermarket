package shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import catalogue.Product;

public class ShoppingCart {


    private final Map<String, List<Product>> productMap;

    public ShoppingCart() {
    	productMap = new HashMap<>();
    }
    
    public ShoppingCart(Product product, int quantity) {
    	productMap = new HashMap<>();
    	
    	for(int i=0; i<quantity; i++) {
    		productMap.get(product.getName()).add(product);
    	} 		
    }
    
    public Map<String, List<Product>> getProductMap(){
    	return this.productMap;
    }

    public void addProduct(Product product) {
        if (!productMap.containsKey(product.getName())) {
        	productMap.put(product.getName(), new ArrayList<>());
        }
        productMap.get(product.getName()).add(product);
    }

    public void deleteProduct(Product product) {
    	if( productMap.containsKey(product.getName()))
    		productMap.remove(product.getName());
    }

}
