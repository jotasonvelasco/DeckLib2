package com.customInk.domain.cards.spanish;

import com.customInk.domain.cards.Rank;

public enum SpanishRank implements Rank {
    REY (12),
    CABALLO (11),
    SOTA (10),
    NUEVE (9),
    OCHO (8),
    SIETE (7),
    SEIS (6),
    CINCO (5),
    CUATRO (4),
    TRES (3),
    DOS (2),
    AS (1),
    /*
    Comodin case
     */
    NINGUNO (0);

    private int cardinality;

    SpanishRank(int cardinality) {
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
