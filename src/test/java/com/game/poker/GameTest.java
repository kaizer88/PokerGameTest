package com.game.poker;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @Test
    public void testPair(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 10;
        card2.rank = 10;
        card3.rank = 11;
        card4.rank = 12;
        card5.rank = 13;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.pair();
        Assert.assertEquals(HandRankings.PAIR, results);
    }

    @Test
    public void testNotPair(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 10;
        card2.rank = 9;
        card3.rank = 11;
        card4.rank = 12;
        card5.rank = 13;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.pair();
        Assert.assertNotEquals(HandRankings.PAIR, results);
    }

    @Test
    public void testTwoPair(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 1;
        card2.rank = 1;
        card3.rank = 12;
        card4.rank = 12;
        card5.rank = 13;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.twoPairs();
        Assert.assertEquals(HandRankings.TWO_PAIRS, results);

    }

    @Test
    public void testNotTwoPair(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 1;
        card2.rank = 10;
        card3.rank = 12;
        card4.rank = 12;
        card5.rank = 13;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.twoPairs();
        Assert.assertNotEquals(HandRankings.TWO_PAIRS, results);

    }

    @Test
    public void testTriplePairs(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 1;
        card2.rank = 1;
        card3.rank = 1;
        card4.rank = 12;
        card5.rank = 13;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.triple();
        Assert.assertEquals(HandRankings.TRIPLE, results);

    }

    @Test
    public void testNotTriplePairs(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 1;
        card2.rank = 2;
        card3.rank = 7;
        card4.rank = 12;
        card5.rank = 13;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.triple();
        Assert.assertNotEquals(HandRankings.TRIPLE, results);

    }

    @Test
    public void testStraight(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 1;
        card2.rank = 2;
        card3.rank = 3;
        card4.rank = 4;
        card5.rank = 5;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.straight();
        Assert.assertEquals(HandRankings.STRAIGHT, results);

    }

    @Test
    public void testNotStraight(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 1;
        card2.rank = 12;
        card3.rank = 3;
        card4.rank = 6;
        card5.rank = 4;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.straight();
        Assert.assertNotEquals(HandRankings.STRAIGHT, results);

    }

    @Test
    public void testFlush(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 7;
        card2.rank = 2;
        card3.rank = 1;
        card4.rank = 4;
        card5.rank = 5;

        card1.suit = 1;
        card2.suit = 1;
        card3.suit = 1;
        card4.suit = 1;
        card5.suit = 1;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.flush();
        Assert.assertEquals(HandRankings.FLUSH, results);

    }

    @Test
    public void testNotFlush(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 7;
        card2.rank = 2;
        card3.rank = 1;
        card4.rank = 4;
        card5.rank = 5;

        card1.suit = 1;
        card2.suit = 1;
        card3.suit = 2;
        card4.suit = 1;
        card5.suit = 1;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.flush();
        Assert.assertNotEquals(HandRankings.FLUSH, results);

    }

    @Test
    public void testFullHouse(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 10;
        card2.rank = 10;
        card3.rank = 10;
        card4.rank = 4;
        card5.rank = 4;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.fullHouse();
        Assert.assertEquals(HandRankings.FULL_HOUSE, results);

    }

    @Test
    public void testNotFullHouse(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 10;
        card2.rank = 10;
        card3.rank = 5;
        card4.rank = 4;
        card5.rank = 4;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.fullHouse();
        Assert.assertNotEquals(HandRankings.FULL_HOUSE, results);

    }

    @Test
    public void testFourOfaKind(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 2;
        card2.rank = 2;
        card3.rank = 2;
        card4.rank = 2;
        card5.rank = 4;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.fourOfaKind();
        Assert.assertEquals(HandRankings.FOUR_OF_A_KIND, results);

    }

    @Test
    public void testNotFourOfaKind(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 2;
        card2.rank = 2;
        card3.rank = 2;
        card4.rank = 3;
        card5.rank = 4;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.fourOfaKind();
        Assert.assertNotEquals(HandRankings.FOUR_OF_A_KIND, results);

    }

    @Test
    public void testStraightFlush(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 4;
        card2.rank = 5;
        card3.rank = 6;
        card4.rank = 7;
        card5.rank = 8;

        card1.suit = 1;
        card2.suit = 1;
        card3.suit = 1;
        card4.suit = 1;
        card5.suit = 1;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.straightFlush();
        Assert.assertEquals(HandRankings.STRAIGHT_FLUSH, results);

    }

    @Test
    public void testNotStraightFlush(){
        Game game = new Game();
        Card card1 = new Card();
        Card card2 = new Card();
        Card card3 = new Card();
        Card card4 = new Card();
        Card card5 = new Card();

        card1.rank = 4;
        card2.rank = 5;
        card3.rank = 6;
        card4.rank = 7;
        card5.rank = 8;

        card1.suit = 1;
        card2.suit = 2;
        card3.suit = 1;
        card4.suit = 1;
        card5.suit = 1;

        List<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);
        hand.add(card3);
        hand.add(card4);
        hand.add(card5);

        game.setHand(hand);
        HandRankings results = game.straightFlush();
        Assert.assertNotEquals(HandRankings.STRAIGHT_FLUSH, results);

    }

}
