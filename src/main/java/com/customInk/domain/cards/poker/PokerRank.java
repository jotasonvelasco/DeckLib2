package com.customInk.domain.cards.poker;

import com.customInk.domain.cards.Rank;

public enum PokerRank implements Rank {

    ACE (14),
    KING (13),
    QUEEN (12),
    JACK (11),
    TEN (10),
    NINE (9),
    EIGHT (8),
    SEVEN (7),
    SIX (6),
    FIVE (5),
    FOUR (4),
    THREE (3),
    TWO (2),
    /*
    Yoker case
     */
    NONE (0);

    int cardinality;

    PokerRank(int cardinality) {
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
