package jba.roumani.sandbox3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UI extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        ((Button) findViewById(R.id.compute)).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        String in1 = ((EditText) findViewById(R.id.input1)).getText().toString();
        String in2 = ((EditText) findViewById(R.id.input2)).getText().toString();
        double principle = Double.parseDouble(in1);
        // 1. get the interest rate
        // 2. Create a Morgage instance
        // 3. get the monthly payment
        // 4. round the monthly payment to dollars and cents (use String.format)
        // 5. find the output1 text viee and set its text to the rounded payment
    }



    // ------------------------------------------------------------------------------

    private Control()
    {

    }

    /**
     *  Determine if a given year is a leap year. A leap year must be divisible
     *  by 4 but if it is divisible by 100 then it must also be divisible by 400.
     * @param year (positive as a precondition)
     * @return true if year is a leap year, false otherwise
     */
    public static boolean isLeap(int year)
    {

    }

    /**
     * Produce a tabulation of all years in the given range and indicate
     * if each is a leap year.
     * @param from the starting year (positive as a precondition)
     * @param upto the ending year (positive as a precondition)
     */
    public static void leapYearTable(int from, int upto)
    {

    }

    /**
     *  Determine if a given number is prime. A prime is divisible only by itself
     *  and 1.
     * @param n the number (positive as a precondition)
     * @return true if the number is prime, false otherwise
     */
    public static boolean isPrime(int n)
    {

    }

    /**
     *  Determine the so-called log2 of a given number. It is defined as the
     *  number of repeated divisions by 2 that are needed to reduce the number
     *  to 1.
     * @param n the number (positive as a precondition)
     * @return the log2 of the passed integer
     */
    public static int log2(int n)
    {

    }

    public static void main(String[] args)
    {
        int y = 2016;
        System.out.printf("%d is a leap year: %b\n", y, Control.isLeap(y));
        y = 2000;
        System.out.printf("%d is a leap year: %b\n", y, Control.isLeap(y));
        y = 1000;
        System.out.printf("%d is a leap year: %b\n", y, Control.isLeap(y));

        Control.leapYearTable(2010, 2020);

        int n = 8;
        System.out.printf("%d is a prime number: %b\n", n, Control.isPrime(n));
        n = 7;
        System.out.printf("%d is a prime number: %b\n", n, Control.isPrime(n));
        n = 17;
        System.out.printf("%d is a prime number: %b\n", n, Control.isPrime(n));
        n = 25;
        System.out.printf("%d is a prime number: %b\n", n, Control.isPrime(n));

        n = 7;
        System.out.printf("The Log2 of %d is %d\n", n, Control.log2(n));
        n = 100;
        System.out.printf("The Log2 of %d is %d\n", n, Control.log2(n));
        n = 1000;
        System.out.printf("The Log2 of %d is %d\n", n, Control.log2(n));

    }
}
