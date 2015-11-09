package com.studyandroid.dongwan.calculation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* variable declare */
    String value;
    int length;
    int index1;
    int index2;
    float result;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiple;
    Button buttonDivide;
    Button buttonReset;
    Button buttonResult;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.main_textview);

        button0 = (Button) findViewById(R.id.main_cal_0);
        button1 = (Button) findViewById(R.id.main_cal_1);
        button2 = (Button) findViewById(R.id.main_cal_2);
        button3 = (Button) findViewById(R.id.main_cal_3);
        button4 = (Button) findViewById(R.id.main_cal_4);
        button5 = (Button) findViewById(R.id.main_cal_5);
        button6 = (Button) findViewById(R.id.main_cal_6);
        button7 = (Button) findViewById(R.id.main_cal_7);
        button8 = (Button) findViewById(R.id.main_cal_8);
        button9 = (Button) findViewById(R.id.main_cal_9);
        buttonPlus = (Button) findViewById(R.id.main_cal_Plus);
        buttonMinus = (Button) findViewById(R.id.main_cal_Minus);
        buttonDivide = (Button) findViewById(R.id.main_cal_divide);
        buttonMultiple = (Button) findViewById(R.id.main_cal_multiple);
        buttonReset = (Button) findViewById(R.id.main_cal_reset);
        buttonResult = (Button) findViewById(R.id.main_cal_result);

        button0.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("0");
            }
        });
        button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("1");
            }
        });
        button2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("2");
            }
        });
        button3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("3");
            }
        });
        button4.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("4");
            }
        });
        button5.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("5");
            }
        });
        button6.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("6");
            }
        });
        button7.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("7");
            }
        });
        button8.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("8");
            }
        });
        button9.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setValue("9");
            }
        });

        buttonPlus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setEvent("+");
            }
        });
        buttonMultiple.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setEvent("×");
            }
        });
        buttonMinus.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setEvent("-");
            }
        });
        buttonDivide.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                setEvent("/");
            }
        });
        buttonResult.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                value = textView.getText().toString();
                boolean checkFirst = true;
                for (int i = 0; i < value.length(); i++) {
                    index1 = value.codePointAt(i);
                    switch (index1) {
                        case 43:
                            if (checkFirst==true) {
                                result = result + Integer.parseInt(value.substring(0, i));
                                checkFirst = false;
                            }
                            if(checkFirst==false) {
                                for (int j = i + 1; j < value.length(); j++) {
                                    index2 = value.codePointAt(j);
                                    if(index2 == 43 || index2 == 45 || index2 == 215 || index2 == 247) {
                                        break;
                                    }
                                    result = result + Integer.parseInt(value.substring(i+1, j+1));
                                }
                            }
                            break;
                        case 45:
                            if (checkFirst==true) {
                                result = result + Integer.parseInt(value.substring(0, i));
                                checkFirst = false;
                            }
                            if(checkFirst==false) {
                                for (int j = i + 1; j < value.length(); j++) {
                                    index2 = value.codePointAt(j);
                                    if(index2 == 43 || index2 == 45 || index2 == 215 || index2 == 247) {
                                        break;
                                    }
                                    result = result - Integer.parseInt(value.substring(i+1, j+1));
                                }
                            }
                            break;
                        case 215:
                            if (checkFirst==true) {
                                result = result + Integer.parseInt(value.substring(0, i));
                                checkFirst = false;
                            }
                            if(checkFirst==false) {
                                for (int j = i + 1; j < value.length(); j++) {
                                    index2 = value.codePointAt(j);
                                    if(index2 == 43 || index2 == 45 || index2 == 215 || index2 == 247) {
                                        break;
                                    }
                                    result = result * Integer.parseInt(value.substring(i+1, j+1));
                                }
                            }
                            break;
                        case 247:
                            if (checkFirst==true) {
                                result = result + Integer.parseInt(value.substring(0, i));
                                checkFirst = false;
                            }
                            if(checkFirst==false) {
                                for (int j = i + 1; j < value.length(); j++) {
                                    index2 = value.codePointAt(j);
                                    if(index2 == 43 || index2 == 45 || index2 == 215 || index2 == 247) {
                                        break;
                                    }
                                    result = result / Integer.parseInt(value.substring(i+1, j+1));
                                }
                            }
                            break;
                    }
                }
                textView.setText("" + result);
                result = 0;
            }
        });
    }

    void setValue(String s) {
        value = textView.getText().toString();
        length = value.length();

        if (length == 0) {
            textView.setText("" + s);
        } else {
            textView.setText(value + s);
        }
    }

    void setEvent(String s) {
        value = textView.getText().toString();
        textView.setText(value + s);
    }

}
