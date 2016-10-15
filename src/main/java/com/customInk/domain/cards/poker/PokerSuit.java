package com.customInk.domain.cards.poker;

import com.customInk.domain.cards.Suit;

public enum PokerSuit implements Suit {
    SPADES (1),
    HEARTS (2),
    DIAMONDS (3),
    CLUBS (4),
    /*
    Cardinal 0 indicate Special Suit
     */
    YOKER (0);

    int cardinality;

    PokerSuit(int cardinality) {
        this.cardinality = cardinality;
    }

    @Override
    public String getValue() {
        return this.toString();
    }

    @Override
    public int getCardinality(){
        return cardinality;
    }

}
