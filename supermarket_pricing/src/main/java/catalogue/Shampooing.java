package catalogue;

public class Shampooing extends Product{
	public static final String NAME = "Shampooing";
    public static final double PRICE = 12d;
    public static final double COST = 5d;
    public static final double WEIGHT = 1d;
    public static final long STOCK = 100;
    
    public Shampooing() {
        super(NAME, PRICE, COST, WEIGHT, STOCK);
    }

}
