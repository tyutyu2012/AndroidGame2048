package com.example.tongyu.game2048;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tongyu on 9/20/17.
 */

public class SwipeControl
{
    private LinearLayout bigbox;
    private Card cards[][] = new Card[4][4];
    private List<Point> emptyPoint = new ArrayList<Point>();

    private TextView currentScore, bestScore;
    private int currentScoreInt = 0, bestScoreInt = 0;
    private float startX, startY, endX, endY, offsetX, offsetY;

    public SwipeControl(LinearLayout bigbox, Card cards[][], TextView currentScore, TextView bestScore)
    {
        this.bigbox = bigbox;
        this.cards = cards;
        this.currentScore = currentScore;
        this.bestScore = bestScore;
        setCaptureSwipe();
    }

    public void setCaptureSwipe()
    {
        bigbox.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent)
            {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        startX = motionEvent.getX();
                        startY = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        endX = motionEvent.getX();
                        endY = motionEvent.getY();

                        offsetX = endX - startX;
                        offsetY = endY - startY;

                        // if the absolute value of offsetX is bigger than offsetY than, swipe horizonally, left or right
                        if(Math.abs(offsetX) > Math.abs(offsetY))
                        {
                            // -5 and 5 because there might be some devies errors
                            // swipe left
                            if(offsetX <  -5)
                            {
                                swipeLeft();
                            }
                            // swipe right
                            else if (offsetX > 5)
                            {
                                swipeRight();
                            }
                        }
                        // else move vertically, up or down
                        else
                        {
                            if(offsetY <  -5)
                            {
                                swipeUp();
                            }
                            else if (offsetY > 5)
                            {
                                swipeDown();
                            }
                        }
                        startX = 0;
                        startY = 0;
                        endX = 0;
                        endY = 0;
                        offsetX = 0;
                        offsetY = 0;
                        break;
                }
                return true;
            }
        });
    }

    public void swipeLeft()
    {
        boolean moved = false;
        for(int x = 0; x < 4; x++)
        {
            for(int y = 0; y <4; y++)
            {
                for(int y1 = y+1; y1 < 4; y1++)
                {
                    if(cards[x][y1].getNum() > 0)
                    {
                        if(cards[x][y].getNum() <= 0)
                        {
                            cards[x][y].setCard(cards[x][y1].getNum());
                            cards[x][y1].setCard(0);
                            moved = true;
                            y --;
                        }
                        else if(cards[x][y].equals(cards[x][y1]))
                        {
                            setCurrentScore(cards[x][y].getNum() * 2);
                            setBestScore(currentScoreInt);
                            cards[x][y].setCard(cards[x][y].getNum() * 2);
                            cards[x][y1].setCard(0);
                            moved = true;
                        }
                        break;
                    }
                }
            }
        }
        if(moved)
        {
            addRandomNumber();
        }
    }

    public void swipeRight()
    {
        boolean moved = false;
        for(int x = 0; x < 4; x++)
        {
            for(int y = 3; y >= 0; y--)
            {
                for(int y1 = y-1; y1 >= 0; y1--)
                {
                    if(cards[x][y1].getNum() > 0)
                    {
                        if(cards[x][y].getNum() <= 0)
                        {
                            cards[x][y].setCard(cards[x][y1].getNum());
                            cards[x][y1].setCard(0);
                            y ++;
                            moved = true;
                        }
                        else if(cards[x][y].equals(cards[x][y1]))
                        {
                            setCurrentScore(cards[x][y].getNum() * 2);
                            setBestScore(currentScoreInt);
                            cards[x][y].setCard(cards[x][y].getNum() * 2);
                            cards[x][y1].setCard(0);
                            moved = true;
                        }
                        break;
                    }
                }
            }
        }
        if(moved)
        {
            addRandomNumber();
        }
    }

    public void swipeUp()
    {
        boolean moved = false;
        for(int y = 0; y < 4; y++)
        {
            for(int x = 0; x < 4; x++)
            {
                for(int x1 = x+1; x1 < 4; x1++)
                {
                    if(cards[x1][y].getNum() > 0)
                    {
                        if(cards[x][y].getNum() <= 0)
                        {
                            cards[x][y].setCard(cards[x1][y].getNum());
                            cards[x1][y].setCard(0);
                            x --;
                            moved = true;
                        }
                        else if(cards[x][y].equals(cards[x1][y]))
                        {
                            setCurrentScore(cards[x][y].getNum() * 2);
                            setBestScore(currentScoreInt);
                            cards[x][y].setCard(cards[x][y].getNum() * 2);
                            cards[x1][y].setCard(0);
                            moved = true;
                        }
                        break;
                    }
                }
            }
        }
        if(moved)
        {
            addRandomNumber();
        }
    }

    public void swipeDown()
    {
        boolean moved = false;
        for(int y = 0; y < 4; y++)
        {
            for(int x = 3; x >= 0; x--)
            {
                for(int x1 = x-1; x1 >= 0; x1--)
                {
                    if(cards[x1][y].getNum() > 0)
                    {
                        if(cards[x][y].getNum() <= 0)
                        {
                            cards[x][y].setCard(cards[x1][y].getNum());
                            cards[x1][y].setCard(0);
                            x ++;
                            moved = true;
                        }
                        else if(cards[x][y].equals(cards[x1][y]))
                        {
                            setCurrentScore(cards[x][y].getNum() * 2);
                            setBestScore(currentScoreInt);
                            cards[x][y].setCard(cards[x][y].getNum() * 2);
                            cards[x1][y].setCard(0);
                            moved = true;
                        }
                        break;
                    }
                }
            }
        }
        if(moved)
        {
            addRandomNumber();
        }
    }


    public void setCurrentScore(int addon)
    {
        currentScoreInt += addon;
        currentScore.setText(currentScoreInt + "");
    }

    public void setBestScore(int addon)
    {
        if(addon > bestScoreInt)
        {
            bestScoreInt = addon;
            bestScore.setText(bestScoreInt + "");
        }
    }

    public void clearScore()
    {
        currentScore.setText("0");
        currentScoreInt = 0;
    }

    // add random number at the beginning of the game
    public void addRandomNumber()
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
}
