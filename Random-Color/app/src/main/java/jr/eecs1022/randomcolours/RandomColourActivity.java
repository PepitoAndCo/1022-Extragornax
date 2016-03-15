package jr.eecs1022.randomcolours;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.Random;

public class RandomColourActivity extends AppCompatActivity implements SensorEventListener
{
    private Random random = new Random();
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_colour);
        System.out.println("*** In the onCreate method");
        Button button = (Button) findViewById(R.id.pushButton);
        System.out.println(button.getText());
        processButtonPush(button);
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_random_colour, menu);
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

    public void processButtonPush(View view)
    {
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        System.out.println("Checkbox status :" + checkBox.isChecked());

        if(checkBox.isChecked()) {

            int red = random.nextInt(1);

            int green = random.nextInt(256);

            int blue = random.nextInt(1);

            view.setBackgroundColor(Color.rgb(red, green, blue));

        } else {
            int red = random.nextInt(256);

            int green = random.nextInt(256);

            int blue = random.nextInt(256);

            view.setBackgroundColor(Color.rgb(red, green, blue));
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        //System.out.println("In the onAccuracyChanged Method");
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)

        {

            double x = event.values[0];

            double y = event.values[1];

            double z = event.values[2];

            double vector = x*x + y*y + z*z;

            if (vector > 15*15)

            {

                this.processButtonPush(findViewById(R.id.pushButton));

            }

        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {

    }
}
