package catalogue;

public class Product {
	protected final String name;
    protected final double price;
    protected final double cost;
    protected final double weight;
    protected final long stock;
    
    public Product(String name, double price, double cost, double weight, long stock) {
    	this.name = name;
    	this.price = price;
    	this.cost = cost;
    	this.weight = weight;
    	this.stock = stock;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public double getPrice() {
    	return this.price;
    }
    
    public double getCost() {
    	return this.cost;
    }
    
    public double getWeight() {
    	return this.weight;
    }
    
    public long getStock() {
    	return this.stock;
    }  
    
    //(double)Math.round(value*100)/100；

} 
