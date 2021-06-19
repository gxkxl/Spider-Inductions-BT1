package com.example.lorentzcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button calc;
    TextView inform;
    TextView res;
    double vel;
    double square_lf;
    double lf;
    String lorentz_factor;
    final String new_val="Please enter velocity";
    final String toast="Invalid input";
    final double c= 299792458;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        res=(TextView)findViewById(R.id.result);
        inform=(TextView)findViewById(R.id.info);
        calc=(Button)findViewById(R.id.answer);
        calc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String velocity=editText.getText().toString();
                vel=Double.parseDouble(velocity);
                square_lf=(1-((vel*vel)/(c*c)));
                if (editText.getText().toString().isEmpty())
                {
                    inform.setText(new_val);

                }
                else
                {
                    if (square_lf<0)
                    {
                        inform.setText(toast);
                    }
                    else
                    {
                        lf=Math.sqrt(square_lf);
                        lorentz_factor=String.valueOf(lf);
                        res.setText(lorentz_factor);
                    }
                }

            }
        });



    }
}