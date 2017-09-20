package com.example.tongyu.game2048;

import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by tongyu on 9/19/17.
 */

public class Card
{
    private TextView card;
    private int num = 0;

    public Card(TextView card)
    {
        this.card = card;
        card.setText("");
    }

    public void setCard(int num)
    {
        this.num = num;
        if(num > 0)
            card.setText(num + "");
        else
            card.setText("");

        if(num == 0)
            card.setBackgroundColor(Color.parseColor("#d8d5cf"));
        else if(num == 2)
            card.setBackgroundColor(Color.parseColor("#eee4da"));
        else if(num == 4)
            card.setBackgroundColor(Color.parseColor("#f67c5f"));
        else if(num == 8)
            card.setBackgroundColor(Color.parseColor("#f2b179"));
        else if(num == 16)
            card.setBackgroundColor(Color.parseColor("#f59563"));
        else if(num == 32)
            card.setBackgroundColor(Color.parseColor("#f67c5f"));
        else if(num == 64)
            card.setBackgroundColor(Color.parseColor("#f65e3b"));
        else if(num == 128)
            card.setBackgroundColor(Color.parseColor("#edcf72"));
        else if(num == 256)
            card.setBackgroundColor(Color.parseColor("#edcc61"));
        else if(num == 512)
            card.setBackgroundColor(Color.parseColor("#edc850"));
        else if(num == 1024)
            card.setBackgroundColor(Color.parseColor("#edc53f"));
        else if(num == 2048)
            card.setBackgroundColor(Color.parseColor("#edc22e"));


    }

    public int getNum()
    {
        return num;
    }

    public boolean equals(Card c)
    {
        return this.num == c.getNum();
    }


}
