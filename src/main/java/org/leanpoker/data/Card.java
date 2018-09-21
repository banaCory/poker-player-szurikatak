package org.leanpoker.data;

public class Card {
    public String getRank() {
        return rank;
    }

    public void setRank(final String rank) {
        this.rank = rank;
        System.out.println("Rank: " + rank);
        try {
            value = Integer.parseInt(rank);
        } catch (final Exception e) {
            if (rank.equals("J")) {
                value = 10;
            }
            if (rank.equals("Q")) {
                value = 11;
            }
            if (rank.equals("K")) {
                value = 12;
            }
            if (rank.equals("A")) {
                value = 13;
            }
        }
        System.out.println("Value: " + value);
    }

    public String getSuit() {
        return suit;
    }

    public Integer getValue() {
        return value;
    }

    public void setSuit(final String suit) {
        this.suit = suit;
    }

    String rank;
    String suit;
    Integer value;

}
