package com.customInk.domain.cards;

public interface Valuable {
    /**
     * Return the value as string
     * @return String with a value
     */
    String getValue();

    /**
     * Return the cardinality of a value
     * @return Int representing the cardinality
     */
    int getCardinality();
}
