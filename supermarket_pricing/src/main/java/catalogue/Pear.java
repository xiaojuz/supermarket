package catalogue;

public class Pear extends Product{
	public static final String NAME = "Pear";
    public static final double PRICE = 0.5d;
    public static final double COST = 0.2d;
    public static final double WEIGHT = 0.23d;
    public static final long STOCK = 500;
    
    public Pear() {
        super(NAME, PRICE, COST, WEIGHT, STOCK);
    }

}
