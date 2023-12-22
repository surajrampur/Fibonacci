package com.example.fibbo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputNumber;
    Button calculateButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.input_number);
        calculateButton = findViewById(R.id.calculate_button);
        resultText = findViewById(R.id.result_text);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputNumber.getText().toString();
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    String fibonacciSeries = generateFibonacciSeries(number);
                    resultText.setText("Fibonacci series up to " + number + " is: " + fibonacciSeries);
                } else {
                    resultText.setText("Please enter a number.");
                }
            }
        });
    }

    private String generateFibonacciSeries(int n) {
        StringBuilder series = new StringBuilder();
        int first = 0;
        int second = 1;
        series.append(first).append(", ");
        while (second <= n) {
            series.append(second).append(", ");
            int temp = first + second;
            first = second;
            second = temp;
        }
        return series.toString();
    }
}