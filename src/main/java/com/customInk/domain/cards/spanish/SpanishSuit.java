package com.customInk.domain.cards.spanish;

import com.customInk.domain.cards.Suit;

public enum SpanishSuit implements Suit {

    OROS (1),
    COPAS (2),
    BASTOS (3),
    ESPADAS (4),
    /*
    Cardinal 0 indicate Special Suit
     */
    COMODIN (0);

    int cardinality;

    SpanishSuit(int cardinality) {
        this.cardinality = cardinality;
    }

    @Override
    public int getCardinality(){
        return cardinality;
    }

    @Override
    public String getValue() {
        return this.toString();
    }
}
