package com.customInk.domain.cards;

/**
 * Represents a abstract Card
 */
public abstract class Card {

    private final Suit suit;
    private final Rank rank;
    private final boolean special;

    public static final String DISCOVER_TEMPLATE = "%s:%s";

    /**
     * Constructor: Create a card common (special = false) or special (special = true)
     * @param suit Suit Card
     * @param rank Rank Card
     * @param special Indicate if the card to create is special
     */
    protected Card(Suit suit, Rank rank, boolean special) {
        this.suit = suit;
        this.rank = rank;
        this.special = special;
    }

    /**
     * Return a string showing which card is.
     * @return String representing the card
     */
    public final String discover(){
        return special ? discoverSpecial() : discoverNotSpecial();
    }

    /**
     * Return a string showing a NOT special card
     * @return String representing a NOT special card
     */
    protected String discoverNotSpecial(){
        return String.format(DISCOVER_TEMPLATE, rank.getValue(), suit.getValue());
    }

    /**
     * Return a string showing a special card
     * @return String representing a special card
     */
    protected abstract String discoverSpecial();

    /**
     * Show to all the players (painting on console) which card is
     */
    public void discoverToAllPlayers(){
        System.out.println(discover());
    }


    // Getters

    /**
     * Return the suit of the card
     * @return Suit of the card
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Return the rank of the card
     * @return Rank of the card
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Return is the card is special
     * @return true is the card is special
     */
    public boolean isSpecial(){
        return special;
    }

}