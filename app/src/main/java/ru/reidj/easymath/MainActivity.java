package ru.reidj.easymath;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumber;
    private EditText secondNumber;
    private TextView result;
    private double res = 0;
    private double x;
    private double x1, x2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Инициализация переменных*/
        firstNumber = findViewById(R.id.FirstNumber);
        secondNumber = findViewById(R.id.SecondNumber);
        result = findViewById(R.id.Result);
    }

    @SuppressLint("SetTextI18n")
    public void onClick(View v) {
        if (TextUtils.isEmpty(firstNumber.getText().toString()) || TextUtils.isEmpty(secondNumber.getText().toString()))
            return;
        /*Создание переменных*/
        double num1 = Double.parseDouble(firstNumber.getText().toString());
        double num2 = Double.parseDouble(secondNumber.getText().toString());
        /*Определяю нажатую кнопку и провожу апперацию с числами*/
        switch (v.getId()) {
            case R.id.Plus:
                res = num1 + num2;
                break;
            case R.id.Minus:
                res = num1 - num2;
                break;
            case R.id.Multiply:
                res = num1 * num2;
                break;
            case R.id.Share:
                res = num1 / num2;
                break;
        }
        result.setText("" + res);
    }

    @SuppressLint("SetTextI18n")
    public void discriminant(View v) {
        EditText firstRoot = findViewById(R.id.a);
        EditText secondRoot = findViewById(R.id.b);
        EditText thirdRoot = findViewById(R.id.c);
        TextView resultRoot = findViewById(R.id.ResultRoot);

        if(TextUtils.isEmpty(firstRoot.getText().toString()) || TextUtils.isEmpty(secondRoot.getText().toString()) || TextUtils.isEmpty(thirdRoot.getText().toString()))
            return;

        double root1 = Double.parseDouble(firstRoot.getText().toString());
        double root2 = Double.parseDouble(secondRoot.getText().toString());
        double root3 = Double.parseDouble(thirdRoot.getText().toString());

        if (v.getId() == R.id.SolveRoot) {
            double d = root2 * root2 - 4 * root1 * root3;
            if (d > 0) {
                x1 = ((-1) * root2 + Math.sqrt(d)) / (2 * root1);
                x2 = ((-1) * root2 - Math.sqrt(d)) / (2 * root1);
                resultRoot.setText("x1 = " + x1 + " x2 = " + x2);
            } else if (d == 0) {
                x = ((-1) * root2/ (2 * root1));
                resultRoot.setText("Уравнение имеет 1 корень = " + x);
            } else
                resultRoot.setText("Уравнение не имеет корней");
        }
    }
}
