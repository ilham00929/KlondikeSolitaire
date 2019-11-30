/**
 * CS 152 Lab 9 - Card
 * 2019/4/25
 * Ilham Babajanov
 */


public class Card {

    private Rank rank;
    private Suit suit;
    private boolean faceUp = true;


    /**
     * Constructs a new Card with the given rank and suit.
     * Newly constructed cards are face-up by default.
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }


    /**
     * Returns the rank of this card: one of ACE through KING.
     * @return the rank of this card.
     */
    public Rank getRank(){
        return this.rank;
    }


    /**
     * Returns the suit of this card, one of CLUBS, SPADES, HEARTS, or DIAMONDS.
     * @return the suit of this card.
     */
    public Suit getSuit() {
        return this.suit;
    }


    /**
     * Returns true if the card is face-up, false if not.
     * @return true or false.
     */
    public boolean isFaceUp() {
        return this.faceUp;
    }


    /**
     * Returns true if the card is black, false if not.
     * @return true or false.
     */
    public boolean isBlack() {
        return this.suit.equals(Suit.SPADES) || this.suit.equals(Suit.CLUBS);
    }


    /**
     * Toggles the face-up status of the card. If the card was face-up,
     * it is now face-down, and vice-versa.
     */
    public void flip() {
        this.faceUp = !this.faceUp;
    }

}
