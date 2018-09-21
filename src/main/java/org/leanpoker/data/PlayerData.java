package org.leanpoker.data;

import java.util.ArrayList;

public class PlayerData {
    String name;
    Integer stack;
    String status;
    Integer get;
    ArrayList<Card> hole_cards;
    String version;
    Integer Id;

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

    public Integer getGet() {
        return get;
    }

    public void setGet(final Integer get) {
        this.get = get;
    }

    public ArrayList<Card> getHoleCards() {
        return hole_cards;
    }

    public void setHoleCards(final ArrayList<Card> holeCards) {
        this.hole_cards = holeCards;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(final Integer id) {
        Id = id;
    }
}
