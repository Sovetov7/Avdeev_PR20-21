package com.example.avdeev_pr20_21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.goraceantuh.GameTask
import com.example.goraceantuh.GameView

class MainActivity : AppCompatActivity(), GameTask {
    lateinit var rootLayout: LinearLayout
    lateinit var startBtn: Button
    lateinit var mGameView: GameView
    lateinit var score: TextView
    lateinit var imagecar: ImageView
    lateinit var NameGame: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView = GameView(this,this)
        imagecar = findViewById(R.id.imagecar)
        NameGame = findViewById(R.id.NameGame)

        startBtn.setOnClickListener{
            mGameView.setBackgroundResource(R.drawable.road)
            rootLayout.addView(mGameView)
            startBtn.visibility = View.GONE
            score.visibility = View.GONE

            imagecar.visibility = View.GONE
            NameGame.visibility = View.GONE


        }
    }
    override fun closeGame(mScore: Int) {
        score.text = "Score : $mScore"
        rootLayout.removeView(mGameView)
        mGameView = GameView(this,this)//)
        startBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
        imagecar.visibility = View.VISIBLE
        NameGame.visibility = View.VISIBLE
    }
}