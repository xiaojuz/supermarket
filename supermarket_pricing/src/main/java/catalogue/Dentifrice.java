package catalogue;

public class Dentifrice extends Product{
	public static final String NAME = "Dentifrice";
    public static final double PRICE = 2d;
    public static final double COST = 0.5d;
    public static final double WEIGHT = 0.3d;
    public static final long STOCK = 600;
    
    public Dentifrice() {
        super(NAME, PRICE, COST, WEIGHT, STOCK);
    }

}
