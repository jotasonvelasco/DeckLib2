package com.customInk.domain.cards;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CardTest {

    static Card commonDummyCard;
    static Card specialDummyCard;

    @BeforeClass
    public static void init() {
        // Dummy common card
        commonDummyCard = CardTestHelper.createCommonDummyCard();
        // Dummy special card
        specialDummyCard = CardTestHelper.createSpecialDummyCard();
    }

    @Test
    public void shouldDiscoverCommonCardTest(){
        String discoveredCard = commonDummyCard.discover();
        // assert
        String expected = String.format(Card.DISCOVER_TEMPLATE, CardTestHelper.DUMMY_RANK_VALUE, CardTestHelper.DUMMY_SUIT_VALUE);
        Assert.assertEquals("The discovered card should be : " + expected, expected, discoveredCard);
    }

    @Test
    public void shouldDiscoverSpecialCardTest(){
        String discoveredCard = specialDummyCard.discover();
        // assert
        Assert.assertEquals("The discovered card should be : " + CardTestHelper.DUMMY_SPECIAL_CARD_DISCOVER,
                discoveredCard, CardTestHelper.DUMMY_SPECIAL_CARD_DISCOVER);
    }

}
