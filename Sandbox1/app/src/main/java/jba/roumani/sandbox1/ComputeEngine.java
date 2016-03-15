package jba.roumani.sandbox1;

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

    public void exploreIntegers(int x, int y)
    {
        System.out.println("-------------------------- Integer Games:");

        // Operators
        int z;
        z = x + y;
        System.out.printf("%d + %d = %d\n", x, y, z);

        z = x - y;
        System.out.printf("%d - %d = %d\n", x, y, z);

        z = x * y;
        System.out.printf("%d * %d = %d\n", x, y, z);

        z = x / y;
        System.out.printf("%d / %d = %d\n", x, y, z);

        z = x % y;
        System.out.printf("%d %% %d = %d\n", x, y, z);

        // Formatting options
        System.out.printf("The numbers are %d and %d\n", x, y);
        System.out.printf("The numbers are %5d and %5d\n", x, y);
        System.out.printf("The numbers are %-5d and %-5d\n", x, y);
        System.out.printf("The numbers are %05d and %05d\n", x, y);

        // Mashup of Operators
        int r1 = 5;
        int r2 = 9;
        int r3 = 2;
        int answer = r1 * r2 / r3;
        System.out.println(answer);

        // Closure by wrapping
        x = 1000000000;
        y = 1500000000;
        z = x + y;
        System.out.printf("%d + %d = %d\n", x, y, z);

        // Use long (8B instead of 4B) for bigger ranges
        long p = 1000000000;
        long q = 1500000000;
        long r = p + q;
        System.out.printf("%d + %d = %d\n", p, q, r);

        // Trying to div by zero
        int n = 30;
        int d = 0;
        //int ratio = n / d; // throw an rutime exception
        //System.out.println(ratio);

        // Mashup of Types (promotion and casting)
        int s1 = 1500000000;
        int s2 = 1000000000;
        long ss = 0;
        long mashup = s1 + s2 + ss;
        System.out.println(mashup);
        mashup = s1 + ss + s2;
        System.out.println(mashup);
        mashup = s1 + (long) s2 + ss;
        System.out.println(mashup);
    }

    public void exploreReals(double x, double y)
    {
        System.out.println("-------------------------- Real Games:");

        // Operators
        double z = x + y;
        System.out.printf("%5.1f + %5.1f = %5.2f\n", x, y, z);

        z = x * y;
        System.out.printf("%.2f * %.2f = %.2f\n", x, y, z);

        z = x - y;
        System.out.printf("%.2f - %.2f = %.2f\n", x, y, z);

        z = x / y;
        System.out.printf("%.2f / %.2f = %.2f\n", x, y, z);

        // The range
        double a = 987654321.01234562;
        double b = 987654321.012345621;
        double c = a - b;
        System.out.println("Difference of two close numbers = " + c);
        double d = 1.0 / c;
        System.out.println("Div by very small number = " + d);
        System.out.println("Infinity times zero = " + d * 0.0);

        // More on the accuracy: add 0.1 to itself 10 times.
        // (can do so manually or via a loop):
        double sum = 0;
        for (int i = 0; i < 10; i++)
        {
            d += 0.1;
        }
        System.out.println("Is 0.1*10 equal to 1.0 ? " + (sum == 1.0));

        // Mixed type expression
        double t = 1.0;
        int i = 3;
        int j = 7;
        double r1 = i / j * t;
        System.out.println("r1 = " + r1);
        double r2 = t * i / j;
        System.out.println("r2 = " + r2);
        double r3 = j / (double) i;
        System.out.println("r3 = " + r3);
    }

    public void exploreChars()
    {
        System.out.println("-------------------------- Char Games:");

        char x = 'B';
        System.out.printf("x = %c\n", x);
        System.out.println(x + 3);
    }

    public void exploreBooleans()
    {
        System.out.println("-------------------------- Boolean Games:");

        boolean x = true;
        boolean y = false;
        System.out.printf("x = %b\n", x);

        // Logical operators on booleans yield booleans
        boolean z;
        z = x & y;
        System.out.printf("%b & %b = %b\n", x, y, z);

        z = x | y;
        System.out.printf("%b | %b = %b\n", x, y, z);

        // Relational operators on numbers yield booleans
        int a = 7;
        int b = 10;
        boolean ok = (a < 23) && (b > 17);
        System.out.println(ok);

        // Verify that xx is in [0,15)
        int xx = 20;
        ok = (xx >= 0) && (xx < 15);
        System.out.println(ok);

        // Verify that xx is not in [0,15)
        // Two different but equivalents ways:
        // Either:
        ok = (xx < 0) || (xx >= 15);
        // Or:
        ok = !((xx >= 0) && (xx < 15));
        System.out.println(ok);
    }

    public static void main(String[] args)
    {
        ComputeEngine engine = new ComputeEngine();
        //engine.exploreIntegers(4, 8);
        //engine.exploreReals(5.0, 2.5);
        engine.exploreChars();
        //engine.exploreBooleans();
    }

}
