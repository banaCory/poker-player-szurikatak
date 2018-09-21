package org.leanpoker.data;

import java.util.ArrayList;

public class GameState {
    ArrayList<PlayerData> players;
    String tournament_id;
    String game_id;
    Integer round;
    ArrayList<Card> community_cards;
    Integer current_by_in;
    Integer pot;
    Integer small_blind;
    Integer big_blind;
    Integer orbits;
    Integer dealer;

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

	public String getTournament_id() {
		return tournament_id;
	}

	public void setTournament_id(String tournament_id) {
		this.tournament_id = tournament_id;
	}

	public String getGame_id() {
		return game_id;
	}

	public void setGame_id(String game_id) {
		this.game_id = game_id;
	}

	public ArrayList<Card> getCommunity_cards() {
		return community_cards;
	}

	public void setCommunity_cards(ArrayList<Card> community_cards) {
		this.community_cards = community_cards;
	}

	public Integer getCurrent_by_in() {
		return current_by_in;
	}

	public void setCurrent_by_in(Integer current_by_in) {
		this.current_by_in = current_by_in;
	}

	public Integer getSmall_blind() {
		return small_blind;
	}

	public void setSmall_blind(Integer small_blind) {
		this.small_blind = small_blind;
	}

	public Integer getBig_blind() {
		return big_blind;
	}

	public void setBig_blind(Integer big_blind) {
		this.big_blind = big_blind;
	}

}
