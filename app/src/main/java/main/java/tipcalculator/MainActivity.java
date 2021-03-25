package main.java.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText checkAmountValue;
    private EditText partySizeValue;
    private TextView fifteenPercentTip;
    private TextView twentyPercentTip;
    private TextView twentyfivePercentTip;
    private TextView fifteenPercentTotal;
    private TextView twentyPercentTotal;
    private TextView twentyfivePercentTotal;
    private Button buttonCompute;

    public double fifteenTip;
    public double twentyTip;
    public double twentyfiveTip;
    public double fifteenTotal;
    public double twentyTotal;
    public double twentyfiveTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkAmountValue = findViewById(R.id.checkAmountValue);
        partySizeValue = findViewById(R.id.partySizeValue);
        fifteenPercentTip = findViewById(R.id.fifteenPercentTipValue);
        twentyPercentTip = findViewById(R.id.twentyPercentTipValue);
        twentyfivePercentTip = findViewById(R.id.twentyfivePercentTipValue);
        fifteenPercentTotal = findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTotal = findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTotal = findViewById(R.id.twentyfivePercentTotalValue);
        buttonCompute = findViewById(R.id.buttonCompute);

    }


    public void buttonCompute(View view){
        if(view.getId() == buttonCompute.getId()){
            if(checkAmountValue.getText().toString().isEmpty() || Double.valueOf(checkAmountValue.getText().toString()) < 0 ||
                    partySizeValue.getText().toString().isEmpty() || Double.valueOf(partySizeValue.getText().toString()) < 0){
                Toast.makeText(TipCalculatorActivity.this, "Empty or incorrect value(s)", Toast.LENGTH_SHORT).show();
            }
            else{
                fifteenTip = Double.parseDouble(checkAmountValue.getText().toString()) / Integer.parseInt(partySizeValue.getText().toString()) * .15;
                fifteenPercentTip.setText(Integer.toString((int) Math.round(fifteenTip)));

                twentyTip = Double.parseDouble(checkAmountValue.getText().toString()) / Integer.parseInt(partySizeValue.getText().toString()) * .2;
                twentyPercentTip.setText(Integer.toString((int)Math.round(twentyTip)));

                twentyfiveTip = Double.parseDouble(checkAmountValue.getText().toString()) / Integer.parseInt(partySizeValue.getText().toString()) * .25;
                twentyfivePercentTip.setText(Integer.toString((int)Math.round(twentyfiveTip)));


                fifteenTotal = Double.parseDouble(checkAmountValue.getText().toString()) / Integer.parseInt(partySizeValue.getText().toString()) + Math.round(fifteenTip);
                fifteenPercentTotal.setText(Integer.toString((int) Math.round(fifteenTotal)));

                twentyTotal = Double.parseDouble(checkAmountValue.getText().toString()) / Integer.parseInt(partySizeValue.getText().toString()) + Math.round(twentyTip);
                twentyPercentTotal.setText(Integer.toString((int)Math.round(twentyTotal)));

                twentyfiveTotal = Double.parseDouble(checkAmountValue.getText().toString()) / Integer.parseInt(partySizeValue.getText().toString()) + Math.round(twentyfiveTip);
                twentyfivePercentTotal.setText(Integer.toString((int)Math.round(twentyfiveTotal)));

            }
        }
    }
}