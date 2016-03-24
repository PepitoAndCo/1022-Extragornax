package jba.roumani.rex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UI extends AppCompatActivity implements View.OnClickListener
{
    private RegexEngine re;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        ((Button) findViewById(R.id.compute)).setOnClickListener(this);
        ((Button) findViewById(R.id.reset)).setOnClickListener(this);
        String[] pool = this.getResources().getStringArray(R.array.pool);
        this.re = new RegexEngine(pool);
        ((TextView) findViewById(R.id.regex)).setText(re.getRegex());
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
        if (v.getId() == R.id.reset)
        {
            re.reset();
            ((TextView) findViewById(R.id.regex)).setText(re.getRegex());
        }
        else
        {
            String output = ((EditText) findViewById(R.id.string)).getText().toString();
            ((TextView) findViewById(R.id.result)).setText(re.analyze(output));
        }
    }
}
