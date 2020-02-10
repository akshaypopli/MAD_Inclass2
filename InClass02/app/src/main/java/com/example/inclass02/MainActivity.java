package com.example.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_result;
    private Button button_calculate;
    private Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_square;
    private ImageView iv_circle;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedShape;


    double length1;
    double length2;
    double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");

        et_length1 = findViewById(R.id.et_length1);
        et_length2 = findViewById(R.id.et_length2);
        tv_result = findViewById(R.id.tv_result);
        tv_shape = findViewById(R.id.tv_shape);
        button_calculate = findViewById(R.id.button_calculate);
        button_clear = findViewById(R.id.button_clear);
        iv_triangle = findViewById(R.id.iv_triangle);
        iv_square = findViewById(R.id.iv_square);
        iv_circle = findViewById(R.id.iv_circle);

        clearButton();



        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();
            }
        });

        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "triangle";
                tv_shape.setText("Triangle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.VISIBLE);
            }
        });

        iv_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "square";
                tv_shape.setText("Square");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

        iv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "circle";
                tv_shape.setText("Circle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String templength1 = et_length1.getText().toString();
                final String templength2 = et_length2.getText().toString();

                if (templength1 != null && !templength1.equals("")) {
                    length1 = Double.parseDouble(templength1);
                }

                if (templength2 != null && !templength2.equals("")) {
                    length2 = Double.parseDouble(templength2);
                }

                if (et_length1.getText().toString().equals("")) {
                    et_length1.setError("Hey, I need a value!");
                } else if (et_length2.getText().toString().equals("")) {
                    et_length2.setError("Hey, I need a value!");
                } else if (selectedShape.equals("null")) {
                    tv_result.setText("Please select a Shape!");
                }
                switch (selectedShape) {
                    case "triangle":
                        result = 0.5 * length1 * length2;
                        tv_result.setText(result+"");
                        break;
                    case "square":
                        result = length1 * length1;
                        tv_result.setText(result+"");
                        break;
                    case "circle":
                        result = 3.14 * length1 * length1;
                        tv_result.setText(result+"");
                        break;
                }
            }
        });
    }

    public void clearButton() {
        et_length1.setText("");
        et_length2.setText("");
        tv_shape.setText("Select a Shape");
        tv_result.setText("");
        et_length1.setVisibility(View.VISIBLE);
        et_length2.setVisibility(View.VISIBLE);
        selectedShape = "null";
    }
}
