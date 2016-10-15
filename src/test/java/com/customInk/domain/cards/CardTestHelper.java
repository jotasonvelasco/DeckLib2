package com.customInk.domain.cards;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CardTestHelper {

    public static final String DUMMY_SPECIAL_CARD_DISCOVER = "I'm a special dummy discoved card";
    public static final String DUMMY_SUIT_VALUE = "dummy_suit_value";
    public static final String DUMMY_RANK_VALUE = "dummy_rank_value";

    static Suit dummySuit;
    static Rank dummyRank;


    static {
        // Dummy Suit
        dummySuit = mock(Suit.class);
        when(dummySuit.getValue()).thenReturn(DUMMY_SUIT_VALUE);
        // Dummy Rank
        dummyRank = mock(Rank.class);
        when(dummyRank.getValue()).thenReturn(DUMMY_RANK_VALUE);
    }

    public static Card createCommonDummyCard(){
        return new Card(dummySuit, dummyRank, false) {
            @Override
            protected String discoverSpecial() {
                return DUMMY_SPECIAL_CARD_DISCOVER;
            }
        };
    }

    public static Card createSpecialDummyCard(){
        return new Card(dummySuit, dummyRank, true) {
            @Override
            protected String discoverSpecial() {
                return DUMMY_SPECIAL_CARD_DISCOVER;
            }
        };
    }

    public static Deck createDummyDeck(final int common, final int special){
        return new Deck() {
            @Override
            protected void populateCardList(List<Card> cards) {
                for (int i=0; i<special; i++){
                    cards.add(CardTestHelper.createSpecialDummyCard());
                }
                for (int i=0; i<common; i++){
                    cards.add(CardTestHelper.createCommonDummyCard());
                }
            }
        };
    }

}
