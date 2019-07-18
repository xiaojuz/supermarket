package supermarket_pricing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import catalogue.Banana;
import catalogue.Hairpin;
import catalogue.Shampooing;
import junit.framework.TestCase;
import pricing.PricingModels;
import shopping.Checkout;
import shopping.ShoppingCart;

public class CheckoutTest extends TestCase {
	
    @Test
    public void testEmpty() {
    	ShoppingCart shoppingCart = new ShoppingCart();
    	assertTrue(Checkout.checkout(shoppingCart) == 0d);
    }
    
    @Test
    public void testUnitPriceRule() {
    	ShoppingCart shoppingCart = new ShoppingCart();   	
    	for(int i=0; i<4; i++)
			shoppingCart.addProduct(new Shampooing());
		Checkout.PRICING_MODEL.put(Shampooing.NAME, PricingModels.UNIT_PRICE);   	
		Assert.assertEquals(Checkout.checkout(shoppingCart), Shampooing.PRICE * 4, 0d);
    }
	
    @Test
    public void testWeightPriceRule() {
    	ShoppingCart shoppingCart = new ShoppingCart();    	
    	shoppingCart.addProduct(new Banana());   	
		Checkout.PRICING_MODEL.put(Banana.NAME, PricingModels.EACH_POUND_1_99);   	
		Assert.assertEquals(Checkout.checkout(shoppingCart), (double)Math.round(1.99*Banana.WEIGHT*100)/100, 0d);
    }
    
    @Test
    public void testPackPriceRule() {
    	ShoppingCart shoppingCart = new ShoppingCart();    
    	for(int i=0; i<8; i++)
    		shoppingCart.addProduct(new Hairpin());   	
		Checkout.PRICING_MODEL.put(Hairpin.NAME, PricingModels.THREE_FOR_A_DOLLAR); 
		
		Assert.assertEquals(Checkout.checkout(shoppingCart), 2+Hairpin.PRICE*2, 0d);
    }
    
    @Test
    public void testFreeProductsInPackPriceRule() {
    	ShoppingCart shoppingCart = new ShoppingCart();    
    	for(int i=0; i<8; i++)
    		shoppingCart.addProduct(new Hairpin());   	
		Checkout.PRICING_MODEL.put(Hairpin.NAME, PricingModels.FIVE_FOR_TWO_FREE); 
		
		Assert.assertEquals(Checkout.checkout(shoppingCart), Hairpin.PRICE*6, 0d);
    }

}
