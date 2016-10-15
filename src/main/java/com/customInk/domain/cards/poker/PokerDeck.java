package com.customInk.domain.cards.poker;

import com.customInk.domain.cards.Card;
import com.customInk.domain.cards.Deck;

import java.util.List;

/**
 * Represents a Poker Deck of cards
 */
public class PokerDeck extends Deck {

    /**
     * Default constructor: Create a poker deck with common cards and without Special cards
     */
    public PokerDeck() {
    }

    /**
     * Constructor: Create a poker deck with common cards and with special cards if param > 0
     * @param numberOfSpecialCards Number of special cards to create. If 0 create it without special cards
     */
    public PokerDeck(int numberOfSpecialCards) {
        super(numberOfSpecialCards);
    }

    @Override
    protected void populateCardList(List<Card> cards) {
        // special cards if apply
        for (int i=0; i < this.getNumberOfSpecialCards(); i++){
            cards.add(new PokerCard(PokerSuit.YOKER, PokerRank.NONE, true));
        }

        // common cards
        for (PokerSuit suit: PokerSuit.values()){
            if (suit != PokerSuit.YOKER){
                for (PokerRank rank: PokerRank.values()){
                    if (rank != PokerRank.NONE){
                        cards.add(new PokerCard(suit, rank));
                    }
                }
            }
        }
    }

}
