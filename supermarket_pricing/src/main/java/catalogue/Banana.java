package catalogue;

public class Banana extends Product{
	public static final String NAME = "Banana";
    public static final double PRICE = 0.4d;
    public static final double COST = 0.2d;
    public static final double WEIGHT = 0.12d;
    public static final long STOCK = 300;
    
    public Banana() {
        super(NAME, PRICE, COST, WEIGHT, STOCK);
    }

}
