package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.IndexOutOfBoundsException;

import com.example.calculator.Calculator;
import com.example.calculator.MyUtils;

public class MainActivity extends Activity implements View.OnClickListener {

    //log的TAG
    private static final String TAG = "MainActivity";

    //运算框
    private TextView mainText;

    //当前输入框
    private TextView nowText;

    //数字1-9
    private Button button_0;
    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;

    //运算符
    private Button button_add;// +
    private Button button_sub;  // -
    private Button button_mul;  // *
    private Button button_div;  // ÷除号
    private Button button_equal;  //=
    private Button button_point;  //小数点
    private Button button_switch;  //正负数切换
    private Button button_sqrt;  // 开方
    private Button button_left;  //左括号
    private Button button_right;  //右括号
    private Button button_sin;  //sin
    private Button button_cos;  //cos

    //功能键
    private Button button_clear;    //清除键，当前输入有内容为C,无内容为AC

    //辅助判断标识
    boolean clear_flag; //清空标识
    boolean isOp = false;  //记录当前是否进行过计算操作
    boolean isPositive = true; //判断当前nowTest是否为正数
    boolean isPoint = false;    //判断是否按过小数点
    boolean haveOp = false; //记录是否按过运算符号



    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //调用函数initViewAndListener()，用于与用户界面程序中的组件建立关联，并分别注册监听接口
        initViewAndListener();


    }

    private void initViewAndListener() {
        mainText = (TextView) findViewById(R.id.mainText);
        nowText = (TextView) findViewById(R.id.nowText);


        button_0 = (Button) findViewById(R.id.button_0);
        button_0.setOnClickListener(this);

        button_1 = (Button) findViewById(R.id.button_1);
        button_1.setOnClickListener(this);

        button_2 = (Button) findViewById(R.id.button_2);
        button_2.setOnClickListener(this);

        button_3 = (Button) findViewById(R.id.button_3);
        button_3.setOnClickListener(this);

        button_4 = (Button) findViewById(R.id.button_4);
        button_4.setOnClickListener(this);

        button_5 = (Button) findViewById(R.id.button_5);
        button_5.setOnClickListener(this);

        button_6 = (Button) findViewById(R.id.button_6);
        button_6.setOnClickListener(this);

        button_7 = (Button) findViewById(R.id.button_7);
        button_7.setOnClickListener(this);

        button_8 = (Button) findViewById(R.id.button_8);
        button_8.setOnClickListener(this);

        button_9 = (Button) findViewById(R.id.button_9);
        button_9.setOnClickListener(this);

        button_add = (Button) findViewById(R.id.button_add);
        button_add.setOnClickListener(this);

        button_sub = (Button) findViewById(R.id.button_sub);
        button_sub.setOnClickListener(this);

        button_mul = (Button) findViewById(R.id.button_mul);
        button_mul.setOnClickListener(this);

        button_div = (Button) findViewById(R.id.button_division);
        button_div.setOnClickListener(this);

        button_equal = (Button) findViewById(R.id.button_equal);
        button_equal.setOnClickListener(this);

        button_point = (Button) findViewById(R.id.button_point);
        button_point.setOnClickListener(this);

        button_switch = (Button) findViewById(R.id.button_switch);
        button_switch.setOnClickListener(this);

        button_sqrt = (Button) findViewById(R.id.button_sqrt);
        button_sqrt.setOnClickListener(this);

        button_left = (Button) findViewById(R.id.button_left);
        button_left.setOnClickListener(this);

        button_right = (Button) findViewById(R.id.button_right);
        button_right.setOnClickListener(this);

        button_sin = (Button) findViewById(R.id.button_sin);
        button_sin.setOnClickListener(this);

        button_cos = (Button) findViewById(R.id.button_cos);
        button_cos.setOnClickListener(this);

        button_clear = (Button) findViewById(R.id.button_clear);
        button_clear.setOnClickListener(this);
    }

    //onClick方法，触发onClickListener接口
    @Override
    public void onClick(View v) {
        //当前总字符串
        String currentText = mainText.getText().toString();
        //现在输入的运算数
        String currentNum = nowText.getText().toString();

        //分别获取按钮的内容至mainText和nowText中
        switch (v.getId()) {
            case R.id.button_0:
                //按下数字按键时,currentNum加上按下的数字符来；如果进行过运算的话，将nowText清零再加上按下的数字符
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);   //设置mainText为空
                    nowText.setText(currentNum + "0");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "0");
                }
                //设置按下运算符状态为无
                haveOp = false;
                break;
            case R.id.button_1:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "1");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "1");
                }
                haveOp = false;
                break;
            case R.id.button_2:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "2");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "2");
                }
                haveOp = false;
                break;
            case R.id.button_3:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "3");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "3");
                }
                haveOp = false;
                break;
            case R.id.button_4:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "4");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "4");
                }
                haveOp = false;
                break;
            case R.id.button_5:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "5");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "5");
                }
                haveOp = false;
                break;
            case R.id.button_6:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "6");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "6");
                }
                haveOp = false;
                break;
            case R.id.button_7:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "7");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "7");
                }
                haveOp = false;
                break;
            case R.id.button_8:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "8");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "8");
                }
                haveOp = false;
                break;
            case R.id.button_9:
                if (isOp) {
                    currentNum = "";
                    mainText.setText(currentNum);
                    nowText.setText(currentNum + "9");
                    isOp = false;
                } else {
                    nowText.setText(currentNum + "9");
                }
                haveOp = false;
                break;
            case R.id.button_add:
                //如果刚按完加号，则不能再按加号
                if (haveOp){
                    break;
                }
                //规范化currentNum
                currentNum = norNum(currentNum);
                //如果除号后面为0则不往后执行(条件为：miantext有数且最后是除号且nownum是0)
                Log.d(TAG, "main:" + mainText.getText().toString().length());
                Log.d(TAG, "now:" + nowText.getText().toString().length());
                if (currentText.length() >= 1 && currentText.substring(currentText.length() - 1).equals("÷") && currentNum.equals("0")) {
                    Toast.makeText(MainActivity.this, "除数不能为0！", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "除数不能为0!");
                }else {
                    //如果进行过运算后按+号，则在上一次基础上累加s
                    if (isOp) {
                        mainText.setText(currentNum + "+");
                        isOp = false;
                    } else {
                        if (isPositive) {
                            mainText.setText(currentText + currentNum + "+");
                        } else {
                            //按下+号时，先判断num正负，负数要加(),把nowText中的currentNum取出放到mainText中；除了=以外，其他运算符同理
                            mainText.setText(currentText + "(" + currentNum + ")" + "+");
                            isPositive = true;
                        }
                    }
                    nowText.setText("");

                    isPoint = false;
                    haveOp = true;
                }

                break;
            case R.id.button_sub:
                if (haveOp){
                    break;
                }
                currentNum = norNum(currentNum);
                //如果除号后面为0则不往后执行
                if (currentText.length() >= 1 && currentText.substring(currentText.length() - 1).equals("÷") && currentNum.equals("0")) {
                    Toast.makeText(MainActivity.this, "除数不能为0！", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "除数不能为0!");
                } else {
                    if (isOp) {
                        mainText.setText(currentNum + "-");
                        isOp = false;
                    } else {
                        if (isPositive) {
                            mainText.setText(currentText + currentNum + "-");
                        } else {
                            //按下+号时，先判断num正负，负数要加(),把nowText中的currentNum取出放到mainText中；除了=以外，其他运算符同理
                            mainText.setText(currentText + "(" + currentNum + ")" + "-");
                            isPositive = true;
                        }
                    }
                    nowText.setText("");

                    isPoint = false;
                    haveOp = true;
                }

                break;
            case R.id.button_mul:
                if (haveOp){
                    break;
                }
                currentNum = norNum(currentNum);
                //如果除号后面为0则不往后执行
                if (currentText.length() >= 1 && currentText.substring(currentText.length() - 1).equals("÷") && currentNum.equals("0")) {
                    Toast.makeText(MainActivity.this, "除数不能为0！", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "除数不能为0!");
                } else {
                    if (isOp) {
                        mainText.setText(currentNum + "x");
                        isOp = false;
                    } else {
                        if (isPositive) {
                            mainText.setText(currentText + currentNum + "x");
                        } else {
                            //按下+号时，先判断num正负，负数要加(),把nowText中的currentNum取出放到mainText中；除了=以外，其他运算符同理
                            mainText.setText(currentText + "(" + currentNum + ")" + "x");
                            isPositive = true;
                        }
                    }
                    nowText.setText("");

                    isPoint = false;
                    haveOp = true;
                }

                break;
            case R.id.button_division:
                if (haveOp){
                    break;
                }
                currentNum = norNum(currentNum);
                if (isOp) {
                    mainText.setText(currentNum + "÷");
                    isOp = false;
                } else {
                    if (isPositive) {
                        mainText.setText(currentText + currentNum + "÷");
                    } else {
                        //按下+号时，先判断num正负，负数要加(),把nowText中的currentNum取出放到mainText中；除了=以外，其他运算符同理
                        mainText.setText(currentText + "(" + currentNum + ")" + "÷");
                        isPositive = true;
                    }
                }
                nowText.setText("");

                isPoint = false;
                haveOp = true;
                break;
            case R.id.button_equal:
                currentNum = norNum(currentNum);
                //如果除号后面为0则不往后执行(条件为：miantext有数且最后是除号且nownum是0)
                Log.d(TAG, "main:" + mainText.getText().toString().length());
                Log.d(TAG, "now:" + nowText.getText().toString().length());
                if (currentText.length() >= 1 && currentText.substring(currentText.length() - 1).equals("÷") && currentNum.equals("0")) {
                    Toast.makeText(MainActivity.this, "除数不能为0！", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "除数不能为0!");
                    break;
                }
                //按下=号后，mianText此时是完整的运算式
                if (isPositive) {
                    mainText.setText(currentText + currentNum + "=");
                } else {
                    mainText.setText(currentText + "(" + currentNum + ")" + "=");
                    isPositive = true;
                }
                //进行过运算，设isOp为true
                isOp = true;
                //进行运算操作，把操作后的数字放在nowText中
                try {
                    Calculator calculator = new Calculator();
                    String result = calculator.prepareParam(mainText.getText().toString());
                    if (result.equals("表达式错误")){
                        Toast.makeText(MainActivity.this, "输入有误，请重新输入!", Toast.LENGTH_SHORT).show();
                        mainText.setText("");
                        nowText.setText("");
                        break;
                    }
                    nowText.setText(result);
                }catch (IndexOutOfBoundsException e){
                    Toast.makeText(MainActivity.this, "输入有误，请重新输入!", Toast.LENGTH_SHORT).show();
                    mainText.setText("");
                    nowText.setText("");
                }

                break;
            case R.id.button_point:
                //考虑直接按下小数点的情况
                if (currentNum.equals("")){
                    nowText.setText("0" + ".");
                    isPoint = true;
                    break;
                }

                if (!isPoint){
                    nowText.setText(currentNum + ".");
                    isPoint = true;
                }else {
                    Toast.makeText(MainActivity.this, "已经有小数点了哦！", Toast.LENGTH_SHORT).show();
                }

                //nowText.setText("");
                break;
            case R.id.button_switch:
                currentNum = norNum(currentNum);
                //正负数切换功能
                if (isPositive) {
                    nowText.setText("-" + currentNum);
                    isPositive = false;
                } else {
                    nowText.setText(currentNum.substring(1, currentNum.length()));
                    isPositive = true;
                }

                break;
            case R.id.button_sqrt:
                //平分开根
                if (currentNum.equals("")){
                    Toast.makeText(MainActivity.this, "请输入要求开方根数值", Toast.LENGTH_SHORT).show();
                    break;
                }
                if (isPositive) {
                    double tempNumSqrt = Math.sqrt(Double.parseDouble(currentNum));
                    String NumStrSqrt = MyUtils.formatResult(String.format("%." + MyUtils.RESULT_DECIMAL_MAX_LENGTH + "f", tempNumSqrt));

                    nowText.setText(NumStrSqrt);
                } else {
                    Toast.makeText(MainActivity.this, "负数不能开根号！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_clear:
                //根据当前清除键的标识符来判断是清除nowText还是maintext
                //待实现,逻辑有点小问题
                if (button_clear.getText() == "AC") {
                    mainText.setText("");
                    nowText.setText("");
                } else {
                    nowText.setText("");
                }

                isPoint = false;

                break;
            case R.id.button_left:
                //left
                mainText.setText(currentText + "(");

                break;
            case R.id.button_right:
                //right
                mainText.setText(currentText + currentNum + ")");
                nowText.setText("");

                break;
            case R.id.button_sin:
                //sin
                if (currentNum.equals("")){
                    Toast.makeText(MainActivity.this, "请输入要求sin的角度", Toast.LENGTH_SHORT).show();
                }else {
                    double tempNumSin = Math.sin(Math.toRadians(Double.parseDouble(currentNum)));
                    String NumStrSin = MyUtils.formatResult(String.format("%." + MyUtils.RESULT_DECIMAL_MAX_LENGTH + "f", tempNumSin));

                    nowText.setText(NumStrSin);
                }

                break;
            case R.id.button_cos:
                //cos
                if (currentNum.equals("")){
                    Toast.makeText(MainActivity.this, "请输入要求cos的角度", Toast.LENGTH_SHORT).show();
                }else {
                    double tempNumCos = Math.cos(Math.toRadians(Double.parseDouble(currentNum)));
                    String NumStrCos = MyUtils.formatResult(String.format("%." + MyUtils.RESULT_DECIMAL_MAX_LENGTH + "f", tempNumCos));

                    nowText.setText(NumStrCos);
                }

                break;
        }

        //清除键标识符切换
        //如果当前currentNum不为空的话，清除键为C，功能是只清除currentNum
        if (nowText.getText() != "" && !isOp) {
            button_clear.setText("C");
        } else {
            button_clear.setText("AC");
        }


    }

    //将currentnum规范化
    public String norNum(String currentNum){
        if (currentNum.length() >= 1 && currentNum.substring(currentNum.length() - 1).equals(".")){
            currentNum += "0";
        }

        return currentNum;
    }





}