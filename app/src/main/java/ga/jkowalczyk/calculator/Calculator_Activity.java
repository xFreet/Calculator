package ga.jkowalczyk.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;


public class Calculator_Activity extends AppCompatActivity {

    TextView result;
    String operation,content;
    Float value_of_result,number1,number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        value_of_result= 0f;
        Log.e("max value",""+Float.MAX_VALUE);
        setContentView(R.layout.activity_calculator_);
    }

    public void math_operation(String name_operation)
    {
        number1=Float.valueOf(String.valueOf(result.getText()));
        result.setText(""+0);
        operation=""+name_operation;
    }
    public void substitution (String number)
    {
        result=(TextView)findViewById(R.id.result);
        if (result != null) {
            content=result.getText().toString();
        }
        Log.e("length",""+content.length());
        if(content.length()<10)
        {
            if (content.equals("0")) {
                result.setText("" + number);
            } else {
                result.setText(content + "" + number);
            }
        }
    }
    public void ac(View view) {
        result=(TextView)findViewById(R.id.result);
        if (result != null) {
            result.setText("0");
        }
        operation="0";
        result.setTextSize(50);
    }

    public void change_sign(View view) {
        result=(TextView)findViewById(R.id.result);
        Float i_content= null;
        if (result != null) {
            i_content = Float.valueOf(String.valueOf(result.getText()));
        }
        result.setText(""+i_content*-1);
    }

    public void multiplication(View view) {
        math_operation("multiplication");
    }

    public void subtraction(View view) {
        math_operation("subtraction");
    }

    public void addition(View view) {
        math_operation("add");
    }

    public void division(View view) {
        math_operation("division");
    }

    public void comma(View view) {
        if(!result.getText().toString().contains("."))
        {
            result.setText(result.getText().toString()+".");
        }
    }

    public void equal(View view) {
        number2= Float.valueOf(String.valueOf(result.getText()));
        switch (operation) {
            case "add":
                value_of_result = number1 + number2;
                break;
            case "division":
                if (number2 != 0) {
                    value_of_result = number1 / number2;
                } else
                    value_of_result = Float.valueOf(0);
                break;
            case "multiplication":
                value_of_result = number1 * number2;
                break;
            case "subtraction":
                value_of_result = number1 - number2;
                break;
        }
        result.setText(""+value_of_result);
        int length=result.getText().length();
        if(length>10)
            result.setTextSize(TypedValue.COMPLEX_UNIT_SP,(result.getWidth()/length)-10);
    }

    public void b0(View view) {
        substitution("0");
    }
    public void b1(View view) {
        substitution("1");
    }
    public void b2(View view) {
        substitution("2");
    }
    public void b3(View view) {
        substitution("3");
    }
    public void b4(View view) {
        substitution("4");
    }
    public void b5(View view) {
        substitution("5");
    }
    public void b6(View view) {
        substitution("6");
    }
    public void b7(View view) {
        substitution("7");
    }
    public void b8(View view) {
        substitution("8");
    }
    public void b9(View view) {
        substitution("9");
    }
}
