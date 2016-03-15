package jba.roumani.sandbox2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import jba.roumani.lib.Mortgage;

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
}
