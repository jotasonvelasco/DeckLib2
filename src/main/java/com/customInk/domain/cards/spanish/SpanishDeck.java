package com.customInk.domain.cards.spanish;

import com.customInk.domain.cards.Card;
import com.customInk.domain.cards.Deck;

import java.util.List;

/**
 * Represents a Spanish Deck of cards
 */
public class SpanishDeck extends Deck {

    /**
     * Default constructor: Create a spanish deck with common cards and without Special cards
     */
    public SpanishDeck() {
    }

    /**
     * Constructor: Create a spanish deck with common cards and with special cards if param > 0
     * @param numberOfSpecialCards Number of special cards to create. If 0 create it without special cards
     */
    public SpanishDeck(int numberOfSpecialCards) {
        super(numberOfSpecialCards);
    }

    @Override
    protected void populateCardList(List<Card> cards) {
        // special cards if apply
        for (int i=0; i < this.getNumberOfSpecialCards(); i++){
            cards.add(new SpanishCard(SpanishSuit.COMODIN, SpanishRank.NINGUNO, true));
        }

        for (SpanishSuit suit: SpanishSuit.values()){
            if (suit != SpanishSuit.COMODIN){
                for (SpanishRank rank: SpanishRank.values()){
                    if (rank != SpanishRank.NINGUNO){
                        cards.add(new SpanishCard(suit, rank));
                    }
                }
            }
        }
    }
}
