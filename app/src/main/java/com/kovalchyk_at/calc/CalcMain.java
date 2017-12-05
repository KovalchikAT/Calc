package com.kovalchyk_at.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcMain extends AppCompatActivity {
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btnClear;
    private Button btnDecr;
    private Button btnDel;
    private Button btnDiv;
    private Button btndiv;
    private Button btnDot;
    private Button btnEnter;
    private Button btnIncr;
    private Button btnMod;
    private Button btnMult;
    private Button btnNeg;

    private TextView tvLog;
    private TextView tvResalt;

    private Double resultDouble;
    private Double firstDouble;

    private String resultStr;
    Button.OnClickListener digitOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button current = (Button) view;
            resultStr = (String) tvResalt.getText() + (String) current.getText();
            tvResalt.setText(resultStr);
        }
    };
    private String operation;
    Button.OnClickListener operationOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button current = (Button) view;
            resultStr = (String) tvResalt.getText();
            if (resultStr.isEmpty()) {
                resultStr = "0.0";
            }
            resultDouble = Double.parseDouble(resultStr);

            switch (current.getId()) {
                case R.id.btnNeg:
                    if (resultDouble < 0) {
                        resultStr = resultStr.substring(1);
                    } else {
                        resultStr = "-" + resultStr;
                    }
                    tvResalt.setText(resultStr);
                    resultDouble = Double.parseDouble(resultStr);
                    break;
                case R.id.btnClear:
                    resultDouble = 0.0;
                    tvResalt.setText("");
                    break;
                case R.id.btnDecr:
                    setOperatoin("-");
                    break;
                case R.id.btnDel:
                    String str = (String) tvResalt.getText();
                    tvResalt.setText(str.substring(0, str.length() - 1));
                    resultDouble = Double.parseDouble(resultStr);
                    break;
                case R.id.btnDiv:
                    setOperatoin("/");
                    break;
                case R.id.btndiv:
                    setOperatoin("div");
                    break;
                case R.id.btnEnter:
                    switch (operation) {
                        case "+":
                            resultDouble = firstDouble + Double.parseDouble(resultStr);
                            break;
                        case "-":
                            resultDouble = firstDouble - Double.parseDouble(resultStr);
                            break;
                        case "*":
                            resultDouble = firstDouble * Double.parseDouble(resultStr);
                            break;
                        case "/":
                            resultDouble = firstDouble / Double.parseDouble(resultStr);
                            break;
                        case "mod":
                            resultDouble = firstDouble % Double.parseDouble(resultStr);
                            break;
                        case "div":
                            resultDouble = firstDouble + Double.parseDouble(resultStr);
                            break;
                    }
                    tvLog.setText(tvLog.getText() + firstDouble.toString() + operation + resultStr + "=" + resultDouble.toString() + "\n");
                    firstDouble = resultDouble;
                    tvResalt.setText(resultDouble.toString());
                    break;
                case R.id.btnDot:
                    break;
                case R.id.btnIncr:
                    setOperatoin("+");
                    break;
                case R.id.btnMod:
                    setOperatoin("mod");
                    break;
                case R.id.btnMult:
                    setOperatoin("*");
                    break;
            }
        }
    };

    protected void setOperatoin(String operation) {
        this.operation = operation;
        firstDouble = resultDouble;
        resultDouble = 0.0;
        tvResalt.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_main);

        initBtn();
        setListeners();

    }

    private void setListeners() {
        btn0.setOnClickListener(digitOnClick);
        btn1.setOnClickListener(digitOnClick);
        btn2.setOnClickListener(digitOnClick);
        btn3.setOnClickListener(digitOnClick);
        btn4.setOnClickListener(digitOnClick);
        btn5.setOnClickListener(digitOnClick);
        btn6.setOnClickListener(digitOnClick);
        btn7.setOnClickListener(digitOnClick);
        btn8.setOnClickListener(digitOnClick);
        btn9.setOnClickListener(digitOnClick);
        btnDot.setOnClickListener(digitOnClick);
        btnClear.setOnClickListener(operationOnClick);
        btnDecr.setOnClickListener(operationOnClick);
        btnDel.setOnClickListener(operationOnClick);
        btnDiv.setOnClickListener(operationOnClick);
        btndiv.setOnClickListener(operationOnClick);
        btnEnter.setOnClickListener(operationOnClick);
        btnIncr.setOnClickListener(operationOnClick);
        btnMod.setOnClickListener(operationOnClick);
        btnMult.setOnClickListener(operationOnClick);
        btnNeg.setOnClickListener(operationOnClick);
    }

    private void initBtn() {
        tvResalt = findViewById(R.id.resaltTV);
        tvLog = findViewById(R.id.Log);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnNeg = findViewById(R.id.btnNeg);
        btnClear = findViewById(R.id.btnClear);
        btnDecr = findViewById(R.id.btnDecr);
        btnDel = findViewById(R.id.btnDel);
        btnDiv = findViewById(R.id.btnDiv);
        btndiv = findViewById(R.id.btndiv);
        btnDot = findViewById(R.id.btnDot);
        btnEnter = findViewById(R.id.btnEnter);
        btnIncr = findViewById(R.id.btnIncr);
        btnMod = findViewById(R.id.btnMod);
        btnMult = findViewById(R.id.btnMult);

    }

}

