package com.example.tongyu.game2048;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponent();
        startGame();
    }

    public void initializeComponent()
    {
        cards[0][0] = new Card( (TextView) findViewById(R.id.card1) );
        cards[0][1] = new Card( (TextView) findViewById(R.id.card2) );
        cards[0][2] = new Card( (TextView) findViewById(R.id.card3) );
        cards[0][3] = new Card( (TextView) findViewById(R.id.card4) );
        cards[1][0] = new Card( (TextView) findViewById(R.id.card5) );
        cards[1][1] = new Card( (TextView) findViewById(R.id.card6) );
        cards[1][2] = new Card( (TextView) findViewById(R.id.card7) );
        cards[1][3] = new Card( (TextView) findViewById(R.id.card8) );
        cards[2][0] = new Card( (TextView) findViewById(R.id.card9) );
        cards[2][1] = new Card( (TextView) findViewById(R.id.card10) );
        cards[2][2] = new Card( (TextView) findViewById(R.id.card11) );
        cards[2][3] = new Card( (TextView) findViewById(R.id.card12) );
        cards[3][0] = new Card( (TextView) findViewById(R.id.card13) );
        cards[3][1] = new Card( (TextView) findViewById(R.id.card14) );
        cards[3][2] = new Card( (TextView) findViewById(R.id.card15) );
        cards[3][3] = new Card( (TextView) findViewById(R.id.card16) );

        motionCapture = (LinearLayout) findViewById(R.id.bigbox);
        newGame = (Button) findViewById(R.id.btn_new_game);
        undo = (Button) findViewById(R.id.btn_undo);
        info = (Button) findViewById(R.id.btn_info);
        currentScore = (TextView)findViewById(R.id.txt_score);
        bestScore = (TextView) findViewById(R.id.txt_best);

        SwipeControl swipe = new SwipeControl(motionCapture, cards);
    }

    public void onClickNewGame(View v)
    {
        startGame();
    }


    public void startGame()
    {
        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y < 4; y++)
            {
                cards[x][y].setCard(0);
            }
        }
        addRandomNumber();
        addRandomNumber();
        addRandomNumber();
        addRandomNumber();
        addRandomNumber();
        addRandomNumber();
        addRandomNumber();

    }

    // add random number at the beginning of the game
    private void addRandomNumber()
    {
        emptyPoint.clear();

        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y < 4; y++)
            {
                if(cards[x][y].getNum() == 0)
                {
                    emptyPoint.add(new Point(x, y));
                }
            }
        }

        Point p = emptyPoint.remove((int)(Math.random()*emptyPoint.size()));
        cards[p.x][p.y].setCard(Math.random()>0.2 ? 2:4);
    }

    private Card cards [][] = new Card[4][4];
    private List<Point> emptyPoint = new ArrayList<Point>();

    private LinearLayout motionCapture;
    private Button newGame, undo, info;
    private TextView currentScore, bestScore;
    private float startX, startY, endX, endY, offsetX, offsetY;

}
