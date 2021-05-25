package com.game.poker;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PlayerTest {

    @Test
    public void testDraw(){
        Deck myDeck = new Deck();
        myDeck.fillDeck();
        myDeck.shuffle();
        List<Card> hand = Player.draw(myDeck);
        Assert.assertEquals("Hand is 5 cards", hand.size(), 5);
        Assert.assertEquals("First index on the list", myDeck.getCardList().get(0), hand.get(0));
        Assert.assertEquals("Second index on the list", myDeck.getCardList().get(1), hand.get(1));
        Assert.assertEquals("Third index on the list", myDeck.getCardList().get(2), hand.get(2));
        Assert.assertEquals("Fourth index on the list", myDeck.getCardList().get(3), hand.get(3));
        Assert.assertEquals("Firth index on the list", myDeck.getCardList().get(4), hand.get(4));
    }
}
