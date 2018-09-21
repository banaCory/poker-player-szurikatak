package org.leanpoker.player;

import java.util.ArrayList;

import org.leanpoker.data.Card;
import org.leanpoker.data.GameState;
import org.leanpoker.data.PlayerData;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(final JsonElement request) {

        final Gson gson = new Gson();
        final GameState game = gson.fromJson(request, GameState.class);

        final PlayerData playerMe = game.getPlayers().stream().filter(play -> play.getName().equals("szurikatak")).findFirst().get();
        final ArrayList<Card> myCards = playerMe.getHoleCards();

        /*
         * System.out.print(request.getAsString());
         * final List<Integer> cards;
         * final List<String> items = Arrays.asList(request.getAsString().split("\\s*,\\s*"));
         * items.forEach(item -> {
         * if(item.contains("rank")){
         * cards.add(item.split(Integer.parseInt(item.split(":")));
         * };
         * });
         */

        if (myCards.get(0).getRank().equals(myCards.get(1).getRank())) {
            return 20;
        }
        return 0;
    }

    public static void showdown(final JsonElement game) {
    }
}
