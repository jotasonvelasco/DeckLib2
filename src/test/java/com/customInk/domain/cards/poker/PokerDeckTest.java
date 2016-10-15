package com.customInk.domain.cards.poker;

import com.customInk.domain.cards.Card;
import com.customInk.domain.cards.Deck;
import org.junit.Assert;
import org.junit.Test;

public class PokerDeckTest {

    @Test
    public void shouldCreateCommonPokerCardTest(){
        // create a common poker card
        Card pokerCard = new PokerCard(PokerSuit.CLUBS, PokerRank.ACE);

        Assert.assertFalse("The created card should not be special", pokerCard.isSpecial());
        Assert.assertEquals("The cardinality of the Rank created Card should be 14", 14, pokerCard.getRank().getCardinality());
        Assert.assertEquals("The value of the Rank created Card should be " + PokerRank.ACE.toString(),
                PokerRank.ACE.toString(), pokerCard.getRank().getValue());
        Assert.assertEquals("The value of the Suit created Card should be " + PokerSuit.CLUBS.toString(),
                PokerSuit.CLUBS.toString(), pokerCard.getSuit().getValue());
    }

    @Test
    public void shouldCreateSpecialPokerCardTest(){
        // create a special poker card
        Card pokerCard = new PokerCard(PokerSuit.YOKER, PokerRank.NONE, true);

        Assert.assertTrue("The created card should be special", pokerCard.isSpecial());
        Assert.assertEquals("The cardinality of the Rank created Card should be 0", 0, pokerCard.getRank().getCardinality());
        Assert.assertEquals("The value of the Rank created Card should be " + PokerRank.NONE.toString(),
                PokerRank.NONE.toString(), pokerCard.getRank().getValue());
        Assert.assertEquals("The value of the Suit created Card should be " + PokerSuit.YOKER.toString(),
                PokerSuit.YOKER.toString(), pokerCard.getSuit().getValue());
    }

    @Test
    public void shouldDiscoverSpecialPokerCardTest(){
        // create a special poker card
        Card pokerCard = new PokerCard(PokerSuit.YOKER, PokerRank.NONE, true);
        String expected = "YOKER !!!";
        Assert.assertEquals("The discover of the special card is not correct", expected, pokerCard.discover());
    }


    @Test
    public void shouldCreatePokerDeckWithoutYokersTest(){
        // create a poker deck without Yokers
        Deck pokerDeck = new PokerDeck();
        Assert.assertEquals("The created poker deck should have 52 cards", 52, pokerDeck.countLeftCards());
        Assert.assertFalse("The created poker deck should not have YOKERS", pokerDeck.hasSpecialCards());
    }

    @Test
    public void shouldCreatePokerDeckYokersTest(){
        // create a poker deck with 2 Yokers
        Deck pokerDeck = new PokerDeck(2);
        Assert.assertEquals("The created poker deck should have 54 cards", 54, pokerDeck.countLeftCards());
        Assert.assertTrue("The created poker deck should have YOKERS", pokerDeck.hasSpecialCards());
        Assert.assertEquals("The created poker deck should have 2 YOKERS", 2, pokerDeck.getNumberOfSpecialCards());
    }

}
