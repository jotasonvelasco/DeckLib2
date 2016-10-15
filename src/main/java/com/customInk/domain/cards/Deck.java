package com.customInk.domain.cards;

import com.customInk.domain.cards.exceptions.NotAvailableCardsException;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a abstract Deck of cards
 */
public abstract class Deck {

    public static final String ILLEGAL_NUMBER_OR_CARDS_MSG = "Invalid number of cards";
    public static final String EMPTY_DECK_MSG = "I have not cards";
    public static final String CARDS_NOT_ENOUGH_MSG = "I have not cards enough";

    /**
     * Collection of cards
     */
    private final List<Card> cards = new LinkedList<>();

    /**
     * Number of special cards in the deck
     */
    private final int numberOfSpecialCards;

    /**
     * Default Constructor: Create a deck only common cards (NO Special cards)
     */
    protected Deck() {
        this.numberOfSpecialCards = 0;
        init();
    }

    /**
     * Constructor: Create a deck with common cards plus special cards (if param > 0)
     * @param numberOfSpecialCards Number of specials cards to create
     */
    protected Deck(int numberOfSpecialCards) {
        if (numberOfSpecialCards < 0){
            throw new IllegalArgumentException(ILLEGAL_NUMBER_OR_CARDS_MSG);
        }
        this.numberOfSpecialCards = numberOfSpecialCards;
        init();
    }

    /**
     * Initialize the collection of cards
     */
    protected void init(){
        cards.clear();
        populateCardList(cards);
    }

    /**
     * Populates the cards of the deck depending on which kind of deck (Factory method pattern)
     * @param cards Collection of cards where inserts the cards
     */
    protected abstract void populateCardList(List<Card> cards);

    /**
     * Initialize the collection of cards and shuffle the deck
     */
    public void reset(){
        init();
        shuffle();
    }

    /**
     * Indicate if the deck has special cards
     * @return true if the deck has special cards
     */
    public boolean hasSpecialCards(){
        return numberOfSpecialCards == 0 ? false : true;
    }

    /**
     * Shuffle the collection of cards
     */
    public void shuffle(){
        Collections.shuffle(cards);
    }

    /**
     * Deal a single card from the collection of cards. First in the list
     * @return The first Card in the list
     * @throws NotAvailableCardsException Thrown if the collection is empty
     */
    public Card deal() throws NotAvailableCardsException {
        validateDeal(1);
        return cards.remove(0);
    }


    /**
     * Deal several cards from the collection of cards starting on first position
     * @param numberOfCards Number of cards to deal
     * @return Collection of cards
     * @throws NotAvailableCardsException Thrown if there is not cards enough to deal
     */
    public List<Card> deal(int numberOfCards) throws NotAvailableCardsException {
        validateDeal(numberOfCards);

        List<Card> cardsToDeal = new LinkedList<>();
        for (int i=0; i<numberOfCards; i++){
            cardsToDeal.add(deal());
        }

        return cardsToDeal;
    }

    /**
     * Print on console the Collection of cards
     */
    public void show(){
        System.out.println(this.toString());
    }

    /**
     * Indicate the current number of cards in the collection
     * @return Current number of cards
     */
    public int countLeftCards(){
        return cards.size();
    }

    /**
     * Validate if the number of cards to deal is legal and if there are cards enough to deal
     * @param numberOfCards Number of cards to deal
     * @throws NotAvailableCardsException Thrown if the number of cards to deal
     */
    private void validateDeal(int numberOfCards) throws NotAvailableCardsException {
        if (numberOfCards <= 0){
            throw new IllegalArgumentException(ILLEGAL_NUMBER_OR_CARDS_MSG);
        }

        if ((cards.isEmpty())){
            throw new NotAvailableCardsException(EMPTY_DECK_MSG);
        }

        if ((numberOfCards > cards.size())){
            throw new NotAvailableCardsException(CARDS_NOT_ENOUGH_MSG);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append("\n");
        for (Card card : cards) {
            sb.append(card.discover());
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    // Getters

    /**
     * Return the collection of cards
     * @return the collection of cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Indicate the number of special cards in the deck
     * @return the number of special cards in the deck
     */
    public int getNumberOfSpecialCards(){
        return numberOfSpecialCards;
    }
}
