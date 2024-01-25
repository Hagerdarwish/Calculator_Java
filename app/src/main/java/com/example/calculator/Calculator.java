package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
TextView resultTv;
String operator="";
String lhs="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        resultTv=findViewById(R.id.tv);
    }
public void onClearClick(View v){
    if(v instanceof Button){
        Button clickedDigit=(Button) v;
        if(!resultTv.getText().toString().isEmpty()){
            resultTv.setText("");
        }}
}
public void onDeletClicked(View v){
        if(v instanceof Button) {
           Button ClickedDigit=(Button) v;
            resultTv.getText().toString().substring(resultTv.getText().length()-2,resultTv.getText().length()-1);
        }

}
    public void onDigitClick(View v){
        if(v instanceof Button){
        Button clickedDigit=(Button) v;

            resultTv.append(clickedDigit.getText());


        }}
   public boolean isInteger(String num){
        try {
            Integer.parseInt(num);
            return true;
        }catch (Exception e){
            return  false;
        }

    }
    public void onOperatorClick(View v){
        Button clickedOperator=(Button) v;
        Log.e("resulttv",resultTv.getText().toString());

        if(isInteger(resultTv.getText().toString()) || lhs==""){
            if(operator.isEmpty()){

                lhs=resultTv.getText().toString();

            }
            else {

                String rhs=resultTv.getText().toString();
                lhs=  calculate(lhs,operator,rhs);}
            operator=clickedOperator.getText().toString();
            resultTv.setText("");
            Log.e("operationClick","lhs"+lhs+"operator"+operator);

        }else {
            resultTv.setText("input error");



        }




    }

    private String calculate(String lhs, String operator, String rhs) {
        double n1 = Double.parseDouble(lhs);
        if(!rhs.isEmpty() ){
        double n2 = Double.parseDouble(rhs);
        if (operator.equals("+")) {
            return ((Double)(n1 + n2)).toString();
        } else if (operator.equals("-")) {
            return ((Double)(n1 - n2)).toString();
        } else if (operator.equals("/")) {
            return ((Double)(n1 / n2)).toString();
        } else if (operator.equals("*")) {
            return ((Double)(n1 * n2)).toString();
        }else if (operator.equals("^")) {
            return String.valueOf(Math.pow(n1, n2)) ;}
        else if (operator.equals("√")) {

            return String.valueOf(Math.sqrt(n1));}

    }
        return "error";
    }


    public void onEqualClick(View v){
        if(!lhs.isEmpty()){
        String rhs= resultTv.getText().toString();
        resultTv.setText(calculate(lhs,operator,rhs));
        lhs="";
        operator="";}else {
            resultTv.setText("enter value");
        }

    }
}