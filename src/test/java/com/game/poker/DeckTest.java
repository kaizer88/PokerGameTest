package com.game.poker;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    @Test
    public void testFillDeck(){
        Deck myDeck = new Deck();
        Assert.assertEquals(myDeck.getCardList().size(), 0);
        myDeck.fillDeck();
        Assert.assertEquals("Cards must be 52 in total after filling the deck", myDeck.getCardList().size(), 52);
    }

}
