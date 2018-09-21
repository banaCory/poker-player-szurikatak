package org.leanpoker.data;

import java.util.ArrayList;

public class GameState {
    ArrayList<PlayerData> players;
    String tournament_id;
    String game_id;
    Integer round;
    Integer small_blind;
    Integer orbits;
    Integer dealer;
    ArrayList<Card> community_cards;
    Integer current_by_in;
    Integer pot;

    public ArrayList<PlayerData> getPlayers() {
        return players;
    }

    public void setPlayers(final ArrayList<PlayerData> players) {
        this.players = players;
    }

    public String getTournamentId() {
        return tournament_id;
    }

    public void setTournamentId(final String tournamentId) {
        this.tournament_id = tournamentId;
    }

    public String getGameId() {
        return game_id;
    }

    public void setGameId(final String gameId) {
        this.game_id = gameId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(final Integer round) {
        this.round = round;
    }

    public Integer getSmallBlind() {
        return small_blind;
    }

    public void setSmallBlind(final Integer smallBlind) {
        this.small_blind = smallBlind;
    }

    public Integer getOrbits() {
        return orbits;
    }

    public void setOrbits(final Integer orbits) {
        this.orbits = orbits;
    }

    public Integer getDealer() {
        return dealer;
    }

    public void setDealer(final Integer dealer) {
        this.dealer = dealer;
    }

    public ArrayList<Card> getCommunityCards() {
        return community_cards;
    }

    public void setCommunityCards(final ArrayList<Card> communityCards) {
        this.community_cards = communityCards;
    }

    public Integer getCurrentBuyIn() {
        return current_by_in;
    }

    public void setCurrentBuyIn(final Integer currentBuyIn) {
        this.current_by_in = currentBuyIn;
    }

    public Integer getPot() {
        return pot;
    }

    public void setPot(final Integer pot) {
        this.pot = pot;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "p: " + round + " " + dealer;
    }

}
