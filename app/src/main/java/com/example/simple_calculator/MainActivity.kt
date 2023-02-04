package com.example.simple_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_clear.setOnClickListener{
            input.text=""
            output.text =""
        }
        button_bracket_left.setOnClickListener{
            input.text=addTpInputText("(")

        }
        button_bracket_right.setOnClickListener{
            input.text=addTpInputText(")")
        }
        button_0.setOnClickListener{
            input.text=addTpInputText("0")
        }
        button_1.setOnClickListener{
            input.text=addTpInputText("1")
        }
        button_2.setOnClickListener{
            input.text=addTpInputText("2")
        }
        button_3.setOnClickListener{
            input.text=addTpInputText("3")
        }
        button_4.setOnClickListener{
            input.text=addTpInputText("4")
        }
        button_5.setOnClickListener{
            input.text=addTpInputText("5")
        }
        button_6.setOnClickListener{
            input.text=addTpInputText("6")
        }
        button_7.setOnClickListener{
            input.text=addTpInputText("7")
        }
        button_8.setOnClickListener{
            input.text=addTpInputText("8")
        }
        button_9.setOnClickListener{
            input.text=addTpInputText("9")
        }
        button_dot.setOnClickListener{
            input.text=addTpInputText(".")
        }
        button_division.setOnClickListener{
            input.text=addTpInputText("÷")
        }
        button_multiply.setOnClickListener{
            input.text=addTpInputText("×")
        }
        button_subtraction.setOnClickListener{
            input.text=addTpInputText("-")
        }
        button_addition.setOnClickListener{
            input.text=addTpInputText("+")
        }
        button_equals.setOnClickListener{
            showResult()
        }

    }
    private fun getInputExpression():String{
        var expression =input.text.replace(Regex("÷"),"/")
        expression =expression.replace(Regex("×"),"*")
        return expression

    }
    private fun showResult(){
        try {
            val exception =getInputExpression()
            val result = Expression(exception).calculate()
            if(result.isNaN()){
                //show error Message
                output.text ="Error"
                output.setTextColor(ContextCompat.getColor(this,R.color.red))
            }
            else {
                //show Result
                output.text = DecimalFormat("0.######").format(result)
                output.setTextColor(ContextCompat.getColor(this,R.color.blue))
            }
        }catch (e:Exception) {
            //show error Message
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }




    private fun addTpInputText (buttonValue:String):String{
        return "${input.text}$buttonValue"
    }
}