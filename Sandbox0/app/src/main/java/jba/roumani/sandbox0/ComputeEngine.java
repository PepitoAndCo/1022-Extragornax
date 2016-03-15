package jba.roumani.sandbox0;

/**
 * A plain Java class not tied to the Android context.
 *
 * @author H. Roumani
 * @since Jan 2016
 */
public class ComputeEngine
{
    // attributes go here
    private int count;

    // this is the constructor
    public ComputeEngine()
    {
        this.count = 0;
    }

    // methods go here
    public int getCount()
    {
        return this.count;
    }

    public double compute(int qty, double price)
    {
        //System.out.println("Parameters received: " + qty + ", " + price);
        final double HST = 0.13;
        double subtotal = qty * price;
        double tax = subtotal * HST;
        double total = subtotal + tax;
        return total;
    }

    public String toString()
    {
        return "The Compute Engine!";
    }

}
