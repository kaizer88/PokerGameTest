# PokerGameTest (Java)

The game is a Java console application with maven build.

One player simple poker, gives you a hand and then evaluates your hand.

HOW TO USE:

Run the program using ./run command, and it'll show you your cards and it will display your new hand and tell you its evaluation. Then you will be prompted to play again.

GameTest class:

This class instantiates the Game class and calls game.play().

Game class:

This class is responsible for instantiating the Deck and PLayer classes It calls methods in Deck to fill and shuffle it, and then calls a method in Player to draw from the Deck. Then the hand is sorted again before it is evaluated, to make evaluation easier. The evaluate() method evaluates the hand, starting from straight flush all the way down to highest card. Then the user is asked if they want to play again.

Card class:

The Card class keeps track of the suit and rank of each card.

Player class:

The Player class two methods. One is a draw method which returns the hand deal that returns a hand of 5 cards.

Deck class:

The Deck class is responsible for filling the deck with 52 Card objects. It shuffles by taking two random numbers from the size of the deck and switching those two card. It does this 1000 times, but it can be changed by changing SHUFFLE_EXCHANGES in the constructor. Method deal() returns a hand of 5 cards.
