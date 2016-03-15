package jr.eecs1022.tonegenerator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.DecimalFormat;
import static jr.eecs1022.tonegenerator.R.*;

public class ToneGenerator extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener
{
    private ToneEmitter toneEmitter = null;
    int changeAmplitude = R.id.changeAmplitude;
    int changeFrequency = R.id.changeFrequency;
    int textAmpli = R.id.amplitudeValue;
    int textFreq = R.id.frequencyValue;
    //TextView textVFreq= (TextView)findViewById(textFreq);


    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    {
        if(seekBar == findViewById(R.id.changeAmplitude)){
            System.out.println("amplitude" + findViewById(R.id.changeAmplitude));
            setAmplitude((double)progress/100);
        }
        else if(seekBar == findViewById(R.id.changeFrequency)){
            System.out.println("frequency" + findViewById(R.id.changeFrequency));
            setFrequency((((double)progress/100)*(ToneEmitter.NOTE_C_ABOVE_MIDDLE_C-ToneEmitter.NOTE_C))+262);
        }
        System.out.println("onPress called with" + progress);
        /*if (toneEmitter != null)
        {
            int ID = seekBar.getId();
            if (ID == 2131492946)
            {
                System.out.println(seekBar.getId());
                System.out.println("Amplitude: " + progress);
                double I = (double) progress;
                setAmplitude(I);
            }
            else if(ID == 2131492949){
                System.out .println(seekBar.getId());
                System.out.println("frequency: " + progress);
                if (progress == 0){
                    setFrequency(ToneEmitter.NOTE_C);
                }
                else if (progress == 100){
                    setFrequency(ToneEmitter.NOTE_C_ABOVE_MIDDLE_C);
                }
                else{
                    double J = (double)progress;
                    setFrequency(J);
                }
            }

        }*/
    }

    public void onStartTrackingTouch(SeekBar seekBar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekBar)
    {
    }

    private void setFrequency(double frequency)
    {
        toneEmitter.setFrequency(frequency);
        DecimalFormat freq = new DecimalFormat("0.00#");
        String freqstr = freq.format(frequency);
        TextView textView = (TextView)findViewById(id.frequencyValue);
        textView.setText(freqstr);
        System.out.println("setFrequency called with " + frequency + "" + freqstr);
        //String text="1234";

        //textVFreq.setText(text);
    }

    private void setAmplitude(double amplitude)
    {    toneEmitter.setAmplitude(amplitude);
        DecimalFormat amp = new DecimalFormat("0.00#");
        String ampstr = amp.format(amplitude);
        TextView textView = (TextView)findViewById(id.amplitudeValue);
        textView.setText(ampstr);
        System.out.println("setAmplitude called with " + amplitude + "" + ampstr);
        //String text="1234";
        //textAmpli.setText(text);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_tone_generator);

        SeekBar seekbar = (SeekBar) findViewById(id.changeAmplitude);
        seekbar.setOnSeekBarChangeListener(this);
        seekbar = (SeekBar) findViewById(id.changeFrequency);
        seekbar.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onResume()
    {
        super.onResume();
        toneEmitter = new ToneEmitter();
        this.setAmplitude(0.0);
        this.setFrequency(ToneEmitter.NOTE_C);
        SeekBar seekBar = (SeekBar) findViewById(id.changeAmplitude);
        seekBar.setProgress(0);
        seekBar = (SeekBar) findViewById(id.changeFrequency);
        System.out.println("onResume ************************************************");
        seekBar.setProgress(0);
    }

    @Override
    public void onPause()
    {
        toneEmitter.shutdown();
        toneEmitter = null;
        super.onPause();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tone_generator, menu);
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
}