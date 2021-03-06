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
    private EditText firstRoot;
    private EditText secondRoot;
    private EditText thirdRoot;
    private EditText cubeNumber;
    private TextView result;
    private double res = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Инициализация переменных*/
        firstNumber = findViewById(R.id.FirstNumber);
        firstRoot = findViewById(R.id.a);
        secondNumber = findViewById(R.id.SecondNumber);
        secondRoot = findViewById(R.id.b);
        thirdRoot = findViewById(R.id.c);
        cubeNumber = findViewById(R.id.CubeNumber);
        result = findViewById(R.id.Result);

    }

    @SuppressLint("SetTextI18n")
    public void onClick(View v) {
        /*Проверка на пустые поля*/
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
            case R.id.Square:
                res = Math.pow(num1, num2);
                result.setText("" + res);
            default:
                break;
        }
        result.setText("" + res);
    }

    @SuppressLint("SetTextI18n")
    public void onDiscriminant(View v) {
        if (TextUtils.isEmpty(firstRoot.getText().toString()) || TextUtils.isEmpty(secondRoot.getText().toString()) || TextUtils.isEmpty(thirdRoot.getText().toString()))
            return;

        double root1 = Double.parseDouble(firstRoot.getText().toString());
        double root2 = Double.parseDouble(secondRoot.getText().toString());
        double root3 = Double.parseDouble(thirdRoot.getText().toString());

        if (v.getId() == R.id.SolveRoot) {
            double d = root2 * root2 - 4 * root1 * root3;
            if (d > 0) {
                double x1 = ((-1) * root2 + Math.sqrt(d)) / (2 * root1);
                double x2 = ((-1) * root2 - Math.sqrt(d)) / (2 * root1);
                result.setText("x1 = " + x1 + " x2 = " + x2);
            } else if (d == 0) {
                double x = ((-1) * root2 / (2 * root1));
                result.setText("Уравнение имеет 1 корень = " + x);
            } else
                result.setText("Уравнение не имеет корней");
        }
    }

    public void onClear(View v) {
        /*Очистка полей*/
        firstNumber.setText(null);
        secondNumber.setText(null);
        firstRoot.setText(null);
        secondRoot.setText(null);
        thirdRoot.setText(null);
        cubeNumber.setText(null);
    }

    @SuppressLint("SetTextI18n")
    public void onCube(View v) {
        if (TextUtils.isEmpty(cubeNumber.getText().toString()))
            return;
        int num = Integer.parseInt(cubeNumber.getText().toString());

        switch (v.getId()) {
            case R.id.Cube:
                result.setText("∛ =  " + Math.cbrt(num));
                break;
            case R.id.Sqrt:
                result.setText("√ = " + Math.sqrt(num));
                break;
            case R.id.Sinus:
                result.setText("" + Math.sin(Math.toRadians(num)));
                break;
            case R.id.Cosinus:
                result.setText("" + Math.cos(Math.toRadians(num)));
                break;
            case R.id.Tangens:
                result.setText("" + Math.tan(Math.toRadians(num)));
            case R.id.Log10:
                result.setText("" + Math.log10(num));
                break;
            case R.id.Log:
                result.setText("" + Math.log(num));
                break;
            case R.id.Bin:
                String convert = Integer.toBinaryString(num);
                result.setText(convert);
                break;
            case R.id.Oct:
                convert = Integer.toOctalString(num);
                result.setText(convert);
                break;
            case R.id.Dec:
                convert = Integer.toHexString(num);
                result.setText(convert);
                break;
            default:
                break;
        }
    }
}
