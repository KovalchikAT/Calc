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
    private TextView tvResult;
    private TextView tvClearLog;

    private Double resultDouble;
    private Double firstDouble;

    private String resultStr;
    private String operation;

    Button.OnClickListener digitOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button current = (Button) view;
            resultStr = (String) tvResult.getText() + (String) current.getText();
            tvResult.setText(resultStr);
        }
    };

    TextView.OnClickListener tvOnClick = new TextView.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView current = (TextView) view;
            switch (current.getId()) {
                case R.id.tvClearLog:
                    tvLog.setText("");
            }
        }
    };

    Button.OnClickListener operationOnClick = new Button.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button current = (Button) view;
            resultStr = (String) tvResult.getText();
            if (resultStr.isEmpty()) {
                resultStr = "0.0";
            }

            resultDouble = Double.parseDouble(resultStr);

            switch (current.getId()) {
                case R.id.btnNeg:
                    if (resultDouble == 0) {
                        resultStr = "0";
                    } else {
                        if (resultDouble < 0) {
                            resultStr = resultStr.substring(1);
                        } else {
                            resultStr = "-" + resultStr;
                        }
                    }
                    tvResult.setText(resultStr);
                    resultDouble = Double.parseDouble(resultStr);
                    break;
                case R.id.btnClear:
                    resultDouble = 0.0;
                    tvResult.setText("");
                    break;
                case R.id.btnDecr:
                    setOperatoin("-");
                    break;
                case R.id.btnDel:
                    String str = (String) tvResult.getText();
                    if (str.length() > 0) {
                        tvResult.setText(str.substring(0, str.length() - 1));
                        resultDouble = Double.parseDouble(resultStr);
                    } else {
                        resultStr = "";
                        resultDouble = 0.0;
                    }
                    break;
                case R.id.btnDiv:
                    setOperatoin("/");
                    break;
                case R.id.btndiv:
                    setOperatoin("div");
                    break;
                case R.id.btnEnter:
                    if (operation != null) {
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
                            default:
                                break;
                        }
                        tvLog.setText(tvLog.getText() + firstDouble.toString() + operation + resultStr + "=" + resultDouble.toString() + "\n");
                        firstDouble = resultDouble;
                        tvResult.setText(resultDouble.toString());
                    }
                    break;
                case R.id.btnDot:
                    if (!((String) tvResult.getText()).contains(current.getText())){
                    resultStr = (String) tvResult.getText() + (String) current.getText();
                    tvResult.setText(resultStr);}
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
        tvResult.setText("");
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
        btnDot.setOnClickListener(operationOnClick);
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
        tvClearLog.setOnClickListener(tvOnClick);
    }

    private void initBtn() {
        tvResult = findViewById(R.id.tvResalt);
        tvLog = findViewById(R.id.tvLog);
        tvClearLog = findViewById(R.id.tvClearLog);

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

