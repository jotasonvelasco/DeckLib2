package com.customInk.domain.cards;

import com.customInk.domain.cards.exceptions.NotAvailableCardsException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DeckTest {

    Deck deckWithSpecialCards;
    Deck deckWithNoSpecialCards;

    @Before
    public void init(){
        // 2 common + 1 special
        deckWithSpecialCards = CardTestHelper.createDummyDeck(2, 1);
        // 4 common
        deckWithNoSpecialCards = CardTestHelper.createDummyDeck(4, 0);
    }


    @Test
    public void shouldCountLeftCardsTest(){
        Assert.assertEquals("The deck should have 3 cards", 3, deckWithSpecialCards.countLeftCards());
    }

    @Test
    public void shouldNotHaveSpecialCardsTest(){
        Assert.assertFalse("The deck should not have special cards", deckWithNoSpecialCards.hasSpecialCards());
        Assert.assertEquals("The deck should not have special cards", 0, deckWithNoSpecialCards.getNumberOfSpecialCards());
    }

    @Test
    public void shouldDealOneCardTest() throws NotAvailableCardsException {
        Card dealtCard = deckWithSpecialCards.deal();
        Assert.assertNotNull("The dealt card should not be null ", dealtCard);
        Assert.assertEquals("The deck should have 2 cards", 2, deckWithSpecialCards.countLeftCards());
    }

    @Test
    public void shouldDealSeveralCardTest() throws NotAvailableCardsException {
        List<Card> dealtCards = deckWithSpecialCards.deal(2);
        Assert.assertEquals("Dealt cards should be 2 ", 2, dealtCards.size());
        Assert.assertEquals("The deck should have 1 cards", 1, deckWithSpecialCards.countLeftCards());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotDealCard_IllegalCardNumberTest() throws NotAvailableCardsException {
        try {
            deckWithSpecialCards.deal(-1);
        }catch (RuntimeException ex){
            Assert.assertEquals("Should not deal cards : " + deckWithSpecialCards.ILLEGAL_NUMBER_OR_CARDS_MSG,
                    deckWithSpecialCards.ILLEGAL_NUMBER_OR_CARDS_MSG, ex.getMessage());
            throw ex;
        }
    }

    @Test(expected = NotAvailableCardsException.class)
    public void shouldNotDealCard_EmptyDeckTest() throws NotAvailableCardsException {
        try {
            // Deck has 3 cards
            deckWithSpecialCards.deal(3);
            deckWithSpecialCards.deal();
        }catch (RuntimeException ex){
            Assert.assertEquals("Should not deal cards : " + deckWithSpecialCards.EMPTY_DECK_MSG,  deckWithSpecialCards.EMPTY_DECK_MSG, ex.getMessage());
            throw ex;
        }
    }

    @Test(expected = NotAvailableCardsException.class)
    public void shouldNotDealCard_CardsNotEnoughTest() throws NotAvailableCardsException {
        try {
            // Deck has 3 cards
            deckWithSpecialCards.deal(4);
        }catch (RuntimeException ex){
            Assert.assertEquals("Should not deal cards : " + deckWithSpecialCards.CARDS_NOT_ENOUGH_MSG,  deckWithSpecialCards.CARDS_NOT_ENOUGH_MSG, ex.getMessage());
            throw ex;
        }
    }

    @Test
    public void shouldResetDeckTest() throws NotAvailableCardsException {
        // Deck has 3 cards
        deckWithSpecialCards.deal(2);
        deckWithSpecialCards.reset();
        Assert.assertEquals("The deck should have 3 cards after reset", 3, deckWithSpecialCards.countLeftCards());
    }

    @Test
    public void shouldStringifyDeckWithSpecialCardsTest() throws NotAvailableCardsException {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("\n");
        sb.append(CardTestHelper.DUMMY_SPECIAL_CARD_DISCOVER);
        sb.append("\n");
        sb.append(CardTestHelper.DUMMY_RANK_VALUE + ":" + CardTestHelper.DUMMY_SUIT_VALUE);
        sb.append("\n");
        sb.append(String.format(Card.DISCOVER_TEMPLATE, CardTestHelper.DUMMY_RANK_VALUE, CardTestHelper.DUMMY_SUIT_VALUE));
        sb.append("\n");
        sb.append("]");
        String expected = sb.toString();

        String stringifiedDeck = deckWithSpecialCards.toString();
        Assert.assertEquals("The stringied Deck is not correct", expected, stringifiedDeck);
    }


}
