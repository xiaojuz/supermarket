package catalogue;

public class Hairpin extends Product{
	public static final String NAME = "Hairpin";
    public static final double PRICE = 0.5d;
    public static final double COST = 0.1d;
    public static final double WEIGHT = 0.08d;
    public static final long STOCK = 100;
    
    public Hairpin() {
        super(NAME, PRICE, COST, WEIGHT, STOCK);
    }

}
