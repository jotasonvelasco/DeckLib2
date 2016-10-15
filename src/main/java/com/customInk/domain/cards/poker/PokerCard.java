package com.customInk.domain.cards.poker;


import com.customInk.domain.cards.Card;
import com.customInk.domain.cards.Rank;
import com.customInk.domain.cards.Suit;

/**
 * Represents a Poker Card
 */
public class PokerCard extends Card {

    public static final String POKER_CARD_SPECIAL_DISCOVERED = "YOKER !!!";

    /**
     * Constructor: Create a Poker Card (common or special)
     * @param suit Suit of the card
     * @param rank Rank of the card
     * @param special Indicate if the card is special
     */
    public PokerCard(Suit suit, Rank rank, boolean special) {
        super(suit, rank, special);
    }


    /**
     * Constructor: Create a common Poker Card
     * @param suit Suit of the card
     * @param rank Rank of the card
     */
    public PokerCard(Suit suit, Rank rank) {
        super(suit, rank, false);
    }


    @Override
    protected String discoverSpecial() {
        return POKER_CARD_SPECIAL_DISCOVERED;
    }

}