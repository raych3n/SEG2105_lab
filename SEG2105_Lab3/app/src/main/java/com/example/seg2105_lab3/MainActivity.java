package com.example.seg2105_lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.seg2105_lab3.R;

public class MainActivity extends AppCompatActivity {

    TextView resultText;
    private enum Operator {none, add, sub, mul, div, eq}

    private double data01=0, data02 = 0;

    private Operator opp = Operator.none;

    private boolean hasDot = false;

    private boolean requiresCleaning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultText = (TextView)findViewById(R.id.resultText);

    }

	// Sample implementation of the onClickNumericalButton (...). 
	// Feel free to re-implement or modidy.
    public void onClickNumericalButton(View view) {
		
		
        //Getting ID of pressed Button
        int pressID = view.getId();

        //If we had an equal sign pressed last, standard operation is to clean
        if (opp == Operator.eq) {
            opp = Operator.none;
            resultText.setText("");
        }

        if (requiresCleaning) {
            requiresCleaning = false;
            hasDot = false;
            resultText.setText("");
        }

        //Figuring out which button was pressed and updating the represented text field object
        if (pressID == R.id.button0) {
            resultText.setText(resultText.getText() + "0");
        } else if (pressID == R.id.button1) {
            resultText.setText(resultText.getText() + "1");
        } else if (pressID == R.id.button2) {
            resultText.setText(resultText.getText() + "2");
        } else if (pressID == R.id.button3) {
            resultText.setText(resultText.getText() + "3");
        } else if (pressID == R.id.button4) {
            resultText.setText(resultText.getText() + "4");
        } else if (pressID == R.id.button5) {
            resultText.setText(resultText.getText() + "5");
        } else if (pressID == R.id.button6) {
            resultText.setText(resultText.getText() + "6");
        } else if (pressID == R.id.button7) {
            resultText.setText(resultText.getText() + "7");
        } else if (pressID == R.id.button8) {
            resultText.setText(resultText.getText() + "8");
        } else if (pressID == R.id.button9) {
            resultText.setText(resultText.getText() + "9");
        } else if (pressID == R.id.buttonDot) {
            if (!hasDot) {
                resultText.setText(resultText.getText() + ".");
                hasDot = true;
            }
        } else {
            resultText.setText("ERROR");
        }

    }

    public void onClickFunctionButton(View view) {
		// Add your code here...
        //get the id of the pressed button
        int pressID = view.getId();

        //get the text from result text
        String dataText = resultText.getText().toString();

        double numberVal = dataText.length() > 0  ? Double.parseDouble(dataText) : 0;
        if(opp == Operator.none)
        {
            //if pressed button is not an operator, store the first number to data01
            data01 = numberVal;

            requiresCleaning = true;

            if(pressID == R.id.buttonEq)
            {
                opp = Operator.eq;
            }
            else if(pressID == R.id.buttonMul)
            {
                opp = Operator.mul;
            }
            else if (pressID == R.id.buttonDiv)
            {
                opp = Operator.div;
            }
            else if (pressID == R.id.buttonMinus)
            {
                opp = Operator.sub;
            }
            else if (pressID == R.id.buttonPlus)
            {
                opp = Operator.add;
            }

        } else {
            //only run when user pressed =
            double result = 0;

            data02 = numberVal;

            switch(opp)
            {
                case sub: result = data01 - data02; break;
                case div: result = data01 / data02; break;
                case mul: result = data01 * data02; break;
                case add: result = data01 + data02; break;
                default:break;
            }

            opp = Operator.none;
            requiresCleaning = true;
            resultText.setText(String.valueOf(result));
        }
    }

}