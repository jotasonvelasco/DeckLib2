package com.customInk.domain.cards.spanish;

import com.customInk.domain.cards.Card;
import com.customInk.domain.cards.Rank;
import com.customInk.domain.cards.Suit;

/**
 * Represents a Poker Card
 */
public class SpanishCard extends Card {

    public static final String SPANISH_CARD_SPECIAL_DISCOVERED = "** COMODIN **";

    /**
     * Constructor: Create a Spanish Card (common or special)
     * @param suit Suit of the card
     * @param rank Rank of the card
     * @param special Indicate if the card is special
     */
    public SpanishCard(Suit suit, Rank rank, boolean special) {
        super(suit, rank, special);
    }

    /**
     * Constructor: Create a common Spanish Card
     * @param suit Suit of the card
     * @param rank Rank of the card
     */
    public SpanishCard(Suit suit, Rank rank) {
        super(suit, rank, false);
    }

    @Override
    protected String discoverSpecial() {
        return SPANISH_CARD_SPECIAL_DISCOVERED;
    }

}
