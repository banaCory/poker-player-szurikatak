package org.leanpoker.data;

public class Card {
    public String getRank() {
        return rank;
    }

    public void setRank(final String elso) {
        this.rank = elso;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(final String masodik) {
        this.suit = masodik;
    }

    String rank;
    String suit;

}
