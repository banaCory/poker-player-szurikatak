package org.leanpoker.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.leanpoker.data.Card;
import org.leanpoker.data.GameState;
import org.leanpoker.data.PlayerData;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(final JsonElement request) {

        try {

            final Gson gson = new Gson();
            final GameState game = gson.fromJson(request, GameState.class);

            final PlayerData playerMe = game.getPlayers().stream().filter(play -> play.getName().equals("szurikatak")).findFirst().get();
            final ArrayList<Card> myCards = playerMe.getHoleCards();

            if (game.getCommunity_cards().isEmpty()) {
                if (myCards.get(0).getRank().equals(myCards.get(1).getRank())) {
                    if (myCards.get(0).getValue() > 9) {
                        return 1000;
                    }
                }
                if (myCards.get(0).getValue() + myCards.get(1).getValue() > 20) {
                    return 250;
                }
                if (myCards.get(0).getValue() > 10 || myCards.get(1).getValue() > 10) {
                    return game.getBig_blind() * 5;
                }
            } else {
                final ArrayList<Card> cardlist = new ArrayList<>();
                cardlist.addAll(game.getCommunity_cards());
                cardlist.addAll(myCards);
                final Set<String> targetSet = new HashSet<>(cardlist.stream().map(card -> card.getRank()).collect(Collectors.toList()));
                if (targetSet.size() < cardlist.size()) {
                    return game.getBig_blind() * 10;
                }
            }

            return 0;

        } catch (final Exception e) {
            return 0;
        }

    }

    public static void showdown(final JsonElement game) {
    }
}
