package jba.roumani.sandbox0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        int x = Integer.parseInt(in1);
        double y = Double.parseDouble(in2);
        ComputeEngine engine = new ComputeEngine();
        System.out.println("About to invoke the engine ...");
        double result = engine.compute(x, y);
        ((TextView) findViewById(R.id.output)).setText("" + result);
    }
}
