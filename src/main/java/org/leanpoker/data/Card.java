package org.leanpoker.data;

public class Card {
    public String getRank() {
        return rank;
    }

    public void setRank(final String elso) {
        this.rank = elso;
        try {
            value = Integer.parseInt(elso);
        } catch (final Exception e) {
            if (elso.equals("J")) {
                value = 10;
            }
            if (elso.equals("Q")) {
                value = 11;
            }
            if (elso.equals("K")) {
                value = 12;
            }
            if (elso.equals("A")) {
                value = 13;
            }
        }
    }

    public String getSuit() {
        return suit;
    }

    public Integer getValue() {
        return value;
    }

    public void setSuit(final String masodik) {
        this.suit = masodik;
    }

    String rank;
    String suit;
    Integer value;

}
