package shopping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import catalogue.Banana;
import catalogue.Dentifrice;
import catalogue.Hairpin;
import catalogue.Pear;
import catalogue.Shampooing;
import pricing.PricingModels;


/**
This program is to simulate a shopping and then calculate the total price by different pricing rules. At last we get a receipt in a txt file.
@author Xiaoju Z
@version V1.1
*/
public class Main{
	
	private final static String FILE_NAME = System.getProperty("user.home") + "\\Downloads\\receipt.txt";
	
	public static void main(String[] args) {
		
		BufferedWriter writer = null;
		
		try {
			
			writer = new BufferedWriter(new FileWriter(FILE_NAME));
			writer.write("shopping receipt");
			writer.newLine();
			writer.write(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES).toString());
			writer.newLine();
			writer.write("item\t\tquantity");
			
			ShoppingCart shoppingCart = new ShoppingCart();
			
			shoppingCart.addProduct(new Banana());		
			Checkout.PRICING_MODEL.put(Banana.NAME, PricingModels.EACH_POUND_1_99);
			writer.newLine();
			writer.write("Banana\t\t1");
			
			for(int i=0; i<6; i++)
				shoppingCart.addProduct(new Pear());
			Checkout.PRICING_MODEL.put(Pear.NAME, PricingModels.EACH_POUND_1_99);
			writer.newLine();
			writer.write("Pear\t\t6");
			
			for(int i=0; i<4; i++)
				shoppingCart.addProduct(new Hairpin());
			Checkout.PRICING_MODEL.put(Hairpin.NAME, PricingModels.THREE_FOR_A_DOLLAR);
			writer.newLine();
			writer.write("Hairpin\t\t4");
			
			for(int i=0; i<5; i++)
				shoppingCart.addProduct(new Dentifrice());
			Checkout.PRICING_MODEL.put(Dentifrice.NAME, PricingModels.FIVE_FOR_TWO_FREE);
			writer.newLine();
			writer.write("Dentifrice\t5");
			
			for(int i=0; i<4; i++)
				shoppingCart.addProduct(new Shampooing());
			Checkout.PRICING_MODEL.put(Shampooing.NAME, PricingModels.THIRD_FREE);
			writer.newLine();
			writer.write("Shampooing\t4");
			
			double totalPrice = Checkout.checkout(shoppingCart);
			System.out.println("totalPrice : " + totalPrice);
			writer.newLine();
			writer.newLine();
			writer.write("totalPrice: "+totalPrice);
			
			//test for calculate result
			double calculResult = (double)Math.round((Banana.WEIGHT + 6*Pear.WEIGHT)* 1.99*100)/100 + (1 + Hairpin.PRICE) + (3*Dentifrice.PRICE)+ (3*Shampooing.PRICE);
			System.out.println("manual calculate result : " + calculResult);
			
			System.out.println("Receipt exported to path "+FILE_NAME);
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            	
            }
        }
	}
}
