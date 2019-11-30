/**
 * CS 152 Lab 9 - Deck
 * 2019/4/25
 * Ilham Babajanov
 */


public class Deck {

    private Card[] deck;
    private int numCards;


    /**
     * A new deck is empty (containing no cards), but has the capacity
     * to hold all the cards in a standard deck.
     */
    public Deck() {
        this.deck = new Card[52];
        this.numCards = 0;
    }


    /**
     * Adds one card to the top of this deck.
     *
     * @param card
     */
    public void add(Card card) {

        this.deck[numCards] = card;
        this.numCards++;
    }


    /**
     * Fills the deck with all the cards in a standard deck of cards.
     */
    public void fill() {

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                add(new Card(rank, suit));
            }
        }
    }


    /**
     * Returns the nth card in this deck, where card 0 is the one on the bottom.
     * Assumes the deck is not empty. Does not modify the deck.
     *
     * @param n
     * @return the nth card in this deck.
     */
    public Card getCardAt(int n) {
        return deck[n];
    }


    /**
     * Moves one card from the top of this deck to the top of the other deck.
     *
     * @param other
     */
    public void move(Deck other) {

        if (this.numCards != 0) {
            other.deck[other.size()] = this.deck[numCards - 1];
            other.numCards++;
            this.numCards--;
        }
    }


    /**
     * Moves the top n cards from the top of this deck to the top of the other
     * deck, maintaining their order so that the card that was on top of this
     * deck becomes the top card of the other deck.
     *
     * @param other
     * @param n
     */
    public void move(Deck other, int n) {

        int limit = this.numCards;
        int index = other.size();
        //if (n > 0 && n <= this.numCards) {
            for (int i = limit - n; (n>0) && i < limit; i++) {
                other.deck[index] = this.deck[i];
                other.numCards++;
                this.numCards--;
                index++;
            }
        //}
    }


    /**
     * Returns the number of cards in this deck.
     *
     * @return number of cards.
     */
    public int size() {

        return this.numCards;
    }


    /**
     * Returns the top card on this deck. Returns null if the deck is empty.
     * Does not modify the deck.
     *
     * @return the top card.
     */
    public Card getTopCard() {

        if (this.numCards == 0) {
            return null;
        } else {
            return this.deck[this.numCards - 1];
        }
    }


    /**
     * Randomly reorders the cards in this deck, no matter if the deck is full
     * or not.
     * <p>
     * When I was doing research on shuffling algorithm, I came
     * across this algorithm called "Yates-Fisher shuffle" on
     * https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
     * <p>
     * Then I did some more research and then I also used the book "Algorithms"
     * 4th edition by Robert Sedgewick and Kevin Wayne to better understand how
     * the algorithm works. In this book, the authors use StdRandom.uniform(n)
     * method, but instead I used Math.random().
     * Apparently Yates-Fisher shuffle algorithm seems like the best choice
     * to me.
     */
    public void shuffle() {

        Card temp;
        int randIndex;

        for (int i = 0; i < this.numCards; i++) {

            randIndex = i + (int) (Math.random() * (this.numCards - i));

            temp = deck[i];
            deck[i] = deck[randIndex];
            deck[randIndex] = temp;
        }
    }


}
