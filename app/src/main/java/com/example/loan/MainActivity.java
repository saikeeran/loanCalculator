package com.example.loan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View view){
        EditText loanMoney = (EditText) findViewById(R.id.loanAmount);
        int emiAmount = Integer.parseInt(loanMoney.getText().toString());
        EditText rate = (EditText) findViewById(R.id.primeInterest);
        int emiTemp = Integer.parseInt(rate.getText().toString());
        int i =1;
        double rateOf = (double)emiTemp/12/100;
        TextView emi= (TextView) findViewById(R.id.text);
        emi.append("Amount paid with rate of interest rate of "+emiTemp+" for following years 5, 10, 15, 20, 25, 30\n");
        while(i<=6) {
            int Months =12*i*5;
            double amount = (emiAmount * rateOf * Math.pow((1 + rateOf),Months))/(Math.pow((1 + rateOf),Months)-1);
            emi.append(+i+ amount + "\n");
            i++;
            emi.append("\n");
        }
    }
}