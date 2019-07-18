package supermarket_pricing;

import org.junit.jupiter.api.Test;

import catalogue.Banana;
import junit.framework.TestCase;
import shopping.ShoppingCart;

public class ShoppingCartTest extends TestCase {

    @Test
    public void testEmpty() {
    	ShoppingCart cart = new ShoppingCart();
    	assertTrue(cart.getProductMap().isEmpty());
    }
	
    @Test
    public void testAddProduct() {
    	ShoppingCart cart = new ShoppingCart();
    	cart.addProduct(new Banana());
    	
    	assertTrue(!cart.getProductMap().get("Banana").isEmpty());
    }
	
    @Test
    public void testDeleteProduct() {
    	ShoppingCart cart = new ShoppingCart();
    	
    	for(int i=0; i<3; i++) {
    		cart.addProduct(new Banana());
    	}
    	
    	cart.deleteProduct(new Banana());
    	
    	assertTrue(cart.getProductMap().size() == 0);
    }

}
