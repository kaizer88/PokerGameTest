package com.game.poker;

import java.util.*;
import java.util.stream.Collectors;

public class Game
{

    private final int HAND_SIZE = 5;
    private int again = 1;

    // instantiate Deck and Player
    Scanner scan = new Scanner(System.in);
    Deck deck = new Deck();

    private List<Card> hand = new ArrayList<>();

    // plays the game
    public void play(){
        while (again == 1){
            // fill deck
            deck.fillDeck();

            // shuffle
            deck.shuffle();

            // player draws
            hand = Player.draw(deck);

            // sort hand
            Collections.sort(hand);

            // player
            this.checkHand();

            // evaluate the hand
            this.evaluate();

            // play again?
            this.again();
        }
        System.out.println("Thanks for playing! =]");
    }

    // tells player cards in hand
    public void checkHand(){
        for (int handCounter = 0; handCounter < HAND_SIZE; handCounter++){
            this.display(hand.get(handCounter));
        }
    }

    // evaluates the hand
    public void evaluate(){
        System.out.println("");

        if (this.straightFlush() == HandRankings.STRAIGHT_FLUSH){
            System.out.println("You have a straight flush!");
        }
        else if (this.fourOfaKind() == HandRankings.FOUR_OF_A_KIND){
            System.out.println("You have four of a kind!");
        }
        else if (this.fullHouse() == HandRankings.FULL_HOUSE){
            System.out.println("You have a full house!");
        }
        else if (this.flush() == HandRankings.FLUSH){
            System.out.println("You have a flush!");
        }
        else if (this.straight() == HandRankings.STRAIGHT){
            System.out.println("You have a straight!");
        }
        else if (this.triple() == HandRankings.TRIPLE){
            System.out.println("You have a three of a kind!");
        }
        else if (this.twoPairs() == HandRankings.TWO_PAIRS){
            System.out.println("You have two pairs!");
        }
        else if (this.pair() == HandRankings.PAIR){
            System.out.println("You have a pair!");
        }
        else{
            int highCard = this.highCard();
            System.out.println("Your highest card is " + highCard);
        }
    }

    // checks for a straight flush
    public HandRankings straightFlush(){
        for (int counter = 1; counter < 5; counter++)
        {
            if (hand.get(0).suit != hand.get(counter).suit)
            {
                return HandRankings.NO_HAND;
            }
        }
        for (int counter2 = 1; counter2 < 5; counter2++)
        {
            if (hand.get(counter2-1).rank != (hand.get(counter2).rank - 1))
            {
                return HandRankings.NO_HAND;
            }

        }
        return HandRankings.STRAIGHT_FLUSH;

    }

    // checks for four of a kind
    public HandRankings fourOfaKind(){

        List<Integer> list = new ArrayList<>();
        for(int i =0; i<hand.size(); i++){
            list.add(hand.get(i).rank);
        }
        List<Integer> newList = list.stream()
                .distinct()
                .collect(Collectors.toList());

        if(newList.size()!=2){
            return HandRankings.NO_HAND;
        }
        else{
            if((Collections.frequency(list, newList.get(0))==4) || (Collections.frequency(list, newList.get(0))==4)){
                return HandRankings.FOUR_OF_A_KIND;
            }
            else {
                return HandRankings.NO_HAND;
            }
        }
    }

    // checks for full house
    public HandRankings fullHouse(){
        int comparison = 0;
        for (int counter = 1; counter < 5; counter++){
            if (hand.get(counter - 1).rank == hand.get(counter).rank){
                comparison++;
            }
        }
        if (comparison == 3){
            return HandRankings.FULL_HOUSE;
        }
        else{
            return HandRankings.NO_HAND;
        }
    }

    // checks for flush
    public HandRankings flush(){
        for (int counter = 1; counter < 5; counter++){
            if (hand.get(0).suit != hand.get(counter).suit){
                return HandRankings.NO_HAND;
            }
        }
        return HandRankings.FLUSH;
    }

    // check for straight
    public HandRankings straight(){
        for (int counter2 = 1; counter2 < 5; counter2++){
            if (hand.get(counter2 - 1).rank != (hand.get(counter2).rank - 1)){
                return HandRankings.NO_HAND;
            }
        }
        return HandRankings.STRAIGHT;
    }

    // checks for triple
    public HandRankings triple(){
        if (hand.get(0).rank == hand.get(2).rank || hand.get(2).rank == hand.get(4).rank){
            return HandRankings.TRIPLE;
        }
        return HandRankings.NO_HAND;
    }

    // checks for two pairs
    public HandRankings twoPairs(){
        int check = 0;
        for(int counter = 1; counter < 5; counter++){
            if (hand.get(counter - 1).rank == hand.get(counter).rank){
                check++;
            }
        }
        if (check == 2){
            return HandRankings.TWO_PAIRS;
        }
        else{
            return HandRankings.NO_HAND;
        }
    }

    // check for pair
    public HandRankings pair(){
        int check = 0;
        for(int counter = 1; counter < 5; counter++){
            if (hand.get(counter - 1).rank == hand.get(counter).rank){
                check++;
            }
        }
        if (check == 1){
            return HandRankings.PAIR;
        }
        else{
            return HandRankings.NO_HAND;
        }
    }

    // find highest card
    public int highCard(){
        int highCard = 0;
        for (int counter = 0; counter < 5; counter++){
            if (hand.get(counter).rank > highCard){
                highCard = hand.get(counter).rank;
            }
        }
        return highCard;
    }

    // asks user if they want to play again
    public void again(){
        System.out.print("Play again? (1 for yes, any number for no recommended 0) \n");

        String line = scan.nextLine();
        try {
            again = Integer.parseInt(line);

        } catch (NumberFormatException e) {
            System.out.print("Wrong input! Input only integer numbers please: " + e.getMessage()+"\n");
            this.again();
        }
    }

    // generates string for each card in hand
    public void display(Card card){
        if (card.rank == 1){
            System.out.print("A");
        }
        if (card.rank == 2){
            System.out.print("2");
        }
        if (card.rank == 3){
            System.out.print("3");
        }
        if (card.rank == 4){
            System.out.print("4");
        }
        if (card.rank == 5){
            System.out.print("5");
        }
        if (card.rank == 6){
            System.out.print("6");
        }
        if (card.rank == 7){
            System.out.print("7");
        }
        if (card.rank == 8){
            System.out.print("8 ");
        }
        if (card.rank == 9){
            System.out.print("9");
        }
        if (card.rank == 10){
            System.out.print("10");
        }
        if (card.rank == 11){
            System.out.print("J");
        }
        if (card.rank == 12){
            System.out.print("Q");
        }
        if (card.rank == 13){
            System.out.print("K");
        }
        if (card.suit == 1){
            //Spades
            System.out.print("\u2660 ");
        }
        if (card.suit == 2){
            //Heart
            System.out.print("\u2661 ");
        }
        if (card.suit == 3){
            //Diamond
            System.out.print("\u2662 ");
        }
        if (card.suit == 4){
            //Clubs
            System.out.print("\u2663 ");
        }

    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }
}

