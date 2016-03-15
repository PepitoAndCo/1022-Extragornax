package jr.eecs1022.rockpaperscissors;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class RPSActivity extends AppCompatActivity
{
    private static final String MODULE = "RSPActivity";

    private int curDrawable = R.drawable.splash;
    private int iaSelectionResult;
    String curText;
    private enum States {SPLASH, THREE, TWO, ONE, ANSWER};
    private States curState = States.SPLASH;


    public void buttonPressed(View view)
    {
        System.out.println("buttonPressed called");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.button);


        if(curDrawable == R.drawable.splash){
            curDrawable = R.drawable.image3;
            curState = States.THREE;
            curText = "Continue";
        }
        else if(curDrawable == R.drawable.image3){
            curDrawable = R.drawable.image2;
            curState = curState = States.TWO;
        }
        else if(curDrawable == R.drawable.image2){
            curDrawable = R.drawable.image1;
            curState = curState = States.ONE;
        }
        else if(curDrawable == R.drawable.image1){

            int randomNumber = (int )(Math.random() * 5 + 1);

            if(randomNumber == 1) {
                iaSelectionResult = R.drawable.scissors;
                curState = States.ANSWER;
            }

            if(randomNumber == 2) {
                iaSelectionResult = R.drawable.paper;
                curState = States.ANSWER;
            }

            if(randomNumber == 3) {
                iaSelectionResult = R.drawable.rock;
                curState = States.ANSWER;
            }

            if(randomNumber == 4) {
                iaSelectionResult = R.drawable.lizard;
                curState = States.ANSWER;
            }

            if(randomNumber == 5) {
                iaSelectionResult = R.drawable.spock;
                curState = States.ANSWER;
            }


            curDrawable = iaSelectionResult;
            curText = "End";

        }
        else if(curDrawable == R.drawable.paper || curDrawable == R.drawable.scissors || curDrawable == R.drawable.rock || curDrawable == R.drawable.lizard || curDrawable == R.drawable.spock){
            curDrawable = R.drawable.splash;
            curState = curState = States.SPLASH;;
            curText = "Start";
        }


        imageView.setImageResource(curDrawable);
        button.setText(curText);

        System.out.println("buttonPressed done");
        System.out.println("***Current image " + curState + " ***");
        System.out.println("Paper = " + R.drawable.paper);
        System.out.println("Scissors = " + R.drawable.scissors);
        System.out.println("Rock = " + R.drawable.rock);
        System.out.println("Image3 = " + R.drawable.image3);
        System.out.println("Image2 = " + R.drawable.image2);
        System.out.println("Image1 = " + R.drawable.image1);
        System.out.println("curState: " + curState);



    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rps);
        System.out.println(curState + " this is the current state");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_r, menu);
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
