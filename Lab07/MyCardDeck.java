import java.util.*;
public class MyCardDeck {
        public static void main(String[] args) {
                Deck myDeck = new Deck();
                for(int i = 0; i <= args.length-1; i++) {
                        if(args[i].matches("-?\\d+")) { // check if the arguemts are numerical
                                if(myDeck.deal(Integer.parseInt(args[i])) == null) {
                                        System.out.println("null");
                                        return;
                                }
                                myDeck.printCards(myDeck.deal(Integer.parseInt(args[i])));
                        } else if(args[i].equals("shuffle")) {
                                myDeck.shuffle();
                        } else {
                                System.out.println("Illegal input!");
                        }
                }
        }
}
class Card {
        private String cardValue;
        private String cardSuit;
        public Card(int cardNumber, String cardSuit) {
                this.cardSuit = cardSuit;
                switch(cardNumber) {
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                               cardValue = String.valueOf(cardNumber);
                               break;
                        case 11:
                               cardValue = "Jack";
                               break;
                        case 12:
                               cardValue = "Queen";
                               break;
                        case 13:
                               cardValue = "King";
                               break;
                        case 14:
                               cardValue = "Ace";
                               break;
                        default:
                               cardValue = "0";
                               break;
                }
                switch(cardSuit) {
                        case "s":
                        case "S":
                                this.cardSuit = "Spaes";
                                break;
                        case "c":
                        case "C":
                                this.cardSuit = "Clubs";
                                break;
                        case "h":
                        case "H":
                                this.cardSuit = "Hearts";
                                break;
                        case "d":
                        case "D":
                                this.cardSuit = "Diamonds";
                                break;
                        default:
                                this.cardSuit = "ERROR";
                                break;
                }
        }
        public Card(String cardValueAndSuitString) {
                switch(cardValueAndSuitString.charAt(0)) {
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                                cardValue = Character.toString(cardValueAndSuitString.charAt(0));
                                cardValueAndSuitString = cardValueAndSuitString.substring(1);
                                break;
                        case '1':
                                if(cardValueAndSuitString.charAt(1) == '0') {
                                        cardValue = "10";
                                        cardValueAndSuitString = cardValueAndSuitString.substring(2);
                                } else {
                                        cardValue = "0";
                                        cardValueAndSuitString = cardValueAndSuitString.substring(2);
                                }
                                break;
                        case 'j':
                        case 'J':
                                cardValue = "Jack";
                                cardValueAndSuitString = cardValueAndSuitString.substring(1);
                                break;
                        case 'q':
                        case 'Q':
                                cardValue = "Queen";
                                cardValueAndSuitString = cardValueAndSuitString.substring(1);
                                break;
                        case 'k':
                        case 'K':
                                cardValue = "King";
                                cardValueAndSuitString = cardValueAndSuitString.substring(1);
                                break;
                        case 'a':
                        case 'A':
                                cardValue = "Ace";
                                cardValueAndSuitString = cardValueAndSuitString.substring(1);
                                break;
                        default:
                                cardValue = "0";
                                break;
                }
                switch(cardValueAndSuitString) {
                        case "s":
                        case "S":
                                cardSuit = "Spades";
                                break;
                        case "c":
                        case "C":
                                cardSuit = "Clubs";
                                break;
                        case "h":
                        case "H":
                                cardSuit = "Hearts";
                                break;
                        case "d":
                        case "D":
                                cardSuit = "Diamonds";
                                break;
                        default:
                                cardSuit = "ERROR";
                                break;
                }
        }
        public Card(String cardValue, String cardSuit) {
                switch(cardValue) {
                        case "2":
                        case "3":
                        case "4":
                        case "5":
                        case "6":
                        case "7":
                        case "8":
                        case "9":
                        case "10":
                                this.cardValue = cardValue;
                                break;
                        case "11":
                                this.cardValue = "Jack";
                                break;
                        case "12":
                                this.cardValue = "Queen";
                                break;
                        case "13":
                                this.cardValue = "King";
                                break;
                        case "14":
                                this.cardValue = "Ace";
                                break;
                        default:
                                this.cardValue = "0";
                                break;
                }
                switch(cardSuit) {
                        case "s":
                        case "S":
                                this.cardSuit = "Spades";
                                break;
                        case "c":
                        case "C":
                                this.cardSuit = "Clubs";
                                break;
                        case "h":
                        case "H":
                                this.cardSuit = "Hearts";
                                break;
                        case "d":
                        case "D":
                                this.cardSuit = "Diamonds";
                                break;
                        default:
                                this.cardSuit = "ERROR";
                                break;
                }
        }
        public Card() {
                cardValue = "0";
                cardSuit = "ERROR";
        }
        public String value() {
                switch(cardValue) {
                        case "Jack":
                                return "11";
                        case "Queen":
                                return "12";
                        case "King":
                                return "13";
                        case "Ace":
                                return "14";
                        default:
                                return cardValue;
                }
        }
        public String suit() {
                switch(cardSuit) {
                        case "Spades":
                                return "S";
                        case "Clubs":
                                return "C";
                        case "Hearts":
                                return "H";
                        case "Diamonds":
                                return "D";
                        default:
                                return "E";
                }
        }
        public String print() {
                char cardValueChar;
                switch(cardValue) {
                        case "Jack":
                        case "Queen":
                        case "King":
                        case "Ace":
                                return cardValue.charAt(0) + suit();
                        default:
                                return cardValue + suit();
                }
        }
        public String getCardValue() {
                return cardValue;
        }
        public String getCardSuit() {
                return cardSuit;
        }
}
class Deck {
        Card allMyCards[] = new Card[52];
        int indexCounter = 0;   
        public Deck(int cardValue, String cardSuit) {   
                if(indexCounter > 51) {
                        System.out.println("Can not add more cards! The deck is full.");
                        return;
                } else {
                        allMyCards[indexCounter] = new Card(cardValue, Character.toString(cardSuit.charAt(0)));
                        indexCounter++;
                }
        }
        /* the default constructor creates a standard deck */
        public Deck() {
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i-2] = new Card(i, "s");
                }
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i+11] = new Card(i, "c");
                }
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i+24] = new Card(i, "h");
                }
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i+37] = new Card(i, "d");
                }
        }
        public String print() {
                String cardsValues = "";
                for(int i = 0; i <= 51; i++) {
                        if(allMyCards[i] == null) {
                                System.out.println("Printing failed! The Deck is not full.");
                                return "";
                        } else {
                                cardsValues = cardsValues + allMyCards[i].getCardValue() + " " + allMyCards[i].getCardSuit() + "  ";
                        }
                }
                return cardsValues;
        }
        public void shuffle() {
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i-2] = new Card(i, "s");
                }
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i+11] = new Card(i, "c");
                }
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i+24] = new Card(i, "h");
                }
                for(int i = 2; i <= 14; i++) {
                        allMyCards[i+37] = new Card(i, "d");
                }
        }
        public Card[] deal(int cardsToDeal) {
                int nullCounter = 0;
                for(int i = 0; i <= allMyCards.length-1; i++) {
                        if(allMyCards[i] == null) {
                                nullCounter++;
                        }
                }
                /* create randomIndexArrayList to store the index reference for later use */
                ArrayList<Integer> randomIndexArrayList = new ArrayList<Integer>(allMyCards.length - nullCounter);
                for(int i = 0; i <= allMyCards.length - nullCounter - 1; i++) {
                        randomIndexArrayList.add(i);
                }
                Card randomNonNullCards[] = new Card[allMyCards.length - nullCounter];
                /* randomize the index refernce */
                Collections.shuffle(randomIndexArrayList);
                /* check if the desired amount of cards to deal is in the range of the valid cards in allMyCards */
                if(allMyCards.length - nullCounter < cardsToDeal) {
                        System.out.println("Dealing failed! Not enough cards in the deck.");
                        return null;
                } else {
                        Card nonNullCards[] = new Card[allMyCards.length - nullCounter];
                        int nonNullCardsIndexCounter = 0;
                        for(int i = 0; i <= allMyCards.length-1; i++) {
                                if(allMyCards[i] != null) {
                                        nonNullCards[nonNullCardsIndexCounter] = allMyCards[i];
                                        nonNullCardsIndexCounter++;
                                }
                        }
                        /* clear allMyCards array */
                        for(int i = 0; i <= allMyCards.length-1; i++) {
                                allMyCards[i] = null;
                        }
                        /* randomize nonNullCards */
                        int counter = 0;
                        for(int i = 0; i <= randomIndexArrayList.size()-1; i++) {
                                /* restrict the amount of cards to deal by using the parameter cardsToDeal as an
                                 * reference */
                                if(i <= cardsToDeal-1) {
                                        /* assign elements in nonNullCards array to randomNonNullCards array based on the
                                         * index reference from randomIndexArrayList */
                                        randomNonNullCards[i] = nonNullCards[randomIndexArrayList.get(i)];
                                } else {
                                        /* assign the rest of the cards back to the allMyCards array*/
                                        allMyCards[counter] = nonNullCards[randomIndexArrayList.get(i)];
                                        counter++;
                                }
                        }
                        return randomNonNullCards;
                }
        }
        public void printCards(Card[] cards) {
                for(int i = 0; i <= cards.length-1; i++) {
                        if(cards[i] != null)
                                System.out.print(cards[i].getCardValue() + " " + cards[i].getCardSuit() + "  ");
                }
                System.out.println("");
        }
}
