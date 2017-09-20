package com.example.tongyu.game2048;

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
