package org.leanpoker.player;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

            System.out.println("Hand: " + myCards);
            System.out.println("Asztal: " + game.getCommunity_cards());

            if (game.getCommunity_cards().isEmpty()) {
                if (myCards.get(0).getRank().equals(myCards.get(1).getRank())) {
                    if (myCards.get(0).getValue() > 9) {
                        return playerMe.getStack();
                    } else {
                        return game.getBig_blind() * 10;
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
                
                getRanking(cardlist);
            }

            return 0;

        } catch (final Exception e) {
            return 0;
        }

    }

    public static void showdown(final JsonElement game) {
    }
    
    
    public static int getRanking(ArrayList<Card> cards) {
    	
    	StringBuilder sB = new StringBuilder();
        sB.append("cards=[");
        sB.append(cards.stream().map(s->s.toString()).reduce("", (a,b) -> a.toString() + "," + b.toString()).substring(1));
        sB.append("]");
        
		//String urlParameters  = "cards=[{\"rank\":\"5\",\"suit\":\"diamonds\"},{\"rank\":\"7\",\"suit\":\"diamonds\"},{\"rank\":\"7\",\"suit\":\"spades\"},{\"rank\":\"8\",\"suit\":\"diamonds\"},{\"rank\":\"9\",\"suit\":\"diamonds\"}]";
		byte[] postData       = sB.toString().getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		String request        = "http://rainman.leanpoker.org/rank";
		URL url;
		try {
			url = new URL( request );
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
			conn.setDoOutput( true );
			conn.setInstanceFollowRedirects( false );
			conn.setRequestMethod( "POST" );
			conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			conn.setRequestProperty( "charset", "utf-8");
			conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
			conn.setUseCaches( false );
			try( DataOutputStream wr = new DataOutputStream( conn.getOutputStream())) {
			   wr.write( postData );
			   wr.flush();
			   wr.close();
			}

			int responseCode = conn.getResponseCode();
			//System.out.println("POST Response Code :: " + responseCode);
			
			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				//System.out.println(response.toString());
				//System.out.println(response.charAt(response.toString().lastIndexOf("rank")+6));
				 int kell = Integer.parseInt(String.valueOf(response.charAt(response.toString().lastIndexOf("rank")+6)));
				 //System.out.println(kell);
				 return kell;
			} else {
				//System.out.println("POST request not worked");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
}
