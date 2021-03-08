package com.example.gpa_sherryb1_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button gpacompute;
    EditText number1,number2,number3,number4,number5;
    TextView score;
    int count=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gpacompute=(Button)findViewById(R.id.compute);
        number1=(EditText)findViewById(R.id.grade1);
        number2=(EditText)findViewById(R.id.grade2);
        number3=(EditText)findViewById(R.id.grade3);
        number4=(EditText)findViewById(R.id.grade4);
        number5=(EditText)findViewById(R.id.grade5);
        score=(TextView)findViewById(R.id.gpascore);
        score.setBackgroundColor(Color.WHITE);
        gpacompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float floatnum1, floatnum2, floatnum3, floatnum4, floatnum5;
                if (count % 2 == 0) {
                    if (number1.getText().toString().equals("") || number2.getText().toString().equals("") || number3.getText().toString().equals("") || number4.getText().toString().equals("") || number5.getText().toString().equals("")) {
                        score.setText("Enter grades in all fields");
                    }
                    else {
                        floatnum1 = Float.parseFloat(number1.getText().toString());
                        floatnum2 = Float.parseFloat(number2.getText().toString());
                        floatnum3 = Float.parseFloat(number3.getText().toString());
                        floatnum4 = Float.parseFloat(number4.getText().toString());
                        floatnum5 = Float.parseFloat(number5.getText().toString());
                        float gpaavg = floatnum1 + floatnum2 + floatnum3 + floatnum4 + floatnum5;
                        gpaavg = gpaavg / 5;
                        if (gpaavg < 60) {
                            score.setText(Float.toString(gpaavg));
                            score.setBackgroundColor(Color.RED);
                            gpacompute.setText("Clear Form");
                        } else if (gpaavg > 60 && gpaavg < 80) {
                            score.setText(Float.toString(gpaavg));
                            score.setBackgroundColor(Color.YELLOW);
                            gpacompute.setText("Clear Form");
                        } else if (gpaavg >= 80 && gpaavg <= 100) {
                            score.setText(Float.toString(gpaavg));
                            score.setBackgroundColor(Color.GREEN);
                            gpacompute.setText("Clear Form");
                        }
                        count++;

                    }

                }
                else {
                number1.setText("");
                number2.setText("");
                number3.setText("");
                number4.setText("");
                number5.setText("");
                score.setText("");
                gpacompute.setText("Compute GPA");
                score.setBackgroundColor(Color.WHITE);
                count++;
                }
            }
        });
    }
}

