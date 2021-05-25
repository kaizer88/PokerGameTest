package com.game.poker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck
{

    private final int DECK_SIZE = 52;
    private final int SHUFFLE_EXCHANGES = 1000;
    private final int HAND_SIZE = 5;

    private List<Card> cardList = new ArrayList<>();

    Random r = new Random();


    // fill deck with cards
    public void fillDeck() {
        for (int suit = 1; suit <= 4; suit++)
        {
            for (int rank = 1; rank <= 13; rank++){
                Card cd = new Card();
                cd.suit = suit;
                cd.rank = rank;
                cardList.add(cd);
            }
        }
    }

    // shuffle deck
    public void shuffle(){
        for (int x = 0; x <= SHUFFLE_EXCHANGES; x++){
            int number1 = r.nextInt(DECK_SIZE);
            int number2 = r.nextInt(DECK_SIZE);
            Card temp = cardList.get(number1);
            cardList.set(number1, cardList.get(number2));
            cardList.set(number2, temp);
        }
    }

    public List<Card> getCardList(){
        return cardList;
    }

    public void setCardList(List<Card> cardList){
        this.cardList = cardList;
    }

}
