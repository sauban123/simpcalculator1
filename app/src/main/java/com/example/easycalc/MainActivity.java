package com.example.easycalc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    MaterialButton buttonC,buttonMod,buttonExpo,buttonDivide,button7,button8,button9,buttonMultiply,button4;
    MaterialButton button5,button6,buttonPlus,button1,button2,button3, buttonMinus,buttonAC,button0,buttonDot,buttonEqual;

    TextView resultTv,solutionTv;
    private String input,output,newOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv=findViewById(R.id.result_tv);
        solutionTv=findViewById(R.id.solution_tv);
        assignId(buttonC,R.id.button_C);
        assignId(buttonMod,R.id.button_mod);
        assignId(buttonExpo,R.id.button_expo);
        assignId(buttonDivide,R.id.button_divide);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
        assignId(buttonMultiply,R.id.button_multiply);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(buttonPlus,R.id.button_plus);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonAC,R.id.button_ac);
        assignId(button0,R.id.button_0);
        assignId(buttonDot,R.id.button_dot);
        assignId(buttonEqual,R.id.button_equals);
    }
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialButton button = (MaterialButton) v;
                String data = button.getText().toString();
                switch (data){
                    case "C":
                    case "AC":
                        input = null;
                        output=null;
                        newOutput=null;
                        resultTv.setText("");
                        break;
                    case "*":
                        solve();
                        input+="*";
                        break;
                    case "=":
                        solve();
                        break;
                    case "%" :
                        solve();
                        input+="%";
                        break;
                    case "^":
                        solve();
                        input+="^";
                        break;
                    default:
                        if(input==null){
                            input="";
                        }
                        if(data.equals("+")||data.equals("/")||data.equals("-")){
                            solve();
                        }
                        input+=data;
                }
                solutionTv.setText(input);

            }
        });
    }






    private void solve()
    {
        if(input.split("\\+").length==2){
            String numbers[]=input.split("\\+");
            try {
                double d=Double.parseDouble(numbers[0])+Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                resultTv.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                resultTv.setText(e.getMessage().toString());
            }
        }
        if(input.split("\\%").length==2){
            String numbers[]=input.split("\\%");
            try {
                double d=Double.parseDouble(numbers[0])%Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                resultTv.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                resultTv.setText(e.getMessage().toString());
            }
        }
        if(input.split("\\^").length==2){
            String numbers[]=input.split("\\^");
            try {
                double d=Math.pow(Double.parseDouble(numbers[0]),Double.parseDouble(numbers[1])) ;
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                resultTv.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                resultTv.setText(e.getMessage().toString());
            }
        }
        if(input.split("\\*").length==2){
            String numbers[]=input.split("\\*");
            try {
                double d=Double.parseDouble(numbers[0])*Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                resultTv.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                resultTv.setText(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length==2){
            String numbers[]=input.split("\\/");
            try {
                double d=Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                output=Double.toString(d);
                newOutput=cutDecimal(output);
                resultTv.setText(newOutput);
                input=d+"";
            }catch (Exception e){
                resultTv.setText(e.getMessage().toString());
            }
        }
        if(input.split("\\-").length==2){
            String numbers[]=input.split("\\-");
            try {
                if(Double.parseDouble(numbers[0])<Double.parseDouble(numbers[1])){


                    double d=Double.parseDouble(numbers[1])-Double.parseDouble(numbers[0]);
                    output=Double.toString(d);
                    newOutput=cutDecimal(output);
                    resultTv.setText("-"+newOutput);
                    input=d+"";}
                else {
                    double d=Double.parseDouble(numbers[0])-Double.parseDouble(numbers[1]);
                    output=Double.toString(d);
                    newOutput=cutDecimal(output);
                    resultTv.setText(newOutput);
                    input=d+"";
                }
            }catch (Exception e){
                resultTv.setText(e.getMessage().toString());
            }
        }

    }
    private String cutDecimal(String number){
        String n[]=number.split("\\.");
        if(n.length>1)
        {
            if(n[1].equals("0")){
                number=n[0];
            }
        }
        return number;
    }
}