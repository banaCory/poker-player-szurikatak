package org.leanpoker.data;

import java.util.ArrayList;

public class PlayerData {
    String name;
    Integer stack;
    String status;
    Integer bet;
    ArrayList<Card> hole_cards;
    Long time_used;
    String version;
    Integer id;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getStack() {
        return stack;
    }

    public void setStack(final Integer stack) {
        this.stack = stack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(final Integer bet) {
        this.bet = bet;
    }

    public ArrayList<Card> getHoleCards() {
        return hole_cards;
    }

    public void setHoleCards(final ArrayList<Card> hole_cards) {
        this.hole_cards = hole_cards;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public ArrayList<Card> getHole_cards() {
        return hole_cards;
    }

    public void setHole_cards(final ArrayList<Card> hole_cards) {
        this.hole_cards = hole_cards;
    }

    public Long getTime_used() {
        return time_used;
    }

    public void setTime_used(final Long time_used) {
        this.time_used = time_used;
    }
}
