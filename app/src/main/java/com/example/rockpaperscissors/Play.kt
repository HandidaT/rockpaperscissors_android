package com.example.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class Play : AppCompatActivity() {
    private lateinit var Computer: TextView
    private lateinit var Computeroutput: TextView
    private lateinit var YourTurn: TextView
    private lateinit var YourScore: TextView
    private lateinit var Score: TextView
    private lateinit var rockb: Button
    private lateinit var paperb: Button
    private lateinit var scissorb: Button

    private val Rock=0
    private val PAPER=1
    private val SCISSOR=2
    private val WIN=1
    private val LOSE=-1
    private val DRAW=0
    private var totalScore=0
    override fun onCreate(savedInstanceState: Bundle?) {
        Computer = findViewById(R.id.computer)
        Computeroutput = findViewById(R.id.computeroutput)
        YourTurn = findViewById(R.id.YourTurn)
        YourScore = findViewById(R.id.YourScore)
        Score = findViewById(R.id.Score)
        rockb = findViewById(R.id.rock)
        paperb = findViewById(R.id.paper)
        scissorb = findViewById(R.id.scissor)
        YourScore.text="0"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        rockb.setOnClickListener {
            var computermove : Int = Random().nextInt(3)
           // Computeroutput.text="rock"
            var r = choosedOption(0,computermove)
        }
        paperb.setOnClickListener {
            var computermove : Int = Random().nextInt(3)
            var r = choosedOption(1,computermove)
        }
        scissorb.setOnClickListener {
            var computermove : Int = Random().nextInt(3)
            var r = choosedOption(2,computermove)
        }
    }

    fun choosedOption(you:Int,cpu:Int):Int{
        if(you==Rock){
            if(cpu==Rock){
                return DRAW
            }
            else if(cpu==PAPER){
                return LOSE
            }
            else{
                return WIN
            }
        }
        else if(you==PAPER){
            if(cpu==PAPER){
                return DRAW
            }
            else if(cpu==SCISSOR){
                return LOSE
            }
            else{
                return WIN
            }
        }
        else{
            if(cpu==SCISSOR){
                return DRAW
            }
            else if(cpu==Rock){
                return LOSE
            }
            else{
                return WIN
            }
        }
    }

    fun result(r:Int){
        if(r==WIN){
            totalScore+=1;
        }
        else if(r==LOSE){
            totalScore-=1;
        }
    }
}