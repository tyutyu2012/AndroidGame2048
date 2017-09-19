package com.example.tongyu.game2048;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by tongyu on 9/18/17.
 */

public class GameView extends LinearLayout
{
    public GameView(Context context)
    {
        super(context);
        initializeView();
    }

    public GameView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        initializeView();
    }

    public GameView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeView();
    }

    // add the motion listener to the Linear Layout
    public void initializeView()
    {
        // set gridView into 4 per column
        setBackgroundColor(0xffbbada0);

        setOnTouchListener(new View.OnTouchListener()
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

    // on AndoridManifest, change the screen into portrait, so it will only change once
    @Override
    protected void onSizeChanged(int w, int h, int oldh, int oldw)
    {
        super.onSizeChanged(w, h, oldh, oldw);

    }

    private void swipeLeft()
    {
        Log.d("1", "Left");

    }

    private void swipeRight()
    {
        Log.d("1", "Right");

    }

    private void swipeUp()
    {
        Log.d("1", "up");

    }

    private void swipeDown()
    {
        Log.d("1", "down");
    }

    private float startX, startY, endX, endY, offsetX, offsetY;
}
