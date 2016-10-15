package com.customInk.domain.cards.spanish;

import com.customInk.domain.cards.Card;
import com.customInk.domain.cards.Deck;
import org.junit.Assert;
import org.junit.Test;

public class SpanishDeckTest {

    @Test
    public void shouldCreateCommonSpanishCardTest(){
        // create a common spanish card
        Card spanishCard = new SpanishCard(SpanishSuit.COPAS, SpanishRank.SOTA);

        Assert.assertFalse("The created card should not be special", spanishCard.isSpecial());
        Assert.assertEquals("The cardinality of the Rank created Card should be 10", 10, spanishCard.getRank().getCardinality());
        Assert.assertEquals("The value of the Rank created Card should be " + SpanishRank.SOTA.toString(),
                SpanishRank.SOTA.toString(), spanishCard.getRank().getValue());
        Assert.assertEquals("The value of the Suit created Card should be " + SpanishSuit.COPAS.toString(),
                SpanishSuit.COPAS.toString(), spanishCard.getSuit().getValue());
    }

    @Test
    public void shouldCreateSpecialSpanishCardTest(){
        // create a special spanish card
        Card spanishCard = new SpanishCard(SpanishSuit.COMODIN, SpanishRank.NINGUNO, true);

        Assert.assertTrue("The created card should be special", spanishCard.isSpecial());
        Assert.assertEquals("The cardinality of the Rank created Card should be 0", 0, spanishCard.getRank().getCardinality());
        Assert.assertEquals("The value of the Rank created Card should be " + SpanishRank.NINGUNO.toString(),
                SpanishRank.NINGUNO.toString(), spanishCard.getRank().getValue());
        Assert.assertEquals("The value of the Suit created Card should be " + SpanishSuit.COMODIN.toString(),
                SpanishSuit.COMODIN.toString(), spanishCard.getSuit().getValue());
    }

    @Test
    public void shouldDiscoverSpecialSpanishCardTest(){
        // create a special spanish card
        Card spanishCard = new SpanishCard(SpanishSuit.COMODIN, SpanishRank.NINGUNO, true);
        String expected = "** COMODIN **";
        Assert.assertEquals("The discover of the special card is not correct", expected, spanishCard.discover());
    }


    @Test
    public void shouldCreateSpanishDeckWithoutYokersTest(){
        // create a spanish deck without Yokers
        Deck spanishDeck = new SpanishDeck();
        Assert.assertEquals("The created spanish deck should have 48 cards", 48, spanishDeck.countLeftCards());
        Assert.assertFalse("The created spanish deck should not have COMODIN", spanishDeck.hasSpecialCards());
    }

    @Test
    public void shouldCreateSpanishDeckYokersTest(){
        // create a spanish deck with 2 Yokers
        Deck spanishDeck = new SpanishDeck(3);
        Assert.assertEquals("The created spanish deck should have 51 cards", 51, spanishDeck.countLeftCards());
        Assert.assertTrue("The created spanish deck should have COMODINES", spanishDeck.hasSpecialCards());
        Assert.assertEquals("The created spanish deck should have 3 COMODINES", 3, spanishDeck.getNumberOfSpecialCards());
    }

}
