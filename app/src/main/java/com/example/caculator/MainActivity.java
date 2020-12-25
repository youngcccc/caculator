package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;  //引用按钮组件
import android.widget.EditText;  //引用文本编辑框组件
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //声明17个按钮和一个文本编辑框
    Button bt_num0,bt_num1,bt_num2,bt_num3,bt_num4,bt_num5,bt_num6,bt_num7,
            bt_num8,bt_num9,bt_delete,bt_div,bt_mult,bt_minus,bt_plus,bt_equal,bt_dot,bt_clear;
    private EditText et_calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //显示activity_main.xml定义的用户界面
        initViewAndListener();  //调用函数initViewAndListener()
    }

    //定义函数initViewAndListener()，用于与用户界面程序中的组件建立关联，并分别注册监听接口
    private void initViewAndListener() {
        bt_num0 = (Button)findViewById(R.id.bt_num0);
        bt_num0.setOnClickListener(this);

        bt_num1 = (Button)findViewById(R.id.bt_num1);
        bt_num1.setOnClickListener(this);


        bt_num2 =(Button) findViewById(R.id.bt_num2);
        bt_num2.setOnClickListener(this);

        bt_num3 = (Button)findViewById(R.id.bt_num3);
        bt_num3.setOnClickListener(this);

        bt_num4 = (Button)findViewById(R.id.bt_num4);
        bt_num4.setOnClickListener(this);

        bt_num5 = (Button)findViewById(R.id.bt_num5);
        bt_num5.setOnClickListener(this);

        bt_num6 = (Button)findViewById(R.id.bt_num6);
        bt_num6.setOnClickListener(this);

        bt_num7 = (Button)findViewById(R.id.bt_num7);
        bt_num7.setOnClickListener(this);

        bt_num8 = (Button)findViewById(R.id.bt_num8);
        bt_num8.setOnClickListener(this);

        bt_num9 = (Button)findViewById(R.id.bt_num9);
        bt_num9.setOnClickListener(this);

        bt_delete = (Button)findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(this);

        bt_div = (Button)findViewById(R.id.bt_div);
        bt_div.setOnClickListener(this);

        bt_mult = (Button)findViewById(R.id.bt_mult);
        bt_mult.setOnClickListener(this);

        bt_minus = (Button)findViewById(R.id.bt_minus);
        bt_minus.setOnClickListener(this);


        bt_plus = (Button)findViewById(R.id.bt_plus);
        bt_plus.setOnClickListener(this);

        bt_equal = (Button)findViewById(R.id.bt_equal);
        bt_equal.setOnClickListener(this);

        et_calc = (EditText)findViewById(R.id.et_calc);

        bt_dot = (Button)findViewById(R.id.bt_dot);
        bt_dot.setOnClickListener(this);

        bt_clear = (Button)findViewById(R.id.bt_clear);
        bt_clear.setOnClickListener(this);

    }

    private boolean lastIsOperator;  //记录当前是否进行计算操作
    private String lastOperators = "";  //记录上一次进行计算操作的结果

    private double firstNumber = 0D;  //定义并初始化第一次的取值
    private double sencondNumber = 0D;  //定义并初始化第二次的取值

    //onClick()方法，触发OnClickListener接口
    public void onClick(View v) {
        String currentText = et_calc.getText().toString();  //获取当前文本编辑框的内容
        String operatorNumber = "";  //定义并初始化操作数为””
        if (currentText.equals("0")) {  //若当前输入数为0则设置文本编辑框为””
            et_calc.setText("");
        }
        operatorNumber = et_calc.getText().toString();  //根据编辑框的内容更改操作数值
        if(!lastOperators.equals(""))  //判断上一次操作的数是否为空，非空则建立索引，随之修改当前操作数
        {
            int index = operatorNumber.lastIndexOf(lastOperators);
            operatorNumber = operatorNumber.substring(index+1);
        }

        //分别获取按钮的内容至文本编辑框
        switch (v.getId()) {
            case R.id.bt_num0:
                et_calc.setText(et_calc.getText() + "0");
                lastIsOperator = false;
                break;
            case R.id.bt_num1:
                et_calc.setText(et_calc.getText() + "1");
                lastIsOperator = false;
                break;
            case R.id.bt_num2:
                et_calc.setText(et_calc.getText() + "2");
                lastIsOperator = false;
                break;
            case R.id.bt_num3:
                et_calc.setText(et_calc.getText() + "3");
                lastIsOperator = false;
                break;
            case R.id.bt_num4:
                et_calc.setText(et_calc.getText() + "4");
                lastIsOperator = false;
                break;
            case R.id.bt_num5:
                et_calc.setText(et_calc.getText() + "5");
                lastIsOperator = false;
                break;
            case R.id.bt_num6:
                et_calc.setText(et_calc.getText() + "6");
                lastIsOperator = false;
                break;
            case R.id.bt_num7:
                et_calc.setText(et_calc.getText() + "7");
                lastIsOperator = false;
                break;
            case R.id.bt_num8:
                et_calc.setText(et_calc.getText() + "8");
                lastIsOperator = false;
                break;
            case R.id.bt_num9:
                et_calc.setText(et_calc.getText() + "9");
                lastIsOperator = false;
                break;
            case R.id.bt_dot:
                et_calc.setText(et_calc.getText() + ".");
                lastIsOperator = false;
                break;
            //归零按钮，将当前操作数直接清零
            case R.id.bt_clear:
                et_calc.setText("");
                lastIsOperator = false;
                firstNumber=0D;
                sencondNumber=0D;
                lastOperators="=";
                break;
            //清除按钮，若当前文本编辑框内容为空，点击一次则删除一个字符串
            case R.id.bt_delete:
                if (TextUtils.isEmpty(et_calc.getText())) {
                    return;
                }
                lastIsOperator = false;
                et_calc.setText(currentText.substring(0, currentText.length() - 1).length() > 0 ? currentText.substring(0, currentText.length() - 1) : "0");
                break;
            //计算按钮，若当前内容非空、或者以及上一次有操作记录且记录不是”=”的情况下，将当前的操作记录设置为+、-、*、/、=
            case R.id.bt_div:
                if ((TextUtils.isEmpty(et_calc.getText())
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    return;
                }
                opratorCalc(operatorNumber,"÷");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "÷");
                lastOperators = "÷";
                break;
            case R.id.bt_mult:
                if ((TextUtils.isEmpty(et_calc.getText())
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    return;
                }
                opratorCalc(operatorNumber,"*");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "*");
                lastOperators = "*";
                break;
            case R.id.bt_minus:
                if ((TextUtils.isEmpty(et_calc.getText())
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    return;
                }
                opratorCalc(operatorNumber,"-");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "-");
                lastOperators = "-";
                break;
            case R.id.bt_plus:
                if ((TextUtils.isEmpty(et_calc.getText())
                        || lastIsOperator) && !lastOperators.equals("=")) {
                    return;
                }
                opratorCalc(operatorNumber,"+");
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "+");
                lastOperators = "+";
                break;
            case R.id.bt_equal:
                double result = 0D;
                if(TextUtils.isEmpty(lastOperators))
                {
                    return;
                }
                opratorResult(operatorNumber);
                sencondNumber = 0D;
                lastOperators ="=";
                lastIsOperator = true;
                et_calc.setText(et_calc.getText() + "\n=" + String.valueOf(firstNumber));
                break;
        }
    }

    //运算函数，按具体操作进行+、-、*、/的运算
    private void operate(String operatorNumber)
    {
        if(sencondNumber != 0D)  //计算情况一：第二次输入的数不为0
        {
            if(lastOperators.equals("÷"))
            {
                sencondNumber = sencondNumber / Double.parseDouble(operatorNumber);
                firstNumber = firstNumber / sencondNumber;
            }
            else if(lastOperators.equals("*"))
            {
                sencondNumber = sencondNumber * Double.parseDouble(operatorNumber);
                firstNumber = firstNumber * sencondNumber;
            }
            else if(lastOperators.equals("+"))
            {
                sencondNumber = Double.parseDouble(operatorNumber);
                firstNumber = firstNumber + sencondNumber;
            }
            else if(lastOperators.equals("-"))
            {
                sencondNumber = Double.parseDouble(operatorNumber);
                firstNumber = firstNumber - sencondNumber;
            }
        }
        else   //计算情况二：第二次输入的数为0
        {
            if(lastOperators.equals("÷"))
            {
                firstNumber = firstNumber / Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("*"))
            {
                firstNumber = firstNumber * Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("+"))
            {
                firstNumber = firstNumber + Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("-"))
            {
                firstNumber= firstNumber - Double.parseDouble(operatorNumber);
            }
        }
    }
    //分别返回计算结果
    public void opratorResult(String operatorNumber)
    {
        operate(operatorNumber);

    }
    //按当前计算结果进行下一次的数据输入及计算
    public void opratorCalc(String operatorNumber,String currentOprator)
    {
        if(TextUtils.isEmpty(lastOperators))
        {
            firstNumber = Double.parseDouble(operatorNumber);
            return;
        }

        if(lastOperators.equals(currentOprator))
        {
            if(lastOperators.equals("÷"))
            {
                firstNumber = firstNumber / Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("*"))
            {
                firstNumber = firstNumber * Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("+"))
            {
                firstNumber = firstNumber + Double.parseDouble(operatorNumber);
            }
            else if(lastOperators.equals("-"))
            {
                firstNumber = firstNumber - Double.parseDouble(operatorNumber);
            }

            return;
        }
        operate(operatorNumber);

    }

}
