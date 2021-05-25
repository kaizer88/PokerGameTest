package com.game.poker;

import java.util.ArrayList;
import java.util.List;

public class Player
{

    // gets 5 cards from deck
    public static List<Card> draw(Deck deck){
        List<Card> hand = deal(deck);
        return hand;
    }

    // deals 5 cards
    private static List<Card> deal(Deck deck){
        List<Card> hand = new ArrayList<>();
        for (int deckPosition = 0; deckPosition < 5; deckPosition++){
            hand.add(deck.getCardList().get(deckPosition));
        }
        return hand;
    }

}
