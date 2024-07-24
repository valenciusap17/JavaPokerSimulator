# Poker Game

## Problem Statement

You are asked to simulate a Poker card game.

## Simulation of the Game

Assume normal deck of cards.

There are 4 suits of cards:

- ♠ Spades

- ♥ Hearts

- ♣ Clubs

- ♦ Diamonds

And there are 13 ranks of cards:

- Ace <- can be placed before 2

- 2

- 3

- 4

- 5

- 6

- 7

- 8

- 9

- 10

- Jack

- Queen

- King

- Ace <- can be placed after King

The game starts, and the deck shuffled then 5 cards dealt to each player, called a hand. Upon this point each player

will show their hands, and they are ranked as below from highest to lowest. The game must determine a winner based on

the highest hand and announce the winner.

## Hands and Their Ranks

### **Royal Flush**

Ace, King, Queen, Jack, and 10 of the same suit. If there are multiple Royal Flushes in a game, the hand with the

highest suit wins.

### **Straight Flush**

5 cards (sequenced rank, one suit). If there are multiple Straight Flushes in a game, the hand with the highest suit

wins. If they are the same suit, the highest rank wins.

### **Four of a Kind**

4 cards (same rank, all suit), one extra card. If there are multiple Four of a Kind in a game, the hand with the highest

rank wins.

### **Full House**

3 cards (same rank, any suit), 2 cards (same rank, any suit). If there are multiple Full Houses in a game, the hand with

the highest suit of the 3 cards wins. If they are the same suit, the highest rank wins.

### **Flush**

5 cards (any rank, same suit). If there are multiple Flushes in a game, the hand with the highest suit wins. If they are

the same suit, the highest rank wins.

### **Straight**

5 cards (sequenced rank, any suit). If there are multiple straights in a game, the hand with the highest rank wins. If

they are the same rank, the highest suit wins.

### **Three of a Kind**

3 cards (same rank, any suit), any 2 extra cards. If there are multiple Three of a Kinds in a game, the hand with the

same rank wins.

### **Two Pairs**

2 cards (same rank, any suit), 2 cards (same rank, any suit), one extra card. If there are multiple Two Pairs in a game,

the hand with the highest rank wins. If they are the same rank, the highest suit wins.

### **One Pair**

2 cards (same rank, any suit), 3 extra cards. If there are multiple One Pairs in a game, the hand with the highest rank

wins. If they are the same rank, the highest suit wins.

### **Nothing**

Any 5 cards that does not arrange the any of the above hands. If there are multiple Nothings in a game, the hand with

the highest rank wins. If they are the same rank, the highest suit wins.
